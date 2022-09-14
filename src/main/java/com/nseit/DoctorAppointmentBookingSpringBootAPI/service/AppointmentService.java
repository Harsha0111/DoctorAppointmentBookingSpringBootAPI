package com.nseit.DoctorAppointmentBookingSpringBootAPI.service;

import com.nseit.DoctorAppointmentBookingSpringBootAPI.exception.ResourceAlreadyExistException;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.exception.ResourceNotFoundException;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.model.Appointment;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.model.AuthUser;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.model.Doctor;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.model.Specialization;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.repository.AppointmentRepository;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.repository.DoctorRepository;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.repository.SpecializationRepository;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.repository.UserRepository;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.request.AppointmentRequest;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.response.AppointmentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private SpecializationRepository specializationRepository;
    @Autowired
    private UserRepository userRepository;

    public void add(AppointmentRequest appointmentRequest) {

        AuthUser docAuthUser = userRepository.findById(appointmentRequest.getDoctorUserId())
                .orElseThrow(() -> new ResourceAlreadyExistException("Doctor does not Exists"));

        AuthUser patientAuthUser = userRepository.findById(appointmentRequest.getUserId())
                .orElseThrow(() -> new ResourceAlreadyExistException("patient does not Exists"));

        Appointment appointment = new Appointment();
        appointment.setApproved(false);
        System.out.println(docAuthUser.getUserName());
        System.out.println(patientAuthUser.getUserName());

        appointment.setDUser(docAuthUser);
        appointment.setPUser(patientAuthUser);

        appointment.setDate(appointmentRequest.getDate());

        appointmentRepository.save(appointment);
    }

    public void update(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    public List<AppointmentResponse> view() {
        List<Appointment> appointments = appointmentRepository.findAll();

        List<AppointmentResponse> appointmentResponses = new ArrayList<>();

        for (Appointment appointment : appointments) {
            AppointmentResponse appointmentResponse = new AppointmentResponse();
            appointmentResponse.setAppointmentId(appointment.getId());
            appointmentResponse.setDate(appointment.getDate());

            AuthUser docAuthUser = userRepository.findById(appointment.getDUser().getId())
                    .orElseThrow(() -> new ResourceAlreadyExistException("Doctor does not Exists"));

//            Doctor doctor = doctorRepository.findByAuthUser(docAuthUser)
//                    .orElseThrow(() -> new ResourceAlreadyExistException("Doctor name does not Exists"));
//
//            Specialization specialization = specializationRepository.findById(doctor.getId())
//                    .orElseThrow(() -> new ResourceNotFoundException("Specialization id does not exists"));


            appointmentResponse.setDoctorName(docAuthUser.getFullName());
//            appointmentResponse.setSpecialization(specialization.getSpecialization());
            appointmentResponses.add(appointmentResponse);
        }
        return appointmentResponses;

    }

    public void delete(int id) {
        appointmentRepository.deleteById(id);
    }
}