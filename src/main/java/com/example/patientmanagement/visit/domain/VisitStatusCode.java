package com.example.patientmanagement.visit.domain;

import com.example.patientmanagement.converter.EntityEnumerable;

public enum VisitStatusCode implements EntityEnumerable {

    VISITING("1", "방문중"),
    END("2", "종료"),
    CANCEL("3", "취소");


    private final String code;
    private final String value;

    VisitStatusCode(String code, String value) {
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
