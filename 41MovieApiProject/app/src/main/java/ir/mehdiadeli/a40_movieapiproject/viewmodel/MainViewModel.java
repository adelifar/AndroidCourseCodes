package ir.mehdiadeli.a40_movieapiproject.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.PagingLiveData;

import java.util.List;

import ir.mehdiadeli.a40_movieapiproject.model.Movie;
import ir.mehdiadeli.a40_movieapiproject.paging.MoviePagingSource;
import ir.mehdiadeli.a40_movieapiproject.repository.MovieRepository;
import ir.mehdiadeli.a40_movieapiproject.service.RetrofitClient;

public class MainViewModel extends AndroidViewModel {
    private MovieRepository repository;
    public LiveData<PagingData<Movie>> moviePagingData;
    public MainViewModel(@NonNull Application application) {
        super(application);
        repository=new MovieRepository(application);
        init();
    }
//    public LiveData<List<Movie>> getMovies(){
//        return repository.getMovieLiveData();
//    }
    private void init(){
        var config=new PagingConfig(20,10,false);
        Pager<Integer,Movie> pager=new Pager<>(config,() -> new MoviePagingSource(RetrofitClient.getService()));
        var scope= ViewModelKt.getViewModelScope(this);
        moviePagingData= PagingLiveData.cachedIn(PagingLiveData.getLiveData(pager),scope);
    }
}
