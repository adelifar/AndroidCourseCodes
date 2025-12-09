package ir.mehdiadeli.a42_quizproject.repository;

import android.app.Application;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import ir.mehdiadeli.a42_quizproject.model.Answer;
import ir.mehdiadeli.a42_quizproject.model.QuestionList;
import ir.mehdiadeli.a42_quizproject.model.QuizResult;
import ir.mehdiadeli.a42_quizproject.retrofit.QuizService;
import ir.mehdiadeli.a42_quizproject.retrofit.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuizRepository {
    private QuizService service;
    private MutableLiveData<QuestionList> questionListMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<QuizResult> quizResultMutableLiveData = new MutableLiveData<>();
    private Application application;

    public QuizRepository(Application application) {
        this.application = application;
        service = RetrofitClient.getInstance();
    }

    public MutableLiveData<QuestionList> getQuestionList() {
        service.getQuestions().enqueue(new Callback<QuestionList>() {
            @Override
            public void onResponse(Call<QuestionList> call, Response<QuestionList> response) {
                if (!responseIsValid(response)) return;
                setQuestions(response);
            }

            @Override
            public void onFailure(Call<QuestionList> call, Throwable t) {
                toast("Response Failed \n" + t.getMessage());
            }
        });
        return questionListMutableLiveData;
    }

    private void setQuestions(Response<QuestionList> response) {
        var questions = response.body();
        if (questions != null && !questions.isEmpty())
            questionListMutableLiveData.setValue(questions);
    }

    private boolean responseIsValid(Response response) {
        if (response.isSuccessful()) return true;
        toast("Response Unsuccessful");
        return false;

    }

    private void toast(String message) {
        Toast.makeText(application, message, Toast.LENGTH_SHORT).show();
    }

    public void addAnswer(Answer answer) {
        service.addAnswer(answer).enqueue(new Callback<Answer>() {
            @Override
            public void onResponse(Call<Answer> call, Response<Answer> response) {
                if (!responseIsValid(response)) return;
                toast("Answer Added Successfully");
            }

            @Override
            public void onFailure(Call<Answer> call, Throwable t) {
                toast("Response Failed \n" + t.getMessage());
            }
        });
    }

    public MutableLiveData<QuizResult> getQuizResult(String username) {
        service.getResults(username).enqueue(new Callback<QuizResult>() {
            @Override
            public void onResponse(Call<QuizResult> call, Response<QuizResult> response) {
                if (!responseIsValid(response)) return;
                setResult(response);
            }

            @Override
            public void onFailure(Call<QuizResult> call, Throwable t) {
                toast("Response Failed \n" + t.getMessage());
            }
        });
        return quizResultMutableLiveData;
    }

    private void setResult(Response<QuizResult> response) {
        var result = response.body();
        if (result != null)
            quizResultMutableLiveData.setValue(result);

    }
}
