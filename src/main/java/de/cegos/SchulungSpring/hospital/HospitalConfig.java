package de.cegos.SchulungSpring.hospital;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

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
    // SpEL: Spring Expression Language
    public String english(@Value("${lang.eng}") String location) {
        String s = "laod english datafile from " + location;
//        System.out.println(s);
        return s + location;
    }

    @Bean("language")
    @ConditionalOnProperty(name = "lang", havingValue = "fr")
    public String french(@Value("${lang.fr}") String location) {
        String s = "laod french datafile from " + location;
//        System.out.println(s);
        return s;
    }

    @Bean
    @Profile("h2")
    public String h2Database(@Value("${database.loc}") String loc) {
        String s = "Connected to H2 Database @ " + loc;
//        System.out.println(s);
        return s;
    }

    @Bean
    @Profile("mysql || default")
    public String mysqlDatabase(
            @Value("${database.loc:fallbackDB}") String loc) {
        String s = "Connected to MySQL Database @ " + loc;
//        System.out.println(s);
        return s;
    }

}
