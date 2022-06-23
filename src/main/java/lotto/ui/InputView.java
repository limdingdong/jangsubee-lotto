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

    public static String inputFirstLottoNumber(){
        System.out.println("1등 당첨번호를 입력해주세요.");
        return sc.nextLine();
    }

    public static int inputBonusBall(){
        System.out.println("bonus ball number 입력해주세요.");
        return sc.nextInt();
    }

}
