package com.example.patientmanagement.hospital.service;

import com.example.patientmanagement.hospital.domain.Hospital;
import com.example.patientmanagement.hospital.dto.HospitalRequestDto;

import java.util.Optional;

public interface HospitalService {

    Hospital findHospital(Long hospitalId);

    Long registrationHospital(HospitalRequestDto.Create dto);
}
