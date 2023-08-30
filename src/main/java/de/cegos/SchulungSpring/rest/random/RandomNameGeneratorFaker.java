package de.cegos.SchulungSpring.rest.random;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RandomNameGeneratorFaker implements RandomNameGenerator{

    private final Faker faker;

    @Override
    public String getRandomFullName() {
        return faker.name().fullName();
    }

    @Override
    public String getRandomMail() {
        return faker.internet().emailAddress();
    }
}
