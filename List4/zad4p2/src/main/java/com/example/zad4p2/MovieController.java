package com.example.zad4p2;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@CrossOrigin
@RestController
public class MovieController {
    private final MovieRepository impl = new MovieRepositoryImpl();

    @GetMapping("/movies/{id}")
    public EntityModel<?> getMovie(@PathVariable int id) {
        try{
            return EntityModel.of(impl.getMovie(id),
                    linkTo(methodOn(MovieController.class).getMovie(id)).withSelfRel(),
                    linkTo(methodOn(MovieController.class).deleteMovie(id)).withRel("delete"),
                    linkTo(methodOn(MovieController.class).deactivateMovie(id)).withRel("In  Cinema?"),
                    linkTo(methodOn(MovieController.class).activateMovie(id)).withRel("In  Cinema?"),
                    linkTo(methodOn(MovieController.class).getMovie()).withRel("list all")
            );
        } catch (MovieNotFoundEx e) {
                System.out.println("...GET Exception");
                throw new RuntimeException(e);
        }
    }

    @GetMapping("/movies")
    public CollectionModel<EntityModel<Movie>> getMovie() throws MovieNotFoundEx{
        System.out.println("...called GET");
        impl.sort((ArrayList<Movie>) impl.getAllMovies());
        List<EntityModel<Movie>> movies;
        movies = impl.getAllMovies().stream().map(movie ->
        {
            Movie temp = new Movie();
            try {
                temp = impl.getMovie(movie.getId());
            }catch (MovieNotFoundEx e) {
                throw new RuntimeException(e);
            }
            return EntityModel.of(temp,
                    linkTo(methodOn(MovieController.class).getMovie(movie.getId())).withSelfRel(),
                    linkTo(methodOn(MovieController.class).deleteMovie(movie.getId())).withRel("delete"),
                    linkTo(methodOn(MovieController.class).deactivateMovie(movie.getId())).withRel("In  Cinema?"),
                    linkTo(methodOn(MovieController.class).activateMovie(movie.getId())).withRel("In  Cinema?")
            );

        }).collect(Collectors.toList());
        return CollectionModel.of(movies, linkTo(methodOn(MovieController.class).getMovie()).withRel("list all"));
    }
    @DeleteMapping("/movies/{id}")
    public Object deleteMovie(@PathVariable int id){
        try{
            System.out.println("...called DELETE");
            return impl.deleteMovie(id);
        } catch (MovieNotFoundEx e) {
            System.out.println("...DELETE Exception");
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/movies")
    public EntityModel<?> addMovie(@RequestBody Movie movie){
        try{
            System.out.println("...called POST");
            return EntityModel.of(impl.addMovie(movie),
                    linkTo(methodOn(MovieController.class).getMovie(movie.getId())).withSelfRel(),
                    linkTo(methodOn(MovieController.class).deleteMovie(movie.getId())).withRel("delete"),
                    linkTo(methodOn(MovieController.class).getMovie()).withRel("list all"),
                    linkTo(methodOn(MovieController.class).deactivateMovie(movie.getId())).withRel("In  Cinema?"),
                    linkTo(methodOn(MovieController.class).activateMovie(movie.getId())).withRel("In  Cinema?")
            );
        } catch (MovieExistsEx | MovieNotFoundEx e) {
            System.out.println("...POST Exception");
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/movies/{id}")
    public EntityModel<?> updateMovie(@PathVariable int id, @RequestBody Movie movie){
        try{
            System.out.println("...called PUT");
            return EntityModel.of(impl.updateMovie(id, movie.getName(), movie.isinCinema(), movie.getRating(), movie.getGenre()),
                    linkTo(methodOn(MovieController.class).getMovie(id)).withSelfRel(),
                    linkTo(methodOn(MovieController.class).deleteMovie(id)).withRel("delete"),
                    linkTo(methodOn(MovieController.class).getMovie()).withRel("list all"),
                    linkTo(methodOn(MovieController.class).deactivateMovie(id)).withRel("In  Cinema?"),
                    linkTo(methodOn(MovieController.class).activateMovie(id)).withRel("In  Cinema?")
                    );
        } catch (Exception e) {
            System.out.println("...PUT Exception");
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/movies/{id}/deactivate")
    public Object deactivateMovie(@PathVariable int id){
        try{
            System.out.println("...called PUT");
            return impl.deactivateMovie(id);
        } catch (Exception e) {
            System.out.println("...PUT Exception");
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/movies/{id}/activate")
    public Object activateMovie(@PathVariable int id){
        try{
            System.out.println("...called PUT");
            return impl.activateMovie(id);
        } catch (Exception e) {
            System.out.println("...PUT Exception");
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/movies/listByGenre")
    public List<List<Movie>> listByGenre() throws EmptyMovieLibraryEx {
        return impl.listByGenre();
    }

}
