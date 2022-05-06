package com.example.patientmanagement.hospital.controller;


import com.example.patientmanagement.exception.CustomException;
import com.example.patientmanagement.exception.ErrorCode;
import com.example.patientmanagement.exception.Success;
import com.example.patientmanagement.hospital.dto.HospitalRequestDto;
import com.example.patientmanagement.hospital.service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HospitalController {

    private final HospitalService hospitalService;

    @PostMapping("api/hospitals")
    public ResponseEntity<Success> registrationHospital(@RequestBody HospitalRequestDto.Create dto) {
        hospitalValid(dto);
        return new ResponseEntity<>(new Success("병원 등록",hospitalService.registrationHospital(dto))
                , HttpStatus.OK);
    }

    private void hospitalValid(HospitalRequestDto.Create dto) {
        if (dto.getHospital_name().isBlank() || dto.getHospital_name().length() > 45) {
            throw new CustomException(ErrorCode.VALID_HOSPITAL_NAME);
        }
        if (dto.getHospital_director().isBlank() || dto.getHospital_director().length() > 10) {
            throw new CustomException(ErrorCode.VALID_HOSPITAL_DIRECTOR);
        }
        if (dto.getNursing_home_number().isBlank() || dto.getNursing_home_number().length() > 20) {
            throw new CustomException(ErrorCode.VALID_HOSPITAL_NURSING_HOME_NUMBER);
        }
    }
}
