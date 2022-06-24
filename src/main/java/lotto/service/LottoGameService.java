package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinnerLotto;
import lotto.enums.Rank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class LottoGameService {

    private LottoGameService() {

    }

    public static Lottos buyLottos(int lottoCount) {
        List<Lotto> lottoBasket = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoBasket.add(LottoService.createLotto());
        }
        return new Lottos(lottoBasket);
    }

    public static Map<Rank, Integer> calculateResult(List<Lotto> lottoBasket, WinnerLotto winnerLotto) {
        Map<Rank, Integer> lottoResult = new HashMap<>();
        for (Lotto lotto : lottoBasket) {
            Lotto winningLotto = winnerLotto.winnerLotto();
            Rank rank = Rank.findRank(winningLotto.countMatchBall(lotto), winnerLotto.isContainBonusBall(lotto));
            Integer rankCount = lottoResult.getOrDefault(rank, 0);
            lottoResult.put(rank, rankCount + 1);
        }
        return lottoResult;
    }
}
