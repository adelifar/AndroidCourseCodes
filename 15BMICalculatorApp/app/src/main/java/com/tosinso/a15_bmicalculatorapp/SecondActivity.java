package com.tosinso.a15_bmicalculatorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    TextView bmiText;
    Button shareButton;
    double bmi;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        bmiText = findViewById(R.id.bmiText);
        shareButton = findViewById(R.id.shareButton);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareBmi();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        int height = (int) extras.get(MainActivity.HEIGHT);
        double weight = (double) extras.get(MainActivity.WEIGHT);
         name = (String) extras.get(MainActivity.NAME);
        bmi = calculateBMI(height, weight);
        bmiText.setText(bmi + "");
    }

    private double calculateBMI(int height, double weight) {
        double heightInMeter = ((double) height) / 100; //170 /100  1
        //bmi=weight/h^2
        double heightSquare = Math.pow(heightInMeter, 2);
        double bmiValue = Math.round(weight / heightSquare * 100.0) / 100.0;
        return bmiValue;
    }

    private void shareBmi() {
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT,"BMI Number");
        intent.putExtra(Intent.EXTRA_TEXT,name+" has BMI: "+bmi);
        startActivity(intent);
    }
}