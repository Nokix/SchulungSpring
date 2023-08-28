package de.cegos.SchulungSpring.hospital;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Component
@Scope("prototype")
public class Doctor {

    private String name;
    private Nurse helper;

    // @Qualifier(q):
    // Suche nach einer Bean mit der Id, Name, Alias oder Qualifier q.
    public Doctor(@Qualifier("getDoctorName") String name,
                  @Qualifier("krankenschwester") Nurse helper) {
        this.name = name;
        this.helper = helper;
    }

    public String assist() {
        return "Dr. " + this.name + " is assisting. "
                + this.helper.assist();
    }
}
