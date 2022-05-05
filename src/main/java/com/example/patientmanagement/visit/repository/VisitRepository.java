package com.example.patientmanagement.visit.repository;

import com.example.patientmanagement.visit.domain.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<Visit, Long> {
}
