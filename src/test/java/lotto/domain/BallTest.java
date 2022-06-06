package lotto.domain;

import exception.InputDataErrorCode;
import exception.InputDataException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallTest {

    @Test
    @DisplayName("1이상 45이하 로또 번호가 들어오지 않았을 경우")
    void inputNumberErrorTest() {
        assertThatThrownBy(() ->
                new Ball(new Number(0)))
                .isInstanceOf(InputDataException.class)
                .hasMessageContaining(InputDataErrorCode.INVALID_RANGE_LOTTO_NUMBER.errorMessage());
    }

    @Test
    @DisplayName("1이상 45이하 로또 번호일 경우")
    void inputNumberTest() {
        Ball ball = new Ball(1);
        assertThat(ball.number()).isEqualTo(1);
    }

}
