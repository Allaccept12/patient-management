
# patient-management program 

<br>

## 1. 프로젝트 소개<br/>
> 병원 관리 프로그램<br/>

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

## API

| 기능       |     메서드 |            URI             | REQUEST | RESPONSE |
|:---------|--------:|:--------------------------:|---------|----------|
| 병원등록     |    POST |       /api/hospitals        |         |          |
| 환자등록      |    POST |         /api/patients         |         |          |
| 환자정보수정 |     PATCH |         api/patients/{patientId}          |         |          |
| 환자정보삭제   |    DELETE |         /api/patients/{patientId}         |         |          |
| 환자 단건 조회   |     GET |    /api/patients/{patientId}    |         |          |
| 환자 검색   |  GET |    /api/patientId/{hospitalId}/all?type&value&pageNo&pageSize    |         |          |
| 환자 접수      |    POST | /api/visits  |         |          |








