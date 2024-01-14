package manager;

import db.dao.DAO;
import db.dto.StudentDTO;
import model.student.Student;
import model.subject.Subject;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private final DAO<StudentDTO, Student> dao;
    private final List<Student> students = new ArrayList<>();

    public StudentManager(DAO<StudentDTO, Student> dao) {
        this.dao = dao;
    }

    public void addUser(String name, List<Subject> inputSubjectList){
        Student student = new Student(1L, name, inputSubjectList);
        students.add(student);
//        dao.save(new StudentDTO(name));
    }

    public List<Student> getAllUser(){
        return students;
//        return dao.getList();
    }

    public Student getByStudent(Long id){
        return dao.getByID(id);
    }
//
//    public boolean isValidSubject(String subjectName) {
//    }
//
//    public Subject getSubject(String subjectName) {
//    }

    /*
    public void deleteStudent(Long id){
        dao.deleteById(id);
    }
     */

}
