package com.pvh.exception;

import feign.Response;
import feign.codec.ErrorDecoder;

/**
 * Custom Feign Error Decoder class
 *
 */
public class FeignErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()){
            case 404:
            {
                return new CustomException(response.reason(),Integer.toString(response.status()) );
            }
            default:
                return new Exception(response.reason());
        }
    }
}
