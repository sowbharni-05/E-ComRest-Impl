package com.banfico.EcomApplication.Exception;

import org.springframework.web.bind.MethodArgumentNotValidException;

public class DataNotValidException extends RuntimeException {
    public DataNotValidException() {
    }

    public DataNotValidException(String message, Throwable cause) {
        super(message, cause);
    }
}
