package com.nseit.DoctorAppointmentBookingSpringBootAPI.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
    private String message;
    private String description;

    public ErrorResponse() {
    }

    public ErrorResponse(String message, String description) {
        this.message = message;
        this.description = description;
    }
}
