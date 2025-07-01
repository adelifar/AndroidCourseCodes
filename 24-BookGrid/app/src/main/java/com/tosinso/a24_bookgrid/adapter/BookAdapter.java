package com.tosinso.a24_bookgrid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.tosinso.a24_bookgrid.R;
import com.tosinso.a24_bookgrid.model.Book;

import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {
    public BookAdapter(@NonNull Context context, @NonNull List<Book> books) {
        super(context, R.layout.grid_item, books);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Book currentBook=getItem(position);
        ViewHolder holder;
        if (convertView==null){
            convertView=inflateConvertView(parent);
            holder=new ViewHolder();
            assignHolderWidgets(convertView,holder);
            convertView.setTag(holder);
        }else holder= (ViewHolder) convertView.getTag();
        setWidgetsValue(holder,currentBook);
        return convertView;
    }


    private void setWidgetsValue(ViewHolder holder,@NonNull Book currentBook){
        holder.titleText.setText(currentBook.getTitle());
        holder.coverImage.setImageResource(currentBook.getImageResourceId());
    }

    private void assignHolderWidgets(@NonNull View convertView,ViewHolder holder){
        holder.titleText=convertView.findViewById(R.id.titleText);
        holder.coverImage=convertView.findViewById(R.id.coverImage);
    }
    private View inflateConvertView(@NonNull ViewGroup parent){
        View convertView;
        LayoutInflater inflater=LayoutInflater.from(getContext());
        convertView=inflater.inflate(R.layout.grid_item,parent,false);
        return convertView;
    }
    private static class ViewHolder{
        ImageView coverImage;
        TextView titleText;
    }
}
