package com.nseit.DoctorAppointmentBookingSpringBootAPI.controller;

import com.nseit.DoctorAppointmentBookingSpringBootAPI.model.Doctor;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.request.DoctorRequest;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.response.APIResponse;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.response.DoctorResponse;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/", maxAge = 3600)
@RequestMapping("/api/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @Autowired
    private APIResponse apiResponse;

    @PutMapping
    public ResponseEntity<APIResponse> update(@RequestBody DoctorRequest doctorRequest) {
        List<DoctorResponse> doctorResponses = doctorService.update(doctorRequest);

        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(doctorResponses);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<APIResponse> viewAll() {
        List<DoctorResponse> doctorResponses = doctorService.viewAll();
        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(doctorResponses);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> delete(@PathVariable int id) {
        doctorService.delete(id);
        List<DoctorResponse> doctorResponses = doctorService.viewAll();
        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(doctorResponses);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}

