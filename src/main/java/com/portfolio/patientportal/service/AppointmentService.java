package com.portfolio.patientportal.service;

import com.portfolio.patientportal.model.Appointment;
import com.portfolio.patientportal.model.TimeSlot;
import com.portfolio.patientportal.repository.AppointmentRepository;
import com.portfolio.patientportal.repository.DoctorRepository;
import com.portfolio.patientportal.repository.PatientRepository;
import com.portfolio.patientportal.repository.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    private AppointmentRepository appointmentRepository;
    private PatientRepository patientRepository;
    private DoctorRepository doctorRepository;
    private TimeSlotRepository timeSlotRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, PatientRepository patientRepository, DoctorRepository doctorRepository, TimeSlotRepository timeSlotRepository) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.timeSlotRepository = timeSlotRepository;
    }

    public void createAppointment (Appointment appointment, Long timeSlotId){
        TimeSlot timeSlot = timeSlotRepository.getOne(timeSlotId);
        appointment.setTimeSlot(timeSlot);
        appointmentRepository.save(appointment);
    }
}
