package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.Input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현]
        Input inputView = new Input();
        int money;
        money = inputView.inputPurchaseAmount();

        List<Lotto> lottos = outputLottoCntAndNumbers(money);
        Lotto winningNumbers = inputView.inputWinningNumbers();
        int bonusNumber = inputView.inputBonusNumber();

        LottoResult result = new LottoResult(lottos, winningNumbers, bonusNumber);
        result.printStatistics();
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
        }
        return lottos;
    }



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
