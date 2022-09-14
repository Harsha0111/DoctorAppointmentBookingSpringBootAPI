package com.nseit.DoctorAppointmentBookingSpringBootAPI.controller;

import com.nseit.DoctorAppointmentBookingSpringBootAPI.model.Patient;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.response.APIResponse;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/", maxAge = 3600)
@RequestMapping("/api/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @Autowired
    private APIResponse apiResponse;

    @PostMapping
    public ResponseEntity<APIResponse> createPatient(@RequestBody Patient patient) {

        Patient loggedInPatient = patientService.createPatient(patient);

        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(loggedInPatient);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<APIResponse> updatePatient(@RequestBody Patient patient) {
        Patient updatePatient = patientService.updatePatient(patient);

        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(updatePatient);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse>getPatient(@PathVariable Integer id) {

        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(null);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deletePatient(@PathVariable Integer id) {
        patientService.delete(id);

        apiResponse.setStatus(HttpStatus.CREATED.value());
//        apiResponse.setData(patientService.getAllPatients);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }
}
