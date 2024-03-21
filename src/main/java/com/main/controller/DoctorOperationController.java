package com.main.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.entity.Doctor;
import com.main.services.IDoctorService;

@RestController("dController")
@RequestMapping("/api")
public class DoctorOperationController 
{
    
	@Autowired
	private IDoctorService service;
	
	 
	@PostMapping("/register")
	public ResponseEntity<String>  registerDoctor(@RequestBody Doctor doctor) 
	{
	     String msg = service.registerDoctor(doctor);	
	     
		return new ResponseEntity<String>(msg, HttpStatus.CREATED); 
	}

    @PostMapping("/registerAll")
	public ResponseEntity<String> registerAllDoctors(@RequestBody List<Doctor> dList) 
	{
		     
		return new ResponseEntity<String>(service.registerAllDoctors(dList),HttpStatus.OK);
	}

	@GetMapping("/getSingleDoctor/{id}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable Integer id) 
	{
		   Optional<Doctor> opt =  service.getDoctorById(id);
		   Doctor d = opt.get();
		   
		   return new ResponseEntity<Doctor>(d, HttpStatus.OK);
	}

	@GetMapping("/fetchDoctor")
	public ResponseEntity<List<Doctor>> getAllDoctors() 
	{
		  List<Doctor> dList = service.getAllDoctors();
		  
		return  new ResponseEntity<List<Doctor>>(dList, HttpStatus.OK);
	}


	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteDoctorById(@PathVariable Integer id)
	{
		return new ResponseEntity<String>(service.deleteDoctorById(id), HttpStatus.OK);
	}

}
