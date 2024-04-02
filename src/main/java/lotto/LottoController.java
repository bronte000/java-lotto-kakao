package lotto;

import lotto.model.LottoTicket;
import lotto.model.LottoTicketGenerator;
import lotto.model.LottoTickets;
import lotto.model.PurchaseAmount;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    public static LottoTickets buyLottoTickets(PurchaseAmount purchaseAmount) {
        int count = (int) purchaseAmount.getPurchaseAmount() / 1000;

        List<LottoTicket> lottoTicketList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoTicketList.add(LottoTicketGenerator.generate());
        }
        return new LottoTickets(lottoTicketList);
    }
}
