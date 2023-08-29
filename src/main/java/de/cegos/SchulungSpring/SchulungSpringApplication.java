package de.cegos.SchulungSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class SchulungSpringApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(SchulungSpringApplication.class, args);
        String[] beanDefinitionNames =
                context.getBeanDefinitionNames();

        // context.getBean("language");

//		Arrays.stream(beanDefinitionNames).forEach(System.out::println);

//		Arrays.stream(context.getAliases("beauty")).forEach(System.out::println);
    }

}
