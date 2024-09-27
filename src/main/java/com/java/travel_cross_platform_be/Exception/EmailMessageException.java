package com.java.travel_cross_platform_be.Exception;


public class EmailMessageException extends RuntimeException {
    public EmailMessageException(String message) {
        super(message);
    }

    public EmailMessageException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailMessageException(Throwable cause) {
        super(cause);
    }
    public EmailMessageException() {
        super();
    }

    protected EmailMessageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
