package com.Om.DentalClinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Om.DentalClinic.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}
