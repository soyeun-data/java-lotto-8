package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;

public class LottoController {
    Input input = new Input();
    Output output = new Output();
    int money;

    public void run() {
        money = input.inputPurchaseAmount();

        List<Lotto> lottos = output.outputLottoCntAndNumbers(money);
        Lotto winningNumbers = input.inputWinningNumbers();
        int bonusNumber = input.inputBonusNumber();

        LottoResult result = new LottoResult(lottos, winningNumbers, bonusNumber);
        result.printStatistics();
    }

}
