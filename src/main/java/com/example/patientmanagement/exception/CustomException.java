package com.example.patientmanagement.exception;

public class CustomException extends RuntimeException{

    private ErrorCode errorCode;

    public CustomException(String message, ErrorCode code){
        super(message);
        this.errorCode = code;
    }

    public CustomException(ErrorCode code) {
        super(code.getMessage());
        this.errorCode = code;
    }

    public ErrorCode getErrorCode(){
        return errorCode;
    }

}
