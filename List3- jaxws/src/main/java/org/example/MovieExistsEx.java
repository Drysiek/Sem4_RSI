package org.example;

import jakarta.xml.ws.WebFault;

@WebFault
public class MovieExistsEx extends Exception {
    public MovieExistsEx(int index){
        super(" " + index + " ");
    }
}
