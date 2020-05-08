package com.jkt.training.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jkt.training.model.MedicalRecords;
import com.jkt.training.repository.MedicalRecordsRepository;

@Service
public class MedicalRecordsService {

	@Autowired
	private MedicalRecordsRepository repository;
	
//	@PostConstruct
//	public void initRecords() {
//		repository.saveAll(new ArrayList<MedicalRecords>(Arrays.asList(new MedicalRecords(1001,"Heart","11/07/2018"),
//															   new MedicalRecords(1002,"Eye Flu","17/12/2019"),
//															   new MedicalRecords(1003,"Liver","02/03/2019"))));
//	}
	
	//mapping
	public List<MedicalRecords> getAllp_Records(int p_id){
		List<MedicalRecords> records=new ArrayList<MedicalRecords>();
		repository.findByPatientId(p_id)
		.forEach(records::add);
		return records;
	}
	
	public List<MedicalRecords> getAllRecords(){
		return repository.findAll(); 
	}
	
	//mapping
	public Optional<MedicalRecords> getp_RecordById(int r_id) {
		return repository.findById(r_id);
	}
	
	public Optional<MedicalRecords> getRecordById(int r_id) {
		return repository.findById(r_id);
	}
	
	public void addRecord(MedicalRecords record) {
		 repository.save(record);
	}
	
	//mapping
	public void addp_Record(MedicalRecords record) {
		 repository.save(record);
	}
	
	public void deleteRecord(int r_id) {
		MedicalRecords record=repository.getOne(r_id);
		repository.delete(record);
	}
	
	//mapping
	public void deletep_Record(int r_id) {
		MedicalRecords record=repository.getOne(r_id);
		repository.delete(record);
	}
	
	public void updateRecord(MedicalRecords record,int r_id) {
		repository.save(record);
	}
	
	//mapping
	public void updatep_Record(MedicalRecords record) {
		repository.save(record);
	}
}
