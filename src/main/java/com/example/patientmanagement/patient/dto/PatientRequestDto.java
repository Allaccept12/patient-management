package com.example.patientmanagement.patient.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

public class PatientRequestDto {


    @Getter
    @NoArgsConstructor
    public static class Create {

        private String name;
        private String unicque_number;
        private String gender_code;
        private String birth;
        private String phone_number;
    }

    @Getter
    @NoArgsConstructor
    public static class Update {

        private String name;
        private String gender_code;
        private String birth;
        private String phone_number;
    }

}

