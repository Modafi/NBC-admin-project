package manager;

import db.dao.ClassReportDAO;
import db.dao.DAO;
import db.dto.ClassReportDTO;
import db.entity.ClassReportEntity;
import model.classreporty.ClassReport;
import model.classreporty.Grade;
import model.subject.SubjectType;

import java.util.ArrayList;
import java.util.List;

public class ClassReportManager {
    private final ClassReportDAO dao;

    public ClassReportManager(ClassReportDAO dao) {
        this.dao = dao;
    }

//    public void addClassReport(Long studentId, Long subjectId, SubjectType subjectType, Integer score, Grade grade, long round){
//        dao.save(new ClassReportDTO(studentId, subjectId, subjectType, score, grade, round));
//    }

    public void addClassReport(Long studentId, Long subjectId, SubjectType subjectType, Double score, long round){
//        dao.save(new ClassReportDTO(studentId, subjectId, subjectType, score, grade, round));
    }

    public ClassReport getClassReport(Long id){
        return dao.getByID(id);
    }

    public List<ClassReport> getAllClassReport(){
        return dao.getList();
    }

    public void deleteClassReport(Long id){
        dao.deleteById(id);
    }

//    public void updateScore(Long studentId, Long subjectId, SubjectType subjectType, Integer score, Grade grade, long round){
//        dao.updateScore(new ClassReportDTO(studentId, subjectId, subjectType, score, grade, round));
//    }

    public void updateScore(Long studentId, Long subjectId, SubjectType subjectType, Double score, long round){
//        dao.updateScore(new ClassReportDTO(studentId, subjectId, subjectType, score, grade, round));
    }

//    public List<ClassReportEntity> getReportBySession(Long studentId, Long subjectId, SubjectType subjectType, Integer score, Grade grade, long round){
//        return dao.getReportsBySession(new ClassReportDTO(studentId, subjectId, subjectType, score, grade, round));
//    }

    public List<ClassReportEntity> getReportBySession(Long studentId, Long subjectId, SubjectType subjectType){
//        return dao.getReportsBySession(new ClassReportDTO(studentId, subjectId, subjectType, score, grade, round));
        List<ClassReportEntity> lists = new ArrayList<>()
;        return lists;
    }
}
