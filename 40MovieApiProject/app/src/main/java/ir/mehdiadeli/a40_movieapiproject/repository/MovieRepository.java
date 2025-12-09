package ir.mehdiadeli.a40_movieapiproject.repository;

import android.app.Application;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import ir.mehdiadeli.a40_movieapiproject.R;
import ir.mehdiadeli.a40_movieapiproject.model.Movie;
import ir.mehdiadeli.a40_movieapiproject.model.Result;
import ir.mehdiadeli.a40_movieapiproject.service.MovieApiService;
import ir.mehdiadeli.a40_movieapiproject.service.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {
    private MutableLiveData<List<Movie>> movieLiveData = new MutableLiveData<>();
    private Application application;

    public MovieRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Movie>> getMovieLiveData() {
        MovieApiService service = RetrofitClient.getService();
        Call<Result> call = service.getPopularMovies(application.getString(R.string.api_key));
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                if (!response.isSuccessful())return;
                Result result=response.body();
                if (result!=null && result.getResults()!=null)
                    movieLiveData.setValue(result.getResults());
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Toast.makeText(application, "Failed \n"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return movieLiveData;
    }
}
