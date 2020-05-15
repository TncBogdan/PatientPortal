package com.portfolio.patientportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.portfolio.patientportal"})
public class PatientPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientPortalApplication.class, args);
    }
///test branch
}
