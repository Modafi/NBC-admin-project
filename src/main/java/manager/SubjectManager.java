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
        return dao.getList();
    }

    /*
    public void deleteSubject(Long id){
        dao.deleteById(id);
    }
     */
}
