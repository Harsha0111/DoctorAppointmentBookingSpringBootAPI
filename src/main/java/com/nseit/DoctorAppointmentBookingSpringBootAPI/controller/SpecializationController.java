package com.nseit.DoctorAppointmentBookingSpringBootAPI.controller;

import com.nseit.DoctorAppointmentBookingSpringBootAPI.model.Specialization;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.response.APIResponse;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/specialization")
public class SpecializationController {
    @Autowired
    private SpecializationService specializationService;

    @Autowired
    private APIResponse apiResponse;

    @PostMapping
    public void add(@RequestBody Specialization specialization) {
        specializationService.add(specialization);
    }

    @PutMapping
    public void update(@RequestBody Specialization specialization) {
        specializationService.add(specialization);
    }

    @GetMapping("/all")
    public List<Specialization> view() {
        return specializationService.view();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        specializationService.delete(id);
    }
}

