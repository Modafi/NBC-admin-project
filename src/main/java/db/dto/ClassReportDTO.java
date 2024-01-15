package db.dto;

import model.classreporty.Grade;
import model.subject.SubjectType;

public class ClassReportDTO {
    private final Long studentId;
    private final Long subjectId;
    private final SubjectType type;
    private final Integer score;
    private final long round;

    public ClassReportDTO(Long studentId,
                          Long subjectId,
                          SubjectType type,
                          Integer score,
                          long round) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.type = type;
        this.score = score;
        this.round = round;
    }

    public Long getStudentId() {
        return studentId;
    }

    public Integer getScore() {
        return score;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public long getRound() {
        return round;
    }

    public SubjectType getSubjectType() {
        return type;
    }
}
