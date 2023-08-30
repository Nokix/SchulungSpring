package de.cegos.SchulungSpring.rest.repo;

import de.cegos.SchulungSpring.rest.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFullNameContaining(String fullNamePart);

    @Query("select s from Student s where s.fullName like concat('%', ?1, '%')")
    List<Student> findInName(String fullName);

    @Query(value = "select s from Student s where s.fullName = :str or s.mail = :str")
    List<Student> findContainingString(String str);
}
