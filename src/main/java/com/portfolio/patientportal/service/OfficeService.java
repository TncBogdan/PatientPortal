package com.portfolio.patientportal.service;

import com.portfolio.patientportal.model.Hospital;
import com.portfolio.patientportal.model.Office;
import com.portfolio.patientportal.repository.OfficeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeService {
    private OfficeRepository officeRepository;

    public void save(Office office) {
        officeRepository.save(office);
    }

    public Office getById(Long id) {
        return officeRepository.getOne(id);
    }

    public List<Office> getAllByHospital(Hospital hospital) {
        return officeRepository.findByHospital(hospital);
    }

    public Office getByHospitalAndNumber(Hospital hospital, String number) {
        return officeRepository.findByHospitalAndNumber(hospital, number);
    }

    public void delete(Office office) {
        officeRepository.delete(office);
    }
}
