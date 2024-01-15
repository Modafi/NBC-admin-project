package db.entity;

import model.subject.Subject;

import java.util.List;

public class StudentEntity {
    private final Long id;
    private final String name;
    private final List<Subject> subjectList;

    public StudentEntity(Long id, String name, List<Subject> subjectList) {
        this.id = id;
        this.name = name;
        this.subjectList = subjectList;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }
}
