package com.main.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="Jpa_Doctor_Info")
@Data
@AllArgsConstructor
public class Doctor 
{
	 @Column(name="DOC_ID")
	 @Id
	 @GeneratedValue
     private Integer id;
	 
 
	 @Column(name="DOC_NAME")
     private String docName;
	 
	 
	 @Column(name="INCOME")
     private Float income;
	 
 
	 @Column(name="SPECIALIZATION")
     private String specialization;
     
}
