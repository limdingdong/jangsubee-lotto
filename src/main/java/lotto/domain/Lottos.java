package lotto.domain;

import java.util.Iterator;
import java.util.List;

public class Lottos implements Iterable<Lotto> {

    private final List<Lotto> lottoBasket;

    public Lottos(List<Lotto> lottoBasket) {
        this.lottoBasket = lottoBasket;
    }

    private StringBuilder cutLastComma(StringBuilder lottoText) {
        return lottoText.delete(lottoText.lastIndexOf(","), lottoText.length());
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottoBasket.iterator();
    }

    @Override
    public String toString() {
        StringBuilder lottoText = new StringBuilder();
        for (Lotto lotto : lottoBasket) {
            printLotto(lottoText, lotto);
        }
        return lottoText.toString();
    }

    private void printLotto(StringBuilder lottoText, Lotto lotto) {
        lottoText.append("[");
        lotto.balls().stream()
                .forEach(ball -> lottoText.append(ball.number() + ", "));
        cutLastComma(lottoText);
        lottoText.append("]\n");
    }
}
