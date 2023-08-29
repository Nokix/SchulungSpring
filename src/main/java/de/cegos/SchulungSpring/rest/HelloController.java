package de.cegos.SchulungSpring.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("hello/{name}")
    public String sayHello(@PathVariable String name) {
        return "Hallöchen " + name;
    }

    @GetMapping("bye")
    public String sayGoodbye(@RequestParam String name) {
        return "Goodbye " + name;
    }
}
