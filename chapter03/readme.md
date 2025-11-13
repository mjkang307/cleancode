# ✨ Clean Code Refactoring Summary

## 🧩 개요
`CheckoutService` 중심으로 리팩터링을 진행하여  
**단일 책임 원칙(SRP)** 과 **명확한 비즈니스 흐름**을 구현했습니다.  
모든 세부 로직은 독립된 클래스로 위임되어 코드의 가독성과 유지보수성이 향상되었습니다.

---

## ✅ 주요 개선 포인트

### 1️⃣ CheckoutService는 오직 흐름만 담당
- 비즈니스 플로우만 담당하며,  
  파싱(`InputParser`), 검증(`Validator`),  
  재고 확인(`InventoryChecker`),  
  가격 계산(`PricingPolicy`),  
  할인 정책(`DiscountPolicy`),  
  저장(`OrderStorage`)은 각각 독립된 클래스에서 수행.  
- 결과적으로 SRP(단일 책임 원칙)를 확실히 준수.

---

### 2️⃣ 예외 처리 일원화
- 기존의 오류코드 반환 로직 제거.  
- `if/else` 분기 대신 예외(`ValidationException`, `OutOfStockException`)로 통일.  
- CheckoutSer
