package UIManager;

import forDelete.Student;

import java.util.ArrayList;

public class ViewManager {
    private static final View view = new View();

    /*
    코어에서 가장 처음 호출받는 메소드입니다.
    1. 수강생 관리
    2. 점수 관리
    3. 프로그램 종료
    사용자가 위에 번호를 입력하면,
    int 값으로 리턴해줍니다.( 코어에서 해당 값에 맞는 메소드를 호출할 걸 기대해서 했습니다.)
     */
    public static int getMenuOptions() {
        view.showMainMenuHeader();
        view.showMainMenuOptions();
        view.showOrder();

        return InputReader.gerOptionNumber(3);
    }

    /*
    메인에서 처음 메소드값에 따라 호출한 메소드
    1. 수강생 등록
    2. 수강생 목록 조회
    3. 메인 화면 이동
    사용자가 위에 번호를 입력하면,
    int 값으로 리턴해줍니다.( 코어에서 해당 값에 맞는 메소드를 호출할 걸 기대해서 했습니다.)
     */
    public static int getStudentOptions(){
        view.showStudentHeader();
        view.showStudentMenu();
        view.showOrder();

        return InputReader.gerOptionNumber(3);
    }

    /*
    새로 등록할 학생의 이름(밑의 메소드는 과목명)을 받고,
    String 값으로 리턴
     */
    public static String getNewStudentName(){
        view.showAddStudentHeader();
        view.showOrderToTypeStudentName();
        String studentName = InputReader.getStudentName();
        return studentName;
    }

    /*
    과목명을 받고 리턴해주면,
    코어는 스튜던트 매니지먼트에게 과목명의 유효성을 판단해줘야한다.
     */
    public static String getStudentsSubject() {
        view.showOrderToTypeStudentSubject();
        String subject = InputReader.getSubjectName();
        return subject;
    }

    /*
    코어에게 학생 리스트를 받는다.
    리턴값이 없는 void 메소드
     */
    public static void showStudentsList(ArrayList<Student> studentsList){
        view.showStudentListHeader();

        for(Student student : studentsList){
            view.showStudentInformation(student);
        }

        view.showListIsFinish();
    }


    public static int getScoreOptions(){
        view.showScoreHeader();
        view.showScoreMenu();
        view.showOrder();

        return InputReader.gerOptionNumber(4);
    }

    /*수정할 학생의 Id를 입력받아
    int로 리턴
     */
    public static int getStudentIdForEdit(){
        view.showOrderToTypeStudentId();
        return InputReader.getStudentId();
    }
}
