package com.Om.DentalClinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Om.DentalClinic.model.Appointment;
import com.Om.DentalClinic.repository.AppointmentRepository;
;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Override
	public void saveAppointment(Appointment appointment) {
	this.appointmentRepository.save(appointment);
	
	}

}
