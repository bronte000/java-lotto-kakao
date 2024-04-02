package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {

    @Test
    void 로또_티켓을_담는다() {

        List<LottoTicket> lottoTicketList = List.of(
                new LottoTicket(List.of(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6)
                )),
                new LottoTicket(List.of(
                        new LottoNumber(7),
                        new LottoNumber(8),
                        new LottoNumber(9),
                        new LottoNumber(10),
                        new LottoNumber(11),
                        new LottoNumber(12)
                ))
        );
        LottoTickets lottoTickets = new LottoTickets(lottoTicketList);

        assertThat(lottoTickets.getSize()).isEqualTo(lottoTicketList.size());
    }
}
