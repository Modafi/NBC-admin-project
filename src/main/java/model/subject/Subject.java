package model.subject;

public class Subject {
    private final Long id;
    private final String name;
    private final SubjectType type;

    public Subject(Long id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = SubjectType.parse(type);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public SubjectType getType() {
        return type;
    }
}
