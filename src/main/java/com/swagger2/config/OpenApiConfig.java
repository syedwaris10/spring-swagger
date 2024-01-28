package com.swagger2.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Student API",
                description = "Implement Swagger with Spring Boot 3",
                version = "1.0",
                contact = @Contact(
                        name = "Syed Abdul Waris",
                        email = "syedwaris10@gmail.com",
                        url = "https://www.linkedin.com/in/syed-abdul-waris-510038105/"
                )

        ),
        servers = {
                @Server(
                        url = "http://localhost:8080",
                        description = "test"
                ),
                @Server(
                        url = "http://localhost:8081",
                        description = "dev"
                )
        }

)
 // this will add Authorize button globaly
@SecurityScheme(
        in = SecuritySchemeIn.HEADER,
        description = "JWT Authorization, Stateless",
        bearerFormat = "bearer",
        name = "JWT-AUTH",
        scheme = "Bearer",
        type = SecuritySchemeType.HTTP)
public class OpenApiConfig {
}
