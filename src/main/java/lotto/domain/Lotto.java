package lotto.domain;

import exception.InputDataErrorCode;
import exception.InputDataException;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public final class Lotto {
    private static final int LOTTO_MAX_COUNT = 6;
    private final List<Ball> balls;

    public Lotto(List<Ball> balls) {
        checkSixBalls(balls);
        this.balls = balls;
    }

    public List<Ball> balls() {
        return balls;
    }

    public int countMatchBall(Lotto compareLotto) {
        return compareLotto.balls.stream()
                .filter(compareBall -> this.balls.stream()
                        .anyMatch(ball -> ball.number() == compareBall.number()))
                .collect(Collectors.toList())
                .size();
    }

    public boolean isMatchBonusBall(Ball bonusBall) {
        return isMatchOneBall(bonusBall);
    }

    public boolean isMatch(Lotto compareLotto) {
        return this.balls.stream()
                .allMatch(ballNumber -> compareLotto.isMatchOneBall(ballNumber));
    }

    public boolean isMatchOneBall(Ball ball) {
        return this.balls.stream()
                .anyMatch(ballNumber -> ball.number() == ballNumber.number());
    }

    private void checkSixBalls(List<Ball> balls) {
        if (balls == null || balls.isEmpty()) {
            throw new InputDataException(InputDataErrorCode.DATA_IS_EMPTY);
        }

        if (balls.size() != LOTTO_MAX_COUNT) {
            throw new InputDataException(InputDataErrorCode.VALID_LOTTO_SIZE_SIX);
        }

        if (checkDuplicateNumber(balls)) {
            throw new InputDataException(InputDataErrorCode.THERE_IS_DUPLICATE_NUMBER);
        }
    }

    private boolean checkDuplicateNumber(List<Ball> balls) {
        List<Integer> numbers = balls.stream()
                .map(Ball::number)
                .collect(Collectors.toList());

        return new HashSet<>(numbers).size() != LOTTO_MAX_COUNT;
    }

    @Override
    public String toString() {
        return this.balls.stream()
                .map(ball -> ball.number())
                .sorted()
                .collect(Collectors.toList())
                .toString();
    }


}
