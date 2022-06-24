package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.List;

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


}
