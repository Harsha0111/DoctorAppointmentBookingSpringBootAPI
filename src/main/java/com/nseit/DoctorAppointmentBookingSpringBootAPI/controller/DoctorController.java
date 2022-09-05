package com.nseit.DoctorAppointmentBookingSpringBootAPI.controller;

import com.nseit.DoctorAppointmentBookingSpringBootAPI.model.Doctor;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.response.APIResponse;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @Autowired
    private APIResponse apiResponse;

    @PostMapping
    public void add(@RequestBody Doctor doctor) {
        doctorService.add(doctor);
    }

    @PutMapping
    public void update(@RequestBody Doctor doctor) {
        doctorService.add(doctor);
    }

    @GetMapping("/all")
    public List<Doctor> view() {
        return doctorService.view();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        doctorService.delete(id);
    }
}

