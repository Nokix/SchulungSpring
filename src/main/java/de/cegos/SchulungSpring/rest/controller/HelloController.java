package de.cegos.SchulungSpring.rest.controller;

import de.cegos.SchulungSpring.rest.random.RandomNameGenerator;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final RandomNameGenerator randomNameGenerator;

    @GetMapping
    public String randomHello() {
        return randomNameGenerator.getRandomFullName();
    }

    @GetMapping("hello/{name}")
    public String sayHello(@PathVariable String name) {
        return "Hallöchen " + name;
    }

    @GetMapping("bye")
    public String sayGoodbye(@RequestParam String name) {
        return "Goodbye " + name;
    }
}
