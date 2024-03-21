package com.main.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entity.Doctor;
import com.main.repository.DoctorRepository;

@Service("dService")
public class DoctorServiceImp implements IDoctorService 
{
   
	@Autowired
	private DoctorRepository repo;
	
	@Override
	public String registerDoctor(Doctor doctor) 
	{
		 
		return "Doctor record is inserted with id-"+repo.save(doctor).getId();
	}

	@Override
	public String registerAllDoctors(List<Doctor> dList) 
	{
		     List<Doctor> list = (List<Doctor>) repo.saveAll(dList);
		     List<Integer> idList = list.stream().map(e->e.getId()).collect(Collectors.toList());
		return "Bulk of doctors record is inserted with ids-"+idList;
	}

	@Override
	public  Optional<Doctor> getDoctorById(Integer id) 
	{
		 return repo.findById(id);
	}

	@Override
	public List<Doctor> getAllDoctors() 
	{
		 
		return (List<Doctor>) repo.findAll();
	}

	@Override
	public String deleteDoctorById(Integer id)
	{
		Optional<Doctor> opt = repo.findById(id);
		if(opt.isPresent())
		{
			repo.deleteById(id);
			return "Doctor record is deleted with the id-"+id;
		}
		else
			return "Doctor record is not found with this id-"+id;
		 
	}

}
