package db.dao;

import model.student.Student;
import db.StudentDB;
import db.dto.StudentDTO;
import db.entity.StudentEntity;

import java.util.List;
import java.util.Optional;

public class StudentDAO implements DAO<StudentDTO, Student>{
    private final StudentDB studentDB;

    public StudentDAO(StudentDB studentDB) {
        this.studentDB = studentDB;
    }

    @Override
    public Student save(StudentDTO dto){
        StudentEntity entity = studentDB.save(dto);
        return new Student(entity.getId(), entity.getName(), entity.getSubjectList());
    }

    @Override
    public Student getByID(Long id){
        Optional<StudentEntity> entity = studentDB.getById(id);

        if(entity.isEmpty()){
            return null;
        }

        StudentEntity studentEntity = entity.get();
        return new Student(studentEntity.getId(), studentEntity.getName(), studentEntity.getSubjectList());
    }

    @Override
    public List<Student> getList(){
        return studentDB.getStudents().stream()
                .map(entity ->
                        new Student(entity.getId(), entity.getName()))
                .toList();
    }

    @Override
    public void deleteById(Long id){
        studentDB.deleteById(id);
    }

}
