package org.example;

public class Movie {
    private int id;
    private String name;
    private boolean inCinema;
    private double rating;
    private Genre genre;

    public Movie() {
    }

    public Movie(int id, String name, boolean inCinema, double rating, Genre genre) {
        this.id = id;
        this.name = name;
        this.inCinema = inCinema;
        this.rating = rating;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isinCinema() {
        return inCinema;
    }

    public void setinCinema(boolean inCinema) {
        this.inCinema = inCinema;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int compareTo(Movie movieToCompare) {
        return this.getId() - movieToCompare.getId();
    }
}
