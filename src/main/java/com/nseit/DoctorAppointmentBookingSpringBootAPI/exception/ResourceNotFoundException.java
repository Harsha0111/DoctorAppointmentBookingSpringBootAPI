package com.nseit.DoctorAppointmentBookingSpringBootAPI.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}