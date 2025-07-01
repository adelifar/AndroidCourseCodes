package com.tosinso.a25_citiesproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tosinso.a25_citiesproject.adapter.CityAdapter;
import com.tosinso.a25_citiesproject.model.City;

import java.util.List;

public class MainActivity extends AppCompatActivity implements CityClickListener {
    RecyclerView recyclerView;
    List<City> cities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //adapter view
        recyclerView = findViewById(R.id.recycler);

        //datasource
        cities = new CityData().getCities();
        //adapter
        CityAdapter adapter = new CityAdapter(cities);
        adapter.setCityClickListener(this);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onItemClick(View view, int position) {
        City city=cities.get(position);
        Toast.makeText(MainActivity.this,"You selected: "+city.getTitle(),Toast.LENGTH_SHORT).show();
    }
}