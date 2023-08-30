package de.cegos.SchulungSpring.rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue
    Long id;

    String fullName;
    String mail;
}
