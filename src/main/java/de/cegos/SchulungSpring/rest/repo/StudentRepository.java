package de.cegos.SchulungSpring.rest.repo;

import de.cegos.SchulungSpring.rest.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFullNameContaining(String fullNamePart);

    List<Student> findByMailStartsWithAndFullNameEndsWith(String mail, String fullName);
}
