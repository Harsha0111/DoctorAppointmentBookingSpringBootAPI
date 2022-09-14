package com.nseit.DoctorAppointmentBookingSpringBootAPI.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientRequest {
    private Integer id;
    private String userName;
    private String email;
    private String fullName;
    private String password;
    private Integer age;
    private Integer height;
    private Integer weight;
}
