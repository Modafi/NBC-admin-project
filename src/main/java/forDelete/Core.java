package forDelete;

import Management.ScoreManagement;
import Management.StudentManagement;
import UIManager.ViewManager;
import model.Score;
import model.Student;
import model.Subject;

import java.util.ArrayList;

public class Core {
    private static Boolean flag = true;
    private static StudentManagement studentManager;
    private static ScoreManagement scoreManager;


    /*


    스위치 문 모음 입니다.


     */
    public void on() {

        while(flag){

            switch (ViewManager.getMenuOptions()){
                case 1:
                    studentOption();
                    break;
                case 2:
                    scoreOption();
                    break;
                case 3:
                    finishOption();
                    break;
            }

        }

    }

    private void studentOption() {

        switch (ViewManager.getStudentOptions()){
            case 1:
                addStudent();
                break;
            case 2:
                showStudentList();
                break;
        }

    }

    private void scoreOption() {

        switch (ViewManager.getScoreOptions()){
            case 1:
                addScore();
                break;
            case 2:
                editScore();
                break;
            case 3:
                showScore();
                break;
        }

    }

    private void finishOption() {
        flag = ViewManager.getFinishOptions();
    }

    /*


    studentManager 관련 메소드 입니다.


     */

    private void addStudent() {
        String studentName = ViewManager.getNewStudentName();

        ArrayList<Subject> subjectList = getSubjectList();

        //새로운 학생의 이름과 과목 리스트 를 리턴 하면 받아서 데이터 베이스 에 넣는 메소드
        studentManager.newStudent(studentName, subjectList);

        ViewManager.showStudentsAddIsOver();
    }

    private ArrayList<Subject> getSubjectList() {
        ArrayList<Subject> subjectList = new ArrayList<>();

        Subject subject = getSubject();

        subjectList.add(subject);

        //studentManager 은 subjectList 가 유효 하지 않을 경우( 필수 과목 , 선택 과목 ),
        //false 를 반환 => ! 때문에 반복
        while(!studentManager.isValidSubjectList(subjectList)){
            subject = getSubject();
            subjectList.add(subject);
        }

        return subjectList;
    }

    private Subject getSubject() {
        String subjectName = ViewManager.getSubjectNameForAdd();

        Subject subject;

        //studentManager.isValidSubject(subjectName)은
        //사용자에게 입력받은 과목명이 데이터베이스에 존재하는 과목명으로 유효한지 체크합니다.

        //유효하지 않을경우
        while(!studentManager.isValidSubject(subjectName)){
            subjectName = ViewManager.getSubjectNameForAddValid();
        }

        //유효할 경우, 과목명이 같은 과목 자체를 가져옵니다.
        subject = studentManager.getSubject(subjectName);

        return subject;
    }

    private void showStudentList() {
        ArrayList<Student> students = studentManager.getStudentList();
        ViewManager.showStudentsList(students);
    }

    /*


     scoreManager 가 관련되었습니다.


     */

    private void addScore() {

        //id를 통해 student 객체를 받음
        Student student = getStudentById();

        //이 학생의 어떤 과목을 받고 싶은지 받아오기
        Subject subject = getSubjectInStudent(student);


        //해당 학생, 해당 과목의 시험이 몇회차까지 있는지 확인하는 메소드 구현하기
        int idx = 0;

        for(int i=0; i<subject.getScoreList().length; i++){
            Score score = subject.getScoreList()[i];

            if(score.getValue()==-1){
                idx = i;
                break;
            }

        }

        if(idx==9){
            ViewManager.showScoreIsFull(subject.getName());
        }else{
            subject.getScoreList()[idx].setValue(ViewManager.getScoreEdit(idx))
            scoreManager.editStudet(student, subject);
        }

    }

    private void editScore() {
        //id를 통해 student 객체를 받음
        Student student = getStudentById();

        //이 학생의 어떤 과목을 받고 싶은지 받아오기
        Subject subject = getSubjectInStudent(student);

        int idx = ViewManager.getScoreEdit(subject);
        subject.getScoreList()[idx].setValue(ViewManager.getScoreEdit(idx));

        scoreManager.editStudet(student, subject);
    }

    private void showScore() {
        //id를 통해 student 객체를 받음
        Student student = getStudentById();

        //이 학생의 어떤 과목을 받고 싶은지 받아오기
        Subject subject = getSubjectInStudent(student);

        ViewManager.showScoreList(subject);
    }

    private Student getStudentById() {

        //user 에게 점수를 등록할 학생의 id 를 입력 받는다.
        Long StudentId = ViewManager.getStudentId();

        //studentId가 유효 한지 확인 하기
        while (!scoreManager.isValidStudentId(StudentId)) {
            StudentId = ViewManager.getStudentIdValid();
        }

        //id를 통해 학생 객체 받아 오기
        Student student = scoreManager.getStudenById(StudentId);

        return student;
    }

    private Subject getSubjectInStudent(Student student) {
        String subjectName = ViewManager.getSubjectName(student);
        Subject subject = null;

        while(scoreManager.doStudentHaveSubject(student, subjectName)){
            subjectName = ViewManager.getSubjectNameForAddValid();
        }

        //student 객체가 가진 subjectList 에서 subject name 이 같은 과목을 빼내기
        ArrayList<Subject> temp = student.getSubjectList();

        for(Subject sj : temp){
            if(sj.getName().equals(subjectName)){
                subject = sj;
            }
        }

        return subject;
    }

}
