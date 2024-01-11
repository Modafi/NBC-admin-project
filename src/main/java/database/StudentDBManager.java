package database;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StudentDBManager{
    private static List<Student> studentList = new LinkedList<>();
    Map<String, Integer> map = new HashMap<>();

    public void save(Student student){
        studentList.add(student);
    }

    public List<Student> findAll(){
        return studentList;
    }
}
