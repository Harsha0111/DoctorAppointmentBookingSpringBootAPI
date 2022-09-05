package com.nseit.DoctorAppointmentBookingSpringBootAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity

public class Specialization {
    @Id
    @GeneratedValue
    private Integer id;
    private String specialization;

    @JsonIgnore
    @OneToMany(mappedBy = "specialization")
    private Set<Doctor> doctors;

}
