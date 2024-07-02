package utils;

public enum ApplicationStrings {

    inputCardNumber("Введите номер карты (XXXX-XXXX-XXXX-XXXX): "),
    inputPin("Введите ПИН-код: "),
    inputWithdrawalAmount("Введите сумму для снятия: "),
    inputDepositAmount("Введите сумму для пополнения: "),
    wrongInput ("Неверный ввод. Попробуйте ещё раз");

    private final String title;

    ApplicationStrings(String title) {
        this.title = title;
    }

    public String GetTitle() {
        return title;
    }

}
