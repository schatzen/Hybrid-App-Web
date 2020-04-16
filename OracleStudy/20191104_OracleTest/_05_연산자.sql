/*
--1.산술연산자 : +  -  *  /
              mod(피젯수,젯수) <=나머지 구하는 함수
  --dual table : 형식을 맞추기 위한 임시테이블
  
  //Number 함수
  select 1+1,5-1,3*2, round(10/3,1),  mod(10,3) from dual      
 
--2.비교연산자 :  > >= < <= 
        같냐?  :  = 
    같지않냐?  :  !=  ,  <>                    
    
    --년봉이 3000보다 많이받는 직원 추출  
    select * from sawon where sapay>3000 
    
    --10번부서 직원 추출
    select * from sawon where deptno=10
    
    --10번부서가 아닌 직원 추출
    select * from sawon where deptno != 10
    select * from sawon where deptno <> 10

--3.일반논리연산자 :  and   or   not
//               cf)   &&   ||    !  <= java 

    --10번부서의 남자직원 추출
    select * from sawon 
    where  (deptno=10) and (sasex='남자')
    
    --10,20번 부서직원 추출
    select * from sawon
    where (deptno=10)  or  (deptno=20)
    
    select * from sawon
    where deptno in(10,20)
    
    --남자가 아닌 직원 추출
    select * from sawon
    where not (sasex='남자') -- <= DB 튜닝에서는 사용하지말것
    
    select * from sawon
    where sasex<>'남자'
    
--4.기타
      필드 between A and B : A~B사이냐?
      필드 in(A,B,C)       : 필드=A or 필드=B or 필드=C     

    --년봉(sapay)이 3500~4000사이받는 직원추출
    select * from sawon
    where (sapay>=3500) and (sapay<=4000)
    
    select * from sawon
    where sapay between 3500 and 4000
    
    




*/