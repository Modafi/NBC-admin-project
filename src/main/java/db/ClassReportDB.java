package db;

import db.dto.ClassReportDTO;
import db.entity.ClassReportEntity;

import java.util.*;

public class ClassReportDB {
    private Map<Long, ClassReportEntity> store = new HashMap<>();
    private long sequance = 1L;

    public ClassReportEntity save(ClassReportDTO dto) {
        ClassReportEntity classReportEntity = new ClassReportEntity(
                sequance++,
                dto.getStudentId(),
                dto.getSubjectId(),
                dto.getSubjectType().name(),
                dto.getScore(),
                dto.getRound()
        );

        store.put(classReportEntity.getId(), classReportEntity);
        return classReportEntity;
    }

    public ClassReportEntity getById(Long id){
        return store.get(id);
    }

    public List<ClassReportEntity> getCourses(){
        return new ArrayList<>(store.values());
    }

    public void deleteById(Long id){
        store.remove(id);
    }

    public void updateById(ClassReportDTO dto){
        Optional<ClassReportEntity> entityOptional =
                getByStudentAndSubject(dto.getStudentId(), dto.getSubjectId(), dto.getRound());

        if(entityOptional.isEmpty()){
            throw new IllegalArgumentException();
        }

        ClassReportEntity originClassReportEntity = entityOptional.get();
        ClassReportEntity newClassReportEntity = new ClassReportEntity(
                originClassReportEntity.getId(),
                originClassReportEntity.getStudentId(),
                originClassReportEntity.getSubjectId(),
                originClassReportEntity.getSubjectType(),
                dto.getScore(),
                dto.getRound()
        );

        store.put(originClassReportEntity.getId(), newClassReportEntity);
    }

    private Optional<ClassReportEntity> getByStudentAndSubject(Long studentId, Long subjectId, long round) {
        return store.values().stream().filter(entity
                        -> Objects.equals(entity.getSubjectId(), subjectId)
                        && Objects.equals(entity.getStudentId(), studentId)
                        && Objects.equals(entity.getRound(), round)
                )
                .findFirst();
    }

    public List<ClassReportEntity> getReports(Long studentId, Long subjectId){
        return store.values().stream().filter(entity
                -> Objects.equals(entity.getStudentId(), studentId)
                && Objects.equals(entity.getSubjectId(), subjectId)
                ).toList();
    }
}
