package com.example.patientmanagement.converter;

import com.example.patientmanagement.exception.CustomException;
import com.example.patientmanagement.exception.ErrorCode;
import com.example.patientmanagement.visit.domain.TreatmentTypeCode;

import javax.persistence.AttributeConverter;
import java.util.EnumSet;
import java.util.Objects;

public class TreatmentTypeConverter implements AttributeConverter<TreatmentTypeCode, String> {

    @Override
    public String convertToDatabaseColumn(TreatmentTypeCode attribute) {
        if (Objects.isNull(attribute)) {
            return null;
        }
        return attribute.getCode();
    }

    @Override
    public TreatmentTypeCode convertToEntityAttribute(String dbData) {
        if (dbData.isBlank()) {
            return null;
        }
        return EnumSet.allOf(TreatmentTypeCode.class).stream()
                .filter(ed -> ed.getCode().equals(dbData))
                .findFirst()
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_SUPPORTED_ENUM_VALUE));
    }
}
