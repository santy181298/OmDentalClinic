package com.Om.DentalClinic.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.Om.DentalClinic.model.Appointment;

public interface AppointmentService {

	public void saveAppointment(Appointment appointment);
	
	public ByteArrayOutputStream exportAppointmentsToExcel() throws IOException;
	
}
