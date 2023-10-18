package com.Om.DentalClinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.Om.DentalClinic.model.Appointment;
import com.Om.DentalClinic.repository.AppointmentRepository;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Override
	public void saveAppointment(Appointment appointment) {
	this.appointmentRepository.save(appointment);
	
	}
	
	
	public ByteArrayOutputStream exportAppointmentsToExcel() throws IOException {
	    List<Appointment> appointments = appointmentRepository.findAll();

	    Workbook workbook = new XSSFWorkbook();
	    Sheet sheet = workbook.createSheet("Appointments");

	    // Create header row
	    Row headerRow = sheet.createRow(0);
	    headerRow.createCell(0).setCellValue("Appointment Number");
	    headerRow.createCell(1).setCellValue("First Name");
	    headerRow.createCell(2).setCellValue("Middle Name");
	    headerRow.createCell(3).setCellValue("Last Name");
	    headerRow.createCell(4).setCellValue("Treatment");
	    headerRow.createCell(5).setCellValue("Start Time");
	    headerRow.createCell(6).setCellValue("End Time");
	    headerRow.createCell(7).setCellValue("Mobile Number");

	    int rowNum = 1;
	    for (Appointment appointment : appointments) {
	        Row dataRow = sheet.createRow(rowNum++);
	        dataRow.createCell(0).setCellValue(appointment.getAppointmentnum());
	        dataRow.createCell(1).setCellValue(appointment.getFirstname());
	        dataRow.createCell(2).setCellValue(appointment.getMiddlename());
	        dataRow.createCell(3).setCellValue(appointment.getLastname());
	        dataRow.createCell(4).setCellValue(appointment.getTreatment());
	        dataRow.createCell(5).setCellValue(appointment.getStarttime().toString());
	        dataRow.createCell(6).setCellValue(appointment.getEndtime().toString());
	        dataRow.createCell(7).setCellValue(appointment.getPatientmobile1());
	    }

	    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	    workbook.write(outputStream);
	    workbook.close();

	    return outputStream;
	}


}
