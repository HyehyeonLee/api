# RESTful API 연습
RESTful API 연습<br />
Spring Boot 2.7.7, PostgreSQL 14.6, Gradle, JAVA 1.8, lombok, myBatis, Swagger
<br />
<br />

## HTTP Method
<ul>
  <li>POST - CREATE</li>
  <li>GET - SELECT</li>
  <li>PUT - UPDATE</li>
  <li>DELETE - DELETE</li>
</ul>
<br />

## 에러 처리
HTTP Response Code를 사용한 후 Response Body에 Error detail을 서술하는 것이 좋음
<ul>
  <li>200 - 성공</li>
  <li>400 - Bad Request : Field Validation 실패 시</li>
  <li>401 - Unauthorized : API 인증, 인가 실패</li>
  <li>404 - Not found : 해당 리소스가 없음</li>
  <li>500 - Internal Server Error : 서버 에러</li>
</ul>
