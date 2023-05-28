package com.example.zad4p2;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class MovieNotFoundEx extends Exception {
    public MovieNotFoundEx(int index){
        super(" id: " + index + " ");
    }
    public MovieNotFoundEx(String name){
        super(" name: " + name + " ");
    }
}
