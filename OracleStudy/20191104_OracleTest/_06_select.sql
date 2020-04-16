/*

--heading: select결과로 추출된 필드명

select
    sabun     사번,
    saname as 사원명,
    sajob     직위,
    sapay     "년 봉",        --기본필드(컬럼)
    sapay*0.1 as bonus        --연(계)산 필드
from  sawon

--문자열 결합연산(+) : ||
select 
   saname || sajob || '님 새해 복 많이 받으세요' as 새해인사
from sawon

--함수사용
select 
     sabun,saname,sahire,
     to_char(sahire,'YYYY') as year,
     to_char(sahire,'MM') as month,
     to_char(sahire,'DD') as day
from sawon
where to_char(sahire,'MM') in('03','04','05')


Q1)사원테이블에서 20번부서의 부장직급의 직원 추출
select * from sawon
where deptno=20  and sajob='부장'

Q2)사원테이블에서 년봉이 3000~3500받는 여자직원 추출
select * from sawon
where (sapay between 3000 and 3500) and (sasex='여자')

Q3)사원테이블에서 입사년도가 1990~1995년사이 입사자 추출
select * from sawon
where to_char(sahire,'YYYY') between '1990' and '1995'

select * from sawon
where to_number(to_char(sahire,'YYYY')) between 1990 and 1995


Q4)사원테이블에서 봄,가을에 입사한 직원 추출
select * from sawon
where to_char(sahire,'MM') in('03','04','05','09','10','11')


select * from sawon
where floor(to_number(to_char(sahire,'MM'))/3) in(1,3)


--     Integer.parseInt('123')
select to_number('123')*10 from dual;


*/