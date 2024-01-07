package com.Om.DentalClinic.service;
import java.util.Date;
import java.util.List;



import com.Om.DentalClinic.model.Sittings;

public interface SittingService {

	public List<Sittings> getAllSittings();
	
	public void deleteSittingById(int id);
	
	public void saveSitting(Sittings sitting);

	public Sittings getSittingById(int id);
	
	public List<Sittings> getSittingByProcedureId(int procedureid);
	
	public List<Sittings> getFilteredProcSittings(Date fromDate, Date toDate, String session);
	
	public List<Sittings> getFilteredProcSittingsByDoctor(Date fromDate, Date toDate, String doctor);
	
	public List<Sittings> getFilteredProcSittingsByLab(Date fromDate, Date toDate, String lab);
}
