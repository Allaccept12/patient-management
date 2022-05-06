package com.example.patientmanagement.patient.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPatient is a Querydsl query type for Patient
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPatient extends EntityPathBase<Patient> {

    private static final long serialVersionUID = 1347161659L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPatient patient = new QPatient("patient");

    public final com.example.patientmanagement.util.QBaseEntity _super = new com.example.patientmanagement.util.QBaseEntity(this);

    public final StringPath birth = createString("birth");

    //inherited
    public final DateTimePath<java.sql.Timestamp> created = _super.created;

    public final EnumPath<GenderCode> genderCode = createEnum("genderCode", GenderCode.class);

    public final com.example.patientmanagement.hospital.domain.QHospital hospital;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.sql.Timestamp> modified = _super.modified;

    public final StringPath name = createString("name");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final StringPath registrationNumber = createString("registrationNumber");

    public final ListPath<com.example.patientmanagement.visit.domain.Visit, com.example.patientmanagement.visit.domain.QVisit> visitList = this.<com.example.patientmanagement.visit.domain.Visit, com.example.patientmanagement.visit.domain.QVisit>createList("visitList", com.example.patientmanagement.visit.domain.Visit.class, com.example.patientmanagement.visit.domain.QVisit.class, PathInits.DIRECT2);

    public QPatient(String variable) {
        this(Patient.class, forVariable(variable), INITS);
    }

    public QPatient(Path<? extends Patient> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPatient(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPatient(PathMetadata metadata, PathInits inits) {
        this(Patient.class, metadata, inits);
    }

    public QPatient(Class<? extends Patient> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.hospital = inits.isInitialized("hospital") ? new com.example.patientmanagement.hospital.domain.QHospital(forProperty("hospital")) : null;
    }

}

