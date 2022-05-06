package com.example.patientmanagement.patient.service;

import com.example.patientmanagement.patient.dto.PatientRequestDto;
import com.example.patientmanagement.patient.dto.PatientResponseDto;

public interface PatientService {

    Long createPatient(PatientRequestDto.Create dto);

    void editPatient(PatientRequestDto.Update dto);

    void deletePatient(Long patientId);

    PatientResponseDto.PatientDetailInfo findPatient(Long patientId);

    PatientResponseDto.PatientList findAllPatient(Long hospitalId,String type,String value, Integer pageNo, Integer pageSize);

}
