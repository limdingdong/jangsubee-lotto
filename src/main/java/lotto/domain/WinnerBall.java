package lotto.domain;

public class WinnerBall {
    private final Lotto winnerLotto;

    WinnerBall(Lotto winnerLotto) {
        this.winnerLotto = winnerLotto;
    }

    public Lotto winnerLotto() {
        return winnerLotto;
    }
}
