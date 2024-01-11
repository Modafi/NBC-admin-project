package database;

public class Test {
    public static void main(String args[]){
        Score score = new Score("ab", "lee");
        Grade grade = new Grade("A");

        ScoreDBManager SDB = new ScoreDBManager();
        SDB.save(1, score);
        System.out.println(SDB);
    }
}
class Score{
    String id;
    String name;

    public Score(String id, String name){
        this.id = id;
        this.name = name;
    }
}
class Grade{
    String grade;

    public Grade(String grade){
        this.grade = grade;
    }
}

class Student{
    String id;
    String name;

    public Student(String id, String name){
        this.id = id;
        this.name = name;
    }
}

class StudentManagaegag{

    Student student = new Student();
    StudentDBManager studentDBManager;

    public StudentManagaegag(StudentDBManager studentDBManager) {
        this.studentDBManager = studentDBManager;
    }

    void join(){
        studentDBManager.save(student);
    }
}
class Subject{
    String subject;
    String
}