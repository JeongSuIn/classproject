-- 20.11.10 과제

--EMP 테이블과 DEPT 테이블을 이용해서 풀이해 주세요.
-- 테이블에서 원하는 행의 컬럼의 값을 추출하는 것
-- select {컬럼명, ...} from 테이블 이름 where 조건 -> 원하는 행, 열을 표현 -> 결과: 테이블


-- 1. 덧셈연산자를 이용하여 모든 사원에 대해서 $300의 급여 인상을 계산한 후 사원의 이름, 급여, 인상된 급여를 출력하시오.​
select ename as "사원 이름", sal as "급여", (sal+300) as "인상된 급여"
from emp
;

--​​ 2. 사원의 이름, 급여, 연간 총 수입을 총 수입이 많은 것부터 작은 순으로 출력하시오,
-- 연간 총수입은 월급에 12를 곱한 후 $100의 상여금을 더해서 계산하시오.​
select ename as "사원 이름", sal as "급여", (sal*12+100) as "연간 총 수입"
from emp
order by sal*12+100 desc
;

-- 3. 급여가 2000을 넘는 사원의 이름과 급여를 표현, 급여가 많은 것부터 작은 순으로 출력하시오.
select ename, sal
from emp
where sal>=2000
order by sal desc
;

-- 4. 사원번호가 7788인 사원의 이름과 부서번호를 출력하시오.
select ename, deptno
from emp
where empno=7788
;

-- 5. 급여가 2000에서 3000 사이에 포함되지 않는 사원의 이름과 급여를 출력하시오.
-- 범위: between 또는 논리연산 사용
select ename, sal
from emp
where sal not between 2000 and 3000
;

-- 논리 연산
select ename, sal
from emp
where not (sal>=2000 and sal<=3000)
;

-- 6. 1981년 2월 20일 부터 1981년 5월 1일 사이에 입사한 사원의 이름, 담당업무, 입사일을 출력하시오.
select ename, job, hiredate
from emp
where hiredate >= '1981/02/20' and hiredate <= '1981/05/01'
-- where hiredate between '1981/02/20' and '1981/05/01'
;

-- 7. 부서번호가 20 및 30에 속한 사원의 이름과 부서번호를 출력, 이름을 기준(내림차순)으로 영문자순으로 출력하시오.
select ename, deptno
from emp
--where deptno=20 or deptno=30
where deptno in(20, 30)
order by ename desc
;

--​​ 8. 사원의 급여가 2000에서 3000사이에 포함되고 부서번호가 20 또는 30인 사원의 이름, 급여와 부서번호를 출력, 이름순(오름차순)으로 출력하시오.​
select ename, sal, deptno
from emp
where (sal>=2000 and sal<=3000) and (deptno=20 or deptno=30)
order by ename
;

-- 9. 1981년도에 입사한 사원의 이름과 입사일을 출력하시오. (like 연산자와 와일드카드 사용)​
select ename, hiredate
from emp
where hiredate like '81%'
;

-- 10. 관리자가 없는 사원의 이름과 담당 업무를 출력하시오.​
select ename, job
from emp
where mgr is null
;

--​11. 커미션을 받을 수 있는 자격이 되는 사원의 이름, 급여, 커미션을 출력하되 급여 및 커미션을 기준으로 내림차순 정렬하여 표시하시오.
select ename, sal, comm
from emp
where comm is not null and comm>0
order by sal desc, comm desc
;

--​ 12. 이름의 세번째 문자가 R인 사원의 이름을 표시하시오.​
select ename
from emp
where ename like '__R%'
;

​-- 13. 이름에 A와 E를 모두 포함하고 있는 사원의 이름을 표시하시오.​
select ename
from emp
where ename like '%A%' and ename like '%E%'
;

​-- 14. 담당업무가 CLERK, 또는 SALESMAN이면서 급여가 $1600, $950 또는 $1300이 아닌 사원의 이름, 담당업무, 급여를 출력하시오.​
select ename, job, sal
from emp
where (job in ('CLERK', 'SALESMAN')) and (sal not in(1600, 950, 1300))
;

-- 15. 커미션이 $500 이상인 사원의 이름과 급여 및 커미션을 출력하시오.​
select ename, sal, comm
from emp
where comm>=500
;







-- 20.11.12 --

-- 부속질의 문제
-- 43. 사원 번호가 7788인 사원과 담당 업무가 같은
-- 사원을 표시(사원 이름과 담당업무)하시오.
select ename, job from emp where empno like '%7788%';

select ename, job
from emp
where job =(select job from emp where empno like '%7788%')
;

-- 44. 사원번호가 7499인 사원보다 급여가 많은 사원을 표시하시오. 
select ename from emp where empno like '%7499%';

select ename, job
from emp
where sal>(select sal from emp where empno like '%7499%')
;

-- 45. 최소급여를 받는 사원의 이름, 담당업무 및 급여를 표시하시오.(그룹함수 사용)
select ename, job, sal
from emp
where (select min(sal) from emp )=sal
;

-- 46. 평균급여가 가장 적은 직급의 직급 이름과 직급의 평균을 구하시오.
select job, avg(sal)
from emp
group by job
having avg(sal) = (select min(avg(sal)) from emp group by job)
;

-- 47. 각 부서의 최소 급여를 받는 사원의 이름, 급여, 부서번호를 표시하시오.
select min(sal) from emp group by deptno; -- 각 부서의 최소 급여

select e.ename, e.sal, e.deptno
from emp e, (select min(sal) as ms from emp group by deptno) m
where e.sal=m.ms
order by e.detpno
;

-- 48.
-- 담당업무가 ALALYST인 사원보다 급여가 적으면서 업무가 ANALYST가 아닌 사원들을 표시(사원번호, 이름, 담당 업무, 급여)하시오.
select e.empno, e.ename, e.job, e.sal 
from emp e, emp ae 
where e.sal<ae.sal and ae.job='ANALYST'
;

-- 49.
-- 부하직원이 없는 사원의 이름을 표시하시오.
select e.ename, e.empno
from emp e
where e.empno NOT in(select distinct mgr from emp where mgr is not null)
;

-- 50.
-- 부하직원이 있는 사원의 이름을 표시하시오.
select e.ename, e.empno
from emp e
where e.empno in(select distinct mgr from emp where mgr is not null)
;

-- 51.
-- BLAKE와 동일한 부서에 속한 사원의 이름고 ㅏ입사일을 표시해라 단 BLAKE는 제외
select e.ename, e.hiredate, e.deptno 
from emp e, emp be 
where e.deptno=be.deptno and be.ename='BLAKE'
;

-- 52. 
-- 급여가 평균 급여보다 많은 사원들의 사원 번호와 이름을 표시하되 결과를 급여에 대해서 오름차순으로 정렬하시오.
select empno, ename
from emp
where (select avg(sal) from emp )<sal
;

-- 53.
-- 이름에 K가 포함된 사원과 같은 부서에서 일하는 사원의 사원 번호와 이름을 표시하시오.
select empno, ename
from emp
where deptno in (select deptno from emp where ename like '%K%')
;

-- 54.
-- 부서위치가 DALLAS인 사원의 이름과 부서번호 및 담당업무를 표시하시오.
select * from dept where loc='DALLAS';

select e.ename, e.deptno, e.job
from dept d, emp e
where e.deptno = d.deptno and loc in (select loc from dept where loc='DALLAS')
;

-- 55.
-- KING에게 보고하는 사원의 이름과 급여를 표시하시오.
select ename, sal
from emp
where job = 'MANAGER'
;

-- 56.
-- RESEARCH 부서의 사원에 대한 부서번호, 사원 이름 및 담당 업무를 표시하시오
select dname, deptno from dept where dname = 'RESEARCH';

select e.deptno, e.empno, e.ename, e.job
from emp e, dept d
where e.deptno=d.deptno and d.dname = 'RESEARCH'
order by empno
;

-- 57.
-- 평균 월급보다 많은 급여를 받고 이름에 M이 포함된 사원과 같은 부서에서 근무하는 사원의 사원 번호, 이름, 급여를 표시하시오.
select empno, ename, sal 
from emp 
where (select avg(sal) from emp )<sal and deptno in (select deptno from emp where ename like '%M%')
;

-- 58. 
-- 평균급여가 가장 적은 업무를 찾으시오.
select avg(sal) from emp group by deptno ;

select min(sal), job
from emp
group by job
having avg(sal) = (select min(avg(sal)) from emp group by job) 
;

-- 59.
-- 담당업무가 MANAGER인 사원이 소속된 부서와 동일한 부서의 사원을 표시하시오
select deptno, ename from emp where job = 'MANAGER';

select ename
from emp
where deptno in (select deptno from emp where job = 'MANAGER')
;