package com.example.patientmanagement.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Fail {

    private final String result = "fail";
    private String msg;

    public Fail(final ErrorCode errorCode){
        this.msg = errorCode.getMessage();
    }

}
