package lotto.service;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {

    @Test
    @DisplayName("로또 생성 테스트")
    void createLottoTest() {
        Lotto lotto = LottoService.createLotto();
        assertThat(lotto.balls().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 2개 생성 테스트")
    void createTwoLottoTest() {
        Lotto lotto = LottoService.createLotto();
        Lotto lotto2 = LottoService.createLotto();
        assertThat(lotto.balls().containsAll(lotto2.balls())).isFalse();
    }

}
