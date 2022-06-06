package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SellerTest {

    @Test
    @DisplayName("판매한 로또 기능 테스트")
    void sellLottoTest(){
        int lottoCount = Seller.sellLotto(15000);
        assertThat(lottoCount).isEqualTo(15);
    }

}
