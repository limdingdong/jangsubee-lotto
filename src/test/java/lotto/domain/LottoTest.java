package lotto.domain;

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
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("비어있는 로또 데이터를 넣지 않았을 경우")
    void notInputDataLottoTest() {
        assertThatThrownBy(() -> new Lotto(new ArrayList<>()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복된 로또 데이터가 있을 경우")
    void inputDuplicationLottoDataTest() {
        assertThatThrownBy(() -> {
            List<Ball> balls = Arrays.asList(new Ball(1), new Ball(2), new Ball(3), new Ball(4), new Ball(6), new Ball(6));
            Lotto lotto = new Lotto(balls);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정상적으로 로또 데이터를 입력했을 경우")
    void inputLottoDataTest() {
        List<Ball> balls = Arrays.asList(new Ball(1), new Ball(2), new Ball(3), new Ball(4), new Ball(5), new Ball(6));
        Lotto lotto = new Lotto(balls);
        assertThat(lotto.balls().size()).isEqualTo(6);
    }
}
