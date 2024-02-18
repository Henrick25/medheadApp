package com.medhead.api.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name= "hospital")
public class Hospital {
	
	

  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = true)
    private Double latitude;

    @Column(nullable = true)
    private Double longitude;

    
    //private Long bed;
    
//	@ManyToMany
//    @JoinTable(
//      name = "hospitalSpecialization",
//      joinColumns = @JoinColumn(name = "hospital_id"),
//      inverseJoinColumns = @JoinColumn(name = "specialization_id")
//    )
 
 //   private Set<Specialization> specializations = new HashSet<>();

    // Getters et setters

//    public Set<Specialization> getSpecializations() {
//        return specializations;
//    }
//
//    public void setSpecializations(Set<Specialization> specializations) {
//        this.specializations = specializations;
//    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	/*
	 * public Long getBed() { return bed; }
	 * 
	 * public void setBed(Long bed) { this.bed = bed; }
	 */

    
    
}
