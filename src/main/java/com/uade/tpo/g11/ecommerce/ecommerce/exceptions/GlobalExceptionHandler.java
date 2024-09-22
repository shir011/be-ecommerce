package com.uade.tpo.g11.ecommerce.ecommerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMessage> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
public class GenericException extends HibernateException {
    private final Exception exception;

    public GenericException(String message, Exception e) {
        super(message);
        this.exception = e;
    }

    public String getMessage() {
        return exception.getMessage();
    }
}
 public class BadRequestException extends HibernateException {
    public BadRequestException(String message) {
        super(message);
    }

    public String getMessage() {
        return super.getMessage();
    }
}   


}