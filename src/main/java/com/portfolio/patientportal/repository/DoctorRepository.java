package com.portfolio.patientportal.repository;

import com.portfolio.patientportal.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Doctor findByName(String name);

    Doctor findBySpecialty(String specialty);
}
