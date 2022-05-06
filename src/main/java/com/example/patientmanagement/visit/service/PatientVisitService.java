package com.example.patientmanagement.visit.service;

import com.example.patientmanagement.visit.dto.VisitRequestDto;

public interface PatientVisitService {

    void receptionPatient(VisitRequestDto.Create dto);
}
