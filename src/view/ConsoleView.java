package view;

public class ConsoleView {

    public void showMenu() {
        System.out.println("---------- Банкомат ----------");
        System.out.println("1. Проверить баланс");
        System.out.println("2. Снять средства");
        System.out.println("3. Пополнить баланс");
        System.out.println("4. Выход");
        System.out.print("Выберите действие: ");
    }

    public void showBalance(double balance) {
        System.out.println("Текущий баланс: " + balance);
    }

    public void showErrorMessage(String message) {
        System.out.println("Ошибка: " + message);
    }

    public void showSuccessMessage(String message) {
        System.out.println("Успешно: " + message);
    }
}

