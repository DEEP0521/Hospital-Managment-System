package com.jkt.training.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jkt.training.model.MedicalRecords;
import com.jkt.training.model.Patient;
import com.jkt.training.service.MedicalRecordsService;

@RestController
public class MedicalRecordsController {
	
	@Autowired
	private MedicalRecordsService service;
	

	@GetMapping("/records")
	public List<MedicalRecords> getAllRecords(){
		
		return service.getAllRecords();
	}
	
	//mapping with medical record
	@GetMapping("/patients/{p_id}/records")
	public List<MedicalRecords> getAllp_Records(@PathVariable int p_id){
		
		return service.getAllp_Records(p_id);
	}
	
	@GetMapping("/records/{r_id}")
	public Optional<MedicalRecords> getrecordById(@PathVariable int r_id) {
		return service.getRecordById(r_id);
	}
	
	//mapping with medical record
	@GetMapping("/patients/{p_id}/records/{r_id}")
	public Optional<MedicalRecords> getp_recordById(@PathVariable int r_id) {
		return service.getp_RecordById(r_id);
	}
	
	@PostMapping(path = "/records",consumes = "application/json")
	public String addRecord(@RequestBody MedicalRecords record) {
		service.addRecord(record);
		return "added";
	}
	
	//mapping with medical record
	@PostMapping(path = "/patients/{p_id}/records",consumes = "application/json")
	public String addp_Record(@PathVariable int p_id,@RequestBody MedicalRecords record) {
		record.setPatient(new Patient(p_id,"","",""));
		service.addp_Record(record);
		return "added p_record";
	}
	
	@PutMapping(path = "/records/{r_id}",consumes = "application/json")
	public String updateRecord(@RequestBody MedicalRecords record,@PathVariable int r_id) {
		service.updateRecord(record, r_id);
		return "updated";
	}
	
	//mapping with medical record
	@PutMapping(path = "/patients/{p_id}/records/{r_id}",consumes = "application/json")
	public String updatep_Record(@RequestBody MedicalRecords record,@PathVariable int p_id,@PathVariable int r_id) {
		record.setPatient(new Patient(p_id,"","",""));
		service.updatep_Record(record);
		return "updated p_record";
	}
	
	@DeleteMapping("/records/{r_id}")
	public String deleteRecord(@PathVariable int r_id) {
		service.deleteRecord(r_id);
		return "deleted";
	}
	
	//mapping with medical record
	@DeleteMapping("/patients/{Pid}/records/{r_id}")
	public String deletep_Record(@PathVariable int r_id) {
		service.deletep_Record(r_id);
		return "deleted";
	}
}
