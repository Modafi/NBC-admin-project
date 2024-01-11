package UIManager;

public class ViewManager {
    private static final View view = new View();

    public static int showMenuOptions() {
        view.showHeader();
        view.showMainMenu();
        view.showOrder();
        return InputReader.gerOrderNumber();
    }

//    public static int showStudentOptions(){
//
//    }
}
