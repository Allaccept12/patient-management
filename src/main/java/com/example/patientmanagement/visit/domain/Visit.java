package com.example.patientmanagement.visit.domain;


import com.example.patientmanagement.converter.TreatmentSubjectConverter;
import com.example.patientmanagement.converter.TreatmentTypeConverter;
import com.example.patientmanagement.converter.VisitStatusConverter;
import com.example.patientmanagement.hospital.domain.Hospital;
import com.example.patientmanagement.patient.domain.Patient;
import com.example.patientmanagement.util.BaseEntity;
import com.example.patientmanagement.visit.dto.VisitRequestDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Visit extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "visit_id")
    private Long id;

    @Convert(converter = VisitStatusConverter.class)
    @Column(nullable = false, length = 10)
    private VisitStatusCode visitStatusCode;

    @Convert(converter = TreatmentSubjectConverter.class)
    @Column(nullable = false, length = 10)
    private TreatmentSubjectCode treatmentSubjectCode;

    @Convert(converter = TreatmentTypeConverter.class)
    @Column(nullable = false, length = 10)
    private TreatmentTypeCode treatmentTypeCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @Builder
    public Visit(VisitStatusCode visitStatusCode, TreatmentSubjectCode treatmentSubjectCode,
                 TreatmentTypeCode treatmentTypeCode, Patient patient, Hospital hospital) {
        this.visitStatusCode = visitStatusCode;
        this.treatmentSubjectCode = treatmentSubjectCode;
        this.treatmentTypeCode = treatmentTypeCode;
        this.patient = patient;
        this.hospital = hospital;
    }

    public static Visit of(Patient patient, Hospital hospital, VisitRequestDto.Create dto) {
        return Visit.builder()
                .visitStatusCode(dto.getVisit_status_code())
                .treatmentSubjectCode(dto.getTreatment_subject_code())
                .treatmentTypeCode(dto.getTreatment_type_code())
                .patient(patient)
                .hospital(hospital)
                .build();
    }
}
