package lotto.domain;

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
            throw new IllegalArgumentException("로또번호는 1이상 45이하 숫자만 가능합니다.");
        }
    }

    private boolean isLottoNumber(int ballNumber) {
        return FIRST_LOTTO_NUMBER <= ballNumber && ballNumber <= LAST_LOTTO_NUMBER;
    }
}
