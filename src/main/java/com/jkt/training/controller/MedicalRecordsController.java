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
import com.jkt.training.service.MedicalRecordsService;

@RestController
public class MedicalRecordsController {
	
	@Autowired
	private MedicalRecordsService service;
	

	@GetMapping("/records")
	public List<MedicalRecords> getAllRecords(){
		
		return service.getAllRecords();
	}
	
	@GetMapping("/records/{r_id}")
	public Optional<MedicalRecords> getrecordById(@PathVariable int r_id) {
		return service.getRecordById(r_id);
	}
	
	@PostMapping(path = "/records",consumes = "application/json")
	public String addRecord(@RequestBody MedicalRecords record) {
		service.addRecord(record);
		return "added";
	}
	
	@PutMapping(path = "/records/{r_id}",consumes = "application/json")
	public String updateRecord(@RequestBody MedicalRecords record,@PathVariable int r_id) {
		service.updateRecord(record, r_id);
		return "updated";
	}
	
	@DeleteMapping("/records/{r_id}")
	public String deleteRecord(@PathVariable int r_id) {
		service.deleteRecord(r_id);
		return "deleted";
	}
}
