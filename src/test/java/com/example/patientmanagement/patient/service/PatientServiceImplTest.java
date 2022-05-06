package com.example.patientmanagement.patient.service;

import com.example.patientmanagement.hospital.domain.Hospital;
import com.example.patientmanagement.hospital.repository.HospitalRepository;
import com.example.patientmanagement.patient.domain.GenderCode;
import com.example.patientmanagement.patient.domain.Patient;
import com.example.patientmanagement.patient.dto.PatientRequestDto;
import com.example.patientmanagement.patient.dto.PatientResponseDto;
import com.example.patientmanagement.patient.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional
class PatientServiceImplTest {


    @Autowired
    PatientService patientService;

    @Autowired
    HospitalRepository hospitalRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    EntityManager em;

    @Test
    public void 환자_생성() {
        //given
        Hospital hospitalTest = getHospital();
        PatientRequestDto.Create dto = getPatient(hospitalTest);
        //when
        Long patientId = patientService.createPatient(dto);
        Optional<Patient> savedPatient = patientRepository.findById(patientId);
        //then
        assertThat(savedPatient.get().getId()).isEqualTo(patientId);
    }

    @Test
    void 환자_정보_수정() {
        // given
        Hospital hospitalTest = getHospital();
        Patient savedPatient = getPatientTest(hospitalTest,"patient1");
        PatientRequestDto.Update updateDto = new PatientRequestDto.Update(savedPatient.getId(), "updateTest", GenderCode.MALE,
                "updateTest", "updateTest");
        // when
        patientService.editPatient(updateDto);
        em.flush();
        em.clear();
        // then
        assertThat(savedPatient.getName()).isEqualTo(updateDto.getName());
        assertThat(savedPatient.getGenderCode()).isEqualTo(updateDto.getGender_code());
        assertThat(savedPatient.getBirth()).isEqualTo(updateDto.getBirth());
        assertThat(savedPatient.getPhoneNumber()).isEqualTo(updateDto.getPhone_number());
    }

    @Test
    void 환자_삭제() {
        // given
        Hospital hospitalTest = getHospital();
        Patient savedPatient = getPatientTest(hospitalTest,"patient1");

        // when
        patientService.deletePatient(savedPatient.getId());
        Optional<Patient> deletedPatient = patientRepository.findById(savedPatient.getId());

        // then
        assertThat(deletedPatient.isPresent()).isFalse();

    }

    @Test
    void 환자_단일_조회() {
        // given
        Hospital hospitalTest = getHospital();
        Patient savedPatient = getPatientTest(hospitalTest,"patient1");
        // when
        PatientResponseDto.PatientDetailInfo patientInfo = patientService.findPatient(savedPatient.getId());
        // then
        assertThat(savedPatient.getName()).isEqualTo(patientInfo.getPatient_name());
        assertThat(savedPatient.getBirth()).isEqualTo(patientInfo.getPatient_birth());
        assertThat(savedPatient.getGenderCode().getCode()).isEqualTo(patientInfo.getPatient_gender_code());
        assertThat(savedPatient.getVisitList().size()).isEqualTo(patientInfo.getPatient_visit_info().size());
    }

    @Test
    void 환자_이름_조회() {
        // given
        Hospital hospitalTest = getHospital();
        Patient savedPatient1 = getPatientTest(hospitalTest,"patient1");
        Patient savedPatient2 = getPatientTest(hospitalTest,"patient1");
        Integer pageNo = 0;
        Integer pageSize = 10;
        String type = "이름";
        String value = "patient1";
        // when
        PatientResponseDto.PatientList allPatient = patientService.findAllPatient(hospitalTest.getId(),type,value,pageNo,pageSize);
        // then
        assertThat(allPatient.getPatientList().size()).isEqualTo(2);
        assertThat(allPatient.getPatientList().get(0).getPatient_name()).isEqualTo(savedPatient1.getName());
        assertThat(allPatient.getPatientList().get(1).getPatient_name()).isEqualTo(savedPatient2.getName());
    }
    @Test
    void 환자_등록번호_조회() {
        // given
        Hospital hospitalTest = getHospital();
        Patient savedPatient1 = getPatientTest(hospitalTest,"patient1");
        Integer pageNo = 0;
        Integer pageSize = 10;
        String type = "환자등록번호";
        String value = savedPatient1.getRegistrationNumber();
        // when
        PatientResponseDto.PatientList allPatient = patientService.findAllPatient(hospitalTest.getId(),type,value,pageNo,pageSize);
        // then
        assertThat(allPatient.getPatientList().size()).isEqualTo(1);
        assertThat(allPatient.getPatientList().get(0).getPatient_name()).isEqualTo(savedPatient1.getName());

    }
    @Test
    void 환자_생일_조회() {
        // given
        Hospital hospitalTest = getHospital();
        Patient savedPatient1 = getPatientTest(hospitalTest,"patient1");
        Integer pageNo = 0;
        Integer pageSize = 10;
        String type = "생년월일";
        String value = savedPatient1.getBirth();
        // when
        PatientResponseDto.PatientList allPatient = patientService.findAllPatient(hospitalTest.getId(),type,value,pageNo,pageSize);
        // then
        assertThat(allPatient.getPatientList().size()).isEqualTo(1);
        assertThat(allPatient.getPatientList().get(0).getPatient_name()).isEqualTo(savedPatient1.getName());

    }

    private Patient getPatientTest(Hospital hospitalTest,String name) {
        return patientRepository.save(Patient.builder()
                .name(name)
                .registrationNumber("test")
                .genderCode(GenderCode.FEMALE)
                .hospital(hospitalTest)
                .birth("1234")
                .build());
    }


    private PatientRequestDto.Create getPatient(Hospital hospitalTest) {
        return new PatientRequestDto.Create(hospitalTest.getId()
                ,"홍길동", GenderCode.FEMALE, "","");
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