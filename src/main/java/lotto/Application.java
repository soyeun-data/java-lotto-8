package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();

                int money = validateInputBlank(input);

                validateMoneyPositive(money);
                validateThousandUnit(money);

                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                throw new IllegalArgumentException("[ERROR] 값이 잘못 입력되었습니다.");
            }
        }
    }

    public static int validateInputBlank(String input) {
        if (input == null || input.trim().isBlank()) {
            throw new IllegalArgumentException("[ERROR] 값이 입력되지 않았습니다.");
        }
        return Integer.parseInt(input);
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
