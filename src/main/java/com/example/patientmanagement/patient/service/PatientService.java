package com.example.patientmanagement.patient.service;

import com.example.patientmanagement.patient.domain.Patient;
import com.example.patientmanagement.patient.dto.PatientRequestDto;
import com.example.patientmanagement.patient.dto.PatientResponseDto;

public interface PatientService {

    Long createPatient(PatientRequestDto.Create dto);

    void editPatient(PatientRequestDto.Update dto);

    void deletePatient(Long patientId);

    PatientResponseDto.PatientDetailInfo findPatient(Long patientId);

    PatientResponseDto.PatientList findAllPatient(Long hospitalId);

}
