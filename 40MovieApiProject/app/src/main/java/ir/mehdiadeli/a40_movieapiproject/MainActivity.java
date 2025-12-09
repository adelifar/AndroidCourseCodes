package ir.mehdiadeli.a40_movieapiproject;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.List;

import ir.mehdiadeli.a40_movieapiproject.adapter.MovieAdapter;
import ir.mehdiadeli.a40_movieapiproject.databinding.ActivityMainBinding;
import ir.mehdiadeli.a40_movieapiproject.model.Movie;
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
        MovieAdapter adapter=new MovieAdapter();
        getMovies(adapter);
        RecyclerView recycler = mainBinding.recycler;
        recycler.setAdapter(adapter);
        recycler.setItemAnimator(new DefaultItemAnimator());
        recycler.setLayoutManager(new GridLayoutManager(this,2));
        SwipeRefreshLayout swipeRefreshLayout = mainBinding.main;
        swipeRefreshLayout.setColorSchemeResources(R.color.blue);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getMovies(adapter);
                Toast.makeText(MainActivity.this, "Refreshed", Toast.LENGTH_SHORT).show();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    private void getMovies(MovieAdapter adapter) {
        viewModel.getMovies().observe(this, movies -> adapter.setMovieList(movies));
    }
}