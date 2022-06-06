package lotto.controller;

import lotto.domain.Seller;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public class LottoGameController {
    private LottoGameController() {
    }

    public static void start() {
        int inputMoney = InputView.inputMoney();
        int lottoCount = Seller.sellLotto(inputMoney);

        OutputView.displayLottoCount(lottoCount);


    }
}
