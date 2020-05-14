package com.portfolio.patientportal.repository;

import com.portfolio.patientportal.model.Appointment;
import com.portfolio.patientportal.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface Doctor extends Entity, JpaRepository<Doctor, Long> {
    List<Appointment>  showAppointmentsByDoctor(Doctor doctor);
    List<Patient> showPatientsByDoctor(Doctor doctor);

}
