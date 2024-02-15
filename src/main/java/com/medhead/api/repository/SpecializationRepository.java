package com.medhead.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medhead.api.model.Specialization;

public interface SpecializationRepository extends JpaRepository<Specialization, Long> {

}
