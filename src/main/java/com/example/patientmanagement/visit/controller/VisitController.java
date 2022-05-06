package com.example.patientmanagement.visit.controller;


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

    @PostMapping("/api/visit")
    public ResponseEntity<Success> visitPatient(@RequestBody VisitRequestDto.Create dto) {
        patientVisitService.receptionPatient(dto);
        return new ResponseEntity<>(new Success("환자 접수",""), HttpStatus.OK);
    }
}
