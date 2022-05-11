package lotto;

import java.util.Arrays;
import java.util.List;

public class OutputView {

    public void printLotto(List<List> lottos){
        lottos.forEach(System.out::println);
    }
}
