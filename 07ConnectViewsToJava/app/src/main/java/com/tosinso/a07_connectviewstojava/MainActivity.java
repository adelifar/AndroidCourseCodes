package com.tosinso.a07_connectviewstojava;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button button=findViewById(R.id.myButton);
        button.setText("Java Button");
        button.setEnabled(false);

        ImageView imageView=findViewById(R.id.image1);
        imageView.setImageResource(R.drawable.android_studio);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setContentDescription("android studio last icon");

        TextView textView=findViewById(R.id.text1);
        textView.setText("This text is from java");
        textView.setTextSize(32);

        EditText editText=findViewById(R.id.edit1);
        editText.setHint("enter text here from java");
        editText.setTextColor(Color.rgb(0,80,80));
        editText.setTextSize(28);









        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}