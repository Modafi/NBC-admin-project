package db.dto;

import model.subject.Subject;

import java.util.List;

public class StudentDTO {
    private final String name;
    private final List<Subject> subjectList;

    public StudentDTO(String name, List<Subject> subjectList) {
        this.name = name;
        this.subjectList = subjectList;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }
}
