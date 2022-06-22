package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.List;

public final class LottoGameService {

    private int lottoCount;

    public LottoGameService(int lottoCount) {
        this.lottoCount = lottoCount;
    }

    public void start() {
        Lottos lottos = this.buyLottos();
        lottos.toString();
    }

    private Lottos buyLottos() {
        List<Lotto> lottoBasket = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoBasket.add(LottoService.createLotto());
        }
        return new Lottos(lottoBasket);
    }
}
