package com.example.patientmanagement.patient.repository;

import com.example.patientmanagement.patient.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> , PatientRepositoryCustom {

    @Query("select p from Patient p left join fetch p.visitList v where p.id =:patientId order by v.created desc ")
    Optional<Patient> findById(Long patientId);


}
