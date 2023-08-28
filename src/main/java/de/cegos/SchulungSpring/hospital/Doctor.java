package de.cegos.SchulungSpring.hospital;

import lombok.Setter;

@Setter
public class Doctor {

    private String name;
    private Nurse helper;

    public Doctor() {
    }

    public Doctor(String name, Nurse helper) {
        this.name = name;
        this.helper = helper;
    }

    public String assist() {
        return "Dr. " + this.name + " is assisting. "
                + this.helper.assist();
    }
}
