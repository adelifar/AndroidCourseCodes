package com.tosinso.a23phonelist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.tosinso.a23phonelist.R;
import com.tosinso.a23phonelist.models.Phone;

import java.util.ArrayList;
import java.util.List;

public class PhoneAdapter extends ArrayAdapter<Phone> {
ArrayList<Phone> phoneArrayList;
    public PhoneAdapter(@NonNull Context context, @NonNull List<Phone> data) {
        super(context, R.layout.my_list_item, data);
        phoneArrayList= (ArrayList<Phone>) data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        Phone phone=phoneArrayList.get(position);
        Phone phone=getItem(position);
        PhoneViewHolder holder;
        if (convertView==null){
            LayoutInflater inflater=LayoutInflater.from(getContext());
            convertView=inflater.inflate(R.layout.my_list_item,parent,false);
            holder=new PhoneViewHolder();
            holder.nameTextView=convertView.findViewById(R.id.nameText);
            holder.priceTextView=convertView.findViewById(R.id.priceText);
            holder.imageView=convertView.findViewById(R.id.phoneImage);
            convertView.setTag(holder);

        }else
            holder = (PhoneViewHolder) convertView.getTag();
        holder.nameTextView.setText(phone.getName());
        holder.priceTextView.setText(phone.getPrice());
        holder.imageView.setImageResource(phone.getImageResource());
        return convertView;
    }

    private static class PhoneViewHolder{
        TextView nameTextView;
        TextView priceTextView;
        ImageView imageView;
    }
}
