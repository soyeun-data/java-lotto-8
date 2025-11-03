package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final List<Lotto> purchasedLottos;
    private final Lotto winningLotto;
    private final int bonusNumber;

    public LottoResult(List<Lotto> purchasedLottos, Lotto winningLotto, int bonusNumber) {
        this.purchasedLottos = purchasedLottos;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public void printStatistics() {
        Map<Rank, Integer> rankCount = new EnumMap<>(Rank.class);

        for (Lotto lotto : purchasedLottos) {
            int matchCount = lotto.countMatchingNumbers(winningLotto);
            boolean bonusMatch = lotto.hasBonusNumber(bonusNumber);

            Rank rank = Rank.valueOf(matchCount, bonusMatch);
            if (rank == null) continue;

            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }

        long totalWin = 0;

        for (Rank rank : Rank.values()) {
            int count = rankCount.getOrDefault(rank, 0);
            System.out.println(rankLabel(rank) + " (" + String.format("%,d", rank.getPrize()) + "원) - " + count + "개");
            totalWin += (long) count * rank.getPrize();
        }

        double yield = (double) totalWin / (purchasedLottos.size() * 1000) * 100;
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }

    private String rankLabel(Rank rank) {
        if (rank == Rank.THREE) return "3개 일치";
        if (rank == Rank.FOUR) return "4개 일치";
        if (rank == Rank.FIVE) return "5개 일치";
        if (rank == Rank.FIVE_BONUS) return "5개 일치, 보너스 볼 일치";
        if (rank == Rank.SIX) return "6개 일치";
        return "";
    }
}
