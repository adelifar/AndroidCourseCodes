package ir.mehdiadeli.a32_databinding.handler;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

public abstract class ButtonClickHandler {
    Context context;
    public ButtonClickHandler(Context context) {
        this.context=context;
    }

//    public void onButtonClicked(View view){
//        Toast.makeText(context, "Button is Clicked", Toast.LENGTH_SHORT).show();
//    }
    public abstract void  onButtonClicked(View view);
}