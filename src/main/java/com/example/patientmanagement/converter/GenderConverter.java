package com.example.patientmanagement.converter;

import com.example.patientmanagement.exception.CustomException;
import com.example.patientmanagement.exception.ErrorCode;
import com.example.patientmanagement.patient.domain.GenderCode;

import javax.persistence.AttributeConverter;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Objects;

public class GenderConverter implements AttributeConverter<GenderCode, String> {


    @Override
    public String convertToDatabaseColumn(GenderCode attribute) {
        if (Objects.isNull(attribute)) {
            return null;
        }
        return attribute.getCode();
    }

    @Override
    public GenderCode convertToEntityAttribute(String dbData) {
        if (dbData.isBlank()) {
            return null;
        }
        return EnumSet.allOf(GenderCode.class).stream()
                .filter(ed -> ed.getCode().equals(dbData))
                .findFirst()
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_SUPPORTED_ENUM_VALUE));
    }
}
