package ir.mehdiadeli.a42_quizproject;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import ir.mehdiadeli.a42_quizproject.databinding.ActivityResultBinding;
import ir.mehdiadeli.a42_quizproject.viewmodel.QuizViewModel;

public class ResultActivity extends AppCompatActivity {
ActivityResultBinding binding;
QuizViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        binding= DataBindingUtil.setContentView(this,R.layout.activity_result);
        viewModel=new ViewModelProvider(this).get(QuizViewModel.class);
        var username=getIntent().getExtras().get(getString(R.string.username)).toString();
        viewModel.getResult(username).observe(this,quizResult -> {
            binding.correctText.setText(quizResult.getCorrect()+"");
            binding.wrongText.setText(quizResult.getWrong()+"");
            binding.totalText.setText(quizResult.getTotal()+"");
        });
    }
}