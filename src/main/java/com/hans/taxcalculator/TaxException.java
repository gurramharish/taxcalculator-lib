package com.hans.taxcalculator;

public class TaxException extends RuntimeException {

    private String message;

    public TaxException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
