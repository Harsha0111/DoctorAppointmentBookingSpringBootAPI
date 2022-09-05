package com.nseit.DoctorAppointmentBookingSpringBootAPI.repository;

import com.nseit.DoctorAppointmentBookingSpringBootAPI.model.Appointment;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
}
