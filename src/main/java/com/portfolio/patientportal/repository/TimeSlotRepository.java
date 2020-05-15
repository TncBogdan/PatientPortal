package com.portfolio.patientportal.repository;

import com.portfolio.patientportal.model.Doctor;
import com.portfolio.patientportal.model.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long> {
    List<TimeSlot> findByDoctor(Doctor doctor);
}
