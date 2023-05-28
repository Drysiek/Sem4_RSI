package com.example.zad4p2;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class MovieExistsEx extends Exception {
    public MovieExistsEx(int index){
        super(" " + index + " ");
    }
}
