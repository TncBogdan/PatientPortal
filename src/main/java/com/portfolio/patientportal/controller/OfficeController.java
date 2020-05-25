package com.portfolio.patientportal.controller;

import com.portfolio.patientportal.service.HospitalService;
import com.portfolio.patientportal.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OfficeController {
    private OfficeService officeService;
    private HospitalService hospitalService;

    @Autowired
    public OfficeController(OfficeService officeService, HospitalService hospitalService) {
        this.officeService = officeService;
        this.hospitalService = hospitalService;
    }
}
