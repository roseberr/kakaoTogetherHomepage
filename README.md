# 솔찬의 같이가치👩‍💻

> **카카오 같이가치의 기능을 참고해서 사용자들이 기부관련 글을 올리면 기부할 수 있는 웹 사이트**

<br/>

~~웹페이지 사이트: http://ec2-15-164-39-73.ap-northeast-2.compute.amazonaws.com:8080/~~
취업완료로 인해 해당 웹사이트를 닫습니다.

# 1. 프로젝트 개요
- **프로젝트 명칭** : 솔찬의 같이가치
- **프로젝트 소개** : 카카오 같이가치의 기능을 모방해서 사용자들이 기부관련 글을 올리면 기부하고 응원할 수 있는 웹 사이트
- **개발 인원** : 1명 (방솔찬)
- **개발 기간** : 2022.07.08~ 09.27
- **개발 목적** : 
  - 회원이 자유롭게 게시글을 등록,수정,삭제할 수있는 게시판
  - 회원 본인에 대한 정보, 직접 작성한 글 목록, 본인의 기부내역을 확인할 수있는 마이페이지
  - 회원이 자유롭게 기부하고 응원할수 있는 기부페이지

- **주요 기능** :
  - 회원 관리 기능 구현
      >- 폼 로그인 / `OAuth 2.0` 로그인 기능
  - 게시판 관리 기능 구현
      >- 카테고리 별 조회,페이징처리,검색,게시글 등록,수정,삭제 
  - `기부, 좋아요, 댓글`  기능 구현
      >- 기부금액 증가, 좋아요수 증가 
      >- 댓글 등록 삭제 기능 
  - 게시물에 `파일 첨부` 기능
      >-  Amazon S3에 파일 저장 
  - 회원 활동 내역 관리 기능 구현
  - 글 `카테고리별/조회순/추천순/최신순` 조회 기능 ->아직 구현 안함 
  - 권한 관리를 통한 접근 제한
  - 관리자에게 문의 메일 전송 기능 -> 아직 구현 안함 
  - 프로그래밍을 통한 웹서버와 데이터베이스 연동
  - 프로그램의 효율과 사용자 편의성을 고려한 디자인 실현 


- **백엔드 개발 언어** : `Java 11`
- **백엔드 개발 환경**
  - `Window 10`
  - `IntelliJ Edu`
  - `SpringBoot`
  - `gradle`
  - `jpa(Spring Data JPA)`
  - `Spring Security`
  - `Oauth 2.0 (naver,google)`
  - `Amazon S3 Oauth`


- **프론트 개발 환경 및 언어**
  - `html5`
  - `css`
  - `thymeleaf`
  - `bootstrap template`
  - `javascript`
  - `jquery`
  
- **데이터베이스** : `H2,MARIA DB`
- **형상관리** : `GitHub`
- **이슈 관리** : `GitHub`


# 2. 프로젝트 요구사항

**주요 사항**
- 폼 로그인 / OAuth 2.0 로그인 기능
- 글 등록 수정 유효성 검사
- 좋아요 기능
- 기부하기 기능
- 게시물 CRUD+파일 첨부 기능
- 글 카테고리별/조회순/추천순/최신순 조회 기능
- 게시물 댓글 기능
- 권한 관리를 통한 접근 제한


## 회원 기능
>-  폼 로그인 / OAuth 2.0 로그인 기능 - `구글로 로그인` / `네이버로 로그인` 기능을 사용할 수 있다.

## 마이페이지 기능
> - 내 회원 정보를 `조회` / `수정`할 수 있다,
- `내가 작성한 게시글` 목록을 조회할 수 있다.
- `내가 작성한 댓글` 목록을 조회할 수 있다.

## 커뮤니티(게시판) 기능
> - 게시판에 글을 올릴때 카테고리를 고를 수 있다. `같이기부` `프로모션`
- 게시판에 `글(이미지 파일 첨부 가능)`을 작성할 수 있다.
- 댓글을 작성할 수 있다.
- 글의 `좋아요`를 누를 수 있다.
- 글을 `최신순`, `카테고리별`로 조회할 수 있다.

## 기부 기능
> - 회원은 기부모집글에 기부할수 있다.
- 회원은 강의를 `등록`/`조회`/`수정`/`삭제` 할 수 있다
- 회원은 기부모집글에 `댓글을 작성` / `좋아요`할 수 있다.

## 권한 관리
> - 회원은 작성한 글과 댓글에서만 수정 삭제가 가능하다.
- 로그인한 사용자 글 작성 권한
- 본인 작성 글에 대한 권한관리

# 3. DB 설계
## ERD

![image](https://user-images.githubusercontent.com/26202424/187957680-004a1309-264e-4eae-99e6-1b8965a8a40d.png)



# 4. API 설계



# 5. 참고사이트
- 스프링 부트와 AWS로 혼자 구현하는 웹서비스
- 인프런 김영한님 스프링 강의
- https://github.com/jylees2/Helpring 


- 아이콘
  - [https://drawkit.com/](https://drawkit.com/)
  - [https://fontawesome.com/versions](https://fontawesome.com/versions)  

- 사진
  -  https://unsplash.com/
- 사람일러스트레이션
  -   https://undraw.co/illustrations
- 유효성 검사
  -   https://www.youtube.com/watch?v=nx5UuyS8foI&t=955s
