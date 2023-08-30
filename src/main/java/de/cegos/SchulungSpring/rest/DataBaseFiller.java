package de.cegos.SchulungSpring.rest;

import de.cegos.SchulungSpring.rest.model.Student;
import de.cegos.SchulungSpring.rest.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBaseFiller implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        Student student = Student.builder()
                .fullName("Claudia D")
                .mail("cld@myjob.de")
                .build();
        studentRepository.save(student);
    }
}
