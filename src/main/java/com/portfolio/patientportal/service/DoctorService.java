package com.portfolio.patientportal.service;

import com.portfolio.patientportal.model.Doctor;
import com.portfolio.patientportal.model.Hospital;
import com.portfolio.patientportal.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class DoctorService {
    private DoctorRepository doctorRepository;
    private HospitalRepository hospitalRepository;
    private MessageRepository messageRepository;
    private TimeSlotRepository timeSlotRepository;
    private AppointmentRepository appointmentRepository;

    @Autowired

    public DoctorService(DoctorRepository doctorRepository, HospitalRepository hospitalRepository, MessageRepository messageRepository,
                         TimeSlotRepository timeSlotRepository, AppointmentRepository appointmentRepository) {
        this.doctorRepository = doctorRepository;
        this.hospitalRepository = hospitalRepository;
        this.messageRepository = messageRepository;
        this.timeSlotRepository = timeSlotRepository;
        this.appointmentRepository = appointmentRepository;
    }

    public void save(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    public List<Doctor> getAll() {
        return doctorRepository.findAll();
    }

    public Doctor getById(Long id) {
        return doctorRepository.getOne(id);
    }

    public Doctor getByName(String name) {
        return doctorRepository.findByName(name);
    }

    public List<Doctor> getBySpecialty(String specialty) {
        return doctorRepository.findBySpecialty(specialty);
    }

    public Set<Doctor> getByHospital(String hospitalName) {
        Hospital hospital = hospitalRepository.findByName(hospitalName);
        return hospital.getDoctors();
    }

    public void delete(Doctor doctor) {
        doctorRepository.delete(doctor);
    }

//    public void addHospital(Long doctorId, Long hospitalId) {
//        Doctor doctor = getById(doctorId);
//        Set<Hospital> currentHospital = doctor.getHospitals();
//        currentHospital.add(hospitalRepository.getOne(hospitalId));
//        doctor.setHospital(currentHospital);
//        doctorRepository.save(doctor);
//    }

//    public Set<Hospital> getHospitals(Long id) {
//        return getById(id).getHospitals();
//    }
//
//    public List<Message> getMessages(Long id) {
//        return getById(id).getMessages();
//    }
//
//    public List<TimeSlot> getTimeSlots(Long id) {
//        return timeSlotRepository.findByDoctor(getById(id));
//    }
//
//    public List<Appointment> getAppointments(Long id) {
//        return appointmentRepository.findByDoctor(getById(id));
//    }

}
