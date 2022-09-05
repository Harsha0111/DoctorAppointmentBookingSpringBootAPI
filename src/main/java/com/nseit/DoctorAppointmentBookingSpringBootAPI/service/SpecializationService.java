package com.nseit.DoctorAppointmentBookingSpringBootAPI.service;

import com.nseit.DoctorAppointmentBookingSpringBootAPI.model.Appointment;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.model.Role;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.model.Specialization;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.repository.SpecializationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecializationService {
    @Autowired
    private SpecializationRepository specializationRepository;

    public void add(Specialization specialization) {
        specializationRepository.save(specialization);
    }

    public void update(Specialization specialization) {
        specializationRepository.save(specialization);
    }

    public List<Specialization> view() {
        return specializationRepository.findAll();
    }

    public void delete(int id) {
        Specialization specialization = specializationRepository.findById(id).get();
        specializationRepository.delete(specialization);
    }
}