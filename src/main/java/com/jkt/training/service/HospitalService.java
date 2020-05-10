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
		Hrrepo.saveAll(Stream.of(new Hospital(1,"Branch-East","East Mumbai"),
				new Hospital(2,"Branch-West","West Mumbai"),
				new Hospital(3,"Branch-South","South Mumbai")).collect(Collectors.toList()));
	}
	//mapping for doctor
	public List<Hospital> getAllDr_Hosp(int d_Id){
		List<Hospital> hospital=new ArrayList<Hospital>();
		((Iterable<Hospital>) Hrrepo.findByDrId(d_Id)).forEach(hospital::add);
		
		return hospital;
	}
	
	
	
	
	public List<Hospital> getHospitals()
	{
		return Hrrepo.findAll();
	}
	

	public Optional<Hospital> getById(int hosp_id)
	{
		return Hrrepo.findById(hosp_id);
		
	}
	//mapping
		public Optional<Hospital> getHr_DrById(int hosp_id) {
			return Hrrepo.findById(hosp_id);
		}
		
//mapping patient
//		public Optional<Hospital> getHrPatientById(int hosp_id) {
//			return Hrrepo.findById(hosp_id);
//			}
	public void addHospital(Hospital hospital)
	{
		Hrrepo.save(hospital);
	}
	//mapping
		public void addHr_dr(Hospital hospital) {
			 Hrrepo.save(hospital);
		}
		//mapping patient
//				public void addHrPatient(Hospital hospital) {
//					 Hrrepo.save(hospital);
//				}
	
	public void deleteHospital(int hosp_id)
	{
		Hospital hospital=Hrrepo.getOne(hosp_id);
		Hrrepo.delete(hospital);
	}
	//mapping
		public void deleteHr_dr(int d_id) {
			Hospital hospital=Hrrepo.getOne(d_id);
			Hrrepo.delete(hospital);
		}
		//mapping patient
//				public void deleteHrPatient(int d_id) {
//					Hospital hospital=Hrrepo.getOne(d_id);
//					Hrrepo.delete(hospital);
//				}
	public void updateHospital(int hosp_id)
	{
		Hospital hospital=Hrrepo.getOne(hosp_id);
		Hrrepo.save(hospital);
	}
	//mapping
		public void updateHr_dr(Hospital hospital) {
			Hrrepo.save(hospital);
		}
		//mapping patient
//				public void updateHrPatient(Hospital hospital) {
//					Hrrepo.save(hospital);
//				}
}
