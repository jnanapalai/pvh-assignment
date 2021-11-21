package com.pvh.configuration;

import com.pvh.exception.FeignErrorDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for Feign class to set Custom Error Decoder
 *
 */
@Configuration
public class FeignConfiguration {
    /**
     * Method Return custom Feign Error decoder
     * @return ErrorDecoder
     */
    @Bean
    public ErrorDecoder errorDecoder() {
        return new FeignErrorDecoder();
    }
}
