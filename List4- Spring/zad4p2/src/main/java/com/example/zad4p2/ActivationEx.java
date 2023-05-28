package com.example.zad4p2;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class ActivationEx extends Exception {
    public ActivationEx(int index){
        super(" " + index + " ");
    }
}
