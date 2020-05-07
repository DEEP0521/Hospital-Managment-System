package com.jkt.training.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.jkt.training.model.Hospital;
import com.jkt.training.service.HospitalService;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
@RestController
public class HospitalController {

  @Autowired
	private HospitalService hrService;

	@GetMapping("/hospitals")
	public List<Hospital> getHospitals()
	{
		return hrservice.getHospitals();
	}
	
	@GetMapping("/hospitals/{hosp_id}")
	public Optional<Hospital> getById(@PathVariable int hosp_id)
	{
		return hrservice.getById(hosp_id);
	}
	
	@PostMapping("/hospitals")
	public String addHospital(@RequestBody Hospital hospital)
	{
		hrservice.addHospital(hospital);
		return "New Hospital Added";
	}
	
	@DeleteMapping("/hospitals/{hosp_id}")
	public String deleteHospital(@RequestBody int hosp_id)
	{
		hrservice.deleteHospital(hosp_id);
		return "The hospital with id "+ hosp_id +"is deleted.";
	}
	
	@PutMapping("/hospitals/{hosp_id}")
	public String updateHospital(@RequestBody Hospital hospital,@PathVariable int hosp_id) {
		hrservice.updateHospital(hospital, hosp_id);
		return "Hospital is updated now.";
	}
}
