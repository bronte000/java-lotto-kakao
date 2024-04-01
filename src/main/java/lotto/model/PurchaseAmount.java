package lotto.model;

import java.util.Objects;

public class PurchaseAmount {
    private long amount;

    public PurchaseAmount(long amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(long amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("구매 금액은 0이하가 될 수 없습니다.");
        }
    }

    public void spend(long spentAmount) {
        amount -= spentAmount;
    }

    public long getPurchaseAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseAmount that = (PurchaseAmount) o;
        return Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
