package de.cegos.SchulungSpring.rest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Objects;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue
    Long id;

    @NotNull
    @Column(nullable = false)
    String fullName;

    @Email
    String mail;
}
