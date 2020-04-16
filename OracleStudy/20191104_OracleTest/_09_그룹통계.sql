/*
  정렬(sort)
  : 형식)
               1차정렬 [정렬방식],  2차정렬
      order by 필드    [asc | desc],필드 [asc | desc]
                       정렬방식은 생략하면 asc(오름차순)
  select * from sawon
  order by deptno asc,sasex asc
  
  select * from sawon
  order by deptno



--###Group by: 그룹별 통계
  --부서별  인원수,급여합계,급여평균
  select
      deptno,
      count(*) 인원수,
      sum(sapay) 급여합계,
      avg(sapay) 급여평균,
      min(sapay) 최저급여,
      max(sapay) 최고급여
  from sawon
  group by deptno 
  order by deptno

  --부서별,성별 인원수
  select
      deptno,sasex 
      count(*)   인원수,
      round(avg(sapay),0) 급여평균
  from sawon
  group by deptno,sasex
  order by deptno,sasex


  --입사월별 인원수
  select 
    to_char(sahire,'MM') 입사월,
    count(*) 인원수
  from sawon 
  group by to_char(sahire,'MM')
  order by to_char(sahire,'MM')
  
  
  --[고객테이블] 지역(광역시)별 인원수
  select 
    substr(goaddr,1,2) 지역,
    count(*)  인원수 
  from gogek
  group by substr(goaddr,1,2)
  order by substr(goaddr,1,2)
  
  --[고객테이블] 성별 인원수
  --   123456789
  --   760815-1325467
  
  select
  	case
  	   when to_number(substr(gojumin,8,1)) in(1,3,5,7) then '남자'
  	   else '여자'
  	end as gender,
  	count(*) 인원수
  from gogek
  group by  case
		  	   when to_number(substr(gojumin,8,1)) in(1,3,5,7) then '남자'
		  	   else '여자'
		  	end
           
  Q1.[사원테이블] 직급별 인원수
     select 
        sajob,count(*)
     from sawon
     group by sajob
     
  Q2.[사원테이블] 부서별,직급별 인원수
     select 
        deptno,sajob,count(*)
     from sawon
     group by deptno,sajob
     order by deptno,sajob
      
  Q3.[사원테이블] 입사년도별 인원수
     1988  1
     1989  1
     
     select
        to_char(sahire,'YYYY') 입사년도,
        count(*) 인원수
     from sawon
     group by to_char(sahire,'YYYY')
     order by to_char(sahire,'YYYY')
  
  Q4.[사원테이블] 입사년대별 인원수
     1980년대  3
     1990년대  4
     
     select 
        substr(to_char(sahire,'YYYY'),1,3) || '0년대' 년대,
        count(*) 인원수
     from sawon
     group by substr(to_char(sahire,'YYYY'),1,3)
     order by substr(to_char(sahire,'YYYY'),1,3)
     
     
  Q5.[고객테이블] 고객 출생계절별 인원수 
  
     select
        case floor(to_number(substr(gojumin,3,2))/3)
           when 1 then '봄'
           when 2 then '여름'
           when 3 then '가을'
           else '겨울'
        end as season,
        count(*) 인원수
     from gogek  
     group by  case floor(to_number(substr(gojumin,3,2))/3)
		           when 1 then '봄'
		           when 2 then '여름'
		           when 3 then '가을'
		           else '겨울'
		        end
    
  --having절 : group by조건절
  select
     deptno,count(*)
  from sawon        
  group by deptno 
  having  count(*) >= 5         
                                                    

  



*/