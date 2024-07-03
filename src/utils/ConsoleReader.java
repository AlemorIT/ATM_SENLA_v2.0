package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleReader implements Reader{

    public Scanner scanner = new Scanner(System.in);

    @Override
    public String ReadString(String text){
        System.out.println(text);
        return scanner.nextLine();
    }

    @Override
    public double ReadDouble(String text){
        String stroka = ReadString(text);
        try {
            return Double.parseDouble(stroka);
        }
        catch(InputMismatchException e){
            return Double.NEGATIVE_INFINITY;
        }
    }
}
