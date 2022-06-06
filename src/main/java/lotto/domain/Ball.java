package lotto.domain;

import exception.InputDataErrorCode;
import exception.InputDataException;

public final class Ball {
    private static final int FIRST_LOTTO_NUMBER = 1;
    private static final int LAST_LOTTO_NUMBER = 45;
    private Number number;

    public Ball(int number) {
        this(new Number(number));
    }

    public Ball(Number number) {
        checkLottoNumber(number);
        this.number = number;
    }

    public int number() {
        return this.number.number();
    }

    private void checkLottoNumber(Number number) {
        int ballNumber = number.number();
        if (!isLottoNumber(ballNumber)) {
            throw new InputDataException(InputDataErrorCode.INVALID_RANGE_LOTTO_NUMBER);
        }
    }

    private boolean isLottoNumber(int ballNumber) {
        return FIRST_LOTTO_NUMBER <= ballNumber && ballNumber <= LAST_LOTTO_NUMBER;
    }
}
