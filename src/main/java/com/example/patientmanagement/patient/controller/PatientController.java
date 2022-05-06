package com.example.patientmanagement.patient.controller;


import com.example.patientmanagement.exception.Success;
import com.example.patientmanagement.patient.dto.PatientRequestDto;
import com.example.patientmanagement.patient.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/patients")
public class PatientController {


    private final PatientService patientService;

    @PostMapping("")
    public ResponseEntity<Success> registrationPatient(@RequestBody PatientRequestDto.Create dto) {
        return new ResponseEntity<>(new Success("환자 등록",patientService.createPatient(dto)
                ), HttpStatus.OK);
    }

    @PatchMapping("")
    public ResponseEntity<Success> editPatient(@RequestBody PatientRequestDto.Update dto) {
        patientService.editPatient(dto);
        return new ResponseEntity<>(new Success("환자 정보 수정",""), HttpStatus.OK);
    }

    @DeleteMapping("/{patientId}")
    public ResponseEntity<Success> deletePatient(@PathVariable Long patientId) {
        patientService.deletePatient(patientId);
        return new ResponseEntity<>(new Success("환자 정보 삭제",""), HttpStatus.OK);
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<Success> singleInquiryPatient(@PathVariable Long patientId) {
        return new ResponseEntity<>(new Success("환자 단건 조회",patientService.findPatient(patientId))
                , HttpStatus.OK);
    }

    @GetMapping("/{hospitalId}/all")
    public ResponseEntity<Success> multipleInquiryPatient(@PathVariable Long hospitalId) {
        return new ResponseEntity<>(new Success("환자 전체 조회",patientService.findAllPatient(hospitalId))
                , HttpStatus.OK);
    }
}
