package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLottoTicket {

    private final LottoTicket lottoTicket;
    private final LottoNumber bonusNumber;

    public WinningLottoTicket(LottoTicket lottoTicket, LottoNumber bonusNumber) {
        validate(lottoTicket, bonusNumber);
        this.lottoTicket = lottoTicket;
        this.bonusNumber = bonusNumber;
    }

    public WinningLottoTicket(List<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
        this(new LottoTicket(lottoNumbers), bonusNumber);
    }

    public WinningLottoTicket(List<Integer> lottoNumbers, int bonusNumber) {
        this(lottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList()), new LottoNumber(bonusNumber));
    }

    public WinningLottoTicket(String lottoNumbers, int bonusNumber) {
        this(Arrays.stream(lottoNumbers.split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList()), bonusNumber);
    }

    private static void validate(LottoTicket lottoTicket, LottoNumber bonusNumber) {
        if (lottoTicket.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 기본 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public LottoRank match(LottoTicket matchingTicket) {
        int matchCount = (int) lottoTicket.getLottoNumbers().stream()
                .filter(matchingTicket::contains)
                .count();
        boolean bonusMatch = matchingTicket.contains(bonusNumber);
        return LottoRank.valueOf(matchCount, bonusMatch);
    }
}
