package com.portfolio.patientportal.repository;

import com.portfolio.patientportal.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Doctor findByName(String name);

    Doctor findBySpecialty(String specialty);

    Set<Doctor> findByHospitals(String hospitalName);
}
