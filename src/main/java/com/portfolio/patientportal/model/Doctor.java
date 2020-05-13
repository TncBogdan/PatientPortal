package com.portfolio.patientportal.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name is missing")
    @Size(min = 3)
    @Pattern(regexp = "^[A-Z].*")
    private String name;

    @NotEmpty(message = "Specialty is missing")
    private String specialty;

    @ManyToMany
    private List<Hospital> hospitals;

    @OneToMany(mappedBy = "receiver")
    private List<Message> messages;

    @OneToMany(mappedBy = "doctor")
    private List<TimeSlot> timeSlots;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Hospital> getHospitals() {
        return hospitals;
    }

    public void setHospital(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
