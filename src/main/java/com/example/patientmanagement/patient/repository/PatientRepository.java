package com.example.patientmanagement.patient.repository;

import com.example.patientmanagement.patient.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("select p from Patient p left join fetch p.visitList v where p.id =:patientId order by v.receptionDate desc ")
    Optional<Patient> findById(Long patientId);

    @Query("select p from Patient p left join fetch p.visitList v where p.hospital.id =:hospitalId order by v.receptionDate desc ")
    Optional<List<Patient>> findAll(Long hospitalId);
}
