package com.nseit.DoctorAppointmentBookingSpringBootAPI.service;

import com.nseit.DoctorAppointmentBookingSpringBootAPI.exception.ResourceNotFoundException;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.model.Patient;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public Patient add(Patient patient) {
        patientRepository.save(patient);
        return patient;
    }

    public void update(Patient patient) {
        patientRepository.save(patient);
    }

    public List<Patient> view() {
        return patientRepository.findAll();
    }

    public void delete(Integer id) {
        Patient patient = patientRepository.findById(id).get();
        patientRepository.delete(patient);
    }

    public Patient createPatient(Patient patient) {
        return null;
    }

    public Patient updatePatient(Patient patient) {
        if (patient.getId() == null)
            throw new ResourceNotFoundException("Id must not be null");

        boolean isExist = patientRepository.findById(patient.getId()).isPresent();
        if (!isExist)
            throw new ResourceNotFoundException("Invalid Post");
        return patientRepository.save(patient);
    }
}
