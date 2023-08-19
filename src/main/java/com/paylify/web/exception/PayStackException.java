package com.paylify.web.exception;

public class PayStackException extends PaylifyException{

    public PayStackException(String err, String code) {
        super(err, code);
    }
}
