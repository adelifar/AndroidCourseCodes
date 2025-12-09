package ir.mehdiadeli.a42_quizproject.retrofit;

import ir.mehdiadeli.a42_quizproject.model.Answer;
import ir.mehdiadeli.a42_quizproject.model.QuestionList;
import ir.mehdiadeli.a42_quizproject.model.QuizResult;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface QuizService {
    @GET("question.php")
    Call<QuestionList> getQuestions();

    @POST("answer.php")
    Call<Answer> addAnswer(@Body Answer answer);

    @GET("answer.php")
    Call<QuizResult> getResults(@Query("username") String username);
}
