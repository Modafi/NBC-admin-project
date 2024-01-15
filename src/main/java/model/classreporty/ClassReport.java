package model.classreporty;

import model.subject.SubjectType;

public class ClassReport {
    private final Long id;
    private final Long studentId;
    private final Long subjectId;
    private final SubjectType type;
    private final Integer score;
    private final Grade grade;
    private final long round;

    public ClassReport(Long id,
                       Long studentId,
                       Long subjectId,
                       SubjectType type,
                       Integer score,
                       long round) {
        this.id = id;
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.type = type;
        this.score = score;
        this.grade = Grade.getGrade(type, score);
        this.round = round;
    }

    public Long getId() {
        return id;
    }

    public Grade getGrade() {
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

    public SubjectType getType() {
        return type;
    }
}
