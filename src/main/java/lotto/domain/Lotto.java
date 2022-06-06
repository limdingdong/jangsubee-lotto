package lotto.domain;

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
            throw new IllegalArgumentException("Lotto Data가 없습니다.");
        }

        if (balls.size() != 6) {
            throw new IllegalArgumentException("Lotto는 6개이어야합니다.");
        }

        if (checkDuplicateNumber(balls)) {
            throw new IllegalArgumentException("중복된 데이터가 있습니다.");
        }
    }

    private boolean checkDuplicateNumber(List<Ball> balls) {
        List<Integer> numbers = balls.stream()
                .map(Ball::number)
                .collect(Collectors.toList());

        return new HashSet<>(numbers).size() != 6;
    }

}
