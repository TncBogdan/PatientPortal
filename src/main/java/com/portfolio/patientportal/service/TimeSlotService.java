package com.portfolio.patientportal.service;

import com.portfolio.patientportal.model.TimeSlot;
import com.portfolio.patientportal.repository.TimeSlotRepository;
import org.springframework.stereotype.Service;

@Service
public class TimeSlotService {
    TimeSlotRepository timeSlotRepository;

    public void saveTimeSlot(TimeSlot timeSlot) {
        timeSlotRepository.save(timeSlot);
    }

    public TimeSlot getById(Long id) {
        return timeSlotRepository.getOne(id);
    }
}
