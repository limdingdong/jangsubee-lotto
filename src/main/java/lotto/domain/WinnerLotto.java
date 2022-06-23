package lotto.domain;

import exception.InputDataErrorCode;
import exception.InputDataException;

public class WinnerLotto {
    private final Lotto winnerLotto;
    private final Ball bonusBall;

    public WinnerLotto(Lotto winnerLotto, Ball bonusBall) {
        this.winnerLotto = winnerLotto;
        checkAlreadyExistBonusBall(bonusBall);
        this.bonusBall = bonusBall;
    }

    public Lotto winnerLotto() {
        return winnerLotto;
    }

    private void checkAlreadyExistBonusBall(Ball bonusBall) {
        if (this.winnerLotto.isMatchOneBall(bonusBall)) {
            throw new InputDataException(InputDataErrorCode.ALREADY_EXIST_BALL);
        }
    }

    @Override
    public String toString() {
        return winnerLotto().toString() + " , bonusBall : " + bonusBall.number();
    }
}
