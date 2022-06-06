package lotto.domain;

import exception.InputDataErrorCode;
import exception.InputDataException;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public final class Lotto {
    private List<Ball> balls;

    public Lotto(List<Ball> balls) {
        checkSixBalls(balls);
        this.balls = balls;
    }

    public List<Ball> balls() {
        return balls;
    }

    private void checkSixBalls(List<Ball> balls) {
        if (balls == null || balls.isEmpty()) {
            throw new InputDataException(InputDataErrorCode.DATA_IS_EMPTY);
        }

        if (balls.size() != 6) {
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

        return new HashSet<>(numbers).size() != 6;
    }

}
