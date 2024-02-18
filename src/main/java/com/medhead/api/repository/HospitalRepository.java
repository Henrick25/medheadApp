package com.medhead.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.medhead.api.model.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Long>{
	
	
	
	/*
	 * @Query(value = """ SELECT hospital.* FROM Hospital hospital JOIN
	 * hospitalSpecialization hs ON hospital.id = hs.hospital_id JOIN Specialization
	 * sp ON hs.specialization_id = sp.id WHERE sp.name =:specialisationName ORDER
	 * BY (6371 * acos( cos(radians(:lat)) * cos(radians(hospital.latitude)) *
	 * cos(radians(hospital.longitude) - radians(:lon)) + sin(radians(:lat)) *
	 * sin(radians(hospital.latitude)) )) ASC LIMIT 1 """, nativeQuery = true)
	 * 
	 * List<Hospital> findNearbyAndBySpecialisation(@Param("lat") double
	 * latitude, @Param("lon") double longitude, @Param("specialisationName") String
	 * specialisationName);
	 */
	
	
	
	 // Exemple pour une procédure retournant une liste d'hôpitaux
    @Procedure(name = "find_nearest_hospital")
    List<Hospital> find_nearest_hospital(@Param("specialisationName") String specialisationName, 
                                        @Param("lat") double lat, 
                                        @Param("lon") double lon);
}
