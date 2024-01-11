package UIManager;

public class View {
    public void showHeader(){
        System.out.println("""
                    ==================================
                    내일배움캠프 관리 프로그램을 실행합니다.
                    """);
    }

    public void showMainMenu(){
        System.out.println("""
                1. 수강생 관리
                2. 점수 관리
                3. 프로그램 종료
                """);
    }

    public void showOrder(){
        System.out.print("원하시는 관리 항목의 번호를 입력하세요 :");
    }

    public void showStudentHeader(){
        System.out.println("""
                    ==================================
                    수강생 관리 메뉴입니다.
                    """);
    }

    public void showStudentMenu() {
        System.out.println("""
                    1. 수강생 등록
                    2. 수강생 목록 조회
                    3. 메인 화면 이동
                    """);
    }

    public void showAddStudentHeader() {
        System.out.println("""
                    ==================================
                    수강생 등록 메뉴입니다.
                    """);
    }

    public void showOrdertoTypeStudentName() {
        System.out.print("등록하실 수강생의 이름을 입력하세요 :");
    }

    public void showOrdertoTypeStudentSubject() {
        System.out.print("수강생이 수강할 과목을 입력하세요 :");
    }
    public void showAskContinue() {
        System.out.println("\n과목를 더 입력하려면 1번을 눌러주세요 :");
    }


    public void showAddisComplete() {
        System.out.println("\n수강생 등록이 성공적으로 처리되었습니다.\n");
    }
    public void showStudentListHeader() {
        System.out.println("""
                    ==================================
                    수강생 목록을 조회하겠습니다.
                    """);
    }
    public void showStudentInformation(String student) {
        int id = 3;
        String studentName = student;
        System.out.println(id+".   "+studentName);
    }



    public void showListIsFinish() {
        System.out.println("\n 수강생 목록을 전부 조회하였습니다.\n");
    }
    public void showScoreHeader() {
        System.out.println("""
                    ==================================
                    점수 관리 메뉴입니다.
                    """);
    }

    public void showScoreMenu() {
        System.out.println("""
                    1. 수강생의 과목별 시험 회차 및 점수 등록
                    2. 수강생의 과목별 회차 점수 수정
                    3. 수강생의 특정 과목 회차별 등급 조회
                    4. 메인 화면 이동
                    """);
    }


    public void showOrderToTypeStudentId() {
        System.out.print("\n관리할 수강생의 Id를 입력하세요:");
    }
}
