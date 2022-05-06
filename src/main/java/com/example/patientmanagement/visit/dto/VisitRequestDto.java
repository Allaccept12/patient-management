package com.example.patientmanagement.visit.dto;

import com.example.patientmanagement.visit.domain.TreatmentSubjectCode;
import com.example.patientmanagement.visit.domain.TreatmentTypeCode;
import com.example.patientmanagement.visit.domain.VisitStatusCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class VisitRequestDto {


    @Getter
    @AllArgsConstructor
    public static class Create {

        private Long hospital_id;
        private Long patient_id;
        private VisitStatusCode visit_status_code;
        private TreatmentSubjectCode treatment_subject_code;
        private TreatmentTypeCode treatment_type_code;

    }
}

