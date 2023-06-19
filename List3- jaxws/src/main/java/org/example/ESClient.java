package org.example;

import org.example.jaxws.server_topdown.*;
import org.example.jaxws.server_topdown.Genre;
import org.example.jaxws.server_topdown.Movie;
import org.example.jaxws.server_topdown.MovieService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ESClient {
        public static void main(String[] args) throws MalformedURLException,
                MovieNotFoundEx_Exception, MovieExistsEx_Exception {
                int num = -1;
                URL addr = new URL("http://localhost:8081/movieservice?wsdl");
                MovieService_Service pService = new MovieService_Service();
                org.example.jaxws.server_topdown.MovieService pServiceProxy = pService.getMovieServiceImplPort();

                num = pServiceProxy.countMovie();
                System.out.println("Num of Movies = " + num);
                System.out.println("---------------");

                List<Movie> list2 = pServiceProxy.getAllMovies();
                for (Movie value : list2) {
                        System.out.println(value.getName() + "- " + value.getId());
                }
                System.out.println("---------------");

                org.example.jaxws.server_topdown.Movie movie = pServiceProxy.getMovie(1);
                pServiceProxy.addMovie(6, "Willy Wonka", false, 2.4, Genre.FANTASY);
                System.out.println("Movie " + movie.getName() + ", id = " + movie.getId());
                System.out.println("---------------");

                movie = pServiceProxy.getMovie(1);
                System.out.println(movie);
                pServiceProxy.updateMovie(3, "nowa nazwa filmu", false, 2.4, Genre.FANTASY);
                movie = pServiceProxy.getMovie(1);
                System.out.println(movie);
                System.out.println("---------------");

                List<Movie> list = pServiceProxy.getAllMovies();
                System.out.println("Movie list ");
                for (Movie value : list) {
                        System.out.println(value.getName());
                }
                pServiceProxy.deleteMovie(2);
                System.out.println("---------------");
                list2 = pServiceProxy.getAllMovies();
                for (Movie value : list2) {
                        System.out.println(value.getName());
                }
        }
}
