package org.example;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.List;

@WebService(serviceName = "MovieService",
        endpointInterface = "org.example.MovieService")
public class MovieServiceImpl implements MovieService{
    private MovieRepository dataRepository = new MovieRepositoryImpl();

    @WebMethod
    public Movie getMovie(int id) throws MovieNotFoundEx{
        System.out.println("...called getMovies id="+id);
        return dataRepository.getMovie(id);
    }
    @WebMethod
    public Movie addMovie(int id, String name, boolean inCinema, double rating, Genre genre) throws MovieExistsEx{
        System.out.println("...called addMovie id=" + id + " name=" + name + " rating=" + rating + " genre=" + genre);
        return dataRepository.addMovie(id, name, inCinema, rating, genre);
    }
    @WebMethod
    public boolean deleteMovie(int id) throws MovieNotFoundEx{
        System.out.println("...called deleteMovie id=" + id);
        return dataRepository.deleteMovie(id);
    }
    @WebMethod
    public List<Movie> getAllMovies(){
        System.out.println("...called getAllMovies");
        return dataRepository.getAllMovies();
    }
    @WebMethod
    public int countMovie(){return dataRepository.countMovies();}
    public Movie updateMovie(int id, String name, boolean inCinema, double rating, Genre genre) throws MovieNotFoundEx{
        return dataRepository.updateMovie(id, name, inCinema, rating, genre);
    }

}
