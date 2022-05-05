package com.example.patientmanagement.patient.domain;


import com.example.patientmanagement.hospital.domain.Hospital;
import com.example.patientmanagement.patient.dto.PatientRequestDto;
import com.example.patientmanagement.visit.domain.Visit;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@Table(indexes = @Index(name = "patient_unique_number", columnList = "uniqueNumber"))
public class Patient {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "patient_id")
    private Long id;

    @Column(nullable = false,length = 45)
    private String name;

    @Column(nullable = false,length = 13)
    private String uniqueNumber;

    @Column(nullable = false, length = 10)
    private String genderCode;

    private String birth;

    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @Builder
    public Patient(String name, String uniqueNumber, String genderCode,
                   String birth, String phoneNumber, Hospital hospital) {
        this.name = name;
        this.uniqueNumber = uniqueNumber;
        this.genderCode = genderCode;
        this.birth = birth;
        this.phoneNumber = phoneNumber;
        this.hospital = hospital;
    }

    public void updatePatient(PatientRequestDto.Update dto) {
        this.name = dto.getName();
        this.genderCode = dto.getGender_code();
        this.birth = dto.getBirth();
        this.phoneNumber = dto.getPhone_number();
    }

    public static Patient of(PatientRequestDto.Create dto, Hospital hospital) {
        return Patient.builder()
                .name(dto.getName())
                .uniqueNumber(dto.getUnicque_number())
                .genderCode(dto.getGender_code())
                .birth(dto.getBirth())
                .phoneNumber(dto.getPhone_number())
                .hospital(hospital)
                .build();
    }
}





