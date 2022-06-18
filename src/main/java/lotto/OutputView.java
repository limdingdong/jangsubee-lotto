package lotto;

import java.util.Arrays;
import java.util.Formatter;
import java.util.List;

public class OutputView {

    String format = "%d개 일치 (%d원) - %d 개";

    public void printLotto(List<List> lottos){
        lottos.forEach(System.out::println);
    }

    public void printResult(int[] result, Double yield) {
        System.out.println("당첨 통계");
        System.out.println("--------");
        System.out.println(String.format(format, 3, Prize.THREE.getPrice(), result[3]));
        System.out.println(String.format(format, 4, Prize.FOUR.getPrice(), result[4]));
        System.out.println(String.format(format, 5, Prize.FIVE.getPrice(), result[5]));
        System.out.println(String.format(format, 6, Prize.SIX.getPrice(), result[6]));
        System.out.println(String.format("총 수익률은 %.2f입니다.", yield));

    }
}
