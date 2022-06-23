package lotto;

import lotto.domain.Lottos;
import lotto.domain.Seller;
import lotto.service.LottoGameService;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        int money = InputView.inputMoney();
        int lottoCount = Seller.sellLotto(money);
        OutputView.displayLottoCount(lottoCount);

        Lottos lottos = LottoGameService.buyLottos(lottoCount);
        OutputView.displayLottos(lottos);

    }
}
