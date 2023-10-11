package br.com.rentacar.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI().info(new Info().title("RentACar API").version("1.0").description("How to use a rent a car API")
                .termsOfService("www.lucas.com").license(
                        new License().name("Apache license 2.0").url("https://www.apache.org/licenses/LICENSE-2.0")));
    }
}
