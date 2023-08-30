package de.cegos.SchulungSpring.rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Objects;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Student{
    @Id
    @GeneratedValue
    Long id;

    String fullName;
    String mail;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(fullName, student.fullName) && Objects.equals(mail, student.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, mail);
    }
}
