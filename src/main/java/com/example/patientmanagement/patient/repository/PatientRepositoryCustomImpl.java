package com.example.patientmanagement.patient.repository;

import com.example.patientmanagement.patient.domain.Patient;
import com.example.patientmanagement.patient.domain.QPatient;
import com.example.patientmanagement.visit.domain.QVisit;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static com.example.patientmanagement.patient.domain.QPatient.patient;
import static com.example.patientmanagement.visit.domain.QVisit.visit;

@RequiredArgsConstructor
public class PatientRepositoryCustomImpl implements PatientRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<List<Patient>> findAll(Long hospitalId,String type,String searchValue, Pageable pageable) {

        return Optional.ofNullable(queryFactory
                .selectFrom(patient)
                .distinct()
                .leftJoin(visit).on(visit.patient.id.eq(patient.id))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .where(isPatientSearch(type, searchValue),
                        patient.hospital.id.eq(hospitalId))
                .fetch());
    }

    private BooleanExpression isPatientSearch(String type,String searchValue) {
        if (searchValue == null) {
            return null;
        }
        return !type.equals("이름") ? isPatientSearchEtc(type, searchValue) : patient.name.eq(searchValue);
    }

    private BooleanExpression isPatientSearchEtc(String type,String searchValue) {
        return type.equals("환자등록번호") ? patient.registrationNumber.eq(searchValue) : patient.birth.eq(searchValue);
    }
}
