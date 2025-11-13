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
- CheckoutService는 “성공하거나 예외를 던지거나” 두 가지 흐름만 유지.

---

### 3️⃣ DTO(Record) 기반의 명확한 입출력 구조
- `CheckoutRequest`, `Receipt`를 **Java Record**로 정의하여  
  불변성(Immutable)과 명확한 데이터 전달 구조 확보.  
- 외부 부작용(Side Effect) 제거.

---

### 4️⃣ 매직 넘버 상수화 및 정책 캡슐화
- 가격, 배송비, 가중치 등의 매직 넘버를 상수로 정의.  
- 가격 정책(`PricingPolicy`)과 할인 정책(`DiscountPolicy`)을  
  별도의 정책 클래스로 분리하여 변경 용이성 확보.

---

### 5️⃣ 독립적인 테스트 설계
- `MainRefTest`에서 각 예외 케이스를 **독립적으로 검증**.  
- 정상 시나리오, 검증 실패, 재고 부족, 포맷 오류, 비VIP 케이스 등  
  명확히 분리된 단위 테스트 흐름을 구성.

---

### 6️⃣ 명확한 패키지 구조 및 읽히는 코드
- `CleanCode.Chap03` 패키지 내부에서 역할별 클래스로 구분.  
- Checkout 흐름이 “이야기처럼” 자연스럽게 읽히도록 구조화.  
- 유지보수자가 비즈니스 플로우를 빠르게 이해할 수 있는 형태로 개선.

---

## 📁 주요 클래스 구조
CleanCode/Chap03/
├── Main.java
├── CheckoutService.java
├── InputParser.java
├── Validator.java
├── InventoryChecker.java
├── PricingPolicy.java
├── DiscountPolicy.java
├── OrderStorage.java
├── Exceptions.java
└── MainRefTest.java

