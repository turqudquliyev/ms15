package az.ingress.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {NotFoundException.class})
    @ResponseStatus(NOT_FOUND)
    public ErrorResponse handleException(NotFoundException ex) {
        return new ErrorResponse(ex.getMessage());
    }

    @ExceptionHandler(value = {UnexpectedException.class})
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(UnexpectedException ex) {
        return new ErrorResponse(ex.getMessage());
    }
}