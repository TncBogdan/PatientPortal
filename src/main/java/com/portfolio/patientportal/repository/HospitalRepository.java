package com.portfolio.patientportal.repository;

import com.portfolio.patientportal.model.Doctor;
import com.portfolio.patientportal.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    Hospital findByName(String name);

    Hospital findBySpecialty(String specialty);
}
