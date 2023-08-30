package de.cegos.SchulungSpring.rest;

import de.cegos.SchulungSpring.rest.model.Student;
import de.cegos.SchulungSpring.rest.repo.StudentRepository;
import de.cegos.SchulungSpring.rest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBaseFiller implements CommandLineRunner {

    @Autowired
    StudentService studentService;

    @Override
    public void run(String... args) throws Exception {
//        studentService.saveRandomStudents(200);
//
//        studentService.findByFullNameContains("Dr.")
//                .forEach(System.out::println);
    }
}
