package utils;

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
        System.out.println(text);
        return scanner.nextDouble();
    }
}
