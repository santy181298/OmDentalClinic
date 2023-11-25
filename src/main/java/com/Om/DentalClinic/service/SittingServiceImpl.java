package com.Om.DentalClinic.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Om.DentalClinic.model.Sittings;
import com.Om.DentalClinic.repository.SittingRepository;


@Service
public class SittingServiceImpl implements SittingService {

	@Autowired
	private SittingRepository sittingRepository ;
	
	@Override
	public List<Sittings> getAllSittings() {
		return sittingRepository.findAll();
	}

	@Override
	public void deleteSittingById(int id) {
		this.sittingRepository.deleteById(id);
	}

	@Override
	public void saveSitting(Sittings sitting) {
		sittingRepository.save(sitting);
	}

	@Override
	public Sittings getSittingById(int id) {		
		return sittingRepository.findById(id).orElse(null);
	}

	@Override
	public List<Sittings> getSittingByProcedureId(int procedureid) {
	
		return sittingRepository.findBySittingid_Procedureid(procedureid);
	}

}
