/*
  ����(sort)
  : ����)
               1������ [���Ĺ��],  2������
      order by �ʵ�    [asc | desc],�ʵ� [asc | desc]
                       ���Ĺ���� �����ϸ� asc(��������)
  select * from sawon
  order by deptno asc,sasex asc
  
  select * from sawon
  order by deptno



--###Group by: �׷캰 ���
  --�μ���  �ο���,�޿��հ�,�޿����
  select
      deptno,
      count(*) �ο���,
      sum(sapay) �޿��հ�,
      avg(sapay) �޿����,
      min(sapay) �����޿�,
      max(sapay) �ְ�޿�
  from sawon
  group by deptno 
  order by deptno

  --�μ���,���� �ο���
  select
      deptno,sasex 
      count(*)   �ο���,
      round(avg(sapay),0) �޿����
  from sawon
  group by deptno,sasex
  order by deptno,sasex


  --�Ի���� �ο���
  select 
    to_char(sahire,'MM') �Ի��,
    count(*) �ο���
  from sawon 
  group by to_char(sahire,'MM')
  order by to_char(sahire,'MM')
  
  
  --[�����̺�] ����(������)�� �ο���
  select 
    substr(goaddr,1,2) ����,
    count(*)  �ο��� 
  from gogek
  group by substr(goaddr,1,2)
  order by substr(goaddr,1,2)
  
  --[�����̺�] ���� �ο���
  --   123456789
  --   760815-1325467
  
  select
  	case
  	   when to_number(substr(gojumin,8,1)) in(1,3,5,7) then '����'
  	   else '����'
  	end as gender,
  	count(*) �ο���
  from gogek
  group by  case
		  	   when to_number(substr(gojumin,8,1)) in(1,3,5,7) then '����'
		  	   else '����'
		  	end
           
  Q1.[������̺�] ���޺� �ο���
     select 
        sajob,count(*)
     from sawon
     group by sajob
     
  Q2.[������̺�] �μ���,���޺� �ο���
     select 
        deptno,sajob,count(*)
     from sawon
     group by deptno,sajob
     order by deptno,sajob
      
  Q3.[������̺�] �Ի�⵵�� �ο���
     1988  1
     1989  1
     
     select
        to_char(sahire,'YYYY') �Ի�⵵,
        count(*) �ο���
     from sawon
     group by to_char(sahire,'YYYY')
     order by to_char(sahire,'YYYY')
  
  Q4.[������̺�] �Ի��뺰 �ο���
     1980���  3
     1990���  4
     
     select 
        substr(to_char(sahire,'YYYY'),1,3) || '0���' ���,
        count(*) �ο���
     from sawon
     group by substr(to_char(sahire,'YYYY'),1,3)
     order by substr(to_char(sahire,'YYYY'),1,3)
     
     
  Q5.[�����̺�] �� ��������� �ο��� 
  
     select
        case floor(to_number(substr(gojumin,3,2))/3)
           when 1 then '��'
           when 2 then '����'
           when 3 then '����'
           else '�ܿ�'
        end as season,
        count(*) �ο���
     from gogek  
     group by  case floor(to_number(substr(gojumin,3,2))/3)
		           when 1 then '��'
		           when 2 then '����'
		           when 3 then '����'
		           else '�ܿ�'
		        end
    
  --having�� : group by������
  select
     deptno,count(*)
  from sawon        
  group by deptno 
  having  count(*) >= 5         
                                                    

  



*/