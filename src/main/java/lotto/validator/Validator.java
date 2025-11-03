package lotto.validator;

public final class Validator {

    public static void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이여야 합니다.");
        }
    }

    public static void validateInputBlank(String input) {
        if (input == null || input.trim().isBlank()) {
            throw new IllegalArgumentException("[ERROR] 값이 입력되지 않았습니다.");
        }
    }

    public static void validateMoneyPositive(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException("[ERROR] 입력된 금액이 음수입니다.");
        }
    }

    public static void validateThousandUnit(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");
        }
    }
}
