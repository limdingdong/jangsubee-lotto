package lotto.service;

import lotto.domain.Ball;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public final class LottoService {
    private static final int FIRST_INDEX_LOTTO = 0;
    private static final int LAST_INDEX_LOTTO = 6;
    private static final int FIRST_NUMBER_LOTTO = 1;
    private static final int LAST_NUMBER_LOTTO = 45;
    private static List<Ball> lottoBalls;

    private LottoService() {
    }

    static {
        lottoBalls = createLottoBalls();
    }

    public static Lotto createLotto() {
        Collections.shuffle(lottoBalls);
        return new Lotto(makeNewBalls());
    }

    private static List<Ball> makeNewBalls() {
        List<Ball> newLottoBalls = new ArrayList<>();
        for (int i = 0; i < LAST_INDEX_LOTTO; i++) {
            int number = lottoBalls.get(i).number();
            newLottoBalls.add(new Ball(number));
        }

        return newLottoBalls.stream()
                .sorted(Comparator.comparingInt(Ball::number))
                .collect(Collectors.toList());
    }

    private static List<Ball> createLottoBalls() {
        List<Ball> balls = new ArrayList<>();
        for (int i = FIRST_NUMBER_LOTTO; i <= LAST_NUMBER_LOTTO; i++) {
            balls.add(new Ball(i));
        }
        return balls;
    }
}
