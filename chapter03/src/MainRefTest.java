package CleanCode.Chap03;

/**
 * CheckoutService 리팩터링 검증 테스트
 */
public class MainRefTest {
    public static void main(String[] args) {
        var service = new CheckoutService();

        System.out.println("=== [1] 정상 케이스 ===");
        try {
            String result = service.process("vip001 , A-100 , 2 , COUPON10");
            System.out.println("RECEIPT=" + result);
        } catch (Exception e) {
            System.out.println("FAIL: 예외 발생 → " + e.getMessage());
        }

        System.out.println("\n=== [2] 검증 실패 ===");
        try {
            service.process(" , A-100 , -1 , ");
        } catch (ValidationException e) {
            System.out.println("PASS: ValidationException 발생 → " + e.getMessage());
        }

        System.out.println("\n=== [3] 재고 부족 ===");
        try {
            service.process("user01 , B-200 , 99 , ");
        } catch (OutOfStockException e) {
            System.out.println("PASS: OutOfStockException 발생 → " + e.getMessage());
        }

        System.out.println("\n=== [4] 포맷 오류 ===");
        try {
            service.process("user01,");
        } catch (ValidationException e) {
            System.out.println("PASS: ValidationException 발생 → " + e.getMessage());
        }

        System.out.println("\n=== [5] 일반 사용자 (비VIP, 쿠폰 없음) ===");
        try {
            String result = service.process("userX , B-300 , 3 , ");
            System.out.println("RECEIPT=" + result);
        } catch (Exception e) {
            System.out.println("FAIL: 예외 발생 → " + e.getMessage());
        }

        System.out.println("\n=== 테스트 종료 ===");
    }
}
