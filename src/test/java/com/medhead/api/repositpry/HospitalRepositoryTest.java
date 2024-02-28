package com.medhead.api.repositpry;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

import com.medhead.api.model.Hospital;
import com.medhead.api.model.Specialization;
import com.medhead.api.repository.HospitalRepository;




import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;

@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class HospitalRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private HospitalRepository hospitalRepository;

    @Test
    public void testFindNearestHospitalWithH2() {
        // Insérer des données de test pour Specialization et Hospital
        Specialization spec = new Specialization();
        spec.setName("Cardiology");
        spec = entityManager.persistFlushFind(spec);

        Hospital hospital = new Hospital();
        hospital.setName("Test Hospital");
        hospital.setLatitude(48.8566);
        hospital.setLongitude(2.3522);
        hospital.setLit(10L);
        hospital.getSpecializations().add(spec);
        entityManager.persistFlushFind(hospital);

        // Assurez-vous que la relation est bien établie
        entityManager.flush();

        // Exécutez une requête qui joint les tables Hospital et Specialization
        String query = "SELECT h FROM Hospital h " +
                       "JOIN h.specializations s " +
                       "WHERE s.name = :specialisationName";
        Hospital foundHospital = entityManager.getEntityManager().createQuery(query, Hospital.class)
                .setParameter("specialisationName", "Cardiology")
                .getSingleResult();

        assertNotNull(foundHospital);
        assertEquals("Test Hospital", foundHospital.getName());
    }

}



