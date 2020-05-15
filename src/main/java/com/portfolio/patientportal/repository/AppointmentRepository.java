package com.portfolio.patientportal.repository;

import com.portfolio.patientportal.model.Appointment;
import com.portfolio.patientportal.model.Doctor;
import com.portfolio.patientportal.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByPatient(Patient patient);

    List<Appointment> findByDoctor(Doctor doctor);
}
