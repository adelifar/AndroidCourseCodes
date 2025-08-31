package ir.mehdiadeli.a34_viewmodel;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import ir.mehdiadeli.a34_viewmodel.databinding.ActivityMainBinding;
import ir.mehdiadeli.a34_viewmodel.viewmodel.MyViewModel;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
MyViewModel viewModel;
//    int counter=0;
//view model
    //model ->database ->server
    //viewmodel
    //view
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

        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        viewModel= viewModelProvider.get(MyViewModel.class);






        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setMyViewModel(viewModel);
        viewModel.getCounter().
                observe(this,counter ->binding.textView.setText(counter+"") );
//        setCounterToTextView();
//        binding.button.setOnClickListener(view -> {
////            counter++;
//            viewModel.increment();
////            setCounterToTextView();
//        });
    }

//    private void setCounterToTextView() {
////        binding.textView.setText(counter+"");
//        binding.textView.setText(viewModel.getCounter()+"");
//    }
}