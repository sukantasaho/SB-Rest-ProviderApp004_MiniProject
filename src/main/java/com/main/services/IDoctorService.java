package com.main.services;

import java.util.List;
import java.util.Optional;

import com.main.entity.Doctor;

public interface IDoctorService 
{
     public String registerDoctor(Doctor doctor);
     public String registerAllDoctors(List<Doctor> dList);
     public Optional<Doctor> getDoctorById(Integer id);
     public List<Doctor> getAllDoctors();
     public String deleteDoctorById(Integer id);
     
     
}
