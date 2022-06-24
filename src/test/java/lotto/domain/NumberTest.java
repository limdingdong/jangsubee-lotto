package lotto.domain;

import exception.InputDataErrorCode;
import exception.InputDataException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberTest {

    @Test
    @DisplayName("음수 입력받으면 에러")
    void negativeTest() {
        int inputNumber = -1;
        Assertions.assertThatThrownBy(() -> new Number(inputNumber))
                .isInstanceOf(InputDataException.class)
                .hasMessageContaining(InputDataErrorCode.INPUT_NOT_NEGATIVE_NUMBER.errorMessage());
    }

    @Test
    @DisplayName("양수 입력받으면 정상")
    void positiveTest() {
        int inputNumber = 1;
        Number number = new Number(inputNumber);
        Assertions.assertThat(number.number()).isEqualTo(1);
    }
}
