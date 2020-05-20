package com.portfolio.patientportal.repository;

import com.portfolio.patientportal.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByName(String name);

    List<Patient> findByAge(int age);


}
