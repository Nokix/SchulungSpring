package de.cegos.SchulungSpring.rest.random;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FakerConfig {

    @Bean
    Faker getFaker() {
        return new Faker();
    }
}
