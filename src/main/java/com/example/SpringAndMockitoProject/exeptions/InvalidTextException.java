package com.example.SpringAndMockitoProject.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)

public class InvalidTextException extends RuntimeException {
    public InvalidTextException() {
    }

    public InvalidTextException(String message) {
        super(message);
    }

    public InvalidTextException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidTextException(Throwable cause) {
        super(cause);
    }

    public InvalidTextException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}