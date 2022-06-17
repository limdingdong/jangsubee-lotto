package lotto.service;

import lotto.domain.Ball;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class LottoService {
    private static final int FIRST_INDEX_LOTTO = 0;
    private static final int LAST_INDEX_LOTTO = 6;
    private static final int FIRST_NUMBER_LOTTO = 1;
    private static final int LAST_NUMBER_LOTTO = 45;
    private static final List<Ball> lottoBalls;

    private LottoService() {
    }

    static {
        lottoBalls = createLottoBalls();
    }

    public static Lotto createLotto() {
        return new Lotto(shuffleLottoBalls());
    }

    private static List<Ball> shuffleLottoBalls() {
        Collections.shuffle(lottoBalls);
        return lottoBalls.subList(FIRST_INDEX_LOTTO, LAST_INDEX_LOTTO);
    }

    private static List<Ball> createLottoBalls() {
        List<Ball> balls = new ArrayList<>();
        for (int i = FIRST_NUMBER_LOTTO; i <= LAST_NUMBER_LOTTO; i++) {
            balls.add(new Ball(i));
        }
        return balls;
    }
}
