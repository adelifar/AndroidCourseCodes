package com.tosinso.a23phonelist;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.tosinso.a23phonelist.adapter.PhoneAdapter;
import com.tosinso.a23phonelist.models.Phone;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        //data source
        //Arraylist
        ArrayList<Phone> phones = new ArrayList<>();
        Phone phone = new Phone("iPhone 16 CH", "95,550,000 تومان", R.drawable.iphone16);
        phones.add(phone);
        phones.add(new Phone("Galaxy A55", "31,210,000 تومان", R.drawable.galaxya55));

        phones.add(new Phone("Poco M5s", "11,800,000 تومان", R.drawable.pocom5s));
        phones.add(new Phone("Galaxy s24 Ultra", "96,000,000 تومان", R.drawable.galaxys24));
        phones.add(new Phone("Galaxy A25", "19,900,000 تومان", R.drawable.galaxya25));
        phones.add(new Phone("Galaxy A35", "24,999,000 تومان", R.drawable.galaxya35));
        phones.add(new Phone("Galaxy A05s", "11,070,000 تومان", R.drawable.galaxya05s));
        phones.add(new Phone("Galaxy S23 FE", "38,990,000 تومان", R.drawable.galaxys23fe));
        phones.add(new Phone("Redmi Note 13", "26,999,000 تومان", R.drawable.redminote13));
        phones.add(new Phone("iPhone 13 Pro Max", "84,999,000 تومان", R.drawable.iphone13promax));

        PhoneAdapter adapter = new PhoneAdapter(MainActivity.this, phones);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Phone phone1=phones.get(i);
                Toast.makeText(MainActivity.this,"You clicked: "+phone1.getName()
                        ,Toast.LENGTH_SHORT ).show();
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}