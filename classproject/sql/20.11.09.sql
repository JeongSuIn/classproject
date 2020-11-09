--2020.11.09
--select 기본

-- scott 계정으로 로그인
-- scott 계정이 소유한 테이블 객체를 확인: -> 사용자가 가지는 테이블의 정보를 저장하는 데이터 딕셔너리

select * from tab;

-- table의 구조를 확인: DESC 사용
-- 테이블의 데이터를 검색하기 전 구조를 확인할 때 사용
DESC emp;
DESC dept;

-- 데이터의 조회 명령: SELECT
-- SELECT 컬럼명, ... FROM 테이블 이름(조회 대상); --> 기본 문법
-- SELECT의 결과는 -> TABLE 이다. ★★★

SELECT      -- 조회하는 명령어
    *       -- 컬럼 이름들을 기술해준다. 기술하는 순서에 따라 결과가 순서에 맞게 출력
FROM emp    -- 조회하고자하는 테이블 이름을 기술
;           -- SQL의 종료

-- 부서 테이블의 모든 데이터를 조회하자
SELECT *
FROM DEPT
;


-- 부서테이블에서 -> FROM
-- 부서의 이름과 위치를 출력 -> SELECT

SELECT DNAME,LOC
FROM DEPT
;


SELECT LOC, DEPTNO, DNAME, DNAME
FROM DEPT
;

-- 모든 사원의 정보를 출력
SELECT *
FROM EMP
;

-- 특정부서에서는 사원의 이름과 사번, 직급(직무)를 출력하고 싶다.
SELECT ENAME, EMPNO, JOB
FROM EMP
;


-- SELECT절의 컬럼의 사칙연산이 가능
-- 임시 테이블 DUAL: 컬럼은 X를 가지는 테이블
SELECT 100+200, 200-100, 100*10, 100/10
FROM DUAL
;

SELECT ENAME, SAL, SAL*12
FROM EMP
;

-- 연봉의 계산을 SAL*12+COMM으로 계산하자
-- NULL은 값은 존재하지만, 정해지지 않은 값
-- 연산이 불가능: 사칙연산, 비교연산, 논리연산 등
SELECT ENAME, SAL, SAL*12, COMM, SAL*12+COMM
FROM EMP
;

-- 개선
-- nvl 함수: null 값을 치환해주는 함수
-- nvl(컬럼, 대체값): 컬럼의 값이 null 일 때 대체값으로 치환해준다. 이 때, 대체값은 컬럼의 타입에 맞는 데이터이어야 한다.
SELECT ENAME, SAL, SAL*12 sal12, nvl(comm, 0) as comm, SAL*12+nvl(comm, 0) as "12개월 연봉"
FROM EMP
;

-- 데이터베이시의 sql 내부의 문자열 처리는 작은 ' ' 
-- 문자열의 조합
select ename || '의 직무는 ' || job || '입니다.'
from emp
;

-- Distinct: 데이터의 중복값을 제거하고 출력
select deptno
from emp;

select DISTINCT deptno
from emp;


-- 특정 데이터를 추출하는 where 절
-- select 컬럼명 ... from 테이블 이름 where 조건식

-- 급여가 3000이상인 사원의 리스트를 출력하자
select ename, job, sal
from emp
where sal>=3000
;

select ename, job, sal
from emp
where sal>4000
;

-- 10번 부서의 소속된
-- 사원들의 리스트를 출력
select *
from emp
where deptno=10
;

-- 사원 이름이 FORD인 사람의 정보를 출력
select *
from emp
where ename='FORD'
;

-- 81/11/17에 입사한 사원의 정보를 출력
select *
from emp
where hiredatte='81/11/17' -- 날짜 비교에서도 날짜도 작은 따음표호
;

-- 10번 부서 소속인 사원들 중에서 -- and

-- 사원명, 부서번호, 직급을 출력하려고 한다.면
-- [조건1] 10번 부서 소속인 사원: deptno=10
-- [조건2] 직급이 manager인 사원: job='manager'

select ename, deptno, job
from emp
where deptno=10 and job='MANAGER'
;

-- 10번 
select ename, deptno, job
from emp
where deptno=10 or job='MANAGER'
;



-- select hiredate from emp;



