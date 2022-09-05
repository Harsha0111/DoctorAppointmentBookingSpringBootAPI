package com.nseit.DoctorAppointmentBookingSpringBootAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Doctor {
    @Id
    @GeneratedValue
    private Integer id;
    private String doctorName;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private AuthUser dUser;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "specialization_id")
    private Specialization specialization;

}
