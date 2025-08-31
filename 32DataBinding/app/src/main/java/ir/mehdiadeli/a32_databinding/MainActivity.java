package ir.mehdiadeli.a32_databinding;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import ir.mehdiadeli.a32_databinding.databinding.ActivityMainBinding;
import ir.mehdiadeli.a32_databinding.handler.ButtonClickHandler;
import ir.mehdiadeli.a32_databinding.model.User;


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

        User user=new User("Mehdi Adeli");
        ActivityMainBinding activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityMainBinding.setUser(user);
        ButtonClickHandler handler= new ButtonClickHandler(this) {
            @Override
            public void onButtonClicked(View view) {
                Toast.makeText(MainActivity.this, user.getName(), Toast.LENGTH_SHORT).show();
            }
        };
        activityMainBinding.setButtonClickHandler(handler);
        activityMainBinding.editText.setTextSize(48);
        activityMainBinding.textView.setTextColor(Color.BLUE);

    }
}