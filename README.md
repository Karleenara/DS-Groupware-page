# Groupware 관리 페이지
  
 
  
 ### ⚙  
> 사용 기술 스택: Java, Spring Boot, Thymeleaf, Mybatis, postgresql
> 
> 배포 : public Cloud GCP, Docker, Github, jenkins
  
gcp, docker, jenkins를 통해 배포를 완료했었고, 현재는 로컬로만 가능
  
<br/>  

### 🛠 DB 설계하기
user, hobby, opperhobby, dept 네 개의 테이블로 구성하였다.
  
<br/>

| 테이블 논리명 | 사용자 |  |  |  |
| --- | --- | --- | --- | --- |
| 테이블 물리명 | USER |  |  |  |
| NO | 컬럼논리명 | 컬럼물리명 | 데이터타입 |  |
| 1 | 사용자ID | USER_ID | VARCHAR | 20 |
| 2 | 사원명 | USER_NM | VARCHAR | 20 |
| 3 | 사용자이메일 | USER_EML_ADDR | VARCHAR | 100 |
| 4 | 사용자전화번호 | USER_TELNO | VARCHAR | 11 |
| 5 | 사용자주소 | USER_ADDR | VARCHAR | 17 |
| 6 | 취미번호 | USER_HOBBY_NO | NUMERIC | 10 |
| 7 | 부서번호 | USER_DEPT_NO | NUMERIC | 2 |
| 8 | 승인여부 | USER_APRV_YN | CHAR | 1 |

| 테이블 논리명 | 취미 |  |  |
| --- | --- | --- | --- |
| 테이블 물리명 | HOBBY |  |  |
| NO | 컬럼논리명 | 컬럼물리명 |  |
| 1 | 취미번호 | HOBBY_NO | NUMERIC(10) |
| 2 | 취미명 | HOBBY_NM | VARCHAR(20) |


| 테이블 논리명 | 취미운영데이터 |  |  |
| --- | --- | --- | --- |
| 테이블 물리명 | OPERHOBBY |  |  |
| NO | 컬럼논리명 | 컬럼물리명 |  |
| 1 | 취미번호 | OPER_HOBBY_CD | NUMERIC(10) |
| 2 | 운영번호 | OPER_NO | NUMERIC(10) |
| 3 | 사용자ID | OPER_USER_ID | VARCHAR(20) |

| 테이블 논리명 | 부서 |  |  |
| --- | --- | --- | --- |
| 테이블 물리명 | DEPT |  |  |
| NO | 컬럼논리명 | 컬럼물리명 |  |
| 1 | 부서번호 | DEPT_NO | NUMERIC(10) |
| 2 | 부서명 | DEPT_NM | VARCHAR(20) |
| 3 | 소속명 | DEPT_OGDP_NM | VARCHAR(20) |
| 4 | 깊이 |  |  |
  
  <br/>
  
![](https://velog.velcdn.com/images/karleenara/post/1204230d-7b68-48df-82a6-e8397668353a/image.png)
  
  <br/>
  
### 👩 사용자 페이지
사용자 등록을 위해 사용자가 ID, 이름, 메일, 취미를 작성해서 등록 신청을 할 수 있는 화면
  
 <br/>
- 부서는 group 내에 존재하는 부서들을 select box로 보여주기
- 취미는 중복 선택 가능
  
![](https://velog.velcdn.com/images/karleenara/post/55d22619-8ccc-4caf-ad61-351a84d28f87/image.png)
  
  <br/>
  
### 👩‍🔧 관리자 페이지
사용자 포털에서 신청한 사용자에 대해 가입 승인 및 사용자 정보를 삭제, 수정 등 관리할 수 있는 화면


- 사용자 이름으로 검색
  > 이름이 포함된 사용자 리스트 보여주기


  > 이름 클릭으로 상세정보 보여주기
- 저장을 누르면 자동으로 승인상태를 Y로 변경
- 회원 정보들을 수정한 후 저장을 누르면 정보 변경
- 삭제 기능

![](https://velog.velcdn.com/images/karleenara/post/03e6bb68-7e0d-4bf9-a0dd-137a4b352328/image.png)

![](https://velog.velcdn.com/images/karleenara/post/a10857af-7f06-47a2-a7a3-96844549c824/image.png)
  
</br>
<br/>
  
#### ❗ 외래키 참조 문제
- 서로 연관되어져 있는 테이블에 cascade 조건 추가하기
  
#### ❗ 배포 문제
- docker logs [conteiner] 명령어 입력해서 오류 해결한 후 컨테이너 삭제하고 재빌드하기
- 재빌드가 안될 때 chmod 666 /var/run/docker.sock 명령어 입력 후 시도해보기
