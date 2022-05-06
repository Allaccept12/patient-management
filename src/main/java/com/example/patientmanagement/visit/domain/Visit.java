package com.example.patientmanagement.visit.domain;


import com.example.patientmanagement.hospital.domain.Hospital;
import com.example.patientmanagement.patient.domain.Patient;
import com.example.patientmanagement.visit.dto.VisitRequestDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Visit {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "visit_id")
    private Long id;

    @Column(nullable = false)
    private Timestamp receptionDate;

    @Column(nullable = false, length = 10)
    private String visitStatusCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @Builder
    public Visit(Timestamp receptionDate, String visitStatusCode, Patient patient, Hospital hospital) {
        this.receptionDate = receptionDate;
        this.visitStatusCode = visitStatusCode;
        this.patient = patient;
        this.hospital = hospital;
    }

    public static Visit of(Patient patient, Hospital hospital, VisitRequestDto.Create dto) {
        return Visit.builder()
                .receptionDate(dto.getReception_time())
                .visitStatusCode(dto.getVisit_status_code())
                .patient(patient)
                .hospital(hospital)
                .build();
    }
}
