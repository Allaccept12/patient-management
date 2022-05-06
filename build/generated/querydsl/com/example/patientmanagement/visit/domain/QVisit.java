package com.example.patientmanagement.visit.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QVisit is a Querydsl query type for Visit
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QVisit extends EntityPathBase<Visit> {

    private static final long serialVersionUID = 1505945403L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QVisit visit = new QVisit("visit");

    public final com.example.patientmanagement.util.QBaseEntity _super = new com.example.patientmanagement.util.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.sql.Timestamp> created = _super.created;

    public final com.example.patientmanagement.hospital.domain.QHospital hospital;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.sql.Timestamp> modified = _super.modified;

    public final com.example.patientmanagement.patient.domain.QPatient patient;

    public final EnumPath<TreatmentSubjectCode> treatmentSubjectCode = createEnum("treatmentSubjectCode", TreatmentSubjectCode.class);

    public final EnumPath<TreatmentTypeCode> treatmentTypeCode = createEnum("treatmentTypeCode", TreatmentTypeCode.class);

    public final EnumPath<VisitStatusCode> visitStatusCode = createEnum("visitStatusCode", VisitStatusCode.class);

    public QVisit(String variable) {
        this(Visit.class, forVariable(variable), INITS);
    }

    public QVisit(Path<? extends Visit> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QVisit(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QVisit(PathMetadata metadata, PathInits inits) {
        this(Visit.class, metadata, inits);
    }

    public QVisit(Class<? extends Visit> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.hospital = inits.isInitialized("hospital") ? new com.example.patientmanagement.hospital.domain.QHospital(forProperty("hospital")) : null;
        this.patient = inits.isInitialized("patient") ? new com.example.patientmanagement.patient.domain.QPatient(forProperty("patient"), inits.get("patient")) : null;
    }

}

