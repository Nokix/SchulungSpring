package de.cegos.SchulungSpring.rest.repo;

import de.cegos.SchulungSpring.rest.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Student student0 = Student.builder().fullName("Karlson v. D.")
                .mail("hoch@hinaus.de").build();
        Student student1 = Student.builder().fullName("Bett Hoffen")
                .mail("gute@musik.de").build();
        Student student2 = Student.builder().fullName("Nachbars Nachbar")
                .mail("guter@freund.com").build();

        entityManager.persist(student0);
        entityManager.persist(student1);
        entityManager.persist(student2);
    }

    @Test
    public void testMethodQuery() {
        List<Student> result =
                studentRepository.findByFullNameContaining("v.");

        assertEquals(1, result.size());
        assertEquals("Karlson v. D.", result.get(0).getFullName());
    }
}