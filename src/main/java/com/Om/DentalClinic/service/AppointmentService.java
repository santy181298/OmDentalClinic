package com.Om.DentalClinic.service;

import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.io.IOException;


public interface AppointmentService {

	public void saveAppointment(Date starttime, Date endtime,String firstname,String middlename, String lastname, String treatment,long patientmobile1);
	
	public ByteArrayOutputStream exportAppointmentsToExcel() throws IOException;
	
}
