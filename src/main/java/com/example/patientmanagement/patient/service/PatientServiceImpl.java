package com.example.patientmanagement.patient.service;

import com.example.patientmanagement.exception.CustomException;
import com.example.patientmanagement.exception.ErrorCode;
import com.example.patientmanagement.hospital.domain.Hospital;
import com.example.patientmanagement.hospital.service.HospitalService;
import com.example.patientmanagement.patient.domain.Patient;
import com.example.patientmanagement.patient.dto.PatientRequestDto;
import com.example.patientmanagement.patient.dto.PatientResponseDto;
import com.example.patientmanagement.patient.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService{

    private final PatientRepository patientRepository;
    private final HospitalService hospitalService;
    private final int PATIENT_REGISTRATION_NUMBER_SIZE = 12;

    @Transactional
    public Long createPatient(PatientRequestDto.Create dto) {
        final Hospital hospital = hospitalService.findHospital(dto.getHospitalId());
        final String registrationNumber = UUID.randomUUID()
                        .toString().substring(0,PATIENT_REGISTRATION_NUMBER_SIZE);
        Patient patient = patientRepository.save(Patient.of(dto, hospital, registrationNumber));
        return patient.getId();
    }

    @Transactional
    public void editPatient(PatientRequestDto.Update dto) {
        final Patient patient = getPatient(dto.getPatient_id());
        patient.updatePatient(dto);
    }

    @Transactional
    public void deletePatient(Long patientId) {
        final Patient patient = getPatient(patientId);
        patientRepository.delete(patient);
    }

    @Transactional(readOnly = true)
    public PatientResponseDto.PatientDetailInfo findPatient(Long patientId) {
        final Patient patient = getPatient(patientId);
        return PatientResponseDto.PatientDetailInfo.from(patient);
    }

    @Transactional(readOnly = true)
    public PatientResponseDto.PatientList findAllPatient(Long hospitalId) {
        final Hospital hospital = hospitalService.findHospital(hospitalId);
        final List<Patient> patients = patientRepository.findAll(hospital.getId())
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_PATIENT));
        return PatientResponseDto.PatientList.builder().patientEntityList(patients).build();
    }

    public Patient getPatient(Long patientId) {
        return patientRepository.findById(patientId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_PATIENT));
    }
}