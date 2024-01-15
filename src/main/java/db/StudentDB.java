package db;

import db.dto.StudentDTO;
import db.entity.StudentEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDB {
    private static final Map<Long, StudentEntity> store = new HashMap<>();
    private long sequence = 1L;

    public StudentEntity save(StudentDTO dto){
        StudentEntity studentEntity = new StudentEntity(sequence++, dto.getName(), dto.getSubjectList());
        store.put(studentEntity.getId(), studentEntity);
        return studentEntity;
    }

    public StudentEntity getById(Long id){
        return store.get(id);
    }

    public List<StudentEntity> getStudents(){
        return new ArrayList<>(store.values());
    }

    public void deleteById(Long id){
        store.remove(id);
    }
}
