package lotto.model;

import java.util.*;

public class LottoTicket {

    public static final Long PRICE = 1_000L;
    public static final int SIZE = 6;

    private final SortedSet<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new TreeSet<>(lottoNumbers);
        validateLottoNumbers();
    }

    private void validateLottoNumbers() {
        if (lottoNumbers.size() != SIZE) {
            throw new IllegalArgumentException("로또 번호는 중복 없는 6개의 숫자로 이루어져야 합니다.");
        }
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableSet(lottoNumbers);
    }
}
