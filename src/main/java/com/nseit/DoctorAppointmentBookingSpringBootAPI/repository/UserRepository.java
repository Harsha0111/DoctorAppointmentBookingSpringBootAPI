package com.nseit.DoctorAppointmentBookingSpringBootAPI.repository;

import com.nseit.DoctorAppointmentBookingSpringBootAPI.model.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AuthUser, Integer> {

    AuthUser findByUserName(String username);
}
