package com.example.patientmanagement.visit.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

public class VisitRequestDto {


    @Getter
    @NoArgsConstructor
    public static class Create {

        private Timestamp reception_time;
        private String visit_status_code;

    }
}

