package ir.mehdiadeli.a29_broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AirplaneModeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
       if (intent.getAction()!=null &&
               intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)){
           boolean mode=intent.getBooleanExtra("state",false);
           String message=mode?"Flight mode is ON":"Flight mode is OFF";
           Toast.makeText(context, message, Toast.LENGTH_LONG).show();
       }
    }
}