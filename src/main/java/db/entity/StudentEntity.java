package db.entity;

public class StudentEntity {
    private final Long id;
    private final String name;

    public StudentEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
