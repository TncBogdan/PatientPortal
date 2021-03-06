package com.portfolio.patientportal.controller;

import com.portfolio.patientportal.model.Hospital;
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
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @GetMapping("/hospitals")
    String getHospitals(Model model) {
        model.addAttribute("hospitals", hospitalService.getAll());
        return "manage-hospitals";
    }

    @GetMapping("/hospitals/{name}")
    String getHospitalsByName(@RequestParam("name") String name, Model model) {
        model.addAttribute("hospitalsByName", hospitalService.getByName(name));
        return "manage-hospitals";
    }

    @GetMapping("/hospitals/{specialty}")
    String getHospitalsBySpecialty(@RequestParam("specialty") String specialty, Model model) {
        model.addAttribute("hospitalsByName", hospitalService.getBySpecialty(specialty));
        return "manage-hospitals";
    }

    @GetMapping("/hospitals/{id}/offices")
    public String getOfficesByHospital(@PathVariable Long id, Model model) {
        model.addAttribute("offices", hospitalService.getById(id).getOffices());
        return "office-details";
    }

    @PostMapping("/hospitals")
    String createHospital(HttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        String specialty = request.getParameter("specialty");
        hospitalService.save(new Hospital(name, specialty));
        model.addAttribute("hospitals", hospitalService.getAll());
        return "manage-hospitals";
    }

    @PostMapping("/editHospitals/{id}")
    String updateHospital(@PathVariable Long id, HttpServletRequest request, Model model) {
        String name = request.getParameter("new_name_for_hospital_id_" + id);
        String specialty = request.getParameter("new_specialty_for_hospital_id_" + id);
        Hospital Hospital = hospitalService.getById(id);
        Hospital.setName(name);
        Hospital.setSpecialty(specialty);
        hospitalService.save(Hospital);
        model.addAttribute("hospitals", hospitalService.getAll());
        return "manage-hospitals";
    }

    @PostMapping("/hospitals/{id}")
    String deleteHospital(@PathVariable Long id, Model model) {
        Hospital Hospital = hospitalService.getById(id);
        hospitalService.delete(Hospital);
        model.addAttribute("hospitals", hospitalService.getAll());
        return "manage-hospitals";
    }
}
