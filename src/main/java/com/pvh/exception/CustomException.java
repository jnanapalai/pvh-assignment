package com.pvh.exception;

import lombok.Getter;

/**
 * Custom Exception class
 */
@Getter
public class CustomException extends Exception {
    private String message;
    private String code;

    /**
     * public constructor
     *
     * @param message error message
     * @param code    error code
     */
    public CustomException(String message,String code)
    {
        this.message=message;
        this.code=code;
    }
}
