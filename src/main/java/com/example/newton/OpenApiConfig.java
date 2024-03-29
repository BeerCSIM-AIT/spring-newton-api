package com.example.newton;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
  @Bean
  public OpenAPI openNewtonApi(){
    return new OpenAPI()
      .info(new Info()
        .title("Newton Ice Factory-Phakpoom I.")
        .description("API Backend")
        .version("1.0")
      );
  }
}
