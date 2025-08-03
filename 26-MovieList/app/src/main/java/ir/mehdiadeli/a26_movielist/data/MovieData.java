package ir.mehdiadeli.a26_movielist.data;

import java.util.ArrayList;
import java.util.List;

import ir.mehdiadeli.a26_movielist.R;
import ir.mehdiadeli.a26_movielist.model.Movie;

public class MovieData {
    private List<Movie> movieList;

    public MovieData() {
        movieList=new ArrayList<>();
        movieList.add(new Movie("The Shawshank Redemption","Frank Darabont","9.3/10", R.drawable.shawshank));
        movieList.add(new Movie("The Green Mile", "Frank Darabont", "8,6/10", R.drawable.greenmile));
        movieList.add(new Movie("Schindler's List", "Steven Spielberg", "9/10", R.drawable.schinder));
        movieList.add(new Movie("The Prestige", "Christopher Nolan", "8.5/10", R.drawable.prestige));
        movieList.add(new Movie("Apocalypse Now", "Francis Ford Coppola", "8.4/10", R.drawable.apocalypse));
        movieList.add(new Movie("Good Will Hunting", "Gus Van Sant", "8.3/10", R.drawable.goodwill));
        movieList.add(new Movie("Django Unchained", "Quentin Tarantino", "8.5/10", R.drawable.django));
        movieList.add(new Movie("Fight Club", "David Fincher", "8.8/10", R.drawable.fight));
        movieList.add(new Movie("Whiplash", "Damien Chazelle", "8.5/10", R.drawable.whiplash));
        movieList.add(new Movie("The Dark Knight", "Christopher Nolan", "9.1/10", R.drawable.darkknight));
        movieList.add(new Movie("Hacksaw Ridge", "Mel Gibson", "8.1/10", R.drawable.hacksawridge));
        movieList.add(new Movie("Saving Private Ryan", "Steven Spielberg", "8,6/10", R.drawable.saveing));
        movieList.add(new Movie("Interstellar", "Christopher Nolan", "8,7/10", R.drawable.interstellar));
    }

    public List<Movie> getMovieList() {
        return movieList;
    }
}
