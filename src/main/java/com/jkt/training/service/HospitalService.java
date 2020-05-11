package com.jkt.training.service;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.jkt.training.model.Hospital;
import com.jkt.training.repository.HospitalRepository;
@Service
public class HospitalService {
   @Autowired
	HospitalRepository Hrrepo;
	
	@PostConstruct
	public void hospitals()
	{
		Hrrepo.saveAll(Stream.of(new Hospital(1,"AIIMS","Mumbai"),
				new Hospital(2,"ESCORTS","Delhi"),
				new Hospital(3,"Fortis","Delhi"),
				new Hospital(4,"HolyFamily","New Delhi")
				).collect(Collectors.toList()));
	}
	
	
	public List<Hospital> getHospitals()
	{
		return Hrrepo.findAll();
	}
	
	public Optional<Hospital> getById(int hosp_id)
	{
		return Hrrepo.findById(hosp_id);
		
	}
	
	public void addHospital(Hospital hospital)
	{
		Hrrepo.save(hospital);
	}
	
	public void deleteHospital(int hosp_id)
	{
		Hospital hospital=Hrrepo.getOne(hosp_id);
		Hrrepo.delete(hospital);
	}
	
	
	public void updateHospital(Hospital hospital,int hosp_id)
	{
		
		Hrrepo.save(hospital);
	}
		
}
