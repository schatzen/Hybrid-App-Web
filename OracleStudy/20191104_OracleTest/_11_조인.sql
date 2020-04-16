/*

1)사원테이블 deptno FK설정
alter table sawon 
  add constraint fk_sawon_deptno
                 foreign key(deptno)
                 references dept(deptno)

2)사원테이블 samgr FK설정                  
alter table sawon
  add constraint fk_sawon_samgr         
                 foreign key(samgr)
                 references sawon(sabun)

3)고객테이블 godam FK설정                 
alter table gogek
  add constraint fk_gogek_godam
                 foreign key(godam)
                 references sawon(sabun)                                   
                 
##조인(join)
: 2이상의 테입를 연결(결합)해서 조회하는 방식

1.Cross Join : 조건없이 무조건 결합
               A(n) x B(m) => n*m 

2.inner join=>  1:1(equi join)

3.outer join
     left  outer join : A left outer join B
                        A는 모두추출
                        B는 조건에 맞는행만 결합+빈자리는 null
     right outer join : A right outer join B
                        A는 조건에 맞는행만 추출 + 빈자리는 null
                        B는 모두추출
      
     full outer join  : A full outer join B
                        A모두
                        B모두
                        +빈자리 null

4.self join          
                                     
                                                                         
--ex) cross join
                 20    5 
  select * from sawon,dept
  
  [ANSI-92 SQL]
  select * from sawon cross join dept
  
--ex) inner join
  select * from sawon s , dept d
  where s.deptno = d.deptno --결합조건
        and
        sapay > 3000        --일반검색조건
         
  
  [ANSI-92 SQL]
  select 
    *                          -- on 결합조건
  from sawon inner join dept  on sawon.deptno=dept.deptno 
  where sapay > 3000           --일반검색조건 
  
  
--ex) left outer join  
  --사원 -> 고객정보 : (+) <- 행추가(null)
  select * 
  from sawon s,gogek g
  where s.sabun=g.godam(+) --oracle문법 
  order by sabun
  
  cf)MS-SQL : where s.sabun*=g.godam 
  
  [ANSI-92 SQL]
  select *
  from sawon s left outer join gogek g on s.sabun=g.godam
  order by sabun
  
  
  --ex)self join
  --사원정보   상사정보
  select *
  from sawon s1,sawon s2
  where s1.samgr = s2.sabun(+)
  
  [ANSI-92 SQL]
  select *
  from sawon s1 left outer join sawon s2 on s1.samgr = s2.sabun
  
  
  select * 
  from sawon s full outer join dept d on s.deptno=d.deptno                                                                                                              
                                                                                                                                                                                     
--사원 + 부서 + 고객
  sabun  saname   dname     goname
     sawon s      dept d    gogek g
            (1)
                         (2)
  select
     *
  from  (sawon s  left outer join dept d on s.deptno=d.deptno)
        left outer join gogek g on s.sabun=g.godam
  order by sabun      
  

--Q1 
    사번 직위 사원명  부서명  상사직위 상사명  
        sawon s1      dept d      sawon s2
     
    select 
       s1.sabun,s1.sajob,s1.saname,dname,s2.sajob,s2.saname
    from sawon s1 inner join dept d on s1.deptno=d.deptno
         left outer join sawon s2   on s1.samgr=s2.sabun
         
                 
              
--Q2
   사번 사원명 사원담당고객명 부서명 상사번호 상사명 상사담당고객명
     sawon s1   gogek  g1     dept d      sawon s2      gogek g2            

   select
      *
   from  sawon s1 left outer join gogek g1 on s1.sabun=g1.godam
         left outer join dept d            on s1.deptno=d.deptno
         left outer join sawon s2          on s1.samgr=s2.sabun
         left outer join gogek g2          on s2.sabun=g2.godam  









*/