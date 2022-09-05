package com.nseit.DoctorAppointmentBookingSpringBootAPI.service;

import com.nseit.DoctorAppointmentBookingSpringBootAPI.model.Appointment;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.model.Doctor;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.model.Specialization;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public void add(Doctor doctor) {

        doctorRepository.save(doctor);
    }

    public void update(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    public List<Doctor> view() {
        return doctorRepository.findAll();
    }

    public void delete(int id) {
        Doctor doctor = doctorRepository.findById(id).get();
        doctorRepository.delete(doctor);
    }

}