package com.example.patientmanagement.visit.service;

import com.example.patientmanagement.hospital.domain.Hospital;
import com.example.patientmanagement.hospital.repository.HospitalRepository;
import com.example.patientmanagement.patient.domain.GenderCode;
import com.example.patientmanagement.patient.domain.Patient;
import com.example.patientmanagement.patient.repository.PatientRepository;
import com.example.patientmanagement.visit.domain.TreatmentSubjectCode;
import com.example.patientmanagement.visit.domain.TreatmentTypeCode;
import com.example.patientmanagement.visit.domain.VisitStatusCode;
import com.example.patientmanagement.visit.dto.VisitRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional
class PatientVisitServiceImplTest {


    @Autowired
    PatientVisitService patientVisitService;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    HospitalRepository hospitalRepository;

    @Autowired
    EntityManager em;

    @Test
    void 환자_접수() {
        // given
        Hospital hospital = getHospital();
        Patient patientTest1 = getPatientTest(hospital, "patient1");
        VisitRequestDto.Create visit = new VisitRequestDto.Create(hospital.getId(), patientTest1.getId(),
                VisitStatusCode.VISITING, TreatmentSubjectCode.MEDICINE, TreatmentTypeCode.TEST);
        // when
        patientVisitService.receptionPatient(visit);
        em.flush();
        em.clear();
        Patient patient = patientRepository.findById(patientTest1.getId()).get();
        // then
        assertThat(patient.getVisitList().size()).isEqualTo(1);
        assertThat(patient.getVisitList().get(0).getVisitStatusCode()).isEqualTo(VisitStatusCode.VISITING);

    }
    private Patient getPatientTest(Hospital hospitalTest, String name) {
        return patientRepository.save(Patient.builder()
                .name(name)
                .registrationNumber("test")
                .genderCode(GenderCode.FEMALE)
                .hospital(hospitalTest)
                .build());
    }

    private Hospital getHospital() {
        Hospital hospital = Hospital.builder().
                hospitalName("test").
                hospitalDirector("test").
                nursingHomeNumber("test").
                build();
        return hospitalRepository.save(hospital);
    }
}