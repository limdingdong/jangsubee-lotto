package lotto.ui;

import java.util.Scanner;

public class InputView {

    private static Scanner sc = new Scanner(System.in);

    private InputView() {
    }

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(sc.nextLine());
    }

}
