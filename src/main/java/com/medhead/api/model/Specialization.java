package com.medhead.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name= "specialization")
public class Specialization {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "name", nullable = false, length = 255)
	    private String name;

	    @Column(name = "idGroupe", nullable = true)
	    private Integer idGroupe;

	    @ManyToOne
	    @JoinColumn(name = "idGroupe", referencedColumnName = "id_groupe", insertable = false, updatable = false)
	    private GroupeSpecialite groupeSpecialite;
}
