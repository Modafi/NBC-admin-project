package UIManage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputReader {
    private static final String STRING_INPUT_EXCEPTION_MESSAGE = "잘못된 입력입니다.다시 입력해주세요 :";
    public static int getOptionNumber(int numbersOfOptions) {

        while(true){
            Scanner sc = new Scanner(System.in);
            int num;

            try{
                num = sc.nextInt();

                if(num>numbersOfOptions||num<=0){
                    throw new InputMismatchException();
                }

                return num;

            }catch(InputMismatchException i){
                System.out.print(STRING_INPUT_EXCEPTION_MESSAGE);
            }
        }

    }


    public static String getName() {

        while(true){
            Scanner sc = new Scanner(System.in);
            String name;

            try{
                name = sc.next();

                return name;

            }catch(InputMismatchException i){
                System.out.print(STRING_INPUT_EXCEPTION_MESSAGE);
            }

        }

    }

    public static boolean getBoolean() {
        Scanner sc = new Scanner(System.in);
        boolean oneIsTrue;

        try{
            oneIsTrue = (sc.next().equals("1"));
            return oneIsTrue;
        }catch(InputMismatchException i){
            return false;
        }

    }

    public static Long getStudentId() {

        while(true){
            Scanner sc = new Scanner(System.in);
            Long num;

            try{
                num = sc.nextLong();

                return num;

            }catch(InputMismatchException i){
                System.out.print(STRING_INPUT_EXCEPTION_MESSAGE);
            }
        }

    }

    public static Integer getScore() {

        while(true){
            Scanner sc = new Scanner(System.in);
            Integer score;

            try{
                score = sc.nextInt();

                return score;

            }catch(InputMismatchException i){
                System.out.print(STRING_INPUT_EXCEPTION_MESSAGE);
            }
        }

    }

    public static int getScoreIdx() {

        while(true){
            Scanner sc = new Scanner(System.in);
            int idx;

            try{
                idx = sc.nextInt();

                return idx;

            }catch(InputMismatchException i){
                System.out.print(STRING_INPUT_EXCEPTION_MESSAGE);
            }
        }

    }
}
