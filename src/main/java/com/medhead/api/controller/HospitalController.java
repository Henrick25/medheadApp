package com.medhead.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.medhead.api.model.Hospital;
import com.medhead.api.service.HospitalService;

@RestController
public class HospitalController {
	  @Autowired
	    private HospitalService hospitalService;
	  
	

	    @GetMapping("/api/hospitals")
	    public ResponseEntity< List   <Hospital>> getNearestHospital(@RequestParam String specialty,  @RequestParam("latitude") double latitude,
	            @RequestParam("longitude") double longitude) {
	      List   <Hospital> hospital = hospitalService.findNearestHospital(specialty, latitude, longitude);
	        if (hospital != null) {
	            return new ResponseEntity<>(hospital, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	    
	    @GetMapping("admin/api/hospital")
	    public ResponseEntity<List<Hospital>> getAllHospital() {
	    	
	        List<Hospital> hospital = hospitalService.findAllHospital();
	        if (hospital != null) {
	            return new ResponseEntity<>(hospital, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	    
	    @GetMapping("/api/hospitalspeciality")
	    public ResponseEntity<List<Hospital>> getAllHospitalspeciality() {
	    	
	        List<Hospital> hospital = hospitalService.findAllHospital();
	        if (hospital != null) {
	            return new ResponseEntity<>(hospital, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	    
}
