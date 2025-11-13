package CleanCode.Chap03;

/**
 * 기본 입력 검증 로직
 */
public class Validator {
    public void check(CheckoutRequest req) {
        if (req.userId() == null || req.userId().isBlank()) {
            throw new ValidationException("USER_REQUIRED");
        }
        if (req.itemId() == null || req.itemId().isBlank()) {
            throw new ValidationException("ITEM_REQUIRED");
        }
        if (req.quantity() <= 0) {
            throw new ValidationException("INVALID_QUANTITY");
        }
    }
}
