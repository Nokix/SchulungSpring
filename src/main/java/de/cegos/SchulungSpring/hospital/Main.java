package de.cegos.SchulungSpring.hospital;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    // "main" für die Generierung der main-Methode
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring.xml");

        Doctor superDoc = applicationContext.getBean(Doctor.class);

        System.out.println(superDoc.assist()); // .sout nach Ausdruck für System.out.println(Ausdruck)
    }
}
