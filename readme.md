## Springboot + JPA 게시판
스프링 부트 게시판 (학습용)

소셜 로그인 (구글, 네이버)을 이용하여 로그인후 사용하는 게시판입니다.
## 기능목록
1. 게시판 리스트

   작성된 게시글들을 볼수 있습니다.

2. 게시글 관리

   게시글 작성하고 수정 , 삭제등을 할수 있습니다.



## 개발정보
- 언어 : JAVA 8 , JavaScript(ES5) , HTML5 , CSS3 
- BACK-END : Spring-boot 2.1.7.RELEASE
- Templates-engine : Musttache (Vue.js 변경예정)
- DBMS : h2 database (InMemory) (MySql 변경예정) , JPA 활용
- UI FrameWork : Bootstrap 4.3.1
- Lib : jQurey



## 페이지 설명

/ : 게시판 (메인페이지)

/posts/save (get) :  게시글 작성페이지

/posts/update/{id} (get) : 게시글 수정페이지 

## Restful api 설명 

/api/v1/posts (post) : 게시글 저장

/api/v1/posts/{id} (put) : 게시글 수정

/api/v1/posts/{id} (get) : 게시글 보기

/api/v1/posts/{id} (delete) : 게시글 삭제

## AWS 배포주소
[바로가기](http://ec2-52-79-204-101.ap-northeast-2.compute.amazonaws.com:8080/)

