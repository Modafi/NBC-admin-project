package model.student;

import model.subject.Subject;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private final Long id;
    private final String name;
    private List<Subject> subjectList = new ArrayList<>();

    public List<Subject> getSubjectList() {
        return subjectList;
    }


    public Student(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(Long id, String name, List<Subject> subjectList) {
        this.id = id;
        this.name = name;
        this.subjectList = subjectList;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}
