-- 20.11.19
-- 데이터베이스 구현 - 문제해결시나리오
--1. 대리키 IDX, 회원 아이디, 이름, 비밀번호, 사진이름, 가입일 을 저장할 수 있는 
--  이름이 MEMBER인 테이블을 생성하세요. 
create table member(
    idx number(6) constraint pi_basic_idx_PK primary key,
    id varchar2(20) not null,
    name varchar2(20) not null,
    password varchar2(20),
    photoname varchar(20),
    regndate date default sysdate

);

--   회원 아이디에는 기본키 제약설정을 하고, 
--   이름과 비밀번호에는 not null, 


--   가입일은 기본 값으로 sysdate가 입력되도록 하시오.
-- 2. Member 테이블에서 이름 컬럼으로 인덱스 객체를 생성하시오.
-- 3. MEMBER 테이블에서 회원 아이디, 이름, 사진 정보만을 출력하는 view 객체를 생성하시오.
--    view의 이름은 member_view 로 생성하시오.