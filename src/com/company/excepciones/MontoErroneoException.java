package com.company.excepciones;

public class MontoErroneoException extends RuntimeException {
    public MontoErroneoException(String s) {
        super(s);
    }
}