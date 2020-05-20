package com.portfolio.patientportal.service;

import com.portfolio.patientportal.model.Hospital;
import com.portfolio.patientportal.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    public void save(Hospital hospital){
        hospitalRepository.save(hospital);
    }

    public List<Hospital> getAll() {
        return hospitalRepository.findAll();
    }

    public Hospital getById(Long id) {
        return hospitalRepository.getOne(id);
    }

    public Hospital getByName(String name) {
        return hospitalRepository.findByName(name);
    }

    public List<Hospital> getBySpecialty(String specialty) {
        return hospitalRepository.findBySpecialty(specialty);
    }

    public void delete(Hospital hospital) {
        hospitalRepository.delete(hospital);
    }
}
