package ir.mehdiadeli.a40_movieapiproject.service;

import java.util.List;

import ir.mehdiadeli.a40_movieapiproject.model.Result;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApiService {
    @GET("movie/popular")
    Call<Result> getPopularMovies(@Query("api_key") String apiKey);
}
