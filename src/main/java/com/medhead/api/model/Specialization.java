package com.medhead.api.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name= "specialization")
public class Specialization {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

//    @ManyToMany(mappedBy = "specializations", fetch = FetchType.LAZY)
 //   private Set<Hospital> hospitals = new HashSet<>();

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
//
//	public Set<Hospital> getHospitals() {
//		return hospitals;
//	}
//
//	public void setHospitals(Set<Hospital> hospitals) {
//		this.hospitals = hospitals;
//	}

	public void setName(String name) {
		this.name = name;
	}
	
}
