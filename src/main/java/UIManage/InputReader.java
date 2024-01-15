package UIManage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputReader {
    private static final String stringInputExceptionMessage = "잘못된 입력입니다.다시 입력해주세요 :";
    public static int getOptionNumber(int numbersOfOptions) {
        Scanner sc = new Scanner(System.in);
        int num;

        try{
            num = sc.nextInt();
            if(num>numbersOfOptions&&num>0){
                throw new InputMismatchException();
            }
        }catch(InputMismatchException i){
            System.out.print(stringInputExceptionMessage);
            num = getOptionNumber(numbersOfOptions);
        }

        return num;
    }

    public static String getStudentName() {
        Scanner sc = new Scanner(System.in);
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
        Scanner sc = new Scanner(System.in);
        String subjectName;

        try{
            subjectName = sc.next();
        }catch(InputMismatchException i){
            System.out.print(stringInputExceptionMessage);
            subjectName = getStudentName();
        }

        return subjectName;
    }

    public static boolean getBoolean() {
        Scanner sc = new Scanner(System.in);
        boolean oneIsTrue;

        try{
            oneIsTrue = (sc.next().equals("1"));
            return oneIsTrue;
        }catch(InputMismatchException i){
            System.out.print(stringInputExceptionMessage);
            oneIsTrue = getBoolean();
        }

        return oneIsTrue;
    }

    public static Long getStudentId() {
        Scanner sc = new Scanner(System.in);
        Long num;

        try{
            num = sc.nextLong();
        }catch(InputMismatchException i){
            System.out.print(stringInputExceptionMessage);
            num = getStudentId();
        }

        return num;
    }

    public static double getScore() {
        Scanner sc = new Scanner(System.in);
        double score;

        try{
            score = sc.nextInt();
            if(score>100||score<0){
                throw new InputMismatchException();
            }
        }catch(InputMismatchException i){
            System.out.print(stringInputExceptionMessage);
            score = getStudentId();
        }

        return score;
    }

    public static int getScoreIdx() {
        Scanner sc = new Scanner(System.in);
        int idx;

        try{
            idx = sc.nextInt();
            if(idx<1||idx>10){
                throw new InputMismatchException();
            }
        }catch(InputMismatchException i){
            System.out.print(stringInputExceptionMessage);
            idx = getScoreIdx();
        }

        return idx;
    }
}