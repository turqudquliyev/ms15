package az.ingress.exception;

import az.ingress.exception.constants.ErrorMessage;

public class UnexpectedException extends Exception {
    public UnexpectedException(ErrorMessage message) {
        super(message.toString());
    }
}