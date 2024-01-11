package UIManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputReader {
    private static final Scanner sc = new Scanner(System.in);
    private static final String stringInputExceptionMessage = "잘못된 입력입니다. 다시 입력해주세요:";
    public static int gerOrderNumber() {
        int num;

        try{
            num = sc.nextInt();
            if(num<4&&num>0){
                throw new InputMismatchException();
            }
        }catch(InputMismatchException i){
            System.out.print(stringInputExceptionMessage);
            num = gerOrderNumber();
        }

        return num;
    }
}
