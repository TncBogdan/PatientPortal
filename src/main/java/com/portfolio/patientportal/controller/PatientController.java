package com.portfolio.patientportal.controller;

import com.portfolio.patientportal.model.Patient;
import com.portfolio.patientportal.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/patients")
    public List<Patient> getAllpatients(){
        return patientService.getAll();
    }

    @PostMapping("/patients")
    public void add(@RequestBody Patient patient){
        patientService.save(patient);
    }
}
