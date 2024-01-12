package db.entity;

import model.classreporty.Grade;
import model.subject.SubjectType;

public class ClassReportEntity {
    private final Long id;
    private final Long studentId;
    private final Long subjectId;
    private final String subjectType;
    private final Integer score;
    private final String grade;
    private final long round;

    public ClassReportEntity(Long id,
                       Long studentId,
                       Long subjectId,
                       String subjectType,
                       Integer score,
                       String grade,
                       long round) {
        this.id = id;
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.subjectType = subjectType;
        this.score = score;
        this.grade = grade;
        this.round = round;
    }

    public Long getId() {
        return id;
    }

    public String getGrade() {
        return grade;
    }

    public Integer getScore() {
        return score;
    }

    public long getRound() {
        return round;
    }

    public Long getStudentId() {
        return studentId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public String getSubjectType() {
        return subjectType;
    }
}
