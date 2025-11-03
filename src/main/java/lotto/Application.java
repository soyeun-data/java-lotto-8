package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.Input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.view.Output.outputLottoCntAndNumbers;

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



}
