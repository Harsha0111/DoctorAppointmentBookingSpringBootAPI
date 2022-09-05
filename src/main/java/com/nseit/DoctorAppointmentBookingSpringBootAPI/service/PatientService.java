package com.nseit.DoctorAppointmentBookingSpringBootAPI.service;

import com.nseit.DoctorAppointmentBookingSpringBootAPI.model.Doctor;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.model.Patient;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.repository.DoctorRepository;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public void add(Patient patient) {
        patientRepository.save(patient);
    }

    public void update(Patient patient) {
        patientRepository.save(patient);
    }

    public List<Patient> view() {
        return patientRepository.findAll();
    }

    public void delete(int id) {
        Patient patient = patientRepository.findById(id).get();
        patientRepository.delete(patient);
    }
}
