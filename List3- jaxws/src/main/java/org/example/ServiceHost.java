package org.example;

import jakarta.xml.ws.Endpoint;

import java.io.IOException;

import static java.lang.System.exit;

public class ServiceHost {
    public static void main(String[] args) {
        System.out.println("Web Service org.example.MovieService is running ...");
        MovieServiceImpl psi = new MovieServiceImpl();
        Endpoint.publish("http://localhost:8081/movieservice", psi);
        System.out.println("Press ENTER to STOP org.example.MovieService ...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        exit(0);
    }
}
