package de.cegos.SchulungSpring.rest.service;

import de.cegos.SchulungSpring.rest.model.Student;
import de.cegos.SchulungSpring.rest.random.RandomNameGenerator;
import de.cegos.SchulungSpring.rest.repo.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class StudentService {
    final StudentRepository studentRepo;
    final RandomNameGenerator randomNameGenerator;

    public Student createRandomStudent() {
        return Student.builder()
                .fullName(randomNameGenerator.getRandomFullName())
                .mail(randomNameGenerator.getRandomMail())
                .build();
    }

    public List<Student> saveRandomStudents(Integer n) {
        return Stream
                .generate(this::createRandomStudent)
                .limit(n)
                .map(studentRepo::save)
                .toList();
    }

    public List<Student> findByFullNameContains(String fullNamePart) {
        return studentRepo.findByFullNameContaining(fullNamePart);
    }

    public List<Student> findAll() {
        return studentRepo.findAll();
    }
}
