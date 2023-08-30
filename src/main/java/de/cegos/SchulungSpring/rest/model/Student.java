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
}
