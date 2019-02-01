package uk.co.datadisk.jpa1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
        super(message);
        System.out.println("In NotFoundException");
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}