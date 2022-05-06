package com.example.patientmanagement.hospital.service;

import com.example.patientmanagement.hospital.domain.Hospital;

import java.util.Optional;

public interface HospitalService {

    Hospital findHospital(Long hospitalId);
}
