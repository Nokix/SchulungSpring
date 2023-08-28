package de.cegos.SchulungSpring.hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Nurse {
    @Autowired
    @Qualifier("getNurseName")
    String name;

    public String assist() {
        return "Nurse is helping";
    }
}
