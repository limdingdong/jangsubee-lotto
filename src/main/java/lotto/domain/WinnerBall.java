package lotto.domain;

public class WinnerBall {
    private final Lotto winnerLotto;
    private final Ball bonusBall;

    WinnerBall(Lotto winnerLotto, Ball bonusBall) {
        this.winnerLotto = winnerLotto;
        this.bonusBall = bonusBall;
    }

    public Lotto winnerLotto() {
        return winnerLotto;
    }
}
