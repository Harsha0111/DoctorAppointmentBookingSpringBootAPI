package com.nseit.DoctorAppointmentBookingSpringBootAPI.exception;

public class UnableToInsertException extends RuntimeException {
    public UnableToInsertException(String msg) {
        super(msg);
    }
}