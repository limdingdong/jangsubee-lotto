package lotto.domain;

import exception.InputDataErrorCode;
import exception.InputDataException;

import java.util.Objects;

public final class Ball implements Comparable<Number> {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ball)) return false;
        Ball ball = (Ball) o;
        return Objects.equals(number, ball.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(Number o) {
        return this.number() - o.number();
    }
}
