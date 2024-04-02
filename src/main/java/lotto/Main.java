package lotto;

import lotto.model.LottoResult;
import lotto.model.LottoTickets;
import lotto.model.LottoWinningNumbers;
import lotto.model.PurchaseAmount;
import lotto.model.dto.LottoResultDto;
import lotto.model.dto.LottoTicketDto;
import lotto.view.Input;
import lotto.view.Output;

import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(Input.getPurchaseAmount());
        LottoTickets lottoTickets = LottoController.buyLottoTickets(purchaseAmount);

        Output.printPurchaseCount(lottoTickets.getSize());
        Output.printLottoTickets(lottoTickets.getLottoTickets()
                .stream()
                .map(LottoTicketDto::new)
                .collect(Collectors.toList()));

        String winningNumbers = Input.getWinningNumbers();
        int bonusNumber = Input.getBonusNumber();
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winningNumbers, bonusNumber);

        LottoResult lottoResult = lottoTickets.getWinningResult(lottoWinningNumbers);
        Output.printResult(new LottoResultDto(lottoResult));
    }
}
