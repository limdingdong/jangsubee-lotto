package lotto;

import java.io.IOException;
import java.util.*;

public class Lotto {

    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public void play() throws IOException {

        // 티켓구매
        int count = inputView.buy();
        // 자동추첨
        List<List> lottos = autoPickes(count);
        // 로또 출력
        outputView.printLotto(lottos);
        // 지난주 당첨번호 입력
        List<Integer> winningNumber = inputView.inputWinningNumber();


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
