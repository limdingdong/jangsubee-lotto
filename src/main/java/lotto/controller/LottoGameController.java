package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Seller;
import lotto.service.LottoGameService;
import lotto.ui.InputView;
import lotto.ui.OutputView;

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
        return LottoGameService.buyLottos(lottoCount);
    }
}
