package com.portfolio.patientportal.repository;

import com.portfolio.patientportal.model.Appointment;
import com.portfolio.patientportal.model.Doctor;
import com.portfolio.patientportal.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Appointment findByPatient(Patient patient);

    Appointment findByDoctor(Doctor doctor);
}
