package com.portfolio.patientportal.repository;

import com.portfolio.patientportal.model.Appointment;
import com.portfolio.patientportal.model.Message;

import java.time.LocalDateTime;
import java.util.List;

public interface Entity<T> {
    void add(T t);
    List<T> showAll();
    List<Message> showMessagesByDate(LocalDateTime date);
    List<Appointment>  showAppointmentsByDate(LocalDateTime date);
    T findById(long id);
    T findByName(String name);
    T update(T t);

}
