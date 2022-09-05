package com.nseit.DoctorAppointmentBookingSpringBootAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "users")
public class AuthUser {

    @Id
    @GeneratedValue
    private Integer id;

    private String userName;
    private String fullName;
    private String password;
    private Integer age;

    @JsonIgnore
    @ManyToMany
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    @JoinTable(joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private Set<Role> roles;

    @JsonIgnore
    @OneToMany(mappedBy = "dUser", cascade = CascadeType.ALL)
    private Set<Doctor> dUsers;

    @JsonIgnore
    @OneToMany(mappedBy = "pUser",cascade = CascadeType.ALL)
    private Set<Patient> pUsers;

    public AuthUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
