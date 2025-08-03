package ir.mehdiadeli.a26_movielist.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ir.mehdiadeli.a26_movielist.R;
import ir.mehdiadeli.a26_movielist.model.Movie;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHodler> {
    private List<Movie> movieList, fullList;

    public MovieAdapter(List<Movie> movieList) {
        this.movieList = new ArrayList<>(movieList);
        fullList = new ArrayList<>(movieList);
    }

    @NonNull
    @Override
    public MovieHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.movie_item, parent, false);
        return new MovieHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHodler holder, int position) {
        Movie movie = movieList.get(position);
        holder.titleText.setText(movie.getTitle());
        holder.directorText.setText(movie.getDirector());
        holder.imdbText.setText(movie.getImdb());
        holder.imageView.setImageResource(movie.getImageResourceId());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void filter(String query) {
        this.movieList.clear();
        if (query.isEmpty())
            movieList.addAll(fullList);
        else {
            String text = query.toLowerCase();
            for (Movie movie : fullList) {
                if (movie.getTitle().toLowerCase().contains(text) || movie.getDirector().toLowerCase().contains(text))
                    movieList.add(movie);
            }
        }
        notifyDataSetChanged();
    }

    public static class MovieHodler extends RecyclerView.ViewHolder {
        TextView titleText, directorText, imdbText;
        ImageView imageView;

        public MovieHodler(@NonNull View itemView) {
            super(itemView);
            titleText = itemView.findViewById(R.id.titleText);
            directorText = itemView.findViewById(R.id.directorText);
            imdbText = itemView.findViewById(R.id.imdbText);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
