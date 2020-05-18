package com.portfolio.patientportal.controller;

import com.portfolio.patientportal.model.Doctor;
import com.portfolio.patientportal.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping("/doctors")
    String getDoctors(Model model) {
        model.addAttribute("doctors", doctorService.getAll());
        return "show-doctors";
    }

    @GetMapping("/doctors/{id}")
    String getDoctorById(@PathVariable Long id, Model model) {
        model.addAttribute("doctorName", doctorService.getById(id).getName());
        model.addAttribute("doctorSpecialty", doctorService.getById(id).getSpecialty());
        return "show-doctors";
    }

    @GetMapping("/")
    String showForm(){
        return "doctors";
    }

    @PostMapping("/doctors")
    String createDoctor(HttpServletRequest request, Model model){
        String name = request.getParameter("name");
        String specialty = request.getParameter("specialty");
        doctorService.save(new Doctor(name, specialty));
        return "show-doctors";
    }
}
