package CleanCode.Chap03;

import java.math.BigDecimal;

/**
 * 상품 가격 + 배송비 + 추가 요금 계산
 */
public class PricingPolicy {
    private static final int PRICE_A = 100;
    private static final int PRICE_B = 150;
    private static final int SHIP_A = 500;
    private static final int SHIP_B = 1200;
    private static final int UNIT_WEIGHT = 2;
    private static final int EXTRA_THRESHOLD = 10;
    private static final int EXTRA_FEE = 800;

    public BigDecimal calculate(String itemId, int qty) {
        int base = itemId.startsWith("A") ? PRICE_A : PRICE_B;
        int shipping = itemId.startsWith("A") ? SHIP_A : SHIP_B;
        int totalWeight = qty * UNIT_WEIGHT;
        int extra = (totalWeight > EXTRA_THRESHOLD) ? EXTRA_FEE : 0;

        return BigDecimal.valueOf(base)
                .multiply(BigDecimal.valueOf(qty))
                .add(BigDecimal.valueOf(shipping))
                .add(BigDecimal.valueOf(extra));
    }
}
