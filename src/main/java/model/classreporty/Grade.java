package model.classreporty;

import model.subject.SubjectType;

import static model.subject.SubjectType.REQUIRED;

public enum Grade {
    A,
    B,
    C,
    D,
    F,
    N;

    public static Grade getGrade(SubjectType subjectType, Integer score){
        if(subjectType.equals(REQUIRED)){
            return calcRequiredSubjectGrade(score);
        }

        return calcOptionalSubjectGrade(score);
    }

    private static Grade calcRequiredSubjectGrade(Integer score) {
        if(score >= 95)
            return A;
        else if(score >= 90)
            return B;
        else if(score >= 80)
            return C;
        else if(score >= 70)
            return D;
        else if(score >= 60)
            return F;
        else
            return N;

    }

    private static Grade calcOptionalSubjectGrade(Integer score) {
        if(score >= 90)
            return A;
        else if(score >= 80)
            return B;
        else if(score >= 70)
            return C;
        else if(score >= 60)
            return D;
        else if(score >= 50)
            return F;
        else
            return N;
    }
}
