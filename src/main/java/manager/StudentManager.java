package manager;

import db.dao.DAO;
import db.dto.StudentDTO;
import model.student.Student;

import java.util.List;

public class StudentManager {
    private final DAO<StudentDTO, Student> dao;

    public StudentManager(DAO<StudentDTO, Student> dao) {
        this.dao = dao;
    }

    public void addUser(String name){
        dao.save(new StudentDTO(name));
    }

    public List<Student> getAllUser(){
        return dao.getList();
    }

    public Student getByStudent(Long id){
        return dao.getByID(id);
    }

    /*
    public void deleteStudent(Long id){
        dao.deleteById(id);
    }
     */

}
