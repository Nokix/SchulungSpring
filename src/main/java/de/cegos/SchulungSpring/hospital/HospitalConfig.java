package de.cegos.SchulungSpring.hospital;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class HospitalConfig {

    @Bean
    public String getDoctorName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

    @Bean
    @Primary
    public String getNurseName() {
        return "Viktor";
    }

    @Bean({"beauty", "krankenschwester", "abc", "cdf"})
    @Qualifier("docName")
    public Nurse getBeautifulNurse() {
        return new Nurse();
    }

    @Bean
    @ConditionalOnMissingBean
    public String getDefaultName() {
        return "Max Mustermann";
    }

    @Bean("language")
    @ConditionalOnProperty(name = "lang", havingValue = "eng")
    public String english(@Value("${lang.eng}") String location) {
        String s = "laod english datafile from ";
        System.out.println(s);
        return s + location;
    }

    @Bean("language")
    @ConditionalOnProperty(name = "lang", havingValue = "fr")
    public String french(@Value("${lang.fr}") String location) {
        String s = "laod french datafile from " + location;
        System.out.println(s);
        return s;
    }

}
