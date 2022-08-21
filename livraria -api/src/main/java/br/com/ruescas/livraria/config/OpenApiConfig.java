package br.com.ruescas.livraria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Bookstore developed to deliver the Fullstack TQI project")
                        .version("v1")
                        .description("Book Store API backend for Fullstack TQI project")
                        .termsOfService("")
                        .license(
                                new License()
                                        .name("Apache 2.0")
                                        .url("")));
    }

}
