package com.tosinso.a13activitylifecycle;

import android.os.Bundle;
import android.widget.Toast;

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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Toast.makeText(this,"OnCreate",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        Toast.makeText(this,"OnStart",Toast.LENGTH_SHORT).show();
        super.onStart();
    }

    @Override
    protected void onResume() {
        Toast.makeText(this,"OnResume",Toast.LENGTH_SHORT).show();
        super.onResume();
    }

    @Override
    protected void onPause() {
        //loosing focus release sensor , stop operation
        Toast.makeText(this,"OnPause",Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    @Override
    protected void onStop() {
        //save data
        Toast.makeText(this,"onStop",Toast.LENGTH_SHORT).show();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        //final step
        Toast.makeText(this,"onDestroy",Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Toast.makeText(this,"onRestart",Toast.LENGTH_SHORT).show();
        super.onRestart();
    }
}