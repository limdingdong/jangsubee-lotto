package lotto.ui;

import lotto.domain.Lottos;
import lotto.enums.Rank;

import java.util.Map;

public class OutputView {
    private static final int NOT_RESULT_COUNT = 0;

    private OutputView() {
    }

    public static void displayLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void displayLottos(Lottos lottos) {
        System.out.println(lottos.toString());
    }

    public static void printResult(Map<Rank, Integer> result) {
        StringBuilder sb = new StringBuilder();
        int fifthCount = changeRankResultCount(result.get(Rank.FIFTH));
        int fourthCount = changeRankResultCount(result.get(Rank.FOURTH));
        int thirdCount = changeRankResultCount(result.get(Rank.THIRD));
        int secondCount = changeRankResultCount(result.get(Rank.SECOND));
        int firstCount = changeRankResultCount(result.get(Rank.FIRST));
        sb.append("당첨 통계\n");
        sb.append("---------------\n");
        sb.append("3개 일치(" + Rank.FIFTH.getAmount() + ") - " + fifthCount + "개\n");
        sb.append("4개 일치(" + Rank.FOURTH.getAmount() + ") - " + fourthCount + "개\n");
        sb.append("5개 일치(" + Rank.THIRD.getAmount() + ") - " + thirdCount + "개\n");
        sb.append("5개와 보너스번호 일치(" + Rank.SECOND.getAmount() + ") - " + secondCount + "개\n");
        sb.append("6개 일치(" + Rank.FIRST.getAmount() + ") - " + firstCount + "개\n");
        System.out.println(sb.toString());


    }

    private static int changeRankResultCount(Integer count) {
        if (count == null) {
            return NOT_RESULT_COUNT;
        }
        return count;
    }

}
