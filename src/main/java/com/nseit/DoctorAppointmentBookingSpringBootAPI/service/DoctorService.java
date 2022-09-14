package com.nseit.DoctorAppointmentBookingSpringBootAPI.service;

import com.nseit.DoctorAppointmentBookingSpringBootAPI.exception.ResourceNotFoundException;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.model.AuthUser;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.model.Doctor;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.model.Specialization;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.repository.DoctorRepository;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.repository.SpecializationRepository;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.repository.UserRepository;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.request.DoctorRequest;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.response.DoctorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private SpecializationRepository specializationRepository;


    public List<DoctorResponse> add(Doctor doctor) {
        doctorRepository.save(doctor);
        return viewAll();
    }

    public List<DoctorResponse> update(DoctorRequest doctorRequest) {
        AuthUser authUser = userRepository.findById(doctorRequest.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User does not exist"));

        Doctor doctor = doctorRepository.findByAuthUser(authUser)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor does not exist "));

        authUser.setPassword(doctorRequest.getPassword());
        authUser.setEmail(doctorRequest.getEmail());
        authUser.setUserName(doctorRequest.getUserName());
        authUser.setAge(doctorRequest.getAge());
        authUser.setFullName(doctorRequest.getFullName());
        userRepository.save(authUser);

        Specialization specialization = specializationRepository.findById(doctorRequest.getSpecializationId())
                .orElseThrow(() -> new ResourceNotFoundException("Specialization does not exist"));

        doctor.setSpecialization(specialization);
        doctor.setAuthUser(authUser);
        doctor.setExperience(doctorRequest.getExperience());
        doctor.setId(doctor.getId());

        doctorRepository.save(doctor);
        return viewAll();
    }

    public List<DoctorResponse> viewAll() {
        List<Doctor> doctors = doctorRepository.findAll();
        List<DoctorResponse> doctorResponses = new ArrayList<>();
        for (Doctor doctor : doctors) {
            DoctorResponse doctorResponse = new DoctorResponse();
            doctorResponse.setAge(doctor.getAuthUser().getAge());
            doctorResponse.setEmail(doctor.getAuthUser().getEmail());
            doctorResponse.setExperience(doctor.getExperience());
            doctorResponse.setSpecialization(doctor.getSpecialization().getSpecialization());
            doctorResponse.setSpecializationId(doctor.getSpecialization().getId());
            doctorResponse.setId(doctor.getAuthUser().getId());
            doctorResponse.setUserName(doctor.getAuthUser().getUserName());
            doctorResponse.setFullName(doctor.getAuthUser().getFullName());

            doctorResponses.add(doctorResponse);
        }
        return doctorResponses;
    }

    public List<DoctorResponse> delete(int id) {
        AuthUser authUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User does not exist"));

        Doctor doctor = doctorRepository.findByAuthUser(authUser)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor does not exist with id " + id));

        doctorRepository.delete(doctor);
        return viewAll();
    }

}