package com.tosinso.a25_citiesproject.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tosinso.a25_citiesproject.CityClickListener;
import com.tosinso.a25_citiesproject.R;
import com.tosinso.a25_citiesproject.model.City;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityViewHolder> {

    private List<City> cities;
    private CityClickListener cityClickListener;

    public void setCityClickListener(CityClickListener cityClickListener) {
        this.cityClickListener = cityClickListener;
    }

    public CityAdapter(List<City> cities) {
        this.cities = cities;
    }

    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.city_item, parent, false);
        return new CityViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CityViewHolder holder, int position) {
        City city = cities.get(position);
        holder.cityImage.setImageResource(city.getImageId());
        holder.titleText.setText(city.getTitle());
        holder.descriptionText.setText(city.getDescription());
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    public class CityViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView cityImage;
        TextView titleText;
        TextView descriptionText;

        public CityViewHolder(@NonNull View itemView) {
            super(itemView);
            cityImage = itemView.findViewById(R.id.cityImage);
            titleText=itemView.findViewById(R.id.titleText);
            descriptionText=itemView.findViewById(R.id.descriptionText);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            cityClickListener.onItemClick(view,getAdapterPosition());
        }
    }
}
