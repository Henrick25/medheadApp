package com.medhead.api.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medhead.api.model.Hospital;
import com.medhead.api.repository.HospitalRepository;

import jakarta.transaction.Transactional;
@Service
public class HospitalService {
	@Autowired
    private HospitalRepository hospitalRepository;
	@Transactional
    public List<Hospital> findNearestHospital(String specialty, double patientLatitude, double patientLongitude) {
        // Implémentez la logique pour trouver l'hôpital le plus proche avec la spécialité requise.
        // Ceci est un exemple simplifié.
    	
    	List<Hospital> hospitals = hospitalRepository.find_nearest_hospital(specialty ,patientLatitude,patientLongitude  );
        return hospitals;
        
        
        
		/*
		 * List<Hospital> hospitals = hospitalRepository.findAll(); return
		 * hospitals.stream() .filter(hospital ->
		 * hospital.getSpecializations().stream().anyMatch(s ->
		 * s.getName().equalsIgnoreCase(specialty)))
		 * .min(Comparator.comparingDouble(hospital ->
		 * calculateDistance(patientLatitude, patientLongitude, hospital.getLatitude(),
		 * hospital.getLongitude()))) .orElse(null);
		 */
    }

	/*
	 * public static double calculateDistance(double lat1, double lon1, double lat2,
	 * double lon2) { final int R = 6371; // Rayon de la Terre en kilomètres double
	 * latDistance = Math.toRadians(lat2 - lat1); double lonDistance =
	 * Math.toRadians(lon2 - lon1); double a = Math.sin(latDistance / 2) *
	 * Math.sin(latDistance / 2) + Math.cos(Math.toRadians(lat1)) *
	 * Math.cos(Math.toRadians(lat2)) Math.sin(lonDistance / 2) *
	 * Math.sin(lonDistance / 2); double c = 2 * Math.atan2(Math.sqrt(a),
	 * Math.sqrt(1 - a)); double distance = R * c; // convertir en kilomètres
	 * 
	 * return distance; }
	 */
    public List <Hospital> findAllHospital() {
        // Implémentez la logique pour trouver l'hôpital le plus proche avec la spécialité requise.
        // Ceci est un exemple simplifié.
    	List<Hospital> hospitals = hospitalRepository.findAll();
   
        return hospitals;
    }
}
