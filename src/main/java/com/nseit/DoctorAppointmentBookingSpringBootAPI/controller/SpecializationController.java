package com.nseit.DoctorAppointmentBookingSpringBootAPI.controller;

import com.nseit.DoctorAppointmentBookingSpringBootAPI.model.Role;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.model.Specialization;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.response.APIResponse;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/api/specialization")
public class SpecializationController {
    @Autowired
    private SpecializationService specializationService;

    @Autowired
    private APIResponse apiResponse;

//    @Secured({Role.ROLE_ADMIN})
    @PostMapping
    public ResponseEntity<APIResponse> addSpecialization(@RequestBody Specialization specialization) {
        specializationService.add(specialization);
        List<Specialization> specializations = specializationService.viewAll();

        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(specializations);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

//    @Secured({Role.ROLE_ADMIN})
    @PutMapping
    public ResponseEntity<APIResponse> updateSpecialization(@RequestBody Specialization specialization) {
        specializationService.update(specialization);
        List<Specialization> specializations = specializationService.viewAll();

        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(specializations);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

//    @Secured({Role.ROLE_ADMIN})
    @GetMapping("/all")
    public ResponseEntity<APIResponse> viewAllSpecialization() {

        List<Specialization> specializations = specializationService.viewAll();

        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(specializations);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

//    @Secured({Role.ROLE_ADMIN})
    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteSpecialization(@PathVariable Integer id) {
        specializationService.delete(id);
        List<Specialization> specializations = specializationService.viewAll();

        apiResponse.setStatus(HttpStatus.CREATED.value());
        apiResponse.setData(specializations);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }
}

