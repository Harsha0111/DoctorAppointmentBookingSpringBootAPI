package com.nseit.DoctorAppointmentBookingSpringBootAPI.controller;

import com.nseit.DoctorAppointmentBookingSpringBootAPI.model.AuthUser;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.model.Doctor;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.model.Role;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.request.DoctorRequest;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.request.PatientRequest;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.response.APIResponse;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.response.AuthResponse;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.response.DoctorResponse;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private APIResponse apiResponse;

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> registerPatient(@PathVariable Integer id) {

        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(userService.viewAll(id));
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    //register patient
    @PostMapping("/registerPatient")
    public ResponseEntity<APIResponse> registerPatient(@RequestBody PatientRequest patientRequest) {

        AuthUser registeredPatient = userService.register(patientRequest);

        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(registeredPatient);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    // login
    @PostMapping("/login")
    public ResponseEntity<APIResponse> loginPatient(@RequestBody AuthUser authUser) {

        AuthResponse loggedInPatient = userService.login(authUser);

        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(loggedInPatient);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    // register doctor
//    @Secured({Role.ROLE_ADMIN})
    @PostMapping("/registerDoctor")
    public ResponseEntity<APIResponse> registerDoctor(@RequestBody DoctorRequest doctorRequest) {

        List<DoctorResponse> registeredDoctor = userService.register(doctorRequest, Role.DOCTOR);

        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(registeredDoctor);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }


}
