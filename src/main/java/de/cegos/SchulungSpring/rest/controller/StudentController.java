package de.cegos.SchulungSpring.rest.controller;

import de.cegos.SchulungSpring.rest.model.Student;
import de.cegos.SchulungSpring.rest.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/create")
    public List<Student> findContainingString(
            @RequestParam(name = "n", defaultValue = "5") Integer amount) {
        return studentService.saveRandomStudents(amount);
    }

    @PostMapping("save")
    @ResponseStatus(HttpStatus.CREATED)
    public Student saveStudent(
            @RequestBody @Valid Student student) {
        return studentService.saveStudent(student);
    }
}
