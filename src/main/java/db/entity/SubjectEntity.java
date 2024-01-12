package db.entity;

public class SubjectEntity {
    private final Long id;
    private final String name;
    private final String subjectType;

    public SubjectEntity(Long id, String name, String subjectType) {
        this.id = id;
        this.name = name;
        this.subjectType = subjectType;
    }
}
