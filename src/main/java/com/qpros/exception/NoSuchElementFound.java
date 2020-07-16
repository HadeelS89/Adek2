package com.qpros.exception;

public class NoSuchElementFound extends Exception{
    private static final long   serialVersionUID = -7986915990118714483L;

    private static final String DEFAULT_MESSAGE  = "the specific web Element is not Visible or Cannot be found";

    public NoSuchElementFound() {
        super(DEFAULT_MESSAGE);
    }

    public NoSuchElementFound(String message) {
        super(message);
    }

}