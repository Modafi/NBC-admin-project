package db.dto;

public class SubjectDTO {
    private final String name;
    private final String subjectType;

    public SubjectDTO(String name, String subjectType) {
        this.name = name;
        this.subjectType = subjectType;
    }

    public String getName() {
        return name;
    }

    public String getSubjectType() {
        return subjectType;
    }
}
