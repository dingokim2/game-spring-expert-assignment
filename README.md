# 🎮 게임 서버 개발 과제 프로젝트 (부트캠프)

## 📌 1. 프로젝트 개요
- **설명:** 부트캠프 과정 중 제공된 베이스 코드를 바탕으로, 누락된 비즈니스 로직과 API를 완성한 WebCraft게임 서버 개발 프로젝트입니다.
- **진행 기간:** 2026.09.16 ~ 2026.09.22

---

## 🛠 2. 기술 스택
- **Language:** Java 21
- **Framework:** Spring Boot
- **Database:** MySQL / Redis
- **Build Tool:** Gradle

---

## ✨ 3. 주요 구현 기능 (My Work)
과제 매뉴얼과 API 명세서에 따라 다음 항목들을 구현 및 완성했습니다.
- [x] Lv 1. Docker로 MySQL과 Redis 설정

- [x] Lv 2. SQL을 JPA 인덱스로 표현하기

- [x] Lv 3. 요청 검증과 DTO: 플레이어 등록

- [x] Lv 4. 월드 생성

- [x] Lv 5. 채팅 저장과 내역 조회

- [x] Lv 6. 최근 채팅 조회 API 구현

- [x] Lv 7. WebSocket 연결과 사용자 식별

- [x] Lv 8. HandshakeInterceptor 등록

- [x] Lv 9. 월드별 WebSocket 세션 관리

- [x] Lv 10. Redis 접속 상태 관리

- [x] Lv 11. 메시지 라우팅과 Ping/Pong

- [x] Lv 12. 플레이어 이동 요청 처리

- [x] Lv 13. 채팅 요청 처리와 응답 구성

- [x] Lv 14. 같은 월드의 참여자에게 채팅 전송

- [x] Lv 15. 접속자 목록 조회

- [x] Lv 16. 낙관적 락

- [x] Lv 17. 커서 페이지 조회

- [x] Lv 18. Redis 최근 채팅 캐시

- [x] Lv 19. Redis Lua로 채팅 전송 횟수 제한

- [x] Lv 20. Docker Compose로 멀티 서버

---

## 📂 4. 디렉토리 구조
<pre><code>src/main/java/com/gameexpert/
 ┣ chat/      # 채팅 및 메시지 관련 로직
 ┣ common/    # 예외 처리
 ┣ config/    # 설정 파일
 ┣ player/    # 플레이어 관리 및 등록
 ┣ presence/  # 접속 상태 관리
 ┣ trial/     # 시련 스포너 관리
 ┣ world/     # 월드 생성 및 관리
 ┗ ws/        # 웹소켓 연결, 핸들러, 세션 관리</code></pre>

---

 ## 🎮 5. 실행 방법
📋 사전 요구 사항 (Prerequisites)
- Java 21
- MySQL (Port: 3306)
- Redis (Port: 6379)
<br>
<br>
🗄️ 데이터베이스 및 인프라 설정

1. MySQL 설정
   - Port: 3306 (기본 포트)
   - User: root
   - Password: 12345678

2. Redis 설정
   - Port: 6379 (기본 포트)
<br>
<br>
⚙️ 프로젝트 빌드 및 실행

1. 저장소 클론 및 이동
<pre><code>git clone <repository-url>
cd <project-directory></code></pre>

2. 프로젝트 빌드 (Gradle)
<pre><code>./gradlew build</code></pre>

3. 서버 실행
<pre><code>./gradlew bootRun</code></pre>

4. 서버 접속
- 브라우저 주소창에 localhost:8080 입력
 
