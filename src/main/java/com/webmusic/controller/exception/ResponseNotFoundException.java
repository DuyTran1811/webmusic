package com.webmusic.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResponseNotFoundException extends RuntimeException {

    public ResponseNotFoundException(String resource) {
        super(String.format("Resource %s not found", resource));
    }
}
