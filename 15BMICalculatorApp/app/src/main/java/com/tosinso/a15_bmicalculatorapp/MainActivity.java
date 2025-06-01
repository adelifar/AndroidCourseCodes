package com.tosinso.a15_bmicalculatorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    public static final String HEIGHT="height";
    public static final String WEIGHT="weight";
    public static final String NAME="name";
    EditText nameEdit;
    EditText heightEdit;
    EditText weightEdit;
    Button calculateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        calculateBtn = findViewById(R.id.calculateBtn);
        nameEdit = findViewById(R.id.nameEdit);
        heightEdit = findViewById(R.id.heightEdit);
        weightEdit = findViewById(R.id.weightEdit);

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int height=Integer.parseInt( heightEdit.getText().toString());
                double weight=Double.parseDouble(weightEdit.getText().toString());
                String name=nameEdit.getText().toString();
                gotoSecondActivity(name,height,weight);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void gotoSecondActivity(String name,int height,double weight){
        Intent intent=new Intent(MainActivity.this,SecondActivity.class);
        intent.putExtra(HEIGHT,height);
        intent.putExtra(WEIGHT,weight);
        intent.putExtra(NAME,name);
        startActivity(intent);
    }
}