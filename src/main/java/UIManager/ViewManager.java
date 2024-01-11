package UIManager;

import java.util.ArrayList;

public class ViewManager {
    private static final View view = new View();

    public static int showMenuOptions() {
        view.showHeader();
        view.showMainMenu();
        view.showOrder();

        return InputReader.gerOrderNumber(3);
    }

    public static int showStudentOptions(){
        view.showStudentHeader();
        view.showStudentMenu();
        view.showOrder();

        return InputReader.gerOrderNumber(3);
    }

    public static ArrayList<String> showAddStudent(){
        view.showAddStudentHeader();
        view.showOrdertoTypeStudentName();
        String studentName = InputReader.getStudentName();

        ArrayList<String> subjects = new ArrayList<>();

        view.showOrdertoTypeStudentSubject();
        String subject = InputReader.getSubjectName();
        subjects.add(subject);
        view.showAskContinue();
        boolean isTrue = InputReader.getTrue();

        while(isTrue){
            view.showOrdertoTypeStudentSubject();
            subject = InputReader.getSubjectName();
            subjects.add(subject);
            view.showAskContinue();
            isTrue = InputReader.getTrue();
        }

        view.showAddisComplete();

        ArrayList<String> returnValue = new ArrayList<>();
        returnValue.add(studentName);
        returnValue.addAll(subjects);
        return returnValue;
    }
    public static void showStudentsList(ArrayList<String> studentsList){
        view.showStudentListHeader();

        for(String student : studentsList){
            view.showStudentInformation(student);
        }

        view.showListIsFinish();
    }

    public static int showScoreOptions(){
        view.showScoreHeader();
        view.showScoreMenu();
        view.showOrder();

        return InputReader.gerOrderNumber(4);
    }

    public static int showEditStudentId(){
        view.showOrderToTypeStudentId();
        return InputReader.getId();
    }
}
