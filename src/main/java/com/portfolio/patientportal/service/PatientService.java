package com.portfolio.patientportal.service;

import com.portfolio.patientportal.model.Patient;
import com.portfolio.patientportal.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAll(){
        return patientRepository.findAll();
    }

    public Patient save(Patient patient){
      return   patientRepository.save(patient);
    }

}
