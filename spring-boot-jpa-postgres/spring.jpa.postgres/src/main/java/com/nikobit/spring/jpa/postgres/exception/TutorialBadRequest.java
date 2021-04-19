package com.nikobit.spring.jpa.postgres.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TutorialBadRequest extends RuntimeException {
    public TutorialBadRequest(String message) {
        super(message);
    }
}
