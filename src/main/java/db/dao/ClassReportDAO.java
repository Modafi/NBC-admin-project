package db.dao;

import db.ClassReportDB;
import db.dto.ClassReportDTO;
import db.entity.ClassReportEntity;
import model.classreporty.ClassReport;
import model.subject.SubjectType;

import java.util.List;

public class ClassReportDAO implements DAO<ClassReportDTO, ClassReport> {
    private final ClassReportDB classReportDB;

    public ClassReportDAO(ClassReportDB classReportDB) {
        this.classReportDB = classReportDB;
    }

    @Override
    public ClassReport save(ClassReportDTO dto) {
        ClassReportEntity entity = classReportDB.save(dto);

        return new ClassReport(
                entity.getId(),
                entity.getStudentId(),
                entity.getSubjectId(),
                SubjectType.parse(entity.getSubjectType()),
                entity.getScore(),
                entity.getRound()
        );
    }

    @Override
    public ClassReport getByID(Long id) {
        ClassReportEntity entity = classReportDB.getById(id);
        return new ClassReport(
                entity.getId(),
                entity.getStudentId(),
                entity.getSubjectId(),
                SubjectType.parse(entity.getSubjectType()),
                entity.getScore(),
                entity.getRound()
        );
    }

    @Override
    public List<ClassReport> getList() {
        return classReportDB.getCourses().stream()
                .map(entity -> new ClassReport(
                        entity.getId(),
                        entity.getStudentId(),
                        entity.getSubjectId(),
                        SubjectType.parse(entity.getSubjectType()),
                        entity.getScore(),
                        entity.getRound()
                ))
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        classReportDB.deleteById(id);
    }

    public void updateScore(ClassReportDTO dto){
        classReportDB.updateById(dto);
    }

    public List<ClassReportEntity> getReportsBySession(ClassReportDTO dto){
        return classReportDB.getReports(dto.getStudentId(), dto.getSubjectId());
    }
}
