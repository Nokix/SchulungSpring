package de.cegos.SchulungSpring.rest.service;

import de.cegos.SchulungSpring.rest.model.Student;
import de.cegos.SchulungSpring.rest.random.RandomNameGenerator;
import de.cegos.SchulungSpring.rest.repo.StudentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class StudentServiceTest {
    @Autowired
    StudentService studentService;

    @MockBean
    StudentRepository studentRepository;
    @MockBean
    RandomNameGenerator random;

    @Test
    void saveRandomStudentsTest() {
        String fullName = "Max M";
        String mail = "max.m@supermail.de";
        Student student = Student.builder().fullName(fullName).mail(mail).build();

        when(random.getRandomFullName())
                .thenReturn(fullName)
                .thenReturn("Dora D")
                .thenReturn("Anton A");
        when(random.getRandomMail())
                .thenReturn(mail);

        when(studentRepository.save(any())).thenReturn(student);

        List<Student> result = studentService.saveRandomStudents(3);
        assertEquals(3, result.size());
        assertNotNull(result.get(0));
        assertNotNull(result.get(1));
        assertNotNull(result.get(2));
    }
}