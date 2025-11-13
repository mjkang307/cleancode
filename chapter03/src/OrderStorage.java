package CleanCode.Chap03;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * 주문 데이터 저장 (Mock)
 */
public class OrderStorage {
    public String store(String userId, String itemId, int qty, BigDecimal total) {
        String orderId = UUID.randomUUID().toString();
        System.out.printf("SAVE: order=%s user=%s item=%s qty=%d total=%s%n",
                orderId, userId, itemId, qty, total);
        return orderId;
    }
}
