package com.example.zad4p2;

import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.mediatype.problem.Problem;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@org.springframework.web.bind.annotation.ControllerAdvice
public class FaultController {
    @ResponseBody
    @ExceptionHandler(MovieNotFoundEx.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    ResponseEntity<?> PNFEHandler(MovieNotFoundEx e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).
                header(HttpHeaders.CONTENT_TYPE, MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE).
                body(Problem.create().withStatus(HttpStatus.NOT_FOUND).withTitle(HttpStatus.NOT_FOUND.name()).
                        withDetail(" - The movie with " + e.getMessage() + ", does not exist"));
    }

    @ResponseBody
    @ExceptionHandler(MovieExistsEx.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    ResponseEntity<?> PNFEHandler(MovieExistsEx e){
        return ResponseEntity.status(HttpStatus.CONFLICT).
                header(HttpHeaders.CONTENT_TYPE, MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE).
                body(Problem.create().withStatus(HttpStatus.CONFLICT).withTitle(HttpStatus.CONFLICT.name()).
                        withDetail(" - The movie with this id(" + e.getMessage() + ") already exist"));
    }

    @ResponseBody
    @ExceptionHandler(DeactivationEx.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    ResponseEntity<?> PNFEHandler(DeactivationEx e){
        return ResponseEntity.status(HttpStatus.CONFLICT).
                header(HttpHeaders.CONTENT_TYPE, MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE).
                body(Problem.create().withStatus(HttpStatus.CONFLICT).withTitle(HttpStatus.CONFLICT.name()).
                        withDetail(" - The movie with this id(" + e.getMessage() + ") is already deactivated"));
    }

    @ResponseBody
    @ExceptionHandler(ActivationEx.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    ResponseEntity<?> PNFEHandler(ActivationEx e){
        return ResponseEntity.status(HttpStatus.CONFLICT).
                header(HttpHeaders.CONTENT_TYPE, MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE).
                body(Problem.create().withStatus(HttpStatus.CONFLICT).withTitle(HttpStatus.CONFLICT.name()).
                        withDetail(" - The movie with this id(" + e.getMessage() + ") is already activated"));
    }

//    @ResponseBody
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
//    ResponseEntity<?> PNFEHandler(Exception e){
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).
//                header(HttpHeaders.CONTENT_TYPE, MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE).
//                body(Problem.create().withStatus(HttpStatus.BAD_REQUEST).withTitle(HttpStatus.BAD_REQUEST.name()).
//                        withDetail(" - The movie library is currently empty"));
//    }
}
