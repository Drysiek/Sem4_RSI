package org.example;

import jakarta.xml.ws.WebFault;

@WebFault
public class MovieNotFoundEx extends Exception {
    public MovieNotFoundEx(int index){
        super(" id: " + index + " ");
    }
    public MovieNotFoundEx(String name){
        super(" name: " + name + " ");
    }
}
