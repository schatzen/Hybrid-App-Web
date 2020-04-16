/*

--�������Լ� : numeric�Լ�
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

--������ �Լ�
  --             1234567890 <= 1 base                  
  SELECT SUBSTR('oracleclub', 3) name FROM DUAL;
  --                         start,count
  SELECT SUBSTR('oracleclub',  3,   4) name FROM DUAL;

  --              1 2 3 4 5  <=���ڴ���
  -               0 3 6 9    <=����Ʈ����
  SELECT SUBSTRB('����ŬŬ��',1) name FROM DUAL
    UNION ALL
  SELECT SUBSTRB('����ŬŬ��',3) name FROM DUAL;

  select * from sawon
  
  --������̺��� '��'������ ���� ��������
  select * from sawon 
  where  substr(saname,1,1)='��'
  
  ###���ڿ� ����˻��� <= ����Ѱ��� �˻�
  �ʵ� like '%_'
            % : ��繮��
            _ : ��繮�� 1��
            
  --�达��          
  select * from sawon where saname like '��%'
  
  --�̸��� 2��° ���ڰ� '��' �� ������ ����                          
  select * from sawon where saname like '_��%'
  
  select * from sawon where substr(saname,2,1)='��'
  
  --�����̺�
  select * from gogek
  
  --�����̺��� ���� ���� ����
  --  12345678901234 <=��ġ
  -- '760815-1325467'
  
  --1.����˻����̿�
  select * from gogek
  where gojumin like '______-2%'
        or 
        gojumin like '______-4%'
        or 
        gojumin like '______-6%'
        or 
        gojumin like '______-8%'
  
  
  --2.�Լ���(substr)�̿�
  select * from gogek
  where to_number(substr(gojumin,8,1)) in (2,4,6,8) 
  
  --���������� �ۼ��ϴ� �ڵ�� ������ ���ض�
  select * from gogek
  where mod(to_number(substr(gojumin,8,1)),2)=0
        
  
--��¥�Լ�
  select to_char(sysdate,'YYYY-MM-DD HH24:MI:SS') ����ð� from dual;  
  
  select to_char(sysdate-1,'YYYY-MM-DD HH24:MI:SS') �Ϸ��� from dual;
  
  select to_char(sysdate-1/24,'YYYY-MM-DD HH24:MI:SS') "1�ð���" from dual;
  
  select to_char(sysdate-1/24/60,'YYYY-MM-DD HH24:MI:SS') "1����" from dual;
  
  select to_char(sysdate-(5/24 + 30/24/60 + 10/24/60/60),'YYYY-MM-DD HH24:MI:SS') "5H30M10��" from dual;
  
  --���糯¥ + ������
  select add_months('2020-04-01',18) ������¥ from dual
  
  --months_between(�ճ�¥,�޳�¥): �ճ�¥-�޳�¥=>������
  select months_between(add_months(sysdate,5),sysdate) from dual
  
  --������̺��� �ټӳ���� ���ϱ�
  select 
     sabun,saname,sahire,sapay,
     round(months_between(sysdate,sahire),0)  as �ѱٹ�����,
     floor(months_between(sysdate,sahire)/12) as �ٹ����,
     round(mod(months_between(sysdate,sahire),12),0) as ����,
     round(sapay/13,0) as ����,
     round((months_between(sysdate,sahire)*(sapay/13))/12,0) as ������
  from sawon
  
  
  --������ ����
    1. ������ = �ٹ����*���� + �ܿ��ٹ�����/12*����
    2. ������ = (�ѱٹ�����*����)/12


  select 
     sabun,saname,
     to_char(sapay,'L999,999,999') as sapay
  from sawon
  
-- decode / case ~ end
  
  select
     sabun,saname,deptno,
     decode(deptno,10,'�ѹ���',
                   20,'������',
                   30,'�����',
                   40,'������','�渮��'  ) as dname  
  from sawon
  
  --�����̺� �������(decode)
  select 
     gobun,goname,gojumin,
     decode( substr(gojumin,8,1),'1','����',
                                 '3','����',
                                 '5','����',
                                 '7','����','����') as gogender
  
  from gogek
  
  --�μ��� ���ʽ� ��������
  select
     sabun,saname,sapay,deptno,
     decode(deptno,10, sapay*0.1,
                   20, sapay*0.2,
                   30, sapay*0.3,
                   40, sapay*0.4, 0) as bonus
  from sawon
  
  --�����̺��� �������(case~end)
  select 
     gobun,goname,gojumin,
     case mod(to_number(substr(gojumin,8,1)),2)
        when 1 then '����'
        else '����' 
     end as gogender
  from gogek   
  
  --������̺��� �Ի���� ����
  --����2)
  select
     sabun,saname,sahire,
     case
        when to_number(to_char(sahire,'MM')) in(3,4,5)   then '��'
        when to_number(to_char(sahire,'MM')) in(6,7,8)   then '����'
        when to_number(to_char(sahire,'MM')) in(9,10,11) then '����'
        else '�ܿ�'
     end as season
  from sawon
  
  --����1)
  select
     sabun,saname,sahire,
     case  floor(to_number(to_char(sahire,'MM'))/3)
        when 1  then '��'
        when 2  then '����'
        when 3  then '����'
        else '�ܿ�'
     end as season
  from sawon
  
--NVL( null value ): null�̸� ��ü������ ����

  --������̺��� �μ��常 ����(samgr=null)
  -- null�� üũ�� :  is null / is not null
  select * from sawon  where samgr is null
  
  --�μ����� �ƴ� ���� ����
  select * from sawon  where samgr is not null    
  
  
  --������̺��� ����ʵ尡 null�̸� 0���� ��ü
  select 
     sabun,saname,sajob,
     nvl(samgr,0) as samgr,
     nvl2(samgr,1,0) as samgr_state
  from sawon
  

*/