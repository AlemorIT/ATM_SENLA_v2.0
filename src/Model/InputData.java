package Model;

import java.util.Scanner;

public class InputData {
    public Scanner scanner = new Scanner(System.in);

    public String inputCardNumber() {
        System.out.print("Введите номер карты (XXXX-XXXX-XXXX-XXXX): ");
        return scanner.nextLine();
    }

    public String inputPin() {
        System.out.print("Введите ПИН-код: ");
        return scanner.nextLine();
    }

    public double inputWithdrawalAmount() {
        System.out.print("Введите сумму для снятия: ");
        return scanner.nextDouble();
    }

    public double inputDepositAmount() {
        System.out.print("Введите сумму для пополнения: ");
        return scanner.nextDouble();
    }
}
