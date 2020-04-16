/*

--숫자형함수 : numeric함수
  select 
    floor(10.2),ceil(10.2),floor(-10.2),ceil(-10.2)
  from dual


  select
    round(192.153,1),
    round(192.153,-1),
    round(196.153,-1) 
  from dual; 
  
  select
    trunc(192.153,1),
    trunc(192.153,-1),
    trunc(196.153,-1),
    trunc(196.153,-2) 
  from dual; 

--문자형 함수
  --             1234567890 <= 1 base                  
  SELECT SUBSTR('oracleclub', 3) name FROM DUAL;
  --                         start,count
  SELECT SUBSTR('oracleclub',  3,   4) name FROM DUAL;

  --              1 2 3 4 5  <=문자단위
  -               0 3 6 9    <=바이트단위
  SELECT SUBSTRB('오라클클럽',1) name FROM DUAL
    UNION ALL
  SELECT SUBSTRB('오라클클럽',3) name FROM DUAL;

  select * from sawon
  
  --사원테이블에서 '김'씨성을 갖는 직원추출
  select * from sawon 
  where  substr(saname,1,1)='김'
  
  ###문자열 유사검색식 <= 비슷한값을 검색
  필드 like '%_'
            % : 모든문자
            _ : 모든문자 1개
            
  --김씨성          
  select * from sawon where saname like '김%'
  
  --이름중 2번째 글자가 '미' 인 데이터 추출                          
  select * from sawon where saname like '_미%'
  
  select * from sawon where substr(saname,2,1)='미'
  
  --고객테이블
  select * from gogek
  
  --고객테이블에서 여자 고객만 추출
  --  12345678901234 <=위치
  -- '760815-1325467'
  
  --1.유사검색식이용
  select * from gogek
  where gojumin like '______-2%'
        or 
        gojumin like '______-4%'
        or 
        gojumin like '______-6%'
        or 
        gojumin like '______-8%'
  
  
  --2.함수식(substr)이용
  select * from gogek
  where to_number(substr(gojumin,8,1)) in (2,4,6,8) 
  
  --함축적으로 작성하는 코드는 가급적 피해라
  select * from gogek
  where mod(to_number(substr(gojumin,8,1)),2)=0
        
  
--날짜함수
  select to_char(sysdate,'YYYY-MM-DD HH24:MI:SS') 현재시간 from dual;  
  
  select to_char(sysdate-1,'YYYY-MM-DD HH24:MI:SS') 하루전 from dual;
  
  select to_char(sysdate-1/24,'YYYY-MM-DD HH24:MI:SS') "1시간전" from dual;
  
  select to_char(sysdate-1/24/60,'YYYY-MM-DD HH24:MI:SS') "1분전" from dual;
  
  select to_char(sysdate-(5/24 + 30/24/60 + 10/24/60/60),'YYYY-MM-DD HH24:MI:SS') "5H30M10전" from dual;
  
  --현재날짜 + 개월수
  select add_months('2020-04-01',18) 전역날짜 from dual
  
  --months_between(앞날짜,뒷날짜): 앞날짜-뒷날짜=>개월차
  select months_between(add_months(sysdate,5),sysdate) from dual
  
  --사원테이블에서 근속년월수 구하기
  select 
     sabun,saname,sahire,sapay,
     round(months_between(sysdate,sahire),0)  as 총근무월수,
     floor(months_between(sysdate,sahire)/12) as 근무년수,
     round(mod(months_between(sysdate,sahire),12),0) as 월수,
     round(sapay/13,0) as 월급,
     round((months_between(sysdate,sahire)*(sapay/13))/12,0) as 퇴직금
  from sawon
  
  
  --퇴직금 계산식
    1. 퇴직금 = 근무년수*월급 + 잔여근무월수/12*월급
    2. 퇴직금 = (총근무월수*월급)/12


  select 
     sabun,saname,
     to_char(sapay,'L999,999,999') as sapay
  from sawon
  
-- decode / case ~ end
  
  select
     sabun,saname,deptno,
     decode(deptno,10,'총무부',
                   20,'영업부',
                   30,'전산실',
                   40,'관리부','경리부'  ) as dname  
  from sawon
  
  --고객테이블 성별출력(decode)
  select 
     gobun,goname,gojumin,
     decode( substr(gojumin,8,1),'1','남자',
                                 '3','남자',
                                 '5','남자',
                                 '7','남자','여자') as gogender
  
  from gogek
  
  --부서별 보너스 차등지급
  select
     sabun,saname,sapay,deptno,
     decode(deptno,10, sapay*0.1,
                   20, sapay*0.2,
                   30, sapay*0.3,
                   40, sapay*0.4, 0) as bonus
  from sawon
  
  --고객테이블에서 성별출력(case~end)
  select 
     gobun,goname,gojumin,
     case mod(to_number(substr(gojumin,8,1)),2)
        when 1 then '남자'
        else '여자' 
     end as gogender
  from gogek   
  
  --사원테이블에서 입사계절 추출
  --형식2)
  select
     sabun,saname,sahire,
     case
        when to_number(to_char(sahire,'MM')) in(3,4,5)   then '봄'
        when to_number(to_char(sahire,'MM')) in(6,7,8)   then '여름'
        when to_number(to_char(sahire,'MM')) in(9,10,11) then '가을'
        else '겨울'
     end as season
  from sawon
  
  --형식1)
  select
     sabun,saname,sahire,
     case  floor(to_number(to_char(sahire,'MM'))/3)
        when 1  then '봄'
        when 2  then '여름'
        when 3  then '가을'
        else '겨울'
     end as season
  from sawon
  
--NVL( null value ): null이면 대체값으로 지정

  --사원테이블에서 부서장만 추출(samgr=null)
  -- null값 체크는 :  is null / is not null
  select * from sawon  where samgr is null
  
  --부서장이 아닌 직원 추출
  select * from sawon  where samgr is not null    
  
  
  --사원테이블에서 상사필드가 null이면 0으로 대체
  select 
     sabun,saname,sajob,
     nvl(samgr,0) as samgr,
     nvl2(samgr,1,0) as samgr_state
  from sawon
  

*/