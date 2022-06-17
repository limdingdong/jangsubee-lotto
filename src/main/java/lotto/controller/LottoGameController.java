package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Seller;
import lotto.service.LottoService;
import lotto.ui.InputView;
import lotto.ui.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGameController {
    private LottoGameController() {
    }

    public static int buyLotto() {
        int inputMoney = InputView.inputMoney();
        int lottoCount = Seller.sellLotto(inputMoney);

        OutputView.displayLottoCount(lottoCount);
        return lottoCount;
    }

    public static Lottos createLotto(int lottoCount) {
        List<Lotto> lottoBasket = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            Lotto createdLotto = LottoService.createLotto();
            lottoBasket.add(createdLotto);
        }
        return new Lottos(lottoBasket);
    }
}
