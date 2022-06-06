package lotto.domain;

public class Number {
    private static final int MIN_NUMBER = 0;
    private int number;

    public Number(int number) {
        checkNegativeNumber(number);
        this.number = number;
    }

    public int number() {
        return this.number;
    }

    private void checkNegativeNumber(int number) {
        if (number < MIN_NUMBER) {
            throw new IllegalArgumentException("음수는 입력할수 없습니다.");
        }
    }
}
