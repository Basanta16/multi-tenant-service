package com.basanta.multitenant.exception;

public class InvalidRequestBodyException extends RuntimeException{
    public InvalidRequestBodyException(String e) {
        super(e);
    }
}
