package ir.mehdiadeli.a43_workmanager;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import java.util.concurrent.TimeUnit;

import ir.mehdiadeli.a43_workmanager.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
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
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        var data=new Data.Builder().putInt(getString(R.string.max),50).build();

        Constraints constraints=new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED)
                .build();
        var periodicRequest=new PeriodicWorkRequest.Builder(MyWorker.class,24, TimeUnit.HOURS);


        WorkRequest workRequest=new OneTimeWorkRequest
                .Builder(MyWorker.class)
                .setConstraints(constraints)
                .setInputData(data)
                .build();
        WorkManager instance = WorkManager.getInstance(getApplicationContext());
        binding.button.setOnClickListener(view -> {

            instance.enqueue(workRequest);
        });
        instance.getWorkInfoByIdLiveData(workRequest.getId()).observe(this,workInfo ->{
            Toast.makeText(this, workInfo.getState().toString(), Toast.LENGTH_SHORT).show();
            if (workInfo.getState().isFinished()){
                var outputData=workInfo.getOutputData();
                var message=outputData.getString(getString(R.string.message));
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            }
        } );
    }
}