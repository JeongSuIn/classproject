-- 20.11.10(화)
-- 함수

-- 단일행 / 집합함수

-- 단일행 함수: 숫자, 문자, 날짜, 변환

desc dual;

-- 숫자 함수
select abs(-15) -- 결과: 절대값 15
from  dual
;

select floor(15.7) -- 소수점을 절사
from  dual
;

select ROUND(15.193, 1) -- round(숫자, 소수점을 표현할 자리수)-> 반올림하여 출력함. 
from  dual
;

select LOG(10, 100) -- 지수를 구해줌
from  dual
;

select POWER(2,8) -- 2의 8승
from  dual
;

-- 문자 함수
select concat('나는', ' 정수인 입니다.')
from dual
;

select concat('제 이름은 ', ename)
from emp
where job='MANAGER'
;

select LOWER('MR. SCOTT MCMILLAN') "Lowercase" -- 모든 대문자가 소문자로 바뀜.
FROM DUAL
;

select lower(ename)
from emp
;

select LPAD('Page 1',15,'*') -- 15자리 중 Page 1을 제외한 9자리는 *로 채워짐
from dual
;

select RPAD('001212-4',14,'*') -- 14자리 중 001212-4를 제외한 6자리는 *로 채워짐
from dual
;

select SUBSTR('ABCDEFG',3,4) -- 3인덱스에서부터 4개를 출력한다. (1부터 시작)
from dual
;

select RPAD(substr('001212-4111111', 1, 8),14,'*')  -- 주민번호 
from dual
;

-- trim
select ltrim('=from=', '=') -- 왼쪽의 지정한 문자열을 지워줌(공백도 가능). LTRIM('원본 문자열', '지울 대상')
from dual
;

select rtrim('=from======', '=') -- 오른쪽의 지정한 문자열을 지워줌(공백도 가능). RTRIM('원본 문자열', '지울 대상')
from dual
;

