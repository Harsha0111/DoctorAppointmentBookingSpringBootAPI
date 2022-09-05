package com.nseit.DoctorAppointmentBookingSpringBootAPI.controller;

import com.nseit.DoctorAppointmentBookingSpringBootAPI.model.AuthUser;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.model.Role;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.response.APIResponse;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private APIResponse apiResponse;


    //register patient
    @Secured({Role.ROLE_PATIENT})
    @PostMapping("/registerPatient")
    public ResponseEntity<APIResponse> registerPatient(@RequestBody AuthUser authUser) {

        AuthUser registeredPatient = userService.registerPatient(authUser);

        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(null);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    // login patient
    @Secured({Role.ROLE_PATIENT})
    @PostMapping("/loginPatient")
    public ResponseEntity<APIResponse> loginPatient(@RequestBody AuthUser authUser) {

        AuthUser loggedInPatient = userService.loginPatient(authUser);

        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(null);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    // register doctor
    @Secured({Role.ROLE_DOCTOR})
    @PostMapping("/registerDoctor")
    public ResponseEntity<APIResponse> registerDoctor(@RequestBody AuthUser authUser) {

        AuthUser registeredDoctor = userService.registerDoctor(authUser);

        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(null);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    // login doctor
    @Secured({Role.ROLE_DOCTOR})
    @PostMapping("/loginDoctor")
    public ResponseEntity<APIResponse>loginDoctor(@RequestBody AuthUser authUser) {

        AuthUser loggedInDoctor = userService.loginDoctor(authUser);

        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(null);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }



}
