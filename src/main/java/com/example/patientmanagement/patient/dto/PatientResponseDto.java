package com.example.patientmanagement.patient.dto;

import com.example.patientmanagement.patient.domain.Patient;
import com.example.patientmanagement.visit.dto.VisitResponseDto;
import com.example.patientmanagement.visit.dto.VisitResponseDto.PatientVisitInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

public class PatientResponseDto {


    @Getter
    @NoArgsConstructor
    public static class PatientDetailInfo {

        private Long patient_id;
        private String patient_name;
        private String patient_reception_number;
        private String patient_gender_code;
        private String patient_birth;
        private String patient_phone_number;
        private List<PatientVisitInfo> patient_visit_info;

        @Builder
        public PatientDetailInfo(Long patient_id,String patient_name, String patient_reception_number,
                           String patient_gender_code, String patient_birth,
                           String patient_phone_number, List<PatientVisitInfo> patient_visit_info) {
            this.patient_id = patient_id;
            this.patient_name = patient_name;
            this.patient_reception_number = patient_reception_number;
            this.patient_gender_code = patient_gender_code;
            this.patient_birth = patient_birth;
            this.patient_phone_number = patient_phone_number;
            this.patient_visit_info = patient_visit_info;
        }

        public static PatientDetailInfo from(Patient patientEntity) {
            return PatientDetailInfo.builder()
                    .patient_id(patientEntity.getId())
                    .patient_name(patientEntity.getName())
                    .patient_reception_number(patientEntity.getRegistrationNumber())
                    .patient_gender_code(patientEntity.getGenderCode().getCode())
                    .patient_birth(patientEntity.getBirth())
                    .patient_phone_number(patientEntity.getPhoneNumber())
                    .patient_visit_info(patientEntity.getVisitList().stream()
                            .map(PatientVisitInfo::of)
                            .collect(Collectors.toList()))
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor
    public static class PatientSimpleInfo {

        private Long patient_id;
        private String patient_name;
        private String patient_reception_number;
        private String patient_gender_code;
        private String patient_birth;
        private String patient_phone_number;
        private String patient_lately_date;

        @Builder
        public PatientSimpleInfo(Long patient_id,String patient_name, String patient_reception_number,
                                 String patient_gender_code, String patient_birth,
                                 String patient_phone_number, String patient_lately_date) {
            this.patient_id = patient_id;
            this.patient_name = patient_name;
            this.patient_reception_number = patient_reception_number;
            this.patient_gender_code = patient_gender_code;
            this.patient_birth = patient_birth;
            this.patient_phone_number = patient_phone_number;
            this.patient_lately_date = patient_lately_date;
        }

        public static PatientSimpleInfo from(Patient patientEntity) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String latelydate = "--";
            if (patientEntity.getVisitList().size() > 0) {
                Timestamp receptionDate = patientEntity.getVisitList().get(0).getCreated();
                latelydate = sdf.format(receptionDate);
            }
            return PatientSimpleInfo.builder()
                    .patient_id(patientEntity.getId())
                    .patient_name(patientEntity.getName())
                    .patient_reception_number(patientEntity.getRegistrationNumber())
                    .patient_gender_code(patientEntity.getGenderCode().getCode())
                    .patient_birth(patientEntity.getBirth())
                    .patient_phone_number(patientEntity.getPhoneNumber())
                    .patient_lately_date(latelydate)
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor
    public static class PatientList {

        private List<PatientSimpleInfo> patientList;

        @Builder
        public PatientList(List<Patient> patientEntityList) {
            this.patientList = patientEntityList.stream()
                    .map(PatientSimpleInfo::from)
                    .collect(Collectors.toList());
        }
    }
}

