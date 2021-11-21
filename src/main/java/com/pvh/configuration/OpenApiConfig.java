package com.pvh.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class used for documentation of Application using Open Api 3.0
 */
@Configuration
public class OpenApiConfig {

    /**
     * Setting title and description of Open Api documentation of Application
     * @return instance of OpenApi class
     */
    @Bean
    public OpenAPI customOpenApi()
    {
        return new OpenAPI().components(new Components())
                .info(new Info().title("Star War API").description("This Rest api responsible to give data of planet" +
                        "and people search by either Name or id"));
    }
}
