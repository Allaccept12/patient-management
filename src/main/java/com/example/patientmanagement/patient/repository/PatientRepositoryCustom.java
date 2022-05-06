package com.example.patientmanagement.patient.repository;

import com.example.patientmanagement.patient.domain.Patient;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PatientRepositoryCustom {

    Optional<List<Patient>> findAll(Long hospitalId,String type,String searchValue, Pageable pageable);
}
