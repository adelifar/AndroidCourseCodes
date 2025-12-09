package ir.mehdiadeli.a40_movieapiproject.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.paging.PagingDataAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;

import ir.mehdiadeli.a40_movieapiproject.R;
import ir.mehdiadeli.a40_movieapiproject.databinding.MovieListItemBinding;
import ir.mehdiadeli.a40_movieapiproject.model.Movie;

public class MoviePagingAdapter
        extends PagingDataAdapter<Movie,MoviePagingAdapter.MoviePagingViewHolder> {
    static final DiffUtil.ItemCallback<Movie> DIFF_CALLBACK=new DiffUtil.ItemCallback<Movie>() {
        @Override
        public boolean areItemsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
            return Objects.equals(oldItem.getId(), newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
            return oldItem.equals(newItem);
        }
    };
    public MoviePagingAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public MoviePagingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MovieListItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.movie_list_item, parent, false);
        return new MoviePagingViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviePagingViewHolder holder, int position) {
        Movie currentMovie = getItem(position);
        holder.binding.setMovie(currentMovie);
    }

    public static class MoviePagingViewHolder extends RecyclerView.ViewHolder {

        MovieListItemBinding binding;

        public MoviePagingViewHolder(@NonNull MovieListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
