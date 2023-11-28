package com.Om.DentalClinic.service;
import java.util.List;



import com.Om.DentalClinic.model.Sittings;

public interface SittingService {

	public List<Sittings> getAllSittings();
	
	public void deleteSittingById(int id);
	
	public void saveSitting(Sittings sitting);

	public Sittings getSittingById(int id);
	
	public List<Sittings> getSittingByProcedureId(int procedureid);
}
