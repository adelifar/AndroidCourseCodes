package ir.mehdiadeli.a37_studentdatabaseproejct.handlers;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import ir.mehdiadeli.a37_studentdatabaseproejct.AddNewStudentActivity;

public class MainActivityClickHandlers {
    private Context context;

    public MainActivityClickHandlers(Context context) {
        this.context = context;
    }

    public void onFabClicked(View view){
        Intent intent=new Intent(context, AddNewStudentActivity.class);
        context.startActivity(intent);
    }
}
