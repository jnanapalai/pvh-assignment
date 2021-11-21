package com.pvh.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * Error class used when required to return error from Rest api
 */
@Getter
@Setter
public class Error {
    private String errorMessage;
    private String errorCode;
    private String errorOccurredTime;
}
