/*
 뷰(View)
 1.가상테이블
 2.뷰안에는 SQL문장이 저장되어 있다->실행
 3.목적)
   1)편리성:복잡한 명령을 간결하게 사용
   2)보안성:노출되지 말아될 데이터 숨길수 있다
 
 --사원테이블 남자(여자)만 조회 
 create or replace view sawon_man_view
 as   
   select * from sawon where sasex='남자'

 --사용:테이블사용하듯이...
 select * from sawon_man_view
 
 
 --고객테이블->출생계절 포함한 뷰생성
 create or replace view gogek_season_view
 as
	 select
	     gobun,goname,goaddr,gojumin,godam,
	     case floor(to_number(substr(gojumin,3,2))/3)
	           when 1 then '봄'
	           when 2 then '여름'
	           when 3 then '가을'
	           else '겨울'
	     end as goseason  
	 from gogek
  --뷰사용
  select * from gogek_season_view
  
  --출생계절별 인원수    
  select
     goseason,
     count(*)
  from gogek_season_view
  group by goseason


  --[고객테이블] 아래와 같은 컬럼을 추가
  gogek_view1
  gobun  goname  goaddr  gojumin          birth_year
                         901212-*******     1990
-------------------------------------------------------------  
  create or replace view gogek_view1
  as                       
	  select
	     gobun,goname,goaddr,
	     substr(gojumin,1,6) ||'-*******' as gojumin,
	     (
	     to_number(substr(gojumin,1,2)) + 
	     case
	        when to_number(substr(gojumin,8,1)) in(1,2,5,6) then 1900
	        else 2000
	     end
	     )as birth_year
	  from gogek                          
-------------------------------------------------------------
  select * from gogek_view1                         
                         
--------------------------------------------------------------             
  create or replace view gogek_view2
  as         
	  select 
	      g.*,
	      (to_number(to_char(sysdate,'YYYY')) - birth_year + 1) as age,
	      case mod(birth_year,12)
	              when  0 then '원숭이'
	              when  1 then '닭'
	              when  2 then '개'
	              when  3 then '돼지'
	              when  4 then '쥐'
	              when  5 then '소'
	              when  6 then '호랑이'
	              when  7 then '토끼'
	              when  8 then '용'
	              when  9 then '뱀'
	              when 10 then '말'
	              else '양'
	      end as tti
	  from (select * from gogek_view1) g                                                                

  -- from에서 작성된 SQL=> inline view

  select * from gogek_view2  


### system계정작성 : 새로운 유저생성
  create user test1 identified by test1
  grant connect to test1
  

### test계정작성  
  : test1에게 gogek_view2 select할수 있는 권한부여
        권한내용 on 대상개체       권한부여할대상(유저)
  grant select   on gogek_view2 to test1

### test1계정전환: 부여받은 개체사용권한 확인
  select * from test.gogek_view2
  
  
  
  
  










*/