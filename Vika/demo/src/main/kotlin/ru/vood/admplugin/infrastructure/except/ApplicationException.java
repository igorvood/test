package ru.vood.admplugin.infrastructure.except;

public class ApplicationException extends RuntimeException {

    protected ApplicationException() {
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationException(String message) {
        super(message);
    }
}
