package com.nseit.DoctorAppointmentBookingSpringBootAPI.service;

import com.nseit.DoctorAppointmentBookingSpringBootAPI.exception.ResourceAlreadyExistException;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.exception.ResourceNotFoundException;
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
        boolean isExist = specializationRepository
                .findBySpecialization(specialization.getSpecialization())
                .isPresent();
        if (isExist)
            throw new ResourceAlreadyExistException("Sp al ex");

        specializationRepository.save(specialization);
    }

    public void update(Specialization specialization) {
        if (specialization.getId() != null) {
            boolean isExist = specializationRepository
                    .findById(specialization.getId())
                    .isPresent();
            if (isExist) {
                specializationRepository.save(specialization);
            } else {
                throw new ResourceNotFoundException("Id not found");
            }
        } else {
            throw new ResourceNotFoundException("Id cnot be nul");
        }
    }

    public void delete(int id) {
        boolean isExist = specializationRepository
                .findById(id)
                .isPresent();
        if (isExist) {
            specializationRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Id not found");
        }
    }

    public List<Specialization> viewAll() {
        return specializationRepository.findAll();
    }
}