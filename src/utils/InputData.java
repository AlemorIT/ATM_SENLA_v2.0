package utils;

import java.util.Scanner;

public class InputData {
    public Scanner scanner = new Scanner(System.in);

    public String inputCardNumber() {
        System.out.print(ApplicationStrings.ApplicationStringsEnum.inputCardNumber.GetTitle());
        return scanner.nextLine();
    }

    public String inputPin() {
        System.out.print(ApplicationStrings.ApplicationStringsEnum.inputPin.GetTitle());
        return scanner.nextLine();
    }

    public double inputWithdrawalAmount() {
        System.out.print(ApplicationStrings.ApplicationStringsEnum.inputWithdrawalAmount.GetTitle());
        return scanner.nextDouble();
    }

    public double inputDepositAmount() {
        System.out.print(ApplicationStrings.ApplicationStringsEnum.inputDepositAmount.GetTitle());
        return scanner.nextDouble();
    }
}
