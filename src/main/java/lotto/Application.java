package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int money;
        money = inputPurchaseAmount();

        List<Lotto> lottos = outputLottoCntAndNumbers(money);
        Lotto winningNumbers = inputWinningNumbers();
    }

    public static Lotto inputWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String input = Console.readLine();

                validateInputBlank(input);

                List<Integer> winningNumbers = Arrays.stream(input.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .toList();

                return new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("[ERROR] 당첨 번호 입력값이 잘못되었습니다.");
            }
        }
    }

    public static List<Lotto> outputLottoCntAndNumbers(int money) {
        int lottoCnt = money / 1000;
        System.out.println(lottoCnt + "개를 구매했습니다.");
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCnt; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                    .stream()
                    .sorted()
                    .toList();

            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
            System.out.println(lotto.getNumbers());
            System.out.println();
        }
        return lottos;
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

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("[ERROR] 값이 잘못 입력되었습니다.");
            }
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
