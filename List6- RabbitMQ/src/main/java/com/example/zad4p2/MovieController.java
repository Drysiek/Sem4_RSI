package com.example.zad4p2;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@CrossOrigin
@RestController
public class MovieController {
    private final MovieRepository impl = new MovieRepositoryImpl();
    public static final String QUEUE1 = "Queue1";
    public static final String QUEUE2 = "Queue2";
    public static final String QUEUE3 = "Queue3";

    ConnectionFactory factory = new ConnectionFactory();
    Connection connection = null;

    @GetMapping("/movies/{id}")
    public EntityModel<?> getMovie(@PathVariable int id) {
        try{
            Link x = linkTo(methodOn(MovieController.class).activateMovie(id)).withRel("InCinema");
            if(impl.getMovie(id).isinCinema())
                x = linkTo(methodOn(MovieController.class).deactivateMovie(id)).withRel("InCinema");

//            try
//            {
//                connection = factory.newConnection();
//                Channel channel = connection.createChannel();
//                channel.queueDeclare(QUEUE1, false, false, false, null);
//
//                var msg = "Trying to find movie with id: " + id;
//                System.out.println("Sending message on queue1: \"" + msg + "\"");
//                channel.basicPublish("", QUEUE1, null, msg.getBytes());
//
//                channel.close();
//                connection.close();
//
//                if(impl.getMovie(id).isinCinema()) {
//                    connection = factory.newConnection();
//                    Channel channel2 = connection.createChannel();
//                    channel2.queueDeclare(QUEUE2, false, false, false, null);
//
//                    msg = "Trying to find movie with id: " + id;
//                    System.out.println("Sending message on queue2: \"" + msg + "\"");
//                    channel2.basicPublish("", QUEUE2, null, msg.getBytes());
//
//                    channel2.close();
//                    connection.close();
//                }
//            }
//            catch (Exception e)
//            {
//                e.printStackTrace();
//            }

            try {
                connection = factory.newConnection();
                Channel channel = connection.createChannel();

                String exchange = "my_exchange";
                channel.exchangeDeclare(exchange, "direct");

                String routingKey1 = "key1";
                String msg = "Trying to find movie with id: " + id;
                channel.basicPublish(exchange, routingKey1, null, msg.getBytes());
                System.out.println("Sending message on queue1 with routing key " + routingKey1 + ": \"" + msg + "\"");

                channel.close();
                connection.close();

                if (impl.getMovie(id).isinCinema()) {
                    connection = factory.newConnection();
                    Channel channel2 = connection.createChannel();

                    String routingKey2 = "key2";
                    msg = "Trying to find movie with id: " + id;
                    channel2.basicPublish(exchange, routingKey2, null, msg.getBytes());
                    System.out.println("Sending message on queue2 with routing key " + routingKey2 + ": \"" + msg + "\"");

                    channel2.close();
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


            return EntityModel.of(impl.getMovie(id),
                    linkTo(methodOn(MovieController.class).getMovie(id)).withSelfRel(),
                    linkTo(methodOn(MovieController.class).deleteMovie(id)).withRel("delete"),
                    x,
                    linkTo(methodOn(MovieController.class).getMovie()).withRel("list all")
            );
        } catch (MovieNotFoundEx e) {
                System.out.println("...GET Exception");
                throw new RuntimeException(e);
        }
    }

    @GetMapping("/movies")
    public CollectionModel<EntityModel<Movie>> getMovie() throws MovieNotFoundEx{
//        factory.setHost("localhost");
//        try
//        {
//            connection = factory.newConnection();
//            Channel channel = connection.createChannel();
//            channel.queueDeclare(QUEUE2, false, false, false, null);
//
//            var msg = "Trying to find all movies";
//            System.out.println("Sending message: \"" + msg + "\"");
//            channel.basicPublish("", QUEUE2, null, msg.getBytes());
//
//            channel.close();
//            connection.close();
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }

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
            Link x = linkTo(methodOn(MovieController.class).activateMovie(movie.getId())).withRel("InCinema");
            if(temp.isinCinema())
                x = linkTo(methodOn(MovieController.class).deactivateMovie(movie.getId())).withRel("InCinema");
            return EntityModel.of(temp,
                    linkTo(methodOn(MovieController.class).getMovie(movie.getId())).withSelfRel(),
                    linkTo(methodOn(MovieController.class).deleteMovie(movie.getId())).withRel("delete"),
                    x
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
            Link x = linkTo(methodOn(MovieController.class).activateMovie(movie.getId())).withRel("InCinema");
            if(impl.getMovie(movie.getId()).isinCinema())
                x = linkTo(methodOn(MovieController.class).deactivateMovie(movie.getId())).withRel("InCinema");
            return EntityModel.of(impl.addMovie(movie),
                    linkTo(methodOn(MovieController.class).getMovie(movie.getId())).withSelfRel(),
                    linkTo(methodOn(MovieController.class).deleteMovie(movie.getId())).withRel("delete"),
                    linkTo(methodOn(MovieController.class).getMovie()).withRel("list all"),
                    x
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
            Link x = linkTo(methodOn(MovieController.class).activateMovie(id)).withRel("InCinema");
            if(impl.getMovie(id).isinCinema())
                x = linkTo(methodOn(MovieController.class).deactivateMovie(id)).withRel("InCinema");
            return EntityModel.of(impl.updateMovie(id, movie.getName(), movie.isinCinema(), movie.getRating(), movie.getGenre()),
                    linkTo(methodOn(MovieController.class).getMovie(id)).withSelfRel(),
                    linkTo(methodOn(MovieController.class).deleteMovie(id)).withRel("delete"),
                    linkTo(methodOn(MovieController.class).getMovie()).withRel("list all"),
                    x
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


//    @GetMapping("/images/{id}/image")
//    public ResponseEntity<byte[]> getMovieImage(@PathVariable int id) throws TimeoutException {
//        System.out.println("get image...");
//        try {
////            ConnectionFactory factory = new ConnectionFactory();
////            factory.setHost("localhost");
////            connection = factory.newConnection();
////            channel = connection.createChannel();
////            replyQueueName = channel.queueDeclare().getQueue();
//
//            String imageName = id + ".png";
//
//            File imageFile = new File("C:\\Users\\505ry\\OneDrive\\Pulpit\\zad4p2\\src\\main\\java\\com\\example\\zad4p2\\images\\" + imageName);
//            byte[] imageBytes = Files.readAllBytes(imageFile.toPath());
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.IMAGE_PNG);
//
//            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @GetMapping("/images/{id}/image")
    public ResponseEntity<byte[]> getMovieImage(@PathVariable("id") String itemId) throws Exception {
        System.out.println("get image...");
        ProducerImage producer = null;
        try{
            producer = new ProducerImage();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_PNG);

            byte[] imageBytes = producer.getImage(itemId);

            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            assert producer != null;
            producer.close();
            System.out.println("close");
        }
        return null;
    }


}
