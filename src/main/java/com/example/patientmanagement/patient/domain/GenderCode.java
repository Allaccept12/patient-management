package com.example.patientmanagement.patient.domain;

import com.example.patientmanagement.converter.EntityEnumerable;



public enum GenderCode implements EntityEnumerable {
    MALE("M", "남자"),
    FEMALE("F", "여자");


    private final String code;
    private final String value;

    GenderCode(String code, String value) {
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
