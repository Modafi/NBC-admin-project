package db.dao;

import db.StudentDB;
import db.SubjectDB;
import db.dto.StudentDTO;
import db.dto.SubjectDTO;
import db.entity.SubjectEntity;
import model.subject.Subject;

import java.util.List;

public class SubjectDAO implements DAO<SubjectDTO, Subject> {
    private final SubjectDB subjectDB;

    public SubjectDAO(StudentDB studentDB) {
        this.subjectDB = new SubjectDB();
    }


    @Override
    public Subject save(SubjectDTO dto) {
        SubjectEntity entity = subjectDB.save(dto);
        return new Subject(entity.getId(), entity.getName(), entity.getSubjectType());
    }

    @Override
    public Subject getByID(Long id) {
        SubjectEntity entity = subjectDB.getById(id);
        return new Subject(entity.getId(), entity.getName(), entity.getSubjectType());
    }

    @Override
    public List<Subject> getList() {
        return subjectDB.getSubjects().stream()
                .map(entity ->
                        new Subject(entity.getId(), entity.getName(), entity.getSubjectType()))
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        subjectDB.deleteById(id);
    }
}
