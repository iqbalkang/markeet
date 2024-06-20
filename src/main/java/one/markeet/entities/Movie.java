package one.markeet.entities;

import one.markeet.constants.MovieGenre;

import java.util.Arrays;

public class Movie extends Bookmark {
    private int releaseYear;

    private double imdbRating;

    private String[] cast;
    private String[] directors;
    private String genre;

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String[] getCast() {
        return cast;
    }

    public void setCast(String[] cast) {
        this.cast = cast;
    }

    public String[] getDirectors() {
        return directors;
    }

    public void setDirectors(String[] directors) {
        this.directors = directors;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean isKidFriendly() {
        if(genre.equals(MovieGenre.THRILLER) || genre.equals(MovieGenre.HORROR)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "releaseYear=" + releaseYear +
                ", imdbRating=" + imdbRating +
                ", cast=" + Arrays.toString(cast) +
                ", directors=" + Arrays.toString(directors) +
                ", genre='" + genre + '\'' +
                "} " + super.toString();
    }
}
