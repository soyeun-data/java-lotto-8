package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();

                if (input == null || input.trim().isBlank()) {
                    throw new IllegalArgumentException("[ERROR] 값이 입력되지 않았습니다.");
                }

                int money = Integer.parseInt(input);

                if (money <= 0) {
                    throw new IllegalArgumentException("[ERROR] 입력된 금액이 음수입니다.");
                }

                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                throw new IllegalArgumentException("[ERROR] 값이 잘못 입력되었습니다.");
            }
        }
    }
}
