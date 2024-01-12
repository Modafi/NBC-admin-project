package UIManager;

import model.Score;
import model.Student;
import model.Subject;

import java.util.ArrayList;

public class ViewManager {
    private static final View view = new View();

    /*


    메뉴 모음 입니다.


     */

    public static int getMenuOptions() {
        view.showMainMenu();
        view.orderToTypeOptionNumber();

        return InputReader.gerOptionNumber(3);
    }

    public static int getStudentOptions(){
        view.showStudentMenu();
        view.orderToTypeOptionNumber();

        return InputReader.gerOptionNumber(3);
    }

    public static int getScoreOptions(){
        view.showScoreMenu();
        view.orderToTypeOptionNumber();

        return InputReader.gerOptionNumber(4);
    }
    public static boolean getFinishOptions() {
        view.showAdditionalCheck();

        return !InputReader.getBoolean();
    }
    /*


    student 메뉴 모음 입니다.


     */
    public static String getNewStudentName(){
        view.showAddStudentMenu();
        String studentName = InputReader.getStudentName();
        return studentName;
    }

    public static String getSubjectNameForAdd() {
        view.orderToTypeNewStudentSubject();
        String subjectName = InputReader.getSubjectName();
        return subjectName;
    }

    public static String getSubjectNameForAddValid() {
        view.showNotValidSubject();
        String subjectName = InputReader.getSubjectName();
        return subjectName;
    }

    public static void showStudentsAddIsOver() {
        view.showAddIsComplete();
    }

    public static void showStudentsList(ArrayList<Student> studentsList){
        view.showStudentListHeader();

        for(Student student : studentsList){
            view.showStudentInformation(student.getId(), student.getName());
        }

        view.showListIsFinish();
    }

    /*


     scoreManager 가 관련되었습니다.


     */

    public static Long getStudentId(){
        view.orderToTypeStudentId();
        return InputReader.getStudentId();
    }
    public static Long getStudentIdValid(){
        view.showNotValidStudentId();
        return InputReader.getStudentId();
    }

    public static String getSubjectName(Student student){
        view.showStudentEditHeader(student.getName());
        for(Subject subject : student.getSubjectList()){
            view.showSubject(subject.getName());
        }
        view.orderToTypeSubject();
        return InputReader.getSubjectName();
    }
    public static double getScoreEdit(int ScoreIdx){
        view.orderToTypeScore(ScoreIdx);
        return InputReader.getScore();
    }

    public static void showScoreIsFull(String subjectName) {
        view.showScoreIsFull(subjectName);
    }

    public static int getScoreEdit(Subject subject){
        view.showScoreEditHeader(subject.getName());
        for(int i=0; i<subject.getScoreList().length; i++){
            if(subject.getScoreList()[i].getValue()!=-1){
                view.showScore(i+1, subject.getScoreList()[i].getValue());
            }

        }
        view.orderToTypeScoreIdxForEdit();
        return InputReader.getScoreIdx();
    }

    public static void showScoreList(Subject subject){
        view.showSubjectGradeHeader(subject.getName());

        for(int i=0; i<subject.getScoreList().length; i++){
            if(subject.getScoreList()[i].getValue()!=-1){
                view.showScore(i+1, subject.getScoreList()[i].getValue());
            }
        }

        view.showListIsFinish();
    }


}
