package de.cegos.SchulungSpring.hospital;

import javax.print.Doc;

public class Doctor {
    public String name;

    public Doctor(String name) {
        this.name = name;
    }

    public String assist() {
        return "Dr. " + this.name + " is assisting.";
    }
}
