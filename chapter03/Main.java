package CleanCode.Chap03;

public class Main {
    public static void main(String[] args) {
        CheckoutService checkoutService = new CheckoutService();

        // 정상 케이스
        System.out.println("RECEIPT=" + checkoutService.process("vip001 , A-100 , 2 , COUPON10"));

        // 입력 에러
        try {
            checkoutService.process(" ,A-100,-1,");
        } catch (Exception e) {
            System.out.println("ERROR=" + e.getMessage());
        }
    }
}
