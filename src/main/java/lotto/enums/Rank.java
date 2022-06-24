package lotto.enums;

public enum Rank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 50_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    NOT_MATCH(0, 0, false);

    private int lottoMatchedCount;
    private int amount;
    private boolean isMatchBonusBall;

    Rank(int lottoMatchedCount, int amount, boolean isMatchBonusBall) {
        this.lottoMatchedCount = lottoMatchedCount;
        this.amount = amount;
        this.isMatchBonusBall = isMatchBonusBall;
    }

    public static Rank findRank(int count, boolean isMatchBonusBall) {
        for (Rank rank : values()) {
            if (isExistRank(count, isMatchBonusBall, rank)) {
                return rank;
            }
        }
        return NOT_MATCH;
    }

    private static boolean isExistRank(int count, boolean isMatchBonusBall, Rank rank) {
        return rank.lottoMatchedCount() == count && rank.isMatchBonusBall() == isMatchBonusBall;
    }

    public int lottoMatchedCount() {
        return lottoMatchedCount;
    }

    public boolean isMatchBonusBall() {
        return isMatchBonusBall;
    }

    public int getAmount() {
        return amount;
    }
}
