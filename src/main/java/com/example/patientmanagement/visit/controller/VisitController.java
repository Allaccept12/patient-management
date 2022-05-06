package com.example.patientmanagement.visit.controller;


import com.example.patientmanagement.exception.CustomException;
import com.example.patientmanagement.exception.ErrorCode;
import com.example.patientmanagement.exception.Success;
import com.example.patientmanagement.visit.dto.VisitRequestDto;
import com.example.patientmanagement.visit.service.PatientVisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class VisitController {

    private final PatientVisitService patientVisitService;

    @PostMapping("api/visits")
    public ResponseEntity<Success> visitPatient(@RequestBody VisitRequestDto.Create dto) {
        if (dto.getVisit_status_code().getCode().isBlank()) {
            throw new CustomException(ErrorCode.VALID_VISIT_STATUS_CODE);
        }
        if (dto.getTreatment_subject_code().getCode().isBlank()) {
            throw new CustomException(ErrorCode.VALID_VISIT_SUBJECT_CODE);
        }
        if (dto.getTreatment_type_code().getCode().isBlank()) {
            throw new CustomException(ErrorCode.VALID_VISIT_TYPE_CODE);
        }
        patientVisitService.receptionPatient(dto);
        return new ResponseEntity<>(new Success("환자 접수",""), HttpStatus.OK);
    }
}
