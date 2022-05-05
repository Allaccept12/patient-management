package com.example.patientmanagement.hospital.repository;

import com.example.patientmanagement.hospital.domain.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
}
