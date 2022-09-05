package com.nseit.DoctorAppointmentBookingSpringBootAPI.service;

import com.nseit.DoctorAppointmentBookingSpringBootAPI.model.Appointment;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.model.Specialization;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    public void add(Appointment appointment) {

        appointmentRepository.save(appointment);
    }

    public void update(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    public List<Appointment> view() {
        return appointmentRepository.findAll();

    }
    public void delete(int id) {
        Appointment appointment = appointmentRepository.findById(id).get();
        appointmentRepository.delete(appointment);
    }
}