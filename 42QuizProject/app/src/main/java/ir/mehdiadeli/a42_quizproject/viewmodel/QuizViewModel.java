package ir.mehdiadeli.a42_quizproject.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import ir.mehdiadeli.a42_quizproject.model.Answer;
import ir.mehdiadeli.a42_quizproject.model.Question;
import ir.mehdiadeli.a42_quizproject.model.QuestionList;
import ir.mehdiadeli.a42_quizproject.model.QuizResult;
import ir.mehdiadeli.a42_quizproject.repository.QuizRepository;

public class QuizViewModel extends AndroidViewModel {
    private QuizRepository repository;
    private MutableLiveData<QuestionList> questionListMutableLiveData=new MutableLiveData<>();
    private QuestionList questions;
    private int currentQuestionIndex=0;
    public QuizViewModel(@NonNull Application application) {
        super(application);
        repository=new QuizRepository(application);
        questions=new QuestionList();
    }

    public QuestionList getQuestions() {
        return questions;
    }
    public LiveData<QuestionList> getQuestionList(){
        questionListMutableLiveData= repository.getQuestionList();
        questions=questionListMutableLiveData.getValue();
        return questionListMutableLiveData;
    }
    public void addAnswer(Answer answer){
        repository.addAnswer(answer);
    }
    public MutableLiveData<Question> getCurrentQuestion(){
        MutableLiveData<Question> questionMutableLiveData=
                new MutableLiveData<>(questions.get(currentQuestionIndex));
        return questionMutableLiveData;
    }
    public MutableLiveData<Question> getNextQuestion(){
        if (questions.size()>=currentQuestionIndex+2)
            currentQuestionIndex++;
        return getCurrentQuestion();
    }

    public void setQuestions(QuestionList questions) {
        this.questions=questions;
    }

    public MutableLiveData<QuizResult> getResult(String username) {
        return repository.getQuizResult(username);
    }
}
