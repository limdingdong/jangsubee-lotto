package lotto.domain;

public class Seller {

    private static final int LOTTO_FEE = 1000;

    private Seller() {
    }

    public static int sellLotto(int money) {
        return money / LOTTO_FEE;
    }
}
