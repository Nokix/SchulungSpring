package de.cegos.SchulungSpring.rest;

import de.cegos.SchulungSpring.rest.model.Student;
import de.cegos.SchulungSpring.rest.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("students")
@RequiredArgsConstructor
public class StudentController {
    final StudentService studentService;

    @GetMapping
    public List<Student> findAll() {
        return studentService.findAll();
    }
}
