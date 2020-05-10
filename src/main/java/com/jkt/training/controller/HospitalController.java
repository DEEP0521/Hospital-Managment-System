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
		return hrService.getHospitals();
	}
	//mapping with doctor
		@GetMapping("/hospitals/doctors/{d_id}")
		public List<Hospital> getAllDr_Hosp(@PathVariable int d_id){
			
			return hrService.getAllDr_Hosp(d_id);
		}
		
		
			
	@GetMapping("/hospitals/{hosp_id}")
	public Optional<Hospital> getById(@PathVariable int hosp_id)
	{
		return hrService.getById(hosp_id);
	}
	//mapping with doctor
		@GetMapping("/hospitals/{hosp_id}/doctors/{d_id}")
		public Optional<Hospital> getHr_DrById(@PathVariable int hosp_id) {
			return hrService.getHr_DrById(hosp_id);
		}
		
				
	
	
	@PostMapping(path="/hospitals",consumes="application/json")
	public String addHospital(@RequestBody Hospital hospital)
	{
		hrService.addHospital(hospital);
		return "New Hospital Added";
	}
	
	//mapping with doctor
		@PostMapping(path = "/hospitals/doctors/{d_id}",consumes = "application/json")
		public String addHr_dr(@PathVariable int d_id,@RequestBody Hospital hospital) {
			hospital.setDoctor(new Doctor());
			hrService.addHr_dr(hospital);
			return "added hospital doctor";
		}
		
				
	@DeleteMapping("/hospitals/{hosp_id}")
	public String deleteHospital(@RequestBody int hosp_id)
	{
		hrService.deleteHospital(hosp_id);
		return "The hospital is deleted.";
	}
	//mapping with doctor
		@DeleteMapping("/doctor/{d_id}/hospitals/{hosp_id}")
		public String deleteHr_dr(@PathVariable int hosp_id) {
			hrService.deleteHr_dr(hosp_id);
			return "deleted";
		}
		
				
	@PutMapping(path = "/hospitals/{hosp_id}",consumes = "application/json")
	public String updateHospital(@RequestBody Hospital hospital,@PathVariable int hosp_id) {
		hrService.updateHospital( hosp_id);
		return "Hospital is updated now.";
	}
	//mapping with doctor
		@PutMapping(path = "/hospitals/{hosp_id}/doctor/{d_id}/",consumes = "application/json")
		public String updateHr_dr(@RequestBody Hospital hospital,@PathVariable int d_id,@PathVariable int hosp_id) {
			hospital.setDoctor(new Doctor());
			hrService.updateHr_dr(hospital);
			return "updated Hr_dr";
		}
}
