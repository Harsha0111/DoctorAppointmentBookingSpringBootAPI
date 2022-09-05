package com.nseit.DoctorAppointmentBookingSpringBootAPI.repository;

import com.nseit.DoctorAppointmentBookingSpringBootAPI.model.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SpecializationRepository extends JpaRepository<Specialization,Integer> {
}
