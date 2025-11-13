package CleanCode.Chap03;

/**
 * 입력 문자열을 구조화된 CheckoutRequest로 변환
 */
public class InputParser {
    public CheckoutRequest toRequest(String raw) {
        if (raw == null || raw.isBlank()) {
            throw new ValidationException("EMPTY_INPUT");
        }

        String[] parts = raw.split(",");
        if (parts.length < 3) {
            throw new ValidationException("INVALID_FORMAT");
        }

        String userId = parts[0].trim();
        String itemId = parts[1].trim();
        String qtyStr = parts[2].trim();
        String coupon = (parts.length >= 4) ? parts[3].trim() : "";

        int qty;
        try {
            qty = Integer.parseInt(qtyStr);
        } catch (NumberFormatException e) {
            throw new ValidationException("INVALID_QTY_NUMBER");
        }

        boolean isVip = userId.toLowerCase().startsWith("vip");
        return new CheckoutRequest(userId, itemId, qty, isVip, coupon);
    }
}
