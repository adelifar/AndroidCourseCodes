package ir.mehdiadeli.a43_workmanager;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWorker extends Worker {
    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        var maxData=getInputData().getInt(getApplicationContext().getString(R.string.max),10);
        for (int i = 0; i < maxData; i++) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Log.d("TagTag","Counting "+i);
        }
        var outputData=new Data.Builder()
                .putString(getApplicationContext().getString(R.string.message)
                        ,"counted to "+maxData)
                .build();
        return Result.success(outputData);
    }
}
