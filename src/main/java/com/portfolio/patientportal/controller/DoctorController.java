package com.portfolio.patientportal.controller;

import com.portfolio.patientportal.model.Doctor;
import com.portfolio.patientportal.model.Hospital;
import com.portfolio.patientportal.service.DoctorService;
import com.portfolio.patientportal.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DoctorController {
    private final DoctorService doctorService;
    private final HospitalService hospitalService;

    @Autowired
    public DoctorController(DoctorService doctorService, HospitalService hospitalService) {
        this.doctorService = doctorService;
        this.hospitalService = hospitalService;
    }

    @GetMapping("/getDoctors")
    String getDoctors(Model model) {
        model.addAttribute("doctors", doctorService.getAll());
        model.addAttribute("hospitals", hospitalService.getAll());
        return "manage-doctors";
    }

    @GetMapping("/getDoctors/{id}")
    String getDoctorById(@PathVariable Long id, Model model) {
        model.addAttribute("doctorName", doctorService.getById(id).getName());
        model.addAttribute("doctorSpecialty", doctorService.getById(id).getSpecialty());
        return "manage-doctors";
    }

    @GetMapping("/doctors/{name}")
    String getDoctorsByName(@RequestParam("name") String name, Model model) {
        model.addAttribute("doctors", doctorService.getByName(name));
        return "manage-doctors";
    }

    @GetMapping("/doctors/{specialty}")
    String getDoctorsBySpecialty(@RequestParam("specialty") String specialty, Model model) {
        model.addAttribute("doctors", doctorService.getBySpecialty(specialty));
        return "manage-doctors";
    }

    @PostMapping("/doctors")
    String createDoctor(HttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        String specialty = request.getParameter("specialty");
        doctorService.save(new Doctor(name, specialty));
        model.addAttribute("doctors", doctorService.getAll());
        model.addAttribute("hospitals", hospitalService.getAll());
        return "manage-doctors";
    }

    @PostMapping("/editDoctors/{id}")
    String updateDoctor(@PathVariable Long id, HttpServletRequest request, Model model) {
        String name = request.getParameter("new_name_for_doctor_id_" + id);
        String specialty = request.getParameter("new_specialty_for_doctor_id_" + id);
        String editHospitalOperation = request.getParameter("edit_hospital_for_doctor_id_" + id);
        Hospital hospital = hospitalService.getById(Long.parseLong(request.getParameter("new_hospital_for_doctor_id_" + id)));
        Doctor doctor = doctorService.getById(id);
        doctor.setName(name);
        doctor.setSpecialty(specialty);
        if (editHospitalOperation != null) {
            if (editHospitalOperation.equals("add")) {
                doctor.addHospital(hospital);
            } else {
                doctor.deleteHospital(hospital);
            }
        }
        doctorService.save(doctor);
        model.addAttribute("doctors", doctorService.getAll());
        model.addAttribute("hospitals", hospitalService.getAll());
        return "manage-doctors";
    }

    @PostMapping("/doctors/{id}")
    String deleteDoctor(@PathVariable Long id, Model model) {
        Doctor doctor = doctorService.getById(id);
        doctorService.delete(doctor);
        model.addAttribute("doctors", doctorService.getAll());
        model.addAttribute("hospitals", hospitalService.getAll());
        return "manage-doctors";
    }

}
