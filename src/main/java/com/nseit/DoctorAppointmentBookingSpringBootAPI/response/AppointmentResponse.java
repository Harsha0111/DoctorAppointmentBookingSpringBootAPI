package com.nseit.DoctorAppointmentBookingSpringBootAPI.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppointmentResponse {
    private Integer appointmentId;
    private String doctorName;
    private String specialization;
    private String date;
}
