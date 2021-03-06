package com.portfolio.patientportal.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "hospitals")
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotEmpty(message = "Name is missing")
//    @Size(min = 3)
//    @Pattern(regexp = "^[A-Z].*")
    private String name;

//    @NotEmpty(message = "Specialty is missing")
    private String specialty;

    @OneToMany(mappedBy = "hospital")
    private List<Office> offices;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Doctor> doctors;

    public Hospital() {
    }

    public Hospital(@NotEmpty(message = "Name is missing") @Size(min = 3) @Pattern(regexp = "^[A-Z].*") String name, @NotEmpty(message = "Specialty is missing") String specialty) {
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

    public List<Office> getOffices() {
        return offices;
    }

    public void setOffices(List<Office> offices) {
        this.offices = offices;
    }

    public Set<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }
}
