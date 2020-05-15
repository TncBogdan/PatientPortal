package com.portfolio.patientportal.repository;

import com.portfolio.patientportal.model.Hospital;
import com.portfolio.patientportal.model.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Long> {
    List<Office> findByHospital(Hospital hospital);

    Office findByHospitalAndNumber(Hospital hospital, String number);
}
