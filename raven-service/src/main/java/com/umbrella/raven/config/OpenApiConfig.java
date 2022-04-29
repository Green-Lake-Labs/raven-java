package com.umbrella.raven.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.AllArgsConstructor;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class OpenApiConfig {


    BuildProperties buildProperties;

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info()
                        .title(
                                buildProperties.getName()
                                        .substring(0, 1).toUpperCase()
                                + buildProperties.getName().substring(1)
                        )
                        .description("Equity valuation.")
                        .version(buildProperties.getVersion()))
                .externalDocs(new ExternalDocumentation()
                        .description("Documentation")
                        .url("https://www.github.com/jpcaulfi/raven/README.md"));
    }
}
