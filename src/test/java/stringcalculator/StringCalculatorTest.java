package stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    public void setUp(){
        stringCalculator = new StringCalculator();
    }

    /**
     * 1. 빈 문자열 또는 null을 입력할 경우 0을 반환해야 한다. (예 : “” => 0, null => 0)
     */
    @Test
    public void 빈_문자열(){
        assertThat(stringCalculator.calculate("")).isEqualTo(0);
        assertThat(stringCalculator.calculate(null)).isEqualTo(0);
    }

    @Test
    public void 숫자_하나(){
        assertThat(stringCalculator.calculate("1")).isEqualTo(1);
        assertThat(stringCalculator.calculate("0")).isEqualTo(0);
    }

    @Test
    public void 숫자_컴마_합(){
        assertThat(stringCalculator.calculate("1,2")).isEqualTo(3);
        assertThat(stringCalculator.calculate("2:3")).isEqualTo(5);
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(()-> stringCalculator.calculate("2/3"));
    }

    @Test
    public void 구분자지정(){
        assertThat(stringCalculator.calculate("//;\\n1;2;3")).isEqualTo("6");
    }
}
