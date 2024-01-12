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

    public StudentDB(){
        initData();
    }

    private void initData() {
        save(new StudentDTO("메타몽"));
        save(new StudentDTO("모다피"));
        save(new StudentDTO("리자몽"));
        save(new StudentDTO("찌리리공"));
        save(new StudentDTO("팸텀"));
    }

    public StudentEntity save(StudentDTO dto){
        StudentEntity studentEntity = new StudentEntity(sequence++, dto.getName());
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
