package com.tosinso.a25_citiesproject;

import com.tosinso.a25_citiesproject.model.City;

import java.util.ArrayList;
import java.util.List;

public class CityData {
    private List<City> cities;

    public CityData() {
        cities=new ArrayList<>();
        cities.add(new City("Tehran","Capital Of Iran", R.drawable.tehran));
        cities.add(new City("Isfahan","Historic Iranian city renowned for its Persian architecture, grand boulevards, and vibrant culture",R.drawable.isfahan));
        cities.add(new City("Tabriz","Tabriz is Iran's third-largest metropolis and East Azerbaijan province's capital.",R.drawable.tabriz));
        cities.add(new City("Hamadan","One of the oldest cities in the world, known for its rich history",R.drawable.hamadan));

        cities.add(new City("Mashhad","Mashhad is Iran's second largest city, a major pilgrimage site for Shia Muslims due to the Imam Reza shrine",R.drawable.mashad));
        cities.add(new City("Shiraz","Shiraz is a historic Iranian city renowned as a cultural capital, famous for its poets, gardens, and vibrant atmosphere",R.drawable.shiraz));
        cities.add(new City("Kerman"," known for its rich cultural heritage, ancient sites, and unique desert landscapes",R.drawable.kerman));
        cities.add(new City("Yazd"," known for its unique adobe architecture, windcatchers, and Zoroastrian heritage",R.drawable.yazd));
    }

    public List<City> getCities() {
        return cities;
    }
}
