package model.subject;

import java.util.Arrays;

public enum SubjectType {
    REQUIRED,
    OPTIONAL,
    NONE;

    public static SubjectType parse(String name){
        return Arrays.stream(SubjectType.values())
                .filter(type -> type.name().equals(name))
                .findFirst()
                .orElse(NONE);
    }
}
