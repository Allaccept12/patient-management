package com.example.patientmanagement.hospital.domain;


import com.example.patientmanagement.hospital.dto.HospitalRequestDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Hospital {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "hospital_id")
    private Long id;

    @Column(nullable = false,length = 45)
    private String hospitalName;

    @Column(nullable = false, length = 20)
    private String nursingHomeNumber;

    @Column(nullable = false, length = 10)
    private String hospitalDirector;

    @Builder
    public Hospital(String hospitalName, String nursingHomeNumber, String hospitalDirector) {
        this.hospitalName = hospitalName;
        this.nursingHomeNumber = nursingHomeNumber;
        this.hospitalDirector = hospitalDirector;
    }

    public static Hospital from(HospitalRequestDto.create dto) {
        return Hospital.builder()
                .hospitalName(dto.getHospital_name())
                .nursingHomeNumber(dto.getNursing_home_number())
                .hospitalDirector(dto.getHospital_director())
                .build();
    }
}





