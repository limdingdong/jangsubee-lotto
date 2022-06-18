package lotto;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoTest {

    Lotto lotto;

    @BeforeEach
    public void setUp(){
        lotto = new Lotto();
    }
    
    @Test
    public void auto_pick_test(){
        List<List> lottos = lotto.autoPickes(1);
        assertThat(lottos).hasSize(1);

        List lotto = lottos.get(0);
        assertThat(lotto).doesNotContain(0);
        assertThat(lotto).doesNotContain(46);
    }

    @Test
    public void calculateYield_test(){
        int[] result = {13,0,0,1,0,0,0};
        int count = 14;
        Double yield = lotto.calculateYield(result, count);
        assertThat(yield).isEqualTo(0.35);
    }
}
