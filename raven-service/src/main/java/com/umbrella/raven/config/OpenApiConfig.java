package com.umbrella.raven.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info().title("Raven API")
                        .description("API for Raven")
                        .version("0.0.1"))
                .externalDocs(new ExternalDocumentation()
                        .description("Raven Documentation")
                        .url("https://www.github.com/jpcaulfi/raven/README.md"));
    }
}
