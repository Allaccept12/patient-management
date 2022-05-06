package com.example.patientmanagement.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    NOT_FOUND_HOSPITAL("병원을 찾을수 없습니다."),
    NOT_FOUND_PATIENT("환자를 찾을 수 없습니다."),
    NOT_SUPPORTED_ENUM_VALUE("지원하지않는 코드(그룹)입니다.");


    private final String message;
}
