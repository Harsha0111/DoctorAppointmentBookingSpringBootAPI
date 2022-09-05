package com.nseit.DoctorAppointmentBookingSpringBootAPI.service;

import com.nseit.DoctorAppointmentBookingSpringBootAPI.model.Appointment;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.model.Role;
import com.nseit.DoctorAppointmentBookingSpringBootAPI.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public void add(Role role){
        roleRepository.save(role);
    }
    public void update(Role role) {
        roleRepository.save(role);
    }

    public List<Role> view() {
        return roleRepository.findAll();

    }
    public void delete(int id) {
       Role role = roleRepository.findById(id).get();
       roleRepository.delete(role);}
}
