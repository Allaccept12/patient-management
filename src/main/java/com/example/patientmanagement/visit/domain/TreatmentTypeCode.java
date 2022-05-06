package com.example.patientmanagement.visit.domain;

import com.example.patientmanagement.converter.EntityEnumerable;

public enum TreatmentTypeCode implements EntityEnumerable {

    PRESCRIPTION("D", "약처방"),
    TEST("T", "검사");



    private final String code;
    private final String value;

    TreatmentTypeCode(String code, String value) {
        this.code = code;
        this.value = value;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getValue() {
        return value;
    }
}
