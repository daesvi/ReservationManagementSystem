package com.example.ReservationManagementSysteem;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;

@SpringBootApplication
public class ReservationManagementSysteemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReservationManagementSysteemApplication.class, args);
    }

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Reservation Management System")
                        .version("1.0.0")
                        .description("This is a reservation management system API developed in Java with the Spring framework, which allows\n" +
                                "\n" +
                                " - Create airlines\n" + "\n" +
                                " - Create users\n" + "\n" +
                                " - Manage flights\n" + "\n" +
                                " - Search flights by search criteria\n" + "\n" +
                                " - Reserve a flight")
                        .termsOfService("http:/swagger.io/terms/")
                );
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("*")
                        .allowedHeaders("*");
            }
        };
    }
}