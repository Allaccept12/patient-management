package com.example.patientmanagement.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Success<T> {

    private final String result = "success" ;
    private String msg;
    private T data;

    public Success(final String msg,final T data) {
        this.msg = msg;
        this.data = data;
    }
}
