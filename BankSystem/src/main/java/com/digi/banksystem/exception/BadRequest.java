package com.digi.banksystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequest extends Exception{
    public BadRequest(String massage) {
        super(massage);
    }
}
