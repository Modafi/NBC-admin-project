package UIManager;

public class View {
    public void showHeader(){
        System.out.println("""
                    ==================================
                    내일배움캠프 수강생 관리 프로그램을 실행합니다.
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
                    내일배움캠프 수강생 관리 프로그램을 실행합니다.
                    """);
    }
}
