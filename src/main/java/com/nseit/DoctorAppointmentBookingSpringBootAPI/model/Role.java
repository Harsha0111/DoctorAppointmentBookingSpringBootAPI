package com.nseit.DoctorAppointmentBookingSpringBootAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Role {

    public static final String ROLE_PATIENT = "ROLE_PATIENT";
    public static final String ROLE_DOCTOR = "ROLE_DOCTOR";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";

    public static final String PATIENT = "PATIENT";
    public static final String DOCTOR = "DOCTOR";
    public static final String ADMIN = "ADMIN";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles", cascade = CascadeType.ALL)
    private Set<AuthUser> authUsers;

}
