package UIManager;

import forDelete.Student;
import forDelete.Subject;

import java.util.ArrayList;

public class ViewManager {
    private static final View view = new View();

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

    public static String getNewStudentName(){
        view.showAddStudentMenu();
        String studentName = InputReader.getStudentName();
        return studentName;
    }

    public static String getStudentsSubject(Student student) {
        view.orderToTypeNewStudentSubject(student.studentName);
        String subjectName = InputReader.getSubjectName();
        return subjectName;
    }

    public static String getStudentsSubjectValid(Student student) {
        view.showNotValidSubject();
        String subjectName = InputReader.getSubjectName();
        return subjectName;
    }

    public static boolean getStudentsSubjectContinue(Student student) {
        view.AskContinue();
        return InputReader.getBoolean();
    }

    public static void showStudentsAddIsOver(Student student) {
        view.showAddIsComplete();
    }

    public static void showStudentsList(ArrayList<Student> studentsList){
        view.showStudentListHeader();

        for(Student student : studentsList){
            view.showStudentInformation(student.studentId, student.studentName);
        }

        view.showListIsFinish();
    }

    public static int getStudentIdForEdit(){
        view.orderToTypeStudentId();
        return InputReader.getStudentId();
    }
    public static int getStudentIdForEditValid(){
        view.showNotValidStudentId();
        return InputReader.getStudentId();
    }

    public static String getSubjectEdit(Student student){
        view.showStudentEditHeader(student.studentName);
        for(Subject subject : student.getSubjectList()){
            view.showSubject(subject.getName());
        }
        view.orderToTypeSubjectForAddScore();
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
//        for(Score score : subject.getScoreList()){
//            view.showScore(ScoreIdx, score);
//        }
        view.orderToTypeScoreIdxForEdit();
        return InputReader.getScoreIdx();
    }

    public static void showScoreList(Subject subject){
        view.showSubjectGradeHeader(subject.getName());

//        for(Score score : subject.getScoreList()){
//            view.showScore(ScoreIdx, grade);
//        }
        view.showListIsFinish();
    }
}
