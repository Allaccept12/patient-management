package com.example.patientmanagement.visit.dto;

import com.example.patientmanagement.visit.domain.Visit;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;

public class VisitResponseDto {



    @Getter
    @NoArgsConstructor
    public static class PatientVisitInfo {

        private String visit_date;
        private String treatment_subject_code;
        private String treatment_type_code;

        @Builder
        public PatientVisitInfo(String visit_date, String treatment_subject_code, String treatment_type_code) {
            this.visit_date = visit_date;
            this.treatment_subject_code = treatment_subject_code;
            this.treatment_type_code = treatment_type_code;
        }

        public static PatientVisitInfo of(Visit visitEntity) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return PatientVisitInfo.builder()
                    .visit_date(sdf.format(visitEntity.getCreated()))
                    .treatment_subject_code(visitEntity.getTreatmentSubjectCode().getCode())
                    .treatment_type_code(visitEntity.getTreatmentTypeCode().getCode())
                    .build();
        }
    }

}
