package CleanCode.Chap03;

/**
 * 재고 확인 로직
 */
public class InventoryChecker {
    private static final int MAX_STOCK = 20;

    public void verify(CheckoutRequest req) {
        if (req.quantity() > MAX_STOCK) {
            throw new OutOfStockException("OUT_OF_STOCK");
        }
    }
}
