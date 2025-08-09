package ir.mehdiadeli.a28_boundservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Random;

public class BaseService extends Service {
    public class LocalBinder extends Binder{
        public BaseService getService(){
            return BaseService.this;
        }
    }
    private final IBinder binder=new LocalBinder();
    public BaseService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
       return binder;
    }
    public int getRandomNumber(){
        return new Random().nextInt(100);
    }
}