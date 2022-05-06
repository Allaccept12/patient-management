package com.example.patientmanagement.converter;

import com.example.patientmanagement.exception.CustomException;
import com.example.patientmanagement.exception.ErrorCode;
import com.example.patientmanagement.visit.domain.TreatmentTypeCode;
import com.example.patientmanagement.visit.domain.VisitStatusCode;

import javax.persistence.AttributeConverter;
import java.util.EnumSet;
import java.util.Objects;

public class VisitStatusConverter implements AttributeConverter<VisitStatusCode, String> {

    @Override
    public String convertToDatabaseColumn(VisitStatusCode attribute) {
        if (Objects.isNull(attribute)) {
            return null;
        }
        return attribute.getCode();
    }

    @Override
    public VisitStatusCode convertToEntityAttribute(String dbData) {
        if (dbData.isBlank()) {
            return null;
        }
        return EnumSet.allOf(VisitStatusCode.class).stream()
                .filter(ed -> ed.getCode().equals(dbData))
                .findFirst()
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_SUPPORTED_ENUM_VALUE));
    }

}
