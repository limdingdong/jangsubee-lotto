package lotto;

import lotto.controller.LottoGameController;
import lotto.domain.Ball;
import lotto.domain.Lottos;
import lotto.domain.WinnerLotto;
import lotto.enums.Rank;
import lotto.ui.InputView;
import lotto.ui.OutputView;

import java.util.Map;

public class LottoApplication {
    public static void main(String[] args) {

        int lottoCount = LottoGameController.buyLotto();
        OutputView.displayLottoCount(lottoCount);

        Lottos lottos = LottoGameController.createLotto(lottoCount);
        OutputView.displayLottos(lottos);

        String inputFirstLottoNumbers = InputView.inputFirstLottoNumber();
        int bonusBallNumber = InputView.inputBonusBall();
        Ball bonusBall = new Ball(bonusBallNumber);

        WinnerLotto winningLotto = LottoGameController.createWinningLotto(inputFirstLottoNumbers, bonusBall);
        System.out.println(winningLotto.toString());

        Map<Rank, Integer> result = LottoGameController.result(lottos, winningLotto);

        OutputView.printResult(result);


    }
}
