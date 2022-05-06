package com.example.patientmanagement.patient.repository;

import com.example.patientmanagement.patient.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
