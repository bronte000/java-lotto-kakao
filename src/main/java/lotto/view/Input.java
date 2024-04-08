package lotto.view;

import lotto.model.LottoNumber;
import lotto.model.LottoTicket;

import java.util.*;
import java.util.stream.Collectors;

public class Input {

    private static final Scanner SCANNER = new Scanner(System.in);

    private Input() {
    }

    public static long getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static int getManualPurchaseCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static List<String> getManualLottoTickets(int count) {
        if (count == 0) {
            return Collections.emptyList();
        }

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> manualLottoTickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            manualLottoTickets.add(SCANNER.nextLine());
        }
        return manualLottoTickets;
    }

    public static String getWinningTicket() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.nextLine();
    }

    public static int getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(SCANNER.nextLine());
    }
}
