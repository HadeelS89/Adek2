package com.qpros.model.enums;

public enum RequestType {
    ReimbursementRequest(1),
    NationalService(2),
    ToWhomItMayConcern(3),
    DropAClass(4),
    ChangeBankDetails(5),
    Maternity(6),
    Chaperone(7),
    SuspendStudies(8),
    RegisterInternshipProgram(9),
    InternshipChange(10),
    MedicalClaimRequest(11),
    StudyACourse(12),
    CancelDiscontinueScholarship(13),
    ExtendPeriodOfStudy(14),
    ExtendEmployeeStudyLeave(15),
    Preliminarie(16);

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    RequestType(int id) {
        this.id = id;
    }

    RequestType() {
    }
}
