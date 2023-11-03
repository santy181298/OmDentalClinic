package com.Om.DentalClinic.repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.Om.DentalClinic.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

//	boolean existsByStarttimeBeforeAndEndtimeAfter(Date startTime, Date endTime);

	List<Appointment> findByStarttimeBetween(@Param("starttime") Date startTime, @Param("endtime") Date endTime);

}
