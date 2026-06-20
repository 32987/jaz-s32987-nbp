package com.example.jaz_s32987_nbp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "JAZ s32987 NBP Application",
                version = "1.0",
                description = "This is an application that communicates with the NBP API."
        )
)
@SpringBootApplication
public class JazS32987NbpApplication {

	public static void main(String[] args) {
		SpringApplication.run(JazS32987NbpApplication.class, args);
	}

}
