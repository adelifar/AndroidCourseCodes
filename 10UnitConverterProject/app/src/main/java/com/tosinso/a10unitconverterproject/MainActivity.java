package com.tosinso.a10unitconverterproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView resultTextView;
    EditText inputEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.button);
        resultTextView=findViewById(R.id.textView);
        inputEdit=findViewById(R.id.inputText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputSting=inputEdit.getText().toString();
                double inputNumber=Double.parseDouble(inputSting);
                double result=convert(inputNumber);
                resultTextView.setText(result+"");
//                resultTextView.setText(Double.toString( result));
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private double convert(double input){
        //1 inch=2.54 cm
        double inchFactor=2.54;
        double result=input*inchFactor;
        return result;
    }
}