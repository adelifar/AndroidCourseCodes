 package ir.mehdiadeli.a33_percentagecalculator;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import ir.mehdiadeli.a33_percentagecalculator.databinding.ActivityMainBinding;
import ir.mehdiadeli.a33_percentagecalculator.handler.ClickHandler;
import ir.mehdiadeli.a33_percentagecalculator.model.Percentage;

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

        ActivityMainBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        Percentage percentage=new Percentage();
        binding.setPercentage(percentage);
        binding.setButtonClickHandler(new ClickHandler(percentage));


    }
}