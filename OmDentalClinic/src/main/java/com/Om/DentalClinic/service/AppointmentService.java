package com.Om.DentalClinic.service;

import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.io.IOException;
import java.util.List;

import com.Om.DentalClinic.model.Appointment;


public interface AppointmentService {

	public void saveAppointment(Date starttime, Date endtime,String firstname,String middlename, String lastname, String treatment,long patientmobile1, String username);
	
	public ByteArrayOutputStream exportAppointmentsToExcel() throws IOException;
	
//	public boolean isAppointmentExists(Date startTime, Date endTime);

	public List<Appointment> getAppointmentsByDate(Date appointmentDate);
	public Appointment getAppointmentById(int id);
	public void deleteAppointmentById(int id);

	public void updateAppointment(Date starttime, Date endtime, String firstname, String middlename, String lastname,
			String treatment, long patientmobile1, int appointmentnum);
}
