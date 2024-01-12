package UIManager;

import forDelete.Student;
import forDelete.Subject;

public class View {
    public void orderToTypeOptionNumber(){
        System.out.print("원하시는 관리 항목의 번호를 입력하세요 :");
    }

    public void showMainMenu(){
        System.out.println("""
                    ==================================
                    내일배움캠프 관리 프로그램을 실행합니다.
                    1. 수강생 관리
                    2. 점수 관리
                    3. 프로그램 종료
                    """);
    }
    public void showStudentMenu(){
        System.out.println("""
                    ==================================
                    수강생 관리 메뉴입니다.
                    1. 수강생 등록
                    2. 수강생 목록 조회
                    3. 메인 화면 이동
                    """);
    }
    public void showScoreMenu() {
        System.out.println("""
                    ==================================
                    점수 관리 메뉴입니다.
                    1. 수강생의 과목별 시험 회차 및 점수 등록
                    2. 수강생의 과목별 회차 점수 수정
                    3. 수강생의 특정 과목 회차별 등급 조회
                    4. 메인 화면 이동
                    """);
    }

    public void showAddStudentMenu() {
        System.out.print("""
                    ==================================
                    수강생 등록 메뉴입니다.
                    등록하실 수강생의 이름을 입력하세요 :
                    """);
    }
    public void orderToTypeNewStudentSubject(String studentName) {
        System.out.print(studentName+"님이 수강할 과목을 입력하세요 :");
    }
    public void showNotValidSubject() {
        System.out.print("유효하지 않는 과목 이름입니다. 다시 입력하세요 :");
    }
    public void AskContinue() {
        System.out.println("\n과목를 더 입력하려면 1번을 눌러주세요 :");
    }

    public void showAddIsComplete() {
        System.out.println("\n수강생 등록이 성공적으로 처리되었습니다.\n");
    }

    public void showStudentListHeader() {
        System.out.println("""
                    ==================================
                    수강생 목록을 조회하겠습니다.
                    """);
    }
    public void showStudentInformation(int studentId, String studentName) {
        System.out.println(studentId+".   "+studentName);
    }
    public void showListIsFinish() {
        System.out.println("\n 목록을 전부 조회하였습니다.\n");
    }


    /*
    점수 등록
     */

    public void orderToTypeStudentId() {
        System.out.println("""
                    ==================================
                    수강생 점수 등록 메뉴입니다.
                    관리할 수강생의 Id를 입력하세요:
                    """);
    }
    public void showNotValidStudentId() {
        System.out.print("유효하지 않는 수강생 ID 입니다." +
                "\n관리할 수강생의 Id를 입력하세요:");
    }

    public void showStudentEditHeader(String studentName) {
        System.out.println("==================================" +
                "\n"+studentName+"님이 수강하시는 과목들입니다.\n");
    }
    public void showSubject(String subjectName) {
        System.out.println(subjectName);
    }
    public void orderToTypeSubjectForAddScore() {
        System.out.print("\n관리할 과목 이름을 입력하세요:");
    }
    public void orderToTypeScore(int ScoreIdx) {
        System.out.print(ScoreIdx+"회차의 점수를 입력하세요:");
    }
    public void showScoreIsFull(String subjectName) {
        System.out.print(subjectName+" 과목은 점수가 모두 등록되었습니다.");
    }

    /*
    점수 수정
     */
    public void showScoreEditHeader(String subjectName) {
        System.out.println("==================================" +
                "\n"+subjectName+"의 회차별 점수 목록입니다.\n");
    }
    public void showScore(int ScoreIdx, double score) {
        System.out.println(ScoreIdx+"회차 : "+score);
    }
    public void orderToTypeScoreIdxForEdit() {
        System.out.print("\n점수를 수정할 회차번호를 입력하세요:");
    }

    /*
    등급 조회
     */
    public void showSubjectGradeHeader(String subjectName) {
        System.out.println("==================================" +
                "\n"+subjectName+"의 회차별 등급입니다.\n");
    }
    public void showGrade(int ScoreIdx, char grade) {
        System.out.println(ScoreIdx+"회차 : "+grade);
    }
}
