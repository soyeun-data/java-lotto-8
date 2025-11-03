package lotto.model;

public enum Rank {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1_500_000),
    FIVE_BONUS(5, 30_000_000),
    SIX(6, 2_000_000_000);

    private final int matchCnt;
    private final long prize;

    Rank(int matchCnt, long prize) {
        this.matchCnt = matchCnt;
        this.prize = prize;
    }

    public int getMatchCnt() {
        return matchCnt;
    }

    public long getPrize() {
        return prize;
    }

    public static Rank valueOf(int matchCnt, boolean bonusMatch) {
        if (matchCnt == 6) return SIX;
        if (matchCnt == 5 && bonusMatch) return FIVE_BONUS;
        if (matchCnt == 5) return FIVE;
        if (matchCnt == 4) return FOUR;
        if (matchCnt == 3) return THREE;
        return null;
    }

}
