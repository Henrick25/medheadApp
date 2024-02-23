package com.medhead.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "groupes_specialites")
public class GroupeSpecialite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_groupe", nullable = false)
    private Integer idGroupe;

    @Column(name = "nom_groupe", nullable = false, length = 255)
    private String nomGroupe;

    // Constructors, getters and setters
}
