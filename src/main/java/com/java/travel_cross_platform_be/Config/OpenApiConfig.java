//package com.java.travel_cross_platform_be.Config;
//
//import io.swagger.v3.oas.models.Components;
//import io.swagger.v3.oas.models.OpenAPI;
//import org.springdoc.core.annotations.ParameterObject;
//import org.springdoc.core.models.GroupedOpenApi;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import io.swagger.v3.oas.models.info.Info;
//import io.swagger.v3.oas.models.security.SecurityScheme;
//import io.swagger.v3.oas.models.security.SecurityScheme.Type;
//import io.swagger.v3.oas.models.security.SecurityRequirement;
//
//@Configuration
//public class OpenApiConfig {
//
//    @Bean
//    public OpenAPI customOpenAPI() {
//        return new OpenAPI()
//                .info(new Info().title("Travel Cross Platform API").version("1.0"))
//                .addSecurityItem(new SecurityRequirement().addList("JWT"))
//                .components(new Components()
//                        .addSecuritySchemes("JWT", new SecurityScheme()
//                                .type(Type.HTTP)
//                                .scheme("bearer")
//                                .bearerFormat("JWT")));
//    }
//}
