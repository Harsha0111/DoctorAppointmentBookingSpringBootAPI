package com.nseit.DoctorAppointmentBookingSpringBootAPI.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AuthResponse {
    private Integer id;
    private String userName;
    private String fullName;
    private String email;
    private Integer age;
    private String role;

}
