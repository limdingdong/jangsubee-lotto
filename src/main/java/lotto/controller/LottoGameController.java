package lotto.controller;

import lotto.domain.*;
import lotto.service.LottoGameService;
import lotto.ui.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LottoGameController {

    private LottoGameController() {
    }

    public static int buyLotto() {
        int inputMoney = InputView.inputMoney();
        return Seller.sellLotto(inputMoney);
    }

    public static Lottos createLotto(int lottoCount) {
        return LottoGameService.buyLottos(lottoCount);
    }

    public static WinnerLotto createWinningLotto(String inputLotto, Ball bonusBall) {
        StringTokenizer st = new StringTokenizer(inputLotto, ",");
        List<Ball> winningBalls = new ArrayList<>();
        while (st.hasMoreTokens()) {
            int number = Integer.parseInt(st.nextToken());
            winningBalls.add(new Ball(number));
        }

        Lotto winnerLotto = new Lotto(winningBalls);
        return new WinnerLotto(winnerLotto, bonusBall);
    }
}
