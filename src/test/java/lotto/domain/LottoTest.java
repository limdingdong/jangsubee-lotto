package lotto.domain;

import exception.InputDataErrorCode;
import exception.InputDataException;
import lotto.enums.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    @DisplayName("로또 데이터를 null을 넣었을 경우")
    void inputNullDataLottoTest() {
        assertThatThrownBy(() -> new Lotto(null))
                .isInstanceOf(InputDataException.class)
                .hasMessageContaining(InputDataErrorCode.DATA_IS_EMPTY.errorMessage());
    }

    @Test
    @DisplayName("비어있는 로또 데이터를 넣지 않았을 경우")
    void notInputDataLottoTest() {
        assertThatThrownBy(() -> new Lotto(new ArrayList<>()))
                .isInstanceOf(InputDataException.class)
                .hasMessageContaining(InputDataErrorCode.DATA_IS_EMPTY.errorMessage());
    }

    @Test
    @DisplayName("중복된 로또 데이터가 있을 경우")
    void inputDuplicationLottoDataTest() {
        assertThatThrownBy(() -> {
            List<Ball> balls = Arrays.asList(new Ball(1), new Ball(2), new Ball(3), new Ball(4), new Ball(6), new Ball(6));
            Lotto lotto = new Lotto(balls);
        }).isInstanceOf(InputDataException.class)
                .hasMessageContaining(InputDataErrorCode.THERE_IS_DUPLICATE_NUMBER.errorMessage());
    }

    @Test
    @DisplayName("로또 Ball 5개만 입력하였을 경우")
    void inputFiveLottoDataTest() {
        assertThatThrownBy(() -> {
            List<Ball> balls = Arrays.asList(new Ball(1), new Ball(2), new Ball(3), new Ball(4), new Ball(6));
            Lotto lotto = new Lotto(balls);
        }).isInstanceOf(InputDataException.class)
                .hasMessageContaining(InputDataErrorCode.VALID_LOTTO_SIZE_SIX.errorMessage());
    }

    @Test
    @DisplayName("정상적으로 로또 데이터를 입력했을 경우")
    void inputLottoDataTest() {
        List<Ball> balls = Arrays.asList(new Ball(1), new Ball(2), new Ball(3), new Ball(4), new Ball(5), new Ball(6));
        Lotto lotto = new Lotto(balls);
        assertThat(lotto.balls().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또를 다른 로또와 비교해서 같은 경우")
    void compareSameLottoTest() {
        List<Ball> balls = Arrays.asList(new Ball(1), new Ball(2), new Ball(3), new Ball(4), new Ball(5), new Ball(6));
        List<Ball> balls2 = Arrays.asList(new Ball(1), new Ball(2), new Ball(3), new Ball(4), new Ball(5), new Ball(6));
        Lotto lotto = new Lotto(balls);
        Lotto lotto2 = new Lotto(balls2);
        assertThat(lotto.isMatch(lotto2)).isTrue();
    }

    @Test
    @DisplayName("로또를 다른 로또와 비교해서 다른 경우")
    void compareDiffrentLottoTest() {
        List<Ball> balls = Arrays.asList(new Ball(1), new Ball(2), new Ball(3), new Ball(4), new Ball(5), new Ball(6));
        List<Ball> balls2 = Arrays.asList(new Ball(1), new Ball(2), new Ball(3), new Ball(4), new Ball(5), new Ball(10));
        Lotto lotto = new Lotto(balls);
        Lotto lotto2 = new Lotto(balls2);
        assertThat(lotto.isMatch(lotto2)).isFalse();
    }

    @Test
    @DisplayName("ball이 로또 안에 들어있는지 테스트 : 성공")
    void containBallTest() {
        List<Ball> balls = Arrays.asList(new Ball(1), new Ball(2), new Ball(3), new Ball(4), new Ball(5), new Ball(6));
        Ball ball = new Ball(6);
        Lotto lotto = new Lotto(balls);
        assertThat(lotto.isMatchOneBall(ball)).isTrue();
    }

    @Test
    @DisplayName("ball이 로또 안에 들어있는지 테스트: 실패")
    void notContainBallTest() {
        List<Ball> balls = Arrays.asList(new Ball(1), new Ball(2), new Ball(3), new Ball(4), new Ball(5), new Ball(6));
        Ball ball = new Ball(7);
        Lotto lotto = new Lotto(balls);
        assertThat(lotto.isMatchOneBall(ball)).isFalse();
    }

    @Test
    @DisplayName("두개의 로또가 몇개 일치하는지 테스트 : 5개 일치")
    void matchBetweenLottosTest() {
        List<Ball> winningBalls = Arrays.asList(new Ball(1), new Ball(2), new Ball(3), new Ball(4), new Ball(5), new Ball(6));
        List<Ball> lottoBalls = Arrays.asList(new Ball(1), new Ball(2), new Ball(3), new Ball(4), new Ball(5), new Ball(10));
        WinnerLotto winnerLotto = new WinnerLotto(new Lotto(winningBalls), new Ball(10));
        Lotto lotto = new Lotto(lottoBalls);

        int matchBallCount = lotto.countMatchBall(winnerLotto.winnerLotto());
        assertThat(matchBallCount).isEqualTo(5);
    }


    @Test
    @DisplayName("로또가 1등 로또와 몇개 일치하는지 count test : 2등")
    void matchCountLottoTest() {
        List<Ball> winningBalls = Arrays.asList(new Ball(1), new Ball(2), new Ball(3), new Ball(4), new Ball(5), new Ball(6));
        WinnerLotto winnerLotto = new WinnerLotto(new Lotto(winningBalls), new Ball(10));

        List<Ball> lottoBalls = Arrays.asList(new Ball(1), new Ball(2), new Ball(3), new Ball(4), new Ball(5), new Ball(10));
        Lotto lotto = new Lotto(lottoBalls);

        int matchCount = lotto.countMatchBall(winnerLotto.winnerLotto());
        Rank resultRank = Rank.findRank(matchCount, lotto.isMatchBonusBall(winnerLotto.bonusBall()));
        assertThat(resultRank.name()).isEqualTo("SECOND");
    }

    @Test
    @DisplayName("로또가 1등 로또와 몇개 일치하는지 count test : 1등")
    void matchCountFirstLottoTest() {
        List<Ball> winningBalls = Arrays.asList(new Ball(1), new Ball(2), new Ball(3), new Ball(4), new Ball(5), new Ball(6));
        WinnerLotto winnerLotto = new WinnerLotto(new Lotto(winningBalls), new Ball(10));

        List<Ball> lottoBalls = Arrays.asList(new Ball(1), new Ball(2), new Ball(3), new Ball(4), new Ball(5), new Ball(6));
        Lotto lotto = new Lotto(lottoBalls);

        int matchCount = lotto.countMatchBall(winnerLotto.winnerLotto());
        Rank resultRank = Rank.findRank(matchCount, lotto.isMatchBonusBall(winnerLotto.bonusBall()));
        assertThat(resultRank.name()).isEqualTo("FIRST");
    }
}
