package lotto;

import lotto.model.*;
import lotto.model.dto.LottoResultDto;
import lotto.model.dto.LottoTicketDto;
import lotto.view.Input;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    public static void play() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(Input.getPurchaseAmount());
        LottoTickets lottoTickets = LottoController.buyLottoTickets(purchaseAmount);

        Output.printPurchaseCount(lottoTickets.getSize());
        Output.printLottoTickets(lottoTickets.getLottoTickets()
                .stream()
                .map(LottoTicketDto::new)
                .collect(Collectors.toList()));

        String winningNumbers = Input.getWinningNumbers();
        int bonusNumber = Input.getBonusNumber();
        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(winningNumbers, bonusNumber);

        LottoResult lottoResult = lottoTickets.getWinningResult(winningLottoTicket);
        Output.printResult(new LottoResultDto(lottoResult.calculateReturnRate(), lottoResult.makeLottoResultMap()));
    }

    public static LottoTickets buyLottoTickets(PurchaseAmount purchaseAmount) {
        int count = (int) purchaseAmount.getPurchaseAmount() / 1000;

        List<LottoTicket> lottoTicketList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoTicketList.add(LottoTicketGenerator.generate());
        }
        return new LottoTickets(lottoTicketList);
    }
}
