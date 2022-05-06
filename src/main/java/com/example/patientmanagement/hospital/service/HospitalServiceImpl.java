package com.example.patientmanagement.hospital.service;


import com.example.patientmanagement.exception.CustomException;
import com.example.patientmanagement.exception.ErrorCode;
import com.example.patientmanagement.hospital.domain.Hospital;
import com.example.patientmanagement.hospital.dto.HospitalRequestDto;
import com.example.patientmanagement.hospital.repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class HospitalServiceImpl implements HospitalService{

    private final HospitalRepository hospitalRepository;


    @Transactional(readOnly = true)
    public Hospital findHospital(Long hospitalId) {
        return hospitalRepository.findById(hospitalId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_HOSPITAL));

    }

    @Transactional
    public Long registrationHospital(HospitalRequestDto.Create dto) {

        Hospital save = hospitalRepository.save(Hospital.from(dto));
        return save.getId();
    }
}
