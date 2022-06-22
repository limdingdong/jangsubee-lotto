package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameServiceTest {

    @Test
    @DisplayName("lottoCount만큼 Lotto 생성이 되었는지 확인")
    void createLottoTest(){
        LottoGameService lottoGameService = new LottoGameService(5);

    }

}
