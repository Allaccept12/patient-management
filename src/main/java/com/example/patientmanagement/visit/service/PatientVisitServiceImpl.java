package com.example.patientmanagement.visit.service;


import com.example.patientmanagement.exception.CustomException;
import com.example.patientmanagement.exception.ErrorCode;
import com.example.patientmanagement.hospital.domain.Hospital;
import com.example.patientmanagement.hospital.service.HospitalService;
import com.example.patientmanagement.patient.domain.Patient;
import com.example.patientmanagement.patient.repository.PatientRepository;
import com.example.patientmanagement.visit.domain.Visit;
import com.example.patientmanagement.visit.dto.VisitRequestDto;
import com.example.patientmanagement.visit.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PatientVisitServiceImpl implements PatientVisitService{

    private final PatientRepository patientRepository;
    private final VisitRepository visitRepository;
    private final HospitalService hospitalService;


    @Transactional
    public void receptionPatient(VisitRequestDto.Create dto) {
        Patient patient = patientRepository.findById(dto.getPatientId())
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_PATIENT));
        Hospital hospital = hospitalService.findHospital(patient.getHospital().getId());
        Visit visit = Visit.of(patient,hospital,dto);
        visitRepository.save(visit);
    }
}
