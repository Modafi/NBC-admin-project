package UIManage;

import db.entity.ClassReportEntity;
import model.student.Student;
import model.subject.Subject;

import java.util.List;

public class UIManager {
    private static final View view = new View();

    /*


    메뉴 모음 입니다.


     */

    public  int getMenuOptions() {
        view.showMainMenu();
        view.orderToTypeOptionNumber();

        int inputNum = InputReader.getOptionNumber(3);
        return inputNum;
    }

    public  int getStudentOptions(){
        view.showStudentMenu();
        view.orderToTypeOptionNumber();

        return InputReader.getOptionNumber(3);
    }

    public  int getScoreOptions(){
        view.showScoreMenu();
        view.orderToTypeOptionNumber();

        return InputReader.getOptionNumber(4);
    }
    public  boolean getFinishOptions() {
        view.showAdditionalCheck();

        return !InputReader.getBoolean();
    }
    /*


    student 메뉴 모음 입니다.


     */
    public  String getNewStudentName(){
        view.showAddStudentMenu();
        String studentName = InputReader.getName();
        return studentName;
    }

    public  String getSubjectNameForAdd() {
        view.orderToTypeNewStudentSubject();
        String subjectName = InputReader.getName();
        return subjectName;
    }

    public boolean askContinue() {
        view.AskContinue();
        boolean oneIsTrue = InputReader.getBoolean();
        return oneIsTrue;
    }

    public  String getSubjectNameForAddValid() {
        view.showNotValidSubject();
        view.orderToTypeNewStudentSubject();
        String subjectName = InputReader.getName();
        return subjectName;
    }

    public  void showStudentsAddIsOver() {
        view.showAddIsComplete();
    }

    public  void showStudentsList(List<Student> studentsList){
        view.showStudentListHeader();

        for(Student student : studentsList){
            view.showStudentInformation(student.getId(), student.getName());
        }

        view.showListIsFinish();
    }

    /*


     scoreManager 가 관련되었습니다.


     */

    public  Long getStudentId(){
        view.orderToTypeStudentId();
        return InputReader.getStudentId();
    }
    public  Long getStudentIdValid(){
        view.showNotValidStudentId();
        return InputReader.getStudentId();
    }

    public  String getSubjectName(Student student){

        view.orderToTypeSubject();
        return InputReader.getName();
    }

    public int getScoreIdx(){
        view.orderToTypeScoreIdx();
        return InputReader.getScoreIdx();
    }

    public  Integer getScoreEdit(int ScoreIdx){
        view.orderToTypeScore(ScoreIdx);
        return InputReader.getScore();
    }

    public  void showScoreIsFull(String subjectName) {
        view.showScoreIsFull(subjectName);
    }

    public void showSubjectNotValidInList() {
        view.showNotValidSubject();
    }

    public void showScoreList(List<ClassReportEntity> classreports) {
        view.showScoreHeader();

        for(ClassReportEntity report: classreports){
            view.showReport(report);
        }

    }

    public void showNotValidStudent() {
        view.showNotValidStudentId();
    }

    public void showStudentsSubject(Student student) {
        view.showStudentEditHeader(student.getName());
        for(Subject subject : student.getSubjectList()){
            view.showSubject(subject.getName());
        }

    }

    public void showNotValidSubject() {
        view.showNotValidSubject();
    }
}