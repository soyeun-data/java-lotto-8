package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.Arrays;
import java.util.List;

import static lotto.Application.*;

public class Input {
    public static int inputBonusNumber() {
        while (true) {
            try {
                System.out.println();
                System.out.println("보너스 번호를 입력해 주세요.");
                String input = Console.readLine();

                validateInputBlank(input);

                int bonusNumber = Integer.parseInt(input);

                validateNumberRange(bonusNumber);

                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자만 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Lotto inputWinningNumbers() {
        while (true) {
            try {
                System.out.println();
                System.out.println("당첨 번호를 입력해 주세요.");
                String input = Console.readLine();

                validateInputBlank(input);

                List<Integer> winningNumbers = Arrays.stream(input.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .toList();

                return new Lotto(winningNumbers);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 당첨 번호 입력값이 잘못 되었습니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int inputPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();

                validateInputBlank(input);
                int money = Integer.parseInt(input);

                validateMoneyPositive(money);
                validateThousandUnit(money);

                System.out.println();
                return money;

            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 값이 잘못 입력되었습니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
