package com.nseit.DoctorAppointmentBookingSpringBootAPI.controller;

import com.nseit.DoctorAppointmentBookingSpringBootAPI.model.Doctor;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.model.Patient;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.response.APIResponse;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @Autowired
    private APIResponse apiResponse;

    @PostMapping
    public void add(@RequestBody Patient patient) {
        patientService.add(patient);
    }
    @PutMapping
    public void update(@RequestBody Patient patient) {
        patientService.add(patient);
    }

    @GetMapping("/all")
    public List<Patient> view() {
        return patientService.view();
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        patientService.delete(id);
    }
}
