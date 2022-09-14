package com.nseit.DoctorAppointmentBookingSpringBootAPI.service;

import com.nseit.DoctorAppointmentBookingSpringBootAPI.exception.ResourceAlreadyExistException;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.exception.ResourceNotFoundException;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.model.*;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.repository.*;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.request.DoctorRequest;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.request.PatientRequest;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.response.AuthResponse;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.response.DoctorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserService implements UserServiceInter {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private SpecializationRepository specializationRepository;

    @Override
    public AuthResponse login(AuthUser authUser) {

        AuthUser userAlreadyExists = userRepository.findByUserName(authUser.getUserName());
        if (userAlreadyExists != null) {
            if (!bCryptPasswordEncoder.matches(authUser.getPassword(), userAlreadyExists.getPassword()))
                throw new ResourceAlreadyExistException("Invalid password");
        } else {
            throw new ResourceAlreadyExistException("Patient does not exists");
        }

        AuthResponse response = new AuthResponse();
        response.setId(userAlreadyExists.getId());
        response.setRole(userAlreadyExists.getRoles().iterator().next().getName());
        response.setUserName(userAlreadyExists.getUserName());
        response.setAge(userAlreadyExists.getAge());
        response.setEmail(userAlreadyExists.getEmail());
        response.setFullName(userAlreadyExists.getFullName());

        System.out.println(response.toString());
        return response;
    }

    @Override
    public AuthUser register(PatientRequest patientRequest) {
        System.out.println(patientRequest.getUserName());
        AuthUser authUser = new AuthUser();
        authUser.setUserName(patientRequest.getUserName());
        authUser.setFullName(patientRequest.getFullName());
        authUser.setEmail(patientRequest.getEmail());
        authUser.setAge(patientRequest.getAge());

        Role role = roleRepository.findByName(Role.PATIENT);

        authUser.setRoles(Set.of(role));
        authUser.setPassword(bCryptPasswordEncoder.encode(patientRequest.getPassword()));

        AuthUser userAlreadyExists = userRepository.findByUserName(authUser.getUserName());
        if (userAlreadyExists != null) {
            throw new ResourceAlreadyExistException("Patient Already Exists");
        }
        authUser = userRepository.save(authUser);

        Patient patient = new Patient();
        patient.setAuthUser(authUser);
        patient.setWeight(patientRequest.getWeight());
        patient.setHeight(patientRequest.getHeight());

        patientRepository.save(patient);
        return authUser;
    }

    @Override
    public List<DoctorResponse> register(DoctorRequest doctorRequest, String role) {
        AuthUser authUser = new AuthUser();
        authUser.setUserName(doctorRequest.getUserName());
        authUser.setFullName(doctorRequest.getFullName());
        authUser.setEmail(doctorRequest.getEmail());
        authUser.setAge(doctorRequest.getAge());
        authUser.setPassword(bCryptPasswordEncoder.encode(doctorRequest.getPassword()));

        Role doctorRole = roleRepository.findByName(role);

        authUser.setRoles(Set.of(doctorRole));

        AuthUser userAlreadyExists = userRepository.findByUserName(authUser.getUserName());
        if (userAlreadyExists != null) {
            throw new ResourceAlreadyExistException("Doctor Already Exists");
        }
        authUser = userRepository.save(authUser);

        Doctor doctor = new Doctor();
        doctor.setExperience(doctorRequest.getExperience());
        doctor.setAuthUser(authUser);
        doctor.setExperience(doctorRequest.getExperience());

        Specialization specialization = specializationRepository.findById(doctorRequest.getSpecializationId())
                .orElseThrow(()-> new ResourceNotFoundException("Specialization id does not exists"));

        doctor.setSpecialization(specialization);
        doctorRepository.save(doctor);

        return doctorService.viewAll();
    }

    public AuthResponse viewAll(Integer id) {
        AuthUser authUser = userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Id does not exists"));
        ;
        authUser.setUserName(authUser.getUserName());
        authUser.setFullName(authUser.getFullName());
        authUser.setEmail(authUser.getEmail());
        authUser.setAge(authUser.getAge());


//
//        Role doctorRole = roleRepository.findByName(role);
//
//        authUser.setRoles(Set.of(doctorRole));
//
//        AuthUser userAlreadyExists = userRepository.findByUserName(authUser.getUserName());
//        if (userAlreadyExists != null) {
//            throw new ResourceAlreadyExistException("Doctor Already Exists");
//        }
//        authUser = userRepository.save(authUser);
//
//        Doctor doctor = new Doctor();
//        doctor.setExperience(doctorRequest.getExperience());
//        doctor.setAuthUser(authUser);
//        doctor.setExperience(doctorRequest.getExperience());
//
//        Specialization specialization = specializationRepository.findById(doctorRequest.getSpecializationId())
//                .orElseThrow(()-> new ResourceNotFoundException("Specialization id does not exists"));
//
//        doctor.setSpecialization(specialization);

        return null;
    }
}
