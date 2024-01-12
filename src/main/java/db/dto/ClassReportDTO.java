package db.dto;

import model.classreporty.Grade;
import model.subject.SubjectType;

public class ClassReportDTO {
    private final Long studentId;
    private final Long subjectId;
    private final SubjectType subjectType;
    private final Integer score;
    private final Grade grade;
    private final long round;

    public ClassReportDTO(Long studentId,
                          Long subjectId,
                          SubjectType subjectType,
                          Integer score,
                          Grade grade,
                          long round) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.subjectType = subjectType;
        this.score = score;
        this.grade = grade;
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

    public Grade getGrade() {
        return grade;
    }

    public long getRound() {
        return round;
    }

    public SubjectType getSubjectType() {
        return subjectType;
    }
}
