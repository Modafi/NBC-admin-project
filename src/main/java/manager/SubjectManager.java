package manager;

import db.dao.DAO;
import db.dao.SubjectDAO;
import db.dto.SubjectDTO;
import model.subject.Subject;

import java.util.ArrayList;
import java.util.List;

public class SubjectManager {
    private final DAO<SubjectDTO, Subject> dao;

    public SubjectManager(DAO<SubjectDTO, Subject> dao) {
        this.dao = dao;
    }

    public void addSubject(String name, String type){
        dao.save(new SubjectDTO(name, type));
    }

    public Subject getBySubject(Long id){
        return dao.getByID(id);
    }

    public List<Subject> getAllSubject(){
        //이거는 나중에 삭제 하고, 데이터 베이스 에 가져 올 수 있게
        List<Subject> subjectList  = new ArrayList<>();

        subjectList.add(new Subject(1L,"자바", "REQUIRED"));
        subjectList.add(new Subject(1L,"파이썬", "REQUIRED"));
        subjectList.add(new Subject(1L,"자바스크립트", "REQUIRED"));
        subjectList.add(new Subject(1L,"장고", "REQUIRED"));
        subjectList.add(new Subject(1L,"스프링", "REQUIRED"));
        subjectList.add(new Subject(1L,"Next.js", "REQUIRED"));

        // Optional
        subjectList.add(new Subject(1L,"레디스", "OPTIONAL"));
        subjectList.add(new Subject(1L,"카프카", "OPTIONAL"));
        subjectList.add(new Subject(1L,"오픈텔레메트리", "OPTIONAL"));
        subjectList.add(new Subject(1L,"도커", "OPTIONAL"));
        subjectList.add(new Subject(1L,"쿠버네티스", "OPTIONAL"));

        return subjectList;
//        return dao.getList();
    }

    /*
    public void deleteSubject(Long id){
        dao.deleteById(id);
    }
     */
}
