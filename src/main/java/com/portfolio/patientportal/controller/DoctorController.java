package com.portfolio.patientportal.controller;

import com.portfolio.patientportal.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping("/doctors")
    String getDoctors(Model model) {
        model.addAttribute("doctors", doctorService.getAll());
        return "doctors";
    }

    @GetMapping("/doctors/{id}")
    String getDoctorById(@PathVariable Long id, Model model) {
        model.addAttribute("doctor", doctorService.getById(id));
        return "doctor";
    }
}
