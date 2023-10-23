package com.Om.DentalClinic.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.Om.DentalClinic.model.Appointment;

public interface AppointmentService {

	public void saveAppointment(Appointment appointment);
	
	public ByteArrayOutputStream exportAppointmentsToExcel() throws IOException;
	
//	public boolean isAppointmentExists(Date startTime, Date endTime);

	public List<Appointment> getAppointmentsByDate(Date appointmentDate);
}
