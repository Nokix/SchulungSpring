package de.cegos.SchulungSpring.hospital;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

@Configuration
@ComponentScan
public class Main {
    // "main" für die Generierung der main-Methode
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(Main.class);
//                new ClassPathXmlApplicationContext("spring.xml");

        System.out.println("All BEANS:");
        Arrays.stream(applicationContext.getBeanDefinitionNames())
                        .forEach(System.out::println);
        System.out.println("#####");


        Doctor superDoc = applicationContext.getBean(Doctor.class);
        superDoc.setName("Karlson");
        System.out.println(superDoc.assist());

        Doctor megaDoc = applicationContext.getBean(Doctor.class);
        System.out.println(megaDoc.assist());
    }
}
