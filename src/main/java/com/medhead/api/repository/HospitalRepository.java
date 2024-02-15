package com.medhead.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medhead.api.model.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Long>{

}
