/*

1)������̺� deptno FK����
alter table sawon 
  add constraint fk_sawon_deptno
                 foreign key(deptno)
                 references dept(deptno)

2)������̺� samgr FK����                  
alter table sawon
  add constraint fk_sawon_samgr         
                 foreign key(samgr)
                 references sawon(sabun)

3)�����̺� godam FK����                 
alter table gogek
  add constraint fk_gogek_godam
                 foreign key(godam)
                 references sawon(sabun)                                   
                 
##����(join)
: 2�̻��� ���Ը� ����(����)�ؼ� ��ȸ�ϴ� ���

1.Cross Join : ���Ǿ��� ������ ����
               A(n) x B(m) => n*m 

2.inner join=>  1:1(equi join)

3.outer join
     left  outer join : A left outer join B
                        A�� �������
                        B�� ���ǿ� �´��ุ ����+���ڸ��� null
     right outer join : A right outer join B
                        A�� ���ǿ� �´��ุ ���� + ���ڸ��� null
                        B�� �������
      
     full outer join  : A full outer join B
                        A���
                        B���
                        +���ڸ� null

4.self join          
                                     
                                                                         
--ex) cross join
                 20    5 
  select * from sawon,dept
  
  [ANSI-92 SQL]
  select * from sawon cross join dept
  
--ex) inner join
  select * from sawon s , dept d
  where s.deptno = d.deptno --��������
        and
        sapay > 3000        --�Ϲݰ˻�����
         
  
  [ANSI-92 SQL]
  select 
    *                          -- on ��������
  from sawon inner join dept  on sawon.deptno=dept.deptno 
  where sapay > 3000           --�Ϲݰ˻����� 
  
  
--ex) left outer join  
  --��� -> ������ : (+) <- ���߰�(null)
  select * 
  from sawon s,gogek g
  where s.sabun=g.godam(+) --oracle���� 
  order by sabun
  
  cf)MS-SQL : where s.sabun*=g.godam 
  
  [ANSI-92 SQL]
  select *
  from sawon s left outer join gogek g on s.sabun=g.godam
  order by sabun
  
  
  --ex)self join
  --�������   �������
  select *
  from sawon s1,sawon s2
  where s1.samgr = s2.sabun(+)
  
  [ANSI-92 SQL]
  select *
  from sawon s1 left outer join sawon s2 on s1.samgr = s2.sabun
  
  
  select * 
  from sawon s full outer join dept d on s.deptno=d.deptno                                                                                                              
                                                                                                                                                                                     
--��� + �μ� + ��
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
    ��� ���� �����  �μ���  ������� ����  
        sawon s1      dept d      sawon s2
     
    select 
       s1.sabun,s1.sajob,s1.saname,dname,s2.sajob,s2.saname
    from sawon s1 inner join dept d on s1.deptno=d.deptno
         left outer join sawon s2   on s1.samgr=s2.sabun
         
                 
              
--Q2
   ��� ����� ��������� �μ��� ����ȣ ���� ��������
     sawon s1   gogek  g1     dept d      sawon s2      gogek g2            

   select
      *
   from  sawon s1 left outer join gogek g1 on s1.sabun=g1.godam
         left outer join dept d            on s1.deptno=d.deptno
         left outer join sawon s2          on s1.samgr=s2.sabun
         left outer join gogek g2          on s2.sabun=g2.godam  









*/