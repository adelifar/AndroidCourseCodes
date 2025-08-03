package ir.mehdiadeli.a26_movielist.model;

public class Movie {
    private String title,director,imdb;
    private int ImageResourceId;

    public Movie(String title, String director, String imdb, int imageResourceId) {
        this.title = title;
        this.director = director;
        this.imdb = imdb;
        ImageResourceId = imageResourceId;
    }

    public Movie() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getImdb() {
        return imdb;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    public int getImageResourceId() {
        return ImageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        ImageResourceId = imageResourceId;
    }
}
