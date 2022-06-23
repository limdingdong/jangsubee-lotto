package lotto;

import lotto.controller.LottoGameController;
import lotto.domain.Lottos;
import lotto.ui.OutputView;

public class LottoApplication {
    public static void main(String[] args) {

        int lottoCount = LottoGameController.buyLotto();
        Lottos lottos = LottoGameController.createLotto(lottoCount);
        OutputView.displayLottos(lottos);

        
    }
}
