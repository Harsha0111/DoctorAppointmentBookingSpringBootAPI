package com.nseit.DoctorAppointmentBookingSpringBootAPI.request;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;

@Getter
@Setter
public class AppointmentRequest {
    private Integer id;
    private String date;
    private Boolean approved;
    private Integer userId;
    private Integer doctorUserId;
}
