package ir.mehdiadeli.a28_boundservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Timer;
import java.util.TimerTask;

public class TimerService extends Service {
    public class TimerBinder extends Binder{
        public TimerService getService(){
            return TimerService.this;
        }
    }

    private final IBinder binder=new TimerBinder();
    private int remainingTime=100;
    private Timer timer;
    private TimerTask timerTask;
    public interface TimerCallback{
        void onTimerUpdate(int remainingTime);
    }

    private TimerCallback callback;
    public TimerService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }
    public void startTimer(){
        if (timer!=null)
            return;
        timer=new Timer();
        timerTask=new TimerTask() {
            @Override
            public void run() {
                if (remainingTime>0){
                    remainingTime--;
                    if (callback!=null)
                        callback.onTimerUpdate(remainingTime);
                }else stopTimer();
            }
        };
        timer.schedule(timerTask,1000,1000);
    }
    public void stopTimer(){
        if (timerTask!=null){
            timerTask.cancel();
            timerTask=null;
        }
        if (timer!=null){
            timer.cancel();
            timer=null;
        }
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setCallback(TimerCallback callback) {
        this.callback = callback;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopTimer();
    }
}