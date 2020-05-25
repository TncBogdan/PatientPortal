package com.portfolio.patientportal.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name is missing")
    @Size(min = 3)
//    @Pattern(regexp = "^[-a-zA-Z0-9._]+")
    @Pattern(regexp = "^[A-Z].*")
    private String name;

    @NotEmpty(message = "Specialty is missing")
    private String specialty;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Hospital> hospitals;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Office> offices;

    @OneToMany(mappedBy = "receiver")
    private List<Message> messages;

    @OneToMany(mappedBy = "doctor")
    private List<TimeSlot> timeSlots;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;

    public Doctor() {
    }

    public Doctor(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }

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

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Set<Hospital> getHospitals() {
        return hospitals;
    }

    public void setHospital(Set<Hospital> hospitals) {
        this.hospitals = hospitals;
    }

    public Set<Office> getOffices() {
        return offices;
    }

    public void setOffices(Set<Office> offices) {
        this.offices = offices;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public void addHospital(Hospital hospital) {
        hospitals.add(hospital);
    }

    public void deleteHospital(Hospital hospital) {
        hospitals.remove(hospital);
    }
}
