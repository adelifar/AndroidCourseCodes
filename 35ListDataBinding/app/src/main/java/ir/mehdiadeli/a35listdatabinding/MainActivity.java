package ir.mehdiadeli.a35listdatabinding;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import ir.mehdiadeli.a35listdatabinding.adapter.MyAdapter;
import ir.mehdiadeli.a35listdatabinding.databinding.ActivityMainBinding;
import ir.mehdiadeli.a35listdatabinding.viewModel.MyViewModel;

public class MainActivity extends AppCompatActivity {

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
        ActivityMainBinding mainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        MyViewModel viewModel=new ViewModelProvider(this).get(MyViewModel.class);
        MyAdapter adapter=new MyAdapter(viewModel.getUsers());
        mainBinding.recycler.setAdapter(adapter);
        mainBinding.recycler.setLayoutManager(new LinearLayoutManager(this));
    }
}