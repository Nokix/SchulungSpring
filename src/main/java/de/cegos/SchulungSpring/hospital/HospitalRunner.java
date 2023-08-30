package de.cegos.SchulungSpring.hospital;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("hospital")
@Component
@RequiredArgsConstructor
public class HospitalRunner implements CommandLineRunner {
    private final Doctor doctor;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hallo");
        System.out.println(doctor.assist());
    }
}
