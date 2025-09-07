package ir.mehdiadeli.a35listdatabinding.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ir.mehdiadeli.a35listdatabinding.R;
import ir.mehdiadeli.a35listdatabinding.databinding.ListItemBinding;
import ir.mehdiadeli.a35listdatabinding.model.User;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
private List<User> users;

    public MyAdapter(List<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ListItemBinding binding= DataBindingUtil.inflate(inflater, R.layout.list_item,parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User currentUser=users.get(position);
        holder.itemBinding.setUser(currentUser);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ListItemBinding itemBinding;

        public MyViewHolder(@NonNull ListItemBinding binding) {
            super(binding.getRoot());
            itemBinding=binding;
        }
    }
}
