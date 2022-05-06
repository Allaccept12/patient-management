package com.example.patientmanagement.patient.dto;

import com.example.patientmanagement.patient.domain.GenderCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class PatientRequestDto {


    @Getter
    @AllArgsConstructor
    public static class Create {

        private Long hospital_id;
        private String name;
        private GenderCode gender_code;
        private String birth;
        private String phone_number;
    }

    @Getter
    @AllArgsConstructor
    public static class Update {

        private Long patient_id;
        private String name;
        private GenderCode gender_code;
        private String birth;
        private String phone_number;
    }

}

