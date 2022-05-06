package com.example.patientmanagement.visit.service;

import com.example.patientmanagement.visit.dto.VisitRequestDto;
import com.example.patientmanagement.visit.dto.VisitResponseDto;

public interface PatientVisitService {

    void receptionPatient(VisitRequestDto.Create dto);
}
