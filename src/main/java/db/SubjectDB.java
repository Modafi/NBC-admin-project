package db;

import db.dto.SubjectDTO;
import db.entity.SubjectEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubjectDB {
    private Map<Long, SubjectEntity> store = new HashMap<>();
    private Long sequance = 1L;

    public SubjectDB(){
        initData();
    }

    private void initData() {
        // Required
        save(new SubjectDTO("자바", "REQUIRED"));
        save(new SubjectDTO("파이썬", "REQUIRED"));
        save(new SubjectDTO("자바스크립트", "REQUIRED"));
        save(new SubjectDTO("장고", "REQUIRED"));
        save(new SubjectDTO("스프링", "REQUIRED"));
        save(new SubjectDTO("Next.js", "REQUIRED"));

        // Optional
        save(new SubjectDTO("레디스", "OPTIONAL"));
        save(new SubjectDTO("카프카", "OPTIONAL"));
        save(new SubjectDTO("오픈텔레메트리", "OPTIONAL"));
        save(new SubjectDTO("도커", "OPTIONAL"));
        save(new SubjectDTO("쿠버네티스", "OPTIONAL"));
    }

    public SubjectEntity save(SubjectDTO dto){
        SubjectEntity subjectEntity = new SubjectEntity(
                sequance++,
                dto.getName(),
                dto.getSubjectType());
        store.put(subjectEntity.getId(), subjectEntity);

        return subjectEntity;
    }

    public SubjectEntity getById(Long id){
        return store.get(id);
    }

    public List<SubjectEntity> getSubjects(){
        return new ArrayList<>(store.values());
    }

    public void deleteById(Long id){
        store.remove(id);
    }
}
