package db;

import db.dto.StudentDTO;
import db.entity.StudentEntity;

import java.util.*;

public class StudentDB {
    private static final Map<Long, StudentEntity> store = new HashMap<>();
    private long sequence = 1L;

    public StudentEntity save(StudentDTO dto){
        StudentEntity studentEntity = new StudentEntity(sequence++, dto.getName(), dto.getSubjectList());
        store.put(studentEntity.getId(), studentEntity);
        return studentEntity;
    }

    public Optional<StudentEntity> getById(Long id){
        Optional<StudentEntity> studentEntity = Optional.ofNullable(store.get(id));
        return studentEntity;
    }

    public List<StudentEntity> getStudents(){
        return new ArrayList<>(store.values());
    }

    public void deleteById(Long id){
        store.remove(id);
    }
}
