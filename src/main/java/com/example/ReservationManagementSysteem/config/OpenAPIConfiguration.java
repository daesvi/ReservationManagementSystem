package com.example.ReservationManagementSysteem.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfiguration {

    @Bean
    public OpenAPI combinedOpenAPI() {
        OpenAPI openAPI1 = new OpenAPI()
                .addServersItem(new Server().url("https://reservationmanagementsystem-production.up.railway.app"));

        OpenAPI openAPI2 = new OpenAPI()
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

        openAPI1.setInfo(openAPI2.getInfo());

        return openAPI1;
    }


}