select trim('  ' from '           =from======       ') as "from" -- trim('지울 대상'
from dual
;

select REPLACE('JACK and JUE','J','BL') -- J를 BL으로 변경
from dual
;

select replace('000000-0000000', '-', '') -- 하이픈(-) 제거
from dual
;

-- 날짜 함수(단일행 함수)
select sysdate -- 오늘 날짜 출력
from dual
;

select sysdate+14 -- 오늘 날짜+14일 출력
from dual
;

select sysdate+21 -- 오늘 날짜+21일 출력
from dual
;

select sysdate-3 -- 오늘 날짜-3일 출력
from dual
;

select add_months(sysdate, 2) -- 오늘 날짜 +2달
from dual
;

select add_months(sysdate, -2) -- 오늘 날짜 -2달
from dual
;

select last_day(sysdate) -- 오늘 날짜에 해당되는 달의 마지막 날 출력
from dual
;

-- 변환 함수
-- TO_CHAR: 날짜 -> 문자 / 숫자 -> 문자

-- 날짜 -> 문자
select sysdate, TO_CHAR(sysdate, 'YYYY.MM.DD day dy AM PM HH24:MI:SS') --  day: 화요일 / dy: 화
from dual
;

select to_char(sysdate, 'YYYY.MM.DD. HH24:MI:ss') -- 결과: 2020.11.10. 12:00:54
from dual
;

-- 숫자 -> 문자
select to_char(100000.123, 'L000,000.00') -- 결과:  100,000.12 / L은 지역 화폐를 출력
from dual
;

select to_char(10000, 'L999,999.99')
from dual
;

select sal, to_char(sal*1100, 'L00,000,000')
from emp
;

select sal, to_char(sal*1100, 'L999,999,999')
from emp
;

select ename,job,  sal, to_char(sal*1100*12+nvl(comm,0)*1100, 'L999,999,999') 
from emp
order by sal desc
;



-- 문자 -> 날짜
-- 2020.11.01.
select to_date('2009/09/05', 'YYYY/MM/DD')
from dual
;

select to_date('2020.11.01.', 'YYYY.MM.DD.') -- 패턴을 맞춰야 출력이 가능함
from dual
;

-- 오늘이 2020년 01월 01일에서 며칠이 지났는지 확인
select trunc(sysdate - to_date('20-01-01', 'YY-MM-DD')) -- trunc 소수점 절사
from dual
;

-- 내가 며칠을 살았는지 확인
select trunc(sysdate - to_date('1997-11-11', 'YYYY-MM-DD'))
from dual
;

-- 문자 -> 숫자
select TO_NUMBER('100,000.00', '999,999.99') / To_number('10.00', '999,999.99')
from dual
;

-- decode 함수: 자바의 switch문과 유사하다.
-- 사원명, 부서번호, 부서이름 출력
select ename, deptno,
    Decode(deptno,
        10, 'ACCOUNTING',    -- deptno = 10 이면 ACCOUNTING을 출력
        20, 'RESERCH',      -- deptno = 20 이면 RESERCH 출력
        30, 'SALES',        -- deptno = 30 이면 SALES 출력
        40, 'OPERATIONS'    -- deptno = 40 이면 OPERATIONS 출력        
    ) as dname
from emp
order by deptno
;

-- 직급에 따라 급여를 인상하도록 하자. 
-- 직급의 'ANALYST'인 사원은 5%, 
--  'SALESMAN'인 사원은 10%, 
--  'MANAGER'인 사원은 15%, 
--  'CLERK'인 사원은 20% 인상

select ename, sal,
    decode(job, 
        'ANALYST', sal+(sal*0.05), -- sal*1.05
        'SALESMAN', sal*1.10,
        'MANAGER', sal*1.15,
        'CLERK', sal*1.20       
    ) as upsal
from emp
;

select distinct job -- distinct => 중복 제거
from emp
;

-- case 함수
select ename as name, deptno as dno,
    case 
        when deptno=10 then 'ACCOUNTING'
        when deptno=20 then 'RESEARCH'
        when deptno=30 then 'SALES'
        when deptno=40 then 'OPERATIONS'
    end as dname    
from emp
 order by dname
;


-- sum 함수 / null 값은 계산하지 않는다.
select comm
from emp
;

-- 그룹 함수: 하나의 행의 컬럼을 대상이 아닌 행의 그룹의 컬럼들을 묶어 그룹화하고, 연산하는 함수
-- 그룹 함수: sum, avg, count, max, min

select   -- 그룹 함수는 단일항을 사용할 수 없다.
    
    to_char( sum(sal)*1100, 'L999,999,999' )as "월 급여 총 액",     
    round (avg(sal))*1100 as "월 급여 평균",
    count(sal) as "전체 사원의 수",
    count(comm) as "커미션 수",
    max(sal) as "가장 큰 금여 액",
    min(sal) as "가장 적은 금여 액"
from emp
;

select 
        sum(comm), 
        avg(comm),
        count(nvl(comm,0)),
        max(comm),
        min(comm)
        
from emp
;

-- 전체 행을 구한다.
select count (*), as "전체 사원의 수",
    svg(sal) as "매니저의 평균 급여",
    max(sal),
min(sal)
from emp
;

select count (*) as "MANAGER의 수"
from emp
where job='MANAGER'
;

-- 직무의 개수
select count(distinct job)
from emp
order by job

;

-- 특정 컬럼을 기준으로 그룹핑: group by 컬럼
select deptno
from emp
group by deptno
order by deptno
;

-- 각 부서의 소속 인원
select deptno, count(*) as 
from emp
group by deptno
order by deptno
;

-- 각 부서별  총 급여액 출력
-- group by deptno
select deptno, to_char (sum(sal), 'L999,999')
from emp
group by deptno
order by deptno
;

-- 부서별 급여 평균
select deptno, round(avg(sal))
from emp
group by deptno
order by deptno
;

-- 부서별 급여 최고 금액과 최소 금액을 출력
select deptno, max(sal), min(sal),( max(sal)-min(sal)) 
from emp
group by deptno
order by deptno
;

-- 부서별로 그룹지은 후,(GROUP BY)
-- 그룹 지어진 부서별 평균 급여가
-- 2000이상인(HAVING)
-- 부서번호와 부서별 평균 급여를 출력
select deptno, avg(sal)
from emp
group by deptno
having avg(sal)>=2000
order by deptno
;

-- 부서별 급여의 최대값과 최소값을 구하되
-- 최대 급여(HAVING)가 2900이상인 부서만 출력합니다.
select deptno, max(sal), min(sal)
from emp
group by deptno
having max(sal)>=2900
order by deptno
;

-- 직무별 지표: 직무별 사원의 수, 급여의 총 합, 평균 급여, 최대 급여, 최소 급여
select 
    job,
    count(*) || '명' as "사원의 수",
    to_char(sum(sal)*1100,'L999,999,999') as " 급여의 총 합",
    to_char(avg(sal)*1100, 'L999,999,999') as "평균 급여",
    to_char(max(sal)*1100, 'L999,999,999') as "최대 급여",                                                  
    to_char(min(sal)*1100, 'L999,999,999') as "최소 급여"
from emp
where job!='PRESIDENT' -- 그룹화하기 위한 행을 선택하는 기준
group by job
order by job
;

select * 
from tab;
desc book;

select * from book;

desc customer;
select * from customer;

desc orders;
select * from orders;

-- 과제

-- 1. 마당 서점의 고객이 요구하는 다음 질문에 대해 SQL문을 작성하시오.
select * from book;
select * from customer;
select * from orders;



-- (1) 도서번호가 1인 도서의 이름
select bookname
from book
where bookid=1
;

-- (2) 가격이 20,000원 이상인 도서의 이름
select bookname
from book
where price>=20000
;

-- (3) ﻿박지성의총구매액(박지성의고객번호는1번으로놓고작성)
select sum(saleprice)
from orders
where custID=1
;

-- (4) 박지성이 구매한 도서의 수(박지성의고객번호는1번으로놓고작성)
select count(saleprice)
from orders
where custid=1
;

-- 2. ﻿마당서점의 운영자와 경영자가 요구하는 다음 질문에 대해 SQL 문을 작성하시오.
select * from book;
select * from customer;
select * from orders;

-- (1) ﻿마당서점도서의총개수
select count(bookid)
from book
;

-- (2) ﻿마당서점에도서를출고하는출판사의총개수
select count(distinct publisher)
from book
;

-- (3) 모든 고객의 이름, 주소
select name, address
from customer
;

-- (4) ﻿2014년 7월 4일 ~ 7월 7일 사이에 주문받은
-- 도서의 주문번호
select orderid
from orders
where orderdate>='2014/07/04' and orderdate<='2014/07/07'
;

-- (5) ﻿2014년 7월 4일 ~ 7월 7일 사이에 주문받은 도서를 제외한 
-- 도서의주문번호
select orderid
from orders
where not orderdate>='2014/07/04' and orderdate<='2014/07/07'
;

-- (6) 성이 '김'씨인 고객의 이름과 주소
select name, address
from customer
where name like '김%'
;

-- (7) ﻿성이 ‘김’씨이고 이름이‘아’로 끝나는 고객의 이름과 주소
select name, address
from customer
where name like '김%아'
;

-- [실습] 단일행 함수, 집합 함수 문제

-- 16. ﻿SUBSTR 함수를 사용하여
-- 사원들의 입사한 년도와 입사한 달만 출력하시오.
select SUBSTR(hiredate,1,5)
from emp
;

-- 17. ﻿SUBSTR 함수를 사용하여 4월에 입사한 사원을 출력하시오.
select ename, hiredate
from emp
where substr(hiredate, 4, 2) = '04'
;

-- 18.﻿ MOD 함수를 사용하여 사원번호가 짝수인 사람만 출력하시오. 
select ename, empno
from emp
where mod(empno, 2)='0'
;

-- 19. ﻿입사일을 년도는 2자리(YY), 월은 숫자(MM)로 표시하고 요일은 약어 (DY)로 지정하여 출력하시오.﻿
select to_char(hiredate, 'YY/MM/DY')
from emp
;

-- 20. ﻿올해 며칠이 지났는지 출력하시오. 
-- 현재날짜에서 올해 1월 1일을 뺀 결과를 출력하고
-- TO_DATE 함수를 사용하여 데이터 형을 일치 시키시오.
select trunc(sysdate - to_date('20-01-01', 'YY-MM-DD')) 
from dual
;

-- 21. ﻿﻿사원들의 상관 사번을 출력하되
-- 상관이 없는 사원에 대해서는
-- NULL 값 대신 0으로 출력하시오.
select ename, nvl(mgr,0)
from emp
;

-- 22. ﻿DECODE 함수로 직급에 따라 급여를 인상하도록 하시오.
    -- 직급이 ‘ANALIST'인 사원은 200,
    -- ‘SALESMAN’인 사원은 180,
    -- ‘MANAGER’인 사원은 150,
    -- ‘CLERK”인 사원은 100을 인상하시오.
select ename, job, sal ,
    decode(job,
        'ANALIST', sal+200,
        'SALESMAN', sal+180,
        'MANAGER', sal+150,
        'CLERK', sal+100
    ) as "인상된 급여"
from emp
;

-- 23. ﻿모든 사원의 급여 최고액, 최저액, 총액 및 평균 급여를 출력하시오.
-- 평균에 대해서는 정수로 반올림하시오.
select max(sal), min(sal), sum(sal), floor(avg(sal))
from emp
;












