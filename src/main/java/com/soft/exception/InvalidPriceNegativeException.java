package com.soft.exception;

public class InvalidPriceNegativeException extends RuntimeException {

    public InvalidPriceNegativeException(String message) {
        super(message);
    }

}
