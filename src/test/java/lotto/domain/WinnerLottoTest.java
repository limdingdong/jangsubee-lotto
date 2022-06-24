package lotto.domain;

import exception.InputDataErrorCode;
import exception.InputDataException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinnerLottoTest {

    @Test
    @DisplayName("1등 로또와 보너스볼이 존재하는지 확인")
    void makeWinningLottoTest() {
        Lotto lotto = new Lotto(Arrays.asList(new Ball(1), new Ball(2), new Ball(3)
                , new Ball(4), new Ball(5), new Ball(6)));

        Lotto lotto2 = new Lotto(Arrays.asList(new Ball(1), new Ball(2), new Ball(3)
                , new Ball(4), new Ball(5), new Ball(6)));

        WinnerLotto winnerLotto = new WinnerLotto(lotto, new Ball(10));
        assertThat(winnerLotto.winnerLotto().isMatch(lotto2)).isTrue();
    }

    @Test
    @DisplayName("이미 1등로또 안에 있는 볼이 존재하는지 테스트")
    void checkAlreadyExistBonusBallTest() {
        Lotto lotto = new Lotto(Arrays.asList(new Ball(1), new Ball(2), new Ball(3)
                , new Ball(4), new Ball(5), new Ball(6)));

        assertThatThrownBy(() -> {
            new WinnerLotto(lotto, new Ball(1));
        }).isInstanceOf(InputDataException.class)
                .hasMessageContaining(InputDataErrorCode.ALREADY_EXIST_BALL.errorMessage());
    }
}
