package lotto.domain;

import exception.InputDataErrorCode;
import exception.InputDataException;

public final class Number {
    private static final int MIN_NUMBER = 0;
    private final int number;

    public Number(int number) {
        checkNegativeNumber(number);
        this.number = number;
    }

    public int number() {
        return this.number;
    }

    private void checkNegativeNumber(int number) {
        if (number < MIN_NUMBER) {
            throw new InputDataException(InputDataErrorCode.INPUT_NOT_NEGATIVE_NUMBER);
        }
    }
}
