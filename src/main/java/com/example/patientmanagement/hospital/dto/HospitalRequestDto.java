package com.example.patientmanagement.hospital.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

public class HospitalRequestDto {



    @Getter
    @NoArgsConstructor
    public static class Create {

        private String hospital_name;
        private String nursing_home_number;
        private String hospital_director;
    }
}

