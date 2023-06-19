package org.example;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface MovieService {
    @WebMethod
    Movie getMovie(int id) throws MovieNotFoundEx;
    @WebMethod
    Movie addMovie(int id, String name, boolean inCinema, double rating, Genre genre) throws MovieExistsEx;
    @WebMethod
    boolean deleteMovie(int id) throws MovieNotFoundEx;
    @WebMethod
    List<Movie> getAllMovies();
    @WebMethod
    int countMovie();
    Movie updateMovie(int id, String name, boolean inCinema, double rating, Genre genre) throws MovieNotFoundEx;
}
