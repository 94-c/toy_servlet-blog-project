# 블로그 만들기 

## ERD
![123](https://user-images.githubusercontent.com/79362952/178654563-e5edfdfc-fc68-47dc-96e9-30459131e1fa.png)

## 예상 시나리오
1. 로그인 시
   1. 회원가입 및 로그인 
      1. 이메일 중복체크, 비밀번호 체크
      2. 회원가입 후, 해당 이메일로 회원가입 확인(Token 발행) 관련한 메일 발송
          1. 이메일 확인 전, email_tokens > state = 0(비회원) 등록
          2. 이메일 확인 후, email_tokens > state = 1(회원) 변환
   2. 포스트 CRUD 전체 사용 가능
   3. 댓글 CRUD 전체 사용 가능
   4. 태그 C,R 사용 가능 


2. 비로그인 시
   1. 포스트 CRUD 전체 사용 가능
      1. 단, 비로그인으로 글 작성 시, 글의 비밀번호 입력 예정
         * DB의 추후 등록 예정
      2. 글 등록 시, 비밀번호로 제한적으로 활용 예정

3. 공용
   1. 비밀번호 분실 시, 해당 이메일로 발생


4. 이메일 관련
    * https://mailtrap.io/inboxes
    * http://www.gisdeveloper.co.kr/?p=6916

------------

## 서비스 구조
![blog_project](https://user-images.githubusercontent.com/79362952/178541973-a3e23f6b-6710-45c2-a63c-a20b5ec29583.png)

1. 클라이언트 작동
2. URL로 접근하여 해당 정보 요청(Request)
3. 해당 요청에 매핑한 컨트롤러 확인
4. 해당 요청 Url에 따라 적절한 view 및 mapping 처리
5. 해당 정보에 대하여 DB에서 데이터를 얻어 Controller 및 Service으로 보낼 때 사용
6. 해당 요청에 대한 비즈니스 로직 실행
7. 실제로 DB 접근하는 객체
8. 실제 DB와 일대일 매칭 클래스
9. 프로그램에 모든 데이터 관리
10. 역순으로 다시 클라이언트에게 정보 전달

-----------

