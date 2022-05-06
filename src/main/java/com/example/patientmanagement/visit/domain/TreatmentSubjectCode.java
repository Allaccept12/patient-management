package com.example.patientmanagement.visit.domain;

import com.example.patientmanagement.converter.EntityEnumerable;

public enum TreatmentSubjectCode implements EntityEnumerable {

    MEDICINE("D", "내과"),
    OPHTHALMOLOGY("T", "안과");

    private final String code;
    private final String value;

    TreatmentSubjectCode(String code, String value) {
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
