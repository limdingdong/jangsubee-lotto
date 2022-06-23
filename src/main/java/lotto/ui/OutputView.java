package lotto.ui;

import lotto.domain.Lottos;

public class OutputView {

    private OutputView(){}

    public static void displayLottoCount(int lottoCount){
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void displayLottos(Lottos lottos) {
        System.out.println(lottos.toString());
    }
}
