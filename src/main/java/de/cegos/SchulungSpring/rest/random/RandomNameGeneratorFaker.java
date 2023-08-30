package de.cegos.SchulungSpring.rest.random;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RandomNameGeneratorFaker implements RandomNameGenerator{

    private Faker faker;

    @Override
    public String getRandomFullName() {
        return faker.name().fullName();
    }
}
