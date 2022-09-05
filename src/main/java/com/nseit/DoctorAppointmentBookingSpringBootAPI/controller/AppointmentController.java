package com.nseit.DoctorAppointmentBookingSpringBootAPI.controller;

import com.nseit.DoctorAppointmentBookingSpringBootAPI.model.Appointment;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.response.APIResponse;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private APIResponse apiResponse;

    @PostMapping
    public void add(@RequestBody Appointment appointment) {

        appointmentService.add(appointment);
    }

    @PutMapping
    public void update(@RequestBody Appointment appointment) {

        appointmentService.update(appointment);
    }

    @GetMapping("/all")
    public List<Appointment> view() {

        return appointmentService.view();
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {

        appointmentService.delete(id);
    }
}
