package UIManager;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputReader {
    private static final Scanner sc = new Scanner(System.in);
    private static final String stringInputExceptionMessage = "잘못된 입력입니다. 다시 입력해주세요:";
    public static int gerOrderNumber(int numbersOfOptions) {
        int num;

        try{
            num = sc.nextInt();
            if(num>numbersOfOptions&&num>0){
                throw new InputMismatchException();
            }
        }catch(InputMismatchException i){
            System.out.print(stringInputExceptionMessage);
            num = gerOrderNumber(numbersOfOptions);
        }

        return num;
    }

    public static String getStudentName() {
        String studentName;

        try{
            studentName = sc.next();
        }catch(InputMismatchException i){
            System.out.print(stringInputExceptionMessage);
            studentName = getStudentName();
        }

        return studentName;
    }

    public static String getSubjectName() {
        String subjectName;

        try{
            subjectName = sc.next();
        }catch(InputMismatchException i){
            System.out.print(stringInputExceptionMessage);
            subjectName = getStudentName();
        }

        return subjectName;
    }

    public static boolean getTrue() {
        Boolean oneIsTrue;

        try{
            oneIsTrue = (sc.nextInt()==1);
            return oneIsTrue;
        }catch(InputMismatchException i){
            System.out.print(stringInputExceptionMessage);
            oneIsTrue = getTrue();
        }

        return oneIsTrue;
    }

    public static int getId() {
        int num;

        try{
            num = sc.nextInt();
        }catch(InputMismatchException i){
            System.out.print(stringInputExceptionMessage);
            num = getId();
        }

        return num;
    }
}
