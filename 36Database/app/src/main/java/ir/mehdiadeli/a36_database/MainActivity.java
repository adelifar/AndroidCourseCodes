package ir.mehdiadeli.a36_database;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import ir.mehdiadeli.a36_database.db.MyDatabase;
import ir.mehdiadeli.a36_database.db.User;

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
        MyDatabase database=MyDatabase.getInstance(this);
        database.getUserDao().insert(new User("Sima","Sima@tosinso.com"));
                List<User> users=database.getUserDao().getAllUsers();
        String usernames="";
        for (User user:users){
            usernames=usernames+" "+user.getUsername();
        }
        Toast.makeText(this, usernames, Toast.LENGTH_SHORT).show();
    }
}