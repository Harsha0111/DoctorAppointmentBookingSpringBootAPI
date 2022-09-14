package com.nseit.DoctorAppointmentBookingSpringBootAPI.service;

import com.nseit.DoctorAppointmentBookingSpringBootAPI.model.AuthUser;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.request.DoctorRequest;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.request.PatientRequest;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.response.AuthResponse;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.response.DoctorResponse;

import java.util.List;

public interface UserServiceInter {
    AuthResponse login(AuthUser authUser);
    AuthUser register(PatientRequest patientRequest);
    List<DoctorResponse> register(DoctorRequest doctorRequest, String role);
}
