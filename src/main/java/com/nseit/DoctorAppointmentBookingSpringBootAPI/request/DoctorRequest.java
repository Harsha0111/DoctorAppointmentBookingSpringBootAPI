package com.nseit.DoctorAppointmentBookingSpringBootAPI.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorRequest {
    private Integer id;
    private String userName;
    private String fullName;
    private String email;
    private String password;
    private Integer age;
    private Integer experience;
    private Integer specializationId;

}
