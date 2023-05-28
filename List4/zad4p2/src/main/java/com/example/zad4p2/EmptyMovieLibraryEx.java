package com.example.zad4p2;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class EmptyMovieLibraryEx extends Exception {
    public EmptyMovieLibraryEx(){
        super();
    }
}
