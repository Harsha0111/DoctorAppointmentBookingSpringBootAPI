package com.nseit.DoctorAppointmentBookingSpringBootAPI.service;

import com.nseit.DoctorAppointmentBookingSpringBootAPI.exception.ResourceAlreadyExistException;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.model.AuthUser;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthUser registerPatient(AuthUser authUser) {
        authUser.setPassword(bCryptPasswordEncoder.encode(authUser.getPassword()));

        AuthUser userAlreadyExists = userRepository.findByUserName(authUser.getUserName());
        if (userAlreadyExists != null) {
            throw new ResourceAlreadyExistException("Patient Already Exists");
        }
        return userRepository.save(authUser);
    }

    public AuthUser loginPatient(AuthUser authUser) {
        authUser.setPassword(bCryptPasswordEncoder.encode(authUser.getPassword()));

        AuthUser userAlreadyExists = userRepository.findByUserName(authUser.getUserName());
        if (userAlreadyExists != null) {
            if (!bCryptPasswordEncoder.matches(authUser.getPassword(), userAlreadyExists.getPassword()))
                throw new ResourceAlreadyExistException("Invalid password");
        } else {
            throw new ResourceAlreadyExistException("Patient does not exists");
        }
        return userRepository.save(authUser);
    }

    public AuthUser registerDoctor(AuthUser authUser) {
        authUser.setPassword(bCryptPasswordEncoder.encode(authUser.getPassword()));

        AuthUser userAlreadyExists = userRepository.findByUserName(authUser.getUserName());
        if (userAlreadyExists != null) {
            throw new ResourceAlreadyExistException("Doctor Already Exists");
        }
        return userRepository.save(authUser);
    }

    public AuthUser loginDoctor(AuthUser authUser) {

        authUser.setPassword(bCryptPasswordEncoder.encode(authUser.getPassword()));

        AuthUser userAlreadyExists = userRepository.findByUserName(authUser.getUserName());
        if (userAlreadyExists != null) {
            if (!bCryptPasswordEncoder.matches(authUser.getPassword(), userAlreadyExists.getPassword()))
                throw new ResourceAlreadyExistException("Invalid password");
        } else {
            throw new ResourceAlreadyExistException("Doctor does not exists");
        }
        return userRepository.save(authUser);
    }
}
