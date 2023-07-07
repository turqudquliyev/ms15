package az.ingress.exception;

import az.ingress.exception.constants.ErrorMessage;

public class NotFoundException extends RuntimeException {
    public NotFoundException(ErrorMessage message) {
        super(message.toString());
    }
}