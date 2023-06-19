package com.example.zad4p2;

import java.util.ArrayList;
import java.util.List;

public interface MovieRepository {
    List<Movie> getAllMovies();
    Movie getMovie(int id) throws MovieNotFoundEx;
    Movie getMovie(String name) throws MovieNotFoundEx;
    Movie updateMovie(int id, String name, boolean inCinema, double rating, Genre genre) throws MovieNotFoundEx;
    boolean deleteMovie(int id) throws MovieNotFoundEx;
    Movie addMovie(int id, String name, boolean inCinema, double rating, Genre genre) throws MovieExistsEx;
    Movie addMovie(Movie movie) throws MovieExistsEx;
    int countMovies();
    boolean deactivateMovie(int id) throws MovieNotFoundEx, DeactivationEx;
    boolean activateMovie(int id) throws MovieNotFoundEx, ActivationEx;
    List<List<Movie>> listByGenre() throws EmptyMovieLibraryEx;
    void sort(ArrayList<Movie> list);
}
