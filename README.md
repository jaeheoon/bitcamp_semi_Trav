## 비트캠프 세미 프로젝트 - 여행 관리 프로그램
### (bitcamp_semi_Trav)

>- 목차
>1. 프로젝트 목적
>   - 목표
>   - 구현목표
>   - 프로젝트 정보
>2. 유스케이스 모델링
>3. ERD
>4. 테이블정의서
>5. 실행화면

## 🛠️ 개발 환경

- **프로그래밍 언어**: Java
- **IDE**: Eclipse
- **DBMS**: Oracle Database
- **SQL 툴**: SQL Developer
- **버전 관리**: GitHub

## ✨ 프로젝트 목적
### 목표: java 문법 복습 및 git 협업 활용 연습(CLI 환경)
### 주제 : 코로나 이후 활발해진 여행 시장에서 다양한 경험 공유를 위해 여행 플랫폼 제작
#### 구현목표
|  대분류  |                         중분류                         |                                              소분류                                             |
|:-----:|:---------------------------------------------------:|:------------------------------------------------------------------------------------------:|
| 회원가입  |                    회원가입<br/>로그인                  |             로컬 회원가입 (아이디, 비밀번호, 이름, 휴대폰번호, 주소 순으로 )                         |
|  여행지  |                     여행지 검색 및 목록 확인             |             여행지 검색(이름, 설명, 대륙별), 여행지 리스트 확인                                      |
|  관리자  |                     회원 관리 및 여행지 관리             |             여행지 추가, 수정, 삭제 및 회원 리스트 확인                                             |
|  게시판  |            게시글 CRUD<br/>평점 남기기 및 수정           |             게시글 작성, 조회, 수정, 삭제 <br/> 여행지 평점 적용 및 여행지별 평점 확인                |
| 메인화면  |                     각 메뉴 이동          	            |             로그인 객체 별 메뉴 변경 <br/> 관리자 메뉴 <br/> 일반 사용자 메뉴                        |

#### UseCase
![유스케이스](https://github.com/user-attachments/assets/99487964-db7e-42f3-8c9f-6fd9f665302d)

#### ERD-DIAGRAM
![ERD](https://github.com/user-attachments/assets/0d6958c1-d9e1-4385-b6e4-00417333b653)

#### 테이블 정의서
![테이블정의서](https://github.com/user-attachments/assets/e74e0459-9d5f-40b8-a628-292143c6e895)

#### 실행 화면
1. 회원 가입
![회원가입](https://github.com/user-attachments/assets/1899ab80-ab15-4492-8b2b-a167a67b9215)
2. 회원 기능
![회원기능](https://github.com/user-attachments/assets/1c4fa4cc-10a2-4f2b-8d36-0ea094eaf0d2)
3. 여행지 목록 및 검색(이름, 설명, 대륙별)
![여행지목록및검색](https://github.com/user-attachments/assets/f5bc6e0d-3d56-4371-b19e-08500d108b8e)
4. 게시판 목록 및 검색(작성자, 내용, 여행지별)
![게시판목록및검색](https://github.com/user-attachments/assets/0d3dade3-e21a-4f74-8262-0dace15920d7)
5. 게시판 작성 및 삭제
![게시판작성및삭제](https://github.com/user-attachments/assets/04753c8f-164f-4fbc-b5cb-9d5f80a2599c)
6. 게시판 수정
![게시판수정](https://github.com/user-attachments/assets/8db9e8d2-2927-4ee2-9c7f-cd46603e43ac)
7. 관리자 모드
![관리자모드](https://github.com/user-attachments/assets/84e46681-f6d1-4172-b826-29d6296bb11b)
8. 관리자 회원 리스트 보기 및 여행지 추가
![관리자회원리스트및여행지추가](https://github.com/user-attachments/assets/707e3b4f-3999-4d96-9243-809f14861809)
9. 관리자 여행지 수정
![여행지수정](https://github.com/user-attachments/assets/6733666d-a9bf-4897-856c-665ba99502b7)
10. 관리자 여행지 삭제
![여행지삭제](https://github.com/user-attachments/assets/a27c5ae8-c97a-4543-991f-3b1f80ea2778)
