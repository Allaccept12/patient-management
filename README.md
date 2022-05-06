
# patient-management program 

<br>

## 1. 프로젝트 소개<br/>
> 병원 관리 프로그램 -> 병원을 등록해서 해당 병원에 등록된 환자들을 관리할 수 있고, 환자의 접수를 도와줄 수 있습니다.<br/>

<br>

## 2. 기술 스택
**`Back-end`**
- Java 11 
- SpringBoot - 2.6.7
- Gradle - 7.4.1
- JPA
- Spring Data Jpa
- QueryDSL
- h2

<br>

## 3. 기능
- 병원 등록 : 관리할 병원을 등록할 수 있습니다.
- 환자 등록 : 환자 신규 등록을 할 수 있습니다.
- 환자 정보 수정 : 환자의 정보를 수정 할 수 있습니다.
- 환자 정보 삭제 : 환자 정보를 삭제 할 수 있습니다.
- 환자 단건 조회 : 환자ID값으로 환자 상세정보를 조회할 수 있습니다.
- 환자 검색 : 원하는 환자정보로 환자를 찾을수 있습니다.
- 환자 접수 : 환자가 원하는 진료를 선택하여 접수 할 수 있습니다.

<br>

## API

| 기능       |     메서드 |            URI             | REQUEST | RESPONSE |
|:---------|--------:|:--------------------------:|---------|----------|
| 병원 등록     |    POST |       /api/hospitals        |         |          |
| 환자 등록      |    POST |         /api/patients         |         |          |
| 환자 정보 수정 |     PATCH |         api/patients/{patientId}          |         |          |
| 환자 정보 삭제   |    DELETE |         /api/patients/{patientId}         |         |          |
| 환자 단건 조회   |     GET |    /api/patients/{patientId}    |         |          |
| 환자 검색   |  GET |    /api/patientId/{hospitalId}/all?type&value&pageNo&pageSize    |         |          |
| 환자 접수      |    POST | /api/visits  |         |          |








