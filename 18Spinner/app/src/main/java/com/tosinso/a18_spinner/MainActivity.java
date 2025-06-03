package com.tosinso.a18_spinner;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        String[] languages = new String[]{"Java", "Kotlin", "C++", "C#", "Javascript"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_spinner_dropdown_item
                , languages);
        spinner.setAdapter(adapter);
        String selected= (String) spinner.getSelectedItem();
        Toast.makeText(MainActivity.this,"selected Item:"+selected,Toast.LENGTH_SHORT).show();
        long itemId=spinner.getSelectedItemId();
        Toast.makeText(MainActivity.this,"selected Item Id:"+itemId,Toast.LENGTH_SHORT).show();
        int position=spinner.getSelectedItemPosition();
        Toast.makeText(MainActivity.this,"selected Item position:"+position,Toast.LENGTH_SHORT).show();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"selected Item position:"+position,Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this,"selected Item :"+languages[position],Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}