package com.tosinso.a22listviewadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyCustomAdapter extends BaseAdapter {
    String[] items;
    Context context;

    public MyCustomAdapter(String[] items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int i) {
        return items[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        //context
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.my_list_item, viewGroup, false);
            holder = new ViewHolder();
            holder.textView = view.findViewById(R.id.text1);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
//        TextView textView=view.findViewById(R.id.text1);
        holder.textView.setText(items[i]);
        return view;
    }

    //ViewHolder
    static class ViewHolder {
        TextView textView;
    }
}
