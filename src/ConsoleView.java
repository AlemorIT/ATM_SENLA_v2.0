import java.util.Scanner;

public class ConsoleView {
    public Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("---------- Банкомат ----------");
        System.out.println("1. Проверить баланс");
        System.out.println("2. Снять средства");
        System.out.println("3. Пополнить баланс");
        System.out.println("4. Выход");
        System.out.print("Выберите действие: ");
    }

    public String inputCardNumber() {
        System.out.print("Введите номер карты (XXXX-XXXX-XXXX-XXXX): ");
        return scanner.nextLine();
    }

    public String inputPin() {
        System.out.print("Введите ПИН-код: ");
        return scanner.nextLine();
    }

    public void showBalance(double balance) {
        System.out.println("Текущий баланс: " + balance);
    }

    public double inputWithdrawalAmount() {
        System.out.print("Введите сумму для снятия: ");
        return scanner.nextDouble();
    }

    public double inputDepositAmount() {
        System.out.print("Введите сумму для пополнения: ");
        return scanner.nextDouble();
    }

    public void showErrorMessage(String message) {
        System.out.println("Ошибка: " + message);
    }

    public void showSuccessMessage(String message) {
        System.out.println("Успешно: " + message);
    }
}

