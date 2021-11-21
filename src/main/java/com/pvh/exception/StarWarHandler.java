package com.pvh.exception;


import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.time.OffsetDateTime;

/**
 * Global Error Handler class
 */
@ControllerAdvice
public class StarWarHandler extends ResponseEntityExceptionHandler {


    /**
     * Method handle constraint violation exception
     *
     * @param ex reference of ConstraintViolationException
     * @return ResponseEntity<Error>  details of Error
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Error> handleConstraintViolationException(ConstraintViolationException ex) {
        Error err=new Error();
        err.setErrorMessage(ex.getLocalizedMessage().split(":")[1]);
        err.setErrorCode("INVALID_VALUE");
        err.setErrorOccurredTime(OffsetDateTime.now().toString());
        return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
    }

    /**
     * Method to handle Custom Exception
     *
     * @param customException reference of custom exception
     * @return  ResponseEntity<Error>--error details
     */
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Error> handleCustomException(CustomException customException)
    {
        Error err=new Error();
        err.setErrorMessage(customException.getMessage());
        err.setErrorCode("Not Found");
        err.setErrorOccurredTime(OffsetDateTime.now().toString());
        return new ResponseEntity<>(err,HttpStatus.valueOf(Integer.valueOf(customException.getCode())));
    }
}
