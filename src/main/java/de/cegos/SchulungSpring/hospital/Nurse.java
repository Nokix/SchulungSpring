package de.cegos.SchulungSpring.hospital;

import org.springframework.stereotype.Component;

@Component
public class Nurse {
    public String assist() {
        return "Nurse is helping";
    }
}
