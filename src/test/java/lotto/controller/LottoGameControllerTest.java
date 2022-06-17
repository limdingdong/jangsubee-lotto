package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameControllerTest {

    @Test
    @DisplayName("로또를 로또 갯수만큼 만든다. 로또 갯수 = 1")
    void createLottoTest() {
        List<Lotto> lottoBasket = new ArrayList<>();

        for (int i = 0; i < 1; i++) {
            Lotto lotto = LottoService.createLotto();
            lottoBasket.add(lotto);
        }
        assertThat(lottoBasket.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("로또를 로또 갯수만큼 만든다. 로또 갯수 = 5")
    void createLottoFiveTest() {
        List<Lotto> lottoBasket = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Lotto lotto = LottoService.createLotto();
            lottoBasket.add(lotto);
        }
        assertThat(lottoBasket.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("로또를 로또 갯수만큼 만든다. 로또 갯수 = 10")
    void createLottoTenTest() {
        List<Lotto> lottoBasket = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Lotto lotto = LottoService.createLotto();
            lottoBasket.add(lotto);
        }
        assertThat(lottoBasket.size()).isEqualTo(10);
    }


}
