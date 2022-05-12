package lotto;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

public class Lotto {

    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    private final Long LOTTO_PRICE = 1000L;

    public void play() throws IOException {

        // 티켓구매
        int count = inputView.buy();
        // 자동추첨
        List<List> lottos = autoPickes(count);
        // 로또 출력
        outputView.printLotto(lottos);
        // 지난주 당첨번호 입력
        List<Integer> winningNumber = inputView.inputWinningNumber();
        //당첨통계계산
        int[] result = checkWin(lottos, winningNumber);
        Double yield = calculateYield(result, count);
        //당첨통계출력
        outputView.printResult(result, yield);
    }

    public Double calculateYield(int[] result, int count) {
        Long totalPrize = Prize.THREE.getPrice() * result[3]
                        + Prize.FOUR.getPrice() * result[4]
                        + Prize.FIVE.getPrice() * result[5]
                        + Prize.SIX.getPrice() * result[6];

        Double yield = Double.valueOf(totalPrize) / Double.valueOf(count*LOTTO_PRICE);

        return Math.floor(yield*100)/100.0;
    }

    private int[] checkWin(List<List> lottos, List<Integer> winningNumber) {
        int[] result = new int[7];
        //당첨 확인
        for (List lotto : lottos) {
           lotto.retainAll(winningNumber);
           result[lotto.size()] = result[lotto.size()]+1;
        }
      return result;
    }

    // 번호만큼 자동추천
    public List<List> autoPickes(int count){

        List<List> lottos = new LinkedList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> lotto = autoPick();
            lottos.add(lotto);
        }
        return lottos;
    }

    // 자동추첨
    private List<Integer> autoPick() {
        Random random = new Random();
        List<Integer> lotto = new ArrayList<>();

        while(lotto.size() < 6){
            int pick = random.nextInt(45);
            if(lotto.stream().anyMatch(item->item.equals(pick))){ continue;}
            lotto.add(pick);
        }

        return lotto;
    }
}
