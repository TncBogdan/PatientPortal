package com.portfolio.patientportal.controller;

import com.portfolio.patientportal.model.Patient;
import com.portfolio.patientportal.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/getPatients")
    String getPatients(Model model) {
        model.addAttribute("patients", patientService.getAll());
        return "manage-patients";
    }

    @GetMapping("/patients/{age}")
    String getPatientsByAge(@PathVariable Integer age, Model model){
        model.addAttribute("patientsByAge", patientService.getByAge(age));
        return "manage-patients";
    }

    @GetMapping("/patients/{name}")
    String getPatiensByName(@PathVariable String name, Model model){
        model.addAttribute("patientsByName", patientService.getByName(name));
        return "manage-patients";
    }

    @PostMapping("/patients")
    String createPatient(HttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        Integer age = Integer.parseInt(request.getParameter("age"));
        patientService.save(new Patient(name, age));
        model.addAttribute("patients", patientService.getAll());
        return "manage-patients";
    }

    @PostMapping("/editPatients/{id}")
    String updatePatient(@PathVariable Long id, HttpServletRequest request, Model model){
        String name = request.getParameter("new_name_for_patient_id_" + id);
        Integer age = Integer.parseInt(request.getParameter("new_age_for_patient_id_" + id));
        Patient patient = patientService.getById(id);
        patient.setName(name);
        patient.setAge(age);
        patientService.save(patient);
        model.addAttribute("patients", patientService.getAll());
        return "manage-patients";
    }

    @PostMapping("/patients/{id}")
    String deletePatient(@PathVariable Long id, Model model){
        Patient patient = patientService.getById(id);
        patientService.delete(patient);
        model.addAttribute("patients", patientService.getAll());
        return "manage-patients";
    }

}
