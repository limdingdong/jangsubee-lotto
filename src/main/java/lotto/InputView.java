package lotto;

import java.io.IOException;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    // 티켓 구매
    public int buy() throws IOException {
        System.out.println("구입 금액을 입력해주세요.");
        Scanner sc = new Scanner(System.in);

        Long purchaseAmount = sc.nextLong();
        int count = (int) (purchaseAmount/1000);

        System.out.println( count + "개를 구입했습니다.");

        return count;
    }

    public List<Integer> inputWinningNumber() throws IOException{
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        return Arrays.stream(str.split(",")).map(item -> Integer.valueOf(item.trim())).collect(Collectors.toList());

    }
}
