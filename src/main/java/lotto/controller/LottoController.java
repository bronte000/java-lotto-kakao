package lotto.controller;

import lotto.model.*;
import lotto.model.dto.LottoResultDto;
import lotto.model.dto.LottoTicketDto;
import lotto.view.Input;
import lotto.view.Output;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    public static void play() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(Input.getPurchaseAmount());
        validatePurchaseAmount(purchaseAmount);
        int manualPurchaseCount = Input.getManualPurchaseCount();
        validateMnaualPurchaseCount(purchaseAmount, manualPurchaseCount);
        LottoTickets lottoTickets = buyLottoTickets(purchaseAmount, manualPurchaseCount);

        Output.printPurchaseCount(manualPurchaseCount, lottoTickets.getSize() - manualPurchaseCount);
        Output.printLottoTickets(parseDto(lottoTickets));

        LottoTicket winningTicket = parseLottoTicket(Input.getWinningTicket());
        LottoNumber bonusNumber = new LottoNumber(Input.getBonusNumber());
        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(winningTicket, bonusNumber);

        LottoResult lottoResult = lottoTickets.makeWinningResult(winningLottoTicket);
        Output.printResult(new LottoResultDto(lottoResult.calculateReturnRate(purchaseAmount), lottoResult.makeLottoResultMap()));
    }

    private static void validatePurchaseAmount(PurchaseAmount purchaseAmount) {
        if (purchaseAmount.getPurchaseAmount() < LottoTicket.PRICE) {
            throw new IllegalArgumentException("구매 금액은 최소 1,000원 이상이어야 합니다.");
        }
    }

    private static void validateMnaualPurchaseCount(PurchaseAmount purchaseAmount, int manualPurchaseCount) {
        if (purchaseAmount.getPurchaseAmount() < (long) manualPurchaseCount * LottoTicket.PRICE) {
            throw new IllegalArgumentException("수동으로 구매할 로또 수가 구매 금액보다 많습니다.");
        }
    }

    private static LottoTicket parseLottoTicket(String lottoTicket) {
        return Arrays.stream(lottoTicket.split(", "))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), LottoTicket::new));
    }

    private static List<LottoTicketDto> parseDto(LottoTickets lottoTickets) {
        return lottoTickets.getLottoTickets()
                .stream()
                .map(LottoTicketDto::new)
                .collect(Collectors.toList());
    }

    public static LottoTickets buyLottoTickets(PurchaseAmount purchaseAmount, int manualCount) {
        List<LottoTicket> lottoTicketList = Input.getManualLottoTickets(manualCount).stream()
                .map(LottoController::parseLottoTicket)
                .collect(Collectors.toList());

        purchaseAmount.spend((long) manualCount * LottoTicket.PRICE);
        LottoTickets lottoTickets = new LottoTickets(lottoTicketList);
        lottoTickets.add(LottoTicketGenerator.generate(purchaseAmount));
        return lottoTickets;
    }
}
