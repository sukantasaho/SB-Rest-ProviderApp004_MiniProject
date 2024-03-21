package com.main;

 
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.main.entity.Doctor;
import com.main.services.IDoctorService;

 

@SpringBootApplication
public class SbRestProviderApp004MiniProjectApplication 
{

	public static void main(String[] args) 
	{
		ApplicationContext ctx = SpringApplication.run(SbRestProviderApp004MiniProjectApplication.class, args);
		IDoctorService service = ctx.getBean("dService", IDoctorService.class);
		 Optional<Doctor> d = service.getDoctorById(1202);
		 if(!d.isEmpty())
		 {
			Doctor doctor = d.get();
			System.out.println(doctor.getDocName()+" "+doctor.getSpecialization());
		 }
		
		
	
	         
	}

}
