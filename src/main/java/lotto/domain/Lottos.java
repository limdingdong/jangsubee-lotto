package lotto.domain;

import java.util.Iterator;
import java.util.List;

public class Lottos implements Iterable<Lotto> {

    private final List<Lotto> lottoBasket;

    public Lottos(List<Lotto> lottoBasket) {
        this.lottoBasket = lottoBasket;
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottoBasket.iterator();
    }
}
