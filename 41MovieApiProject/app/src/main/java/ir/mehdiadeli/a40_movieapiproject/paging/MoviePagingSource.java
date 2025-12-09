package ir.mehdiadeli.a40_movieapiproject.paging;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.paging.PagingState;
import androidx.paging.rxjava3.RxPagingSource;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import ir.mehdiadeli.a40_movieapiproject.model.Movie;
import ir.mehdiadeli.a40_movieapiproject.model.Result;
import ir.mehdiadeli.a40_movieapiproject.service.MovieApiService;
import ir.mehdiadeli.a40_movieapiproject.BuildConfig;

public class MoviePagingSource extends RxPagingSource<Integer, Movie> {
    private final MovieApiService apiService;

    public MoviePagingSource(MovieApiService apiService) {
        this.apiService = apiService;
    }

    @NonNull
    @Override
    public Single<LoadResult<Integer, Movie>> loadSingle(@NonNull LoadParams<Integer> loadParams) {
        var pageIndex=loadParams.getKey();
        if (pageIndex==null)pageIndex=1;
        final int currentPage=pageIndex;
        String apiKey=BuildConfig.API_KEY;
       Single<Result> popularMovies= apiService.getMoviesByPage(apiKey,currentPage);
      return popularMovies.subscribeOn(Schedulers.io())
               .map(result -> {
                   var movies=result.getResults();
                   var preKey=(currentPage==1)?null:(currentPage-1);
                   var nextKey=(movies.isEmpty())?null:(currentPage+1);
                   return (LoadResult<Integer,Movie>) new LoadResult.Page<>(movies,preKey,nextKey);
               })
              .onErrorReturn(LoadResult.Error::new) //error handling
              ;
    }

    @Nullable
    @Override
    public Integer getRefreshKey(@NonNull PagingState<Integer, Movie> pagingState) {
        var anchorPosition=pagingState.getAnchorPosition();
        if (anchorPosition==null)
            return null;
        var anchorPage=pagingState.closestPageToPosition(anchorPosition);
        if (anchorPage==null)
            return null;
        var prevKey=anchorPage.getPrevKey();
        if (prevKey!=null)
            return prevKey+1;
        var nextKey=anchorPage.getNextKey();
        if (nextKey!=null)
            return nextKey-1;
        return null;
    }
}
