package ru.vood.infrastructure.wrappers;

import java.util.List;

public class ErrorMessage {
    private List<String> errorMessages;

    public ErrorMessage() {
    }

    public ErrorMessage(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }
}
