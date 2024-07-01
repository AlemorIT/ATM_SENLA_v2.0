package utils;

public class ApplicationStrings {

    enum ApplicationStringsEnum {
        inputCardNumber ("Введите номер карты (XXXX-XXXX-XXXX-XXXX): "),
        inputPin ("Введите ПИН-код: "),
        inputWithdrawalAmount("Введите сумму для снятия: "),
        inputDepositAmount("Введите сумму для пополнения: ");

        private final String title;

        ApplicationStringsEnum(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return title;
        }
    }
}
