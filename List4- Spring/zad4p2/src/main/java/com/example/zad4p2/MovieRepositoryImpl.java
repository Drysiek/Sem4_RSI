package com.example.zad4p2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieRepositoryImpl implements MovieRepository {
    private List<Movie> movieList;

    public MovieRepositoryImpl(){
        movieList = new ArrayList<>();
        movieList.add(new Movie(0, "Titanic", false, 2.4, Genre.Romance));
        movieList.add(new Movie(1, "Dirty dancing", true, 4.2, Genre.Romance));
        movieList.add(new Movie(2, "Avatar 2", false, 2.9, Genre.Fantasy));
        movieList.add(new Movie(3, "Władca pierścieni", true, 4.6, Genre.Fantasy));
        movieList.add(new Movie(4, "Hiszpański Romans", true, 3.0, Genre.Romance));
        movieList.add(new Movie(5, "Milczenie owiec", true, 1.7, Genre.Horror));
    }

    public List<Movie> getAllMovies() {
        return movieList;
    }

    public Movie getMovie(int id) throws MovieNotFoundEx {
        for(Movie theMovie:movieList){
            if(theMovie.getId() == id){
                return theMovie;
            }
        }
        throw new MovieNotFoundEx(id);
    }
    public Movie getMovie(String name) throws MovieNotFoundEx{
        for(Movie theMovie:movieList){
            if(theMovie.getName().equals(name)){
                return theMovie;
            }
        }
        throw new MovieNotFoundEx(name);
    }

    public Movie updateMovie(int id, String name, boolean inCinema, double rating, Genre genre) throws MovieNotFoundEx {
        for(Movie theMovie:movieList){
            if(theMovie.getId() == id){
                movieList.remove(theMovie);
                theMovie.setId(id);
                theMovie.setName(name);
                theMovie.setinCinema(inCinema);
                theMovie.setRating(rating);
                theMovie.setGenre(genre);
                movieList.add(theMovie);
                return theMovie;
            }
        }
        throw new MovieNotFoundEx(id);
    }
    public boolean deleteMovie(int id) throws MovieNotFoundEx{
        for(Movie theMovie:movieList){
            if(theMovie.getId() == id){
                movieList.remove(theMovie);
                return true;
            }
        }
        throw new MovieNotFoundEx(id);
    }

    public Movie addMovie(int id, String name, boolean inCinema, double rating, Genre genre) throws MovieExistsEx{
        for(Movie theMovie:movieList){
            if(theMovie.getId() == id){
                throw new MovieExistsEx(id);
            }
        }
        Movie movie = new Movie(id, name, inCinema, rating, genre);
        movieList.add(movie);
        return movie;
    }

    public Movie addMovie(Movie movie) throws MovieExistsEx{
        int id = movie.getId();
        for(Movie theMovie:movieList){
            if(theMovie.getId() == id){
                throw new MovieExistsEx(id);
            }
        }
        movieList.add(movie);
        return movie;
    }

    public int countMovies(){
        return movieList.size();
    }

    public boolean deactivateMovie(int id) throws MovieNotFoundEx, DeactivationEx {
        for(Movie theMovie:movieList){
            if(theMovie.getId() == id){
                if(theMovie.isinCinema()){
                    theMovie.setinCinema(false);
                    return true;
                }
                else{
                    throw new DeactivationEx(id);
                }
            }
        }
        throw new MovieNotFoundEx(id);
    }

    public boolean activateMovie(int id) throws MovieNotFoundEx, ActivationEx {
        for(Movie theMovie:movieList){
            if(theMovie.getId() == id){
                if(theMovie.isinCinema()){
                    throw new ActivationEx(id);
                }
                else{
                    theMovie.setinCinema(true);
                    return true;
                }
            }
        }
        throw new MovieNotFoundEx(id);
    }

    public List<List<Movie>> listByGenre() throws EmptyMovieLibraryEx {
        if(movieList.size() == 0){
            throw new EmptyMovieLibraryEx();
        }
        List<List<Movie>> byGenreList = new ArrayList<>();
        Arrays.asList(Genre.values())
                .forEach(genre -> {
                    List<Movie> thisGenre = new ArrayList<>();
                        for(Movie theMovie:movieList){
                            if(theMovie.getGenre() == genre){
                                thisGenre.add(theMovie);
                            }
                        }
                    byGenreList.add(thisGenre);
                });
        return byGenreList;
    }

    public void sort(ArrayList<Movie> list) {
        movieList.sort((o1, o2)
                -> o1.compareTo(o2));
    }
}
