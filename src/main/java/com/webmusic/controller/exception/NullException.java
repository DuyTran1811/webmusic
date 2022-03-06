package com.webmusic.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NullException extends RuntimeException {
    public NullException(String message) {
        super(message);
    }
}
