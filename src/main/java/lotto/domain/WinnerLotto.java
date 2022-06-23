package lotto.domain;

public class WinnerLotto {
    private final Lotto winnerLotto;
    private final Ball bonusBall;

    public WinnerLotto(Lotto winnerLotto, Ball bonusBall) {
        this.winnerLotto = winnerLotto;
        this.bonusBall = bonusBall;
    }

    public Lotto winnerLotto() {
        return winnerLotto;
    }

    @Override
    public String toString() {
        return winnerLotto().toString()+" , bonusBall : " + bonusBall.number();
    }
}
