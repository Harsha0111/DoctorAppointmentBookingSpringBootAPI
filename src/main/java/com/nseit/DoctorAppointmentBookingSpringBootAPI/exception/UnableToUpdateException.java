package com.nseit.DoctorAppointmentBookingSpringBootAPI.exception;

public class UnableToUpdateException extends RuntimeException {
    public UnableToUpdateException(String msg) {
        super(msg);
    }
}