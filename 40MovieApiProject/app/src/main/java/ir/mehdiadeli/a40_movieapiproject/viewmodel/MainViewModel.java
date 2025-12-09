package ir.mehdiadeli.a40_movieapiproject.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import ir.mehdiadeli.a40_movieapiproject.model.Movie;
import ir.mehdiadeli.a40_movieapiproject.repository.MovieRepository;

public class MainViewModel extends AndroidViewModel {
    private MovieRepository repository;
    public MainViewModel(@NonNull Application application) {
        super(application);
        repository=new MovieRepository(application);
    }
    public LiveData<List<Movie>> getMovies(){
        return repository.getMovieLiveData();
    }
}
