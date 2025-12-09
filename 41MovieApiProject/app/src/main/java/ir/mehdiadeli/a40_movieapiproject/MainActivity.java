package ir.mehdiadeli.a40_movieapiproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.LoadState;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import ir.mehdiadeli.a40_movieapiproject.adapter.MoviePagingAdapter;
import ir.mehdiadeli.a40_movieapiproject.databinding.ActivityMainBinding;
import ir.mehdiadeli.a40_movieapiproject.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mainBinding;
    MainViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        mainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        viewModel=new ViewModelProvider(this).get(MainViewModel.class);
        var adapter=new MoviePagingAdapter();
        getMovies(adapter);
        RecyclerView recycler = mainBinding.recycler;
        recycler.setAdapter(adapter);
        recycler.setItemAnimator(new DefaultItemAnimator());
        recycler.setLayoutManager(new GridLayoutManager(this,2));
        SwipeRefreshLayout swipeRefreshLayout = mainBinding.main;
        swipeRefreshLayout.setColorSchemeResources(R.color.blue);
        swipeRefreshLayout.setOnRefreshListener(() -> {
//                getMovies(adapter);
            adapter.retry();
            Toast.makeText(MainActivity.this, "Refreshed", Toast.LENGTH_SHORT).show();
            swipeRefreshLayout.setRefreshing(false);
        });
        handleState(adapter);
    }

    private void handleState(MoviePagingAdapter adapter) {
        adapter.addLoadStateListener(combinedLoadStates -> {
            var refreshState=combinedLoadStates.getRefresh();
            if(refreshState instanceof LoadState.Loading){
                //progress
                Toast.makeText(this, "Loading...", Toast.LENGTH_SHORT).show();
                mainBinding.main.setVisibility(View.GONE);
                mainBinding.loadingLinear.setVisibility(View.VISIBLE);
                mainBinding.errorLinear.setVisibility(View.GONE);
            }
            else if(refreshState instanceof LoadState.Error){
                LoadState.Error error= (LoadState.Error) refreshState;
                mainBinding.main.setVisibility(View.GONE);
                mainBinding.loadingLinear.setVisibility(View.VISIBLE);
                mainBinding.errorLinear.setVisibility(View.VISIBLE);
                mainBinding.errorMsg.setText(error.getError().getLocalizedMessage());
                mainBinding.retryButton.setOnClickListener(view -> adapter.retry());
                Toast.makeText(this, "Error...", Toast.LENGTH_SHORT).show();
                //error message
            } else if(refreshState instanceof LoadState.NotLoading){
                mainBinding.loadingLinear.setVisibility(View.GONE);
                mainBinding.main.setVisibility(View.VISIBLE);
            };
            return null;
        });
    }

    private void getMovies(MoviePagingAdapter adapter) {
//        viewModel.getMovies().observe(this, movies -> adapter.setMovieList(movies));
        viewModel.moviePagingData.observe(this, moviePagingData ->
                adapter.submitData(getLifecycle(),moviePagingData) );
    }
}