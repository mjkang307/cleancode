package CleanCode.Chap03;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * CheckoutService
 * ----------------------------
 * 1. 비즈니스 플로우만 담당: 파싱 → 검증 → 재고확인 → 계산 → 저장
 * 2. 세부 계산 및 검증 로직은 각각 별도 객체에 위임
 * 3. 예외 기반 오류 처리 (코드 반환 X)
 * 4. DTO(불변 record) 기반으로 명확한 입력·출력 전달
 */
public class CheckoutService {
    private final InputParser parser = new InputParser();
    private final Validator validator = new Validator();
    private final InventoryChecker inventory = new InventoryChecker();
    private final PricingPolicy pricing = new PricingPolicy();
    private final DiscountPolicy discount = new DiscountPolicy();
    private final OrderStorage repository = new OrderStorage();

    public String process(String rawInput) {
        CheckoutRequest req = parser.toRequest(rawInput);
        validator.check(req);
        inventory.verify(req);

        BigDecimal baseTotal = pricing.calculate(req.itemId(), req.quantity());
        BigDecimal discounted = discount.apply(baseTotal, req.isVip(), req.couponCode());

        String orderId = repository.store(req.userId(), req.itemId(), req.quantity(), discounted);
        return new Receipt(orderId, req.userId(), req.itemId(), req.quantity(), discounted).toString();
    }
}

/* ==========================
   DTO
   ========================== */
record CheckoutRequest(String userId, String itemId, int quantity, boolean isVip, String couponCode) {}
record Receipt(String orderId, String userId, String itemId, int quantity, BigDecimal totalAmount) {
    @Override
    public String toString() {
        return String.format("OK:%s:%s:%s:%d:%s", orderId, userId, itemId, quantity, totalAmount);
    }
}
