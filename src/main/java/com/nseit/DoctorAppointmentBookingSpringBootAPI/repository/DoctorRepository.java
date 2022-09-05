package com.nseit.DoctorAppointmentBookingSpringBootAPI.repository;

import com.nseit.DoctorAppointmentBookingSpringBootAPI.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}
