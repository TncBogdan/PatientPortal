package com.portfolio.patientportal.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name is missing")
    @Size(min = 3)
    @Pattern(regexp = "^([A-Z][a-z]* *)+")
    private String name;

    @NotNull(message = "Age is missing")
    @Range(min = 1, max = 100, message = "Age is invalid")
    private Integer age;

    @OneToMany(mappedBy = "sender")
    private List<Message> messages;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

    public Patient() {
    }

    public Patient(String name, Integer age) {
        this.name = name;
        this.age = age;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
