# ⚾ 야구게임

## 📌 게임 규칙  
- **0부터 9까지 서로 다른 수로 이루어진 n(1~5)자리의 수**를 맞추는 게임  
- 같은 수가 같은 자리에 있으면 **스트라이크**, 다른 자리에 있으면 **볼**  
- **힌트를 이용하여 먼저 상대방(컴퓨터)의 숫자를 맞추면 승리**  

---

## 🛠 설계 원칙  
유지보수성과 가독성을 높여 보다 **객체 지향적인 설계**를 적용  

### 1️⃣ 객체별 책임 분리  
각 클래스는 하나의 주요 책임을 가지도록 설계하여 **결합도를 낮추고, 응집도를 높이는 구조**를 구현  
→ **수정 및 확장이 용이하며, 유지보수성이 향상됨**  

### 2️⃣ 명확한 역할 분담 및 가독성 향상  
클래스별 역할을 명확히 구분하여 **코드의 흐름을 직관적으로 이해**할 수 있도록 함  
→ **가독성과 유지보수성을 향상**  

### 📌 클래스별 역할  
- **Computer** → 랜덤 숫자를 생성하여 게임의 정답을 결정  
- **Player** → 사용자의 입력을 처리하고 검증  
- **Referee** → 사용자의 입력값과 정답을 비교하여 결과를 판정  
- **Result** → 판정된 결과를 저장하고 출력  
- **GameManager** → 전체 게임의 흐름을 관리하고 조율  

---

## 🔄 설계 변화 과정  

### 🏁 1. 초기 버전 - 단일 클래스 구조  
- 모든 기능을 하나의 **Main 클래스**에 구현  
- 기능 분리가 없어 코드가 길고, 유지보수가 어려움  
- 코드 수정 시 **다른 기능에 영향을 줄 가능성**이 높음  

### 🔧 2. 두 번째 버전 - MVC 패턴 적용 시도  
- **Model, View, Controller** 구조를 도입하여 코드 분리  
- 하지만, **View의 역할이 MVC 패턴과 잘맞지 않았다**  
- 코드의 명확성이 많이 떨어짐  

### 🚀 3. 현재 버전 - 객체 지향적인 역할 분리  
- **각 객체의 역할을 명확하게 분리**하여 책임을 단순화  
- 유지보수성과 가독성이 크게 향상됨  
- 추가 기능을 쉽게 확장할 수 있는 구조  


---

## 🎮 게임 흐름  

1. **컴퓨터가 랜덤한 1~5자리 숫자를 생성** (중복 없음)  
2. **사용자가 동일한 길이의 숫자를 입력** (예외 처리 포함)  
3. **Referee가 입력값을 판별하여 스트라이크, 볼 개수 계산**  
   - **스트라이크**: 숫자와 위치가 모두 맞음  
   - **볼**: 숫자는 맞지만 위치가 다름  
4. **정답을 맞히면 게임 종료, 다시 할지(Y/N) 선택**  
   - Y 입력 시 새로운 게임 시작  
   - N 입력 시 게임 완전 종료  

![FlowChart drawio](https://github.com/user-attachments/assets/f30e847a-fd6e-487c-8b1c-4e0e8c829e95)  

---

## 🏗 기능 구현  

### 🔹 1. Computer 클래스 (랜덤 숫자 생성)  
- 1~5자리 **중복 없는 랜덤 숫자 생성**  
- 생성된 숫자를 저장하고 반환  
- 숫자의 길이를 반환  

### 🔹 2. Player 클래스 (사용자 입력 및 예외 처리)  
- 사용자로부터 입력을 받고 **예외 처리**  
- 입력 값 검증  
  - **빈 값 입력 방지**  
  - **숫자만 입력하도록 제한**  
  - **컴퓨터가 만든 숫자 길이와 동일한지 확인**  
  - **중복된 숫자가 있는지 확인**  

### 🔹 3. Referee 클래스 (결과 판별)  
- 컴퓨터의 숫자와 사용자의 입력을 비교  
- 스트라이크, 볼 개수 판별  

### 🔹 4. Result 클래스 (게임 결과 저장 및 출력)  
- 스트라이크와 볼 개수를 저장  
- 결과를 문자열로 변환하여 출력  
- 사용자가 정답을 맞혔는지 확인  

### 🔹 5. GameManager 클래스 (게임 진행 & 로직 관리)  
- 게임 전체의 흐름을 관리  
- **게임 진행 순서**  
  - 컴퓨터의 랜덤 숫자 생성  
  - 사용자 입력  
  - 결과 판별  
  - 정답 확인  
- 게임이 끝난 후 다시 할지(Y/N) 묻고 처리  

### 🔹 6. Main 클래스 (게임 실행)  
- 게임 실행을 시작하는 **진입점**  
- `GameManager` 객체를 생성하여 `startGame()` 호출  










