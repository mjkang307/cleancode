package CleanCode.Chap03;

import java.math.BigDecimal;

/**
 * VIP 및 쿠폰 할인 정책
 */
public class DiscountPolicy {
    private static final BigDecimal VIP_RATE = BigDecimal.valueOf(0.9);
    private static final String COUPON_CODE = "COUPON10";

    public BigDecimal apply(BigDecimal amount, boolean isVip, String couponCode) {
        BigDecimal result = amount;

        if (isVip) result = result.multiply(VIP_RATE);
        if (COUPON_CODE.equalsIgnoreCase(couponCode)) {
            result = result.subtract(BigDecimal.TEN);
        }

        return result.max(BigDecimal.ZERO);
    }
}
