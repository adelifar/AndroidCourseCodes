package com.tosinso.a19_datetimepicker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity2 extends AppCompatActivity {
DatePicker datePicker;
Button showDateButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        datePicker=findViewById(R.id.datePicker1);
        datePicker.getYear();
        datePicker.getMonth();
        datePicker.getDayOfMonth();

        Calendar minDate=Calendar.getInstance();
        minDate.set(2025,Calendar.JANUARY,1);
        datePicker.setMinDate(minDate.getTimeInMillis());

        datePicker.init(2025,3,12,null);

//        datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
//            @Override
//            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
//
//            }
//        });


showDateButton=findViewById(R.id.showDateBtn);
showDateButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Toast.makeText(MainActivity2.this,"You selected :"+datePicker.getYear()+
                "/"+(datePicker.getMonth()+1)+
                "/"+datePicker.getDayOfMonth()
                ,Toast.LENGTH_LONG).show();
    }
});



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}