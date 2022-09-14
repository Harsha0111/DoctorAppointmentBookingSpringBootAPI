package com.nseit.DoctorAppointmentBookingSpringBootAPI.controller;

import com.nseit.DoctorAppointmentBookingSpringBootAPI.model.Appointment;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.request.AppointmentRequest;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.response.APIResponse;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.response.AppointmentResponse;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.response.SuccessResponse;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/api/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private APIResponse apiResponse;

    @PostMapping
    public ResponseEntity<APIResponse> add(@RequestBody AppointmentRequest appointmentRequest) {
        appointmentService.add(appointmentRequest);

        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(new SuccessResponse());
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @PutMapping
    public void update(@RequestBody Appointment appointment) {
        appointmentService.update(appointment);
    }

    @GetMapping("/all")
    public ResponseEntity<APIResponse> view() {
        List<AppointmentResponse> appointmentResponses = appointmentService.view();
        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(appointmentResponses);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> delete(@PathVariable int id) {

        appointmentService.delete(id);

        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(appointmentService.view());
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }
}

