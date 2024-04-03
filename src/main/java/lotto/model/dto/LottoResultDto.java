package lotto.model.dto;

import lotto.model.LottoRank;
import lotto.model.LottoResult;

import java.util.HashMap;
import java.util.Map;

public class LottoResultDto {
    private final float returnRate;

    private final Map<LottoRank, Integer> lottoResult;

    public LottoResultDto(float returnRate, Map<LottoRank, Integer> lottoResult) {
        this.returnRate = returnRate;
        this.lottoResult = lottoResult;
    }

    public LottoResultDto(LottoResult lottoResult) {
        this(lottoResult.calculateReturnRate(), makeLottoResultMap(lottoResult));
    }

    private static Map<LottoRank, Integer> makeLottoResultMap(LottoResult lottoResult) {
        Map<LottoRank, Integer> lottoResultMap = new HashMap<>();
        for (LottoRank lottoRank : LottoRank.values()) {
            lottoResultMap.put(lottoRank, 0);
        }
        for (LottoRank lottoRank : lottoResult.getLottoRanks()) {
            lottoResultMap.put(lottoRank, lottoResultMap.get(lottoRank) + 1);
        }
        lottoResultMap.remove(LottoRank.NONE);
        return lottoResultMap;
    }

    public float getReturnRate() {
        return returnRate;
    }

    public Map<LottoRank, Integer> getLottoResult() {
        return lottoResult;
    }
}

