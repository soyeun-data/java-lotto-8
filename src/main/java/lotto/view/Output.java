package lotto.view;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Output {
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
}
