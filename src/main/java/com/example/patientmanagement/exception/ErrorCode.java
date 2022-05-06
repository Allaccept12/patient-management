package com.example.patientmanagement.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    NOT_FOUND_HOSPITAL("병원을 찾을수 없습니다."),
    NOT_FOUND_PATIENT("환자를 찾을수 없습니다."),
    NOT_SUPPORTED_ENUM_VALUE("지원하지않는 코드(그룹)입니다."),

    VALID_HOSPITAL_NAME("병원 이름이 길거나 유효하지 않습니다."),
    VALID_HOSPITAL_DIRECTOR("병원장명이 길거나 유효하지 않습니다."),
    VALID_HOSPITAL_NURSING_HOME_NUMBER("요양기관번호가 유효하지 않습니다."),

    VALID_PATIENT_NAME("환자명이 길거나 유효하지 않습니다."),
    VALID_PATIENT_GENDER_CODE("성별을 선택하지 않았습니다."),

    VALID_VISIT_STATUS_CODE("현재 상태를 선택해주세요."),
    VALID_VISIT_SUBJECT_CODE("진료받으셨거나 진료를 받기를 원하시는 과를 선택해주세요"),
    VALID_VISIT_TYPE_CODE("진료를 원하시는 행위를 선택해주세요.");




    private final String message;
}
