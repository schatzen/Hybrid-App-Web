/*

select * from sawon

--##�ֺҾϰ� ������ �μ� ���� ����

1.�ֺҾ��� �μ� Ȯ��
select deptno from sawon where saname='�ֺҾ�'

2.����� �μ��� �̿��ؼ� �������� ����
select * from sawon 
where deptno=(select deptno from sawon where saname='�ֺҾ�')

--##�������� ������ ������ ���� ����
1.������ ����Ȯ��
select sajob from sawon where saname='������'
2.����� ����� �̿��ؼ� ������ ����
select * from sawon
where sajob in (select sajob from sawon where saname='������')

--##�����̺��� ���ΰ� ������ ����(������)�� ��� �� ����
1.������ ������ �������Ѵ�
select substr(goaddr,1,2) from gogek where goname='����'
2.����� ����� �̿��ؼ� ������ ����
select * from gogek
where substr(goaddr,1,2) in (select substr(goaddr,1,2) from gogek where goname='����')




--Q1.(������̺�)�������� ������ ����� �޴� ���� ����
     select * from sawon
     where sapay = (select sapay from sawon where saname='������')
--Q2.(������̺�)�ֺҾϰ� ���� �޿� �Ի��� ���� ����
     select * from sawon
     where to_char(sahire,'MM') = (select to_char(sahire,'MM') from sawon where saname='�ֺҾ�')
--Q3.(������̺�)�̹��ڿ� ���� ������ �Ի��� ���� ����(�ڡڡڡڡ�)
                (���̹���)
     select * from sawon
     where  decode(
                   floor(to_number(to_char(sahire,'MM'))/3),4,0,
                   floor(to_number(to_char(sahire,'MM'))/3)
                  )
     =                        
     (           
       select decode(
                     floor(to_number(to_char(sahire,'MM'))/3),4,0,
                     floor(to_number(to_char(sahire,'MM'))/3)
                    ) 
       from sawon where saname='���̹���'
     )                   

--Q4.(�����̺�)��¡���� ������ ��뿡 ����� �� ����(�ڡڡ�)
                 86-> 80��� �����
     select * from gogek
     where  substr(gojumin,1,1)=           
            (select substr(gojumin,1,1) from gogek where goname='��¡��')            

--Q5.(�����̺�)¯���� ������ ���� �¾ �� ����
     select * from gogek
     where substr(gojumin,3,2) = 
           (select substr(gojumin,3,2) from gogek where goname='¯��')                  
                 
###---������ �������� : ������������� ������ 
   ---�嵿��,������� �Ҽӵ� �μ� ���� ����
   ---����:���� �� ���� ���ǿ� 2�� �̻��� ���� ���ϵǾ����ϴ�.
     select * from sawon
     where deptno in ( select deptno from sawon 
                       where saname in('�����','�嵿��')


###��(��)���Լ� : 
     count(*)   : ��ü���ڵ��
     count(�ʵ�): �����γ� �ʵ�����ϱ�(null���Ծ���)
     sum(�ʵ�)  : �ʵ��� 
     avg(�ʵ�)  : �ʵ����
     min(�ʵ�)  : �ּҰ�
     max(�ʵ�)  : �ִ밪
     
     select
        count(*)     ��ü�����,
        count(samgr) �μ����̾ƴ�������,
        sum(sapay)   ��ü�޿��հ�,
        avg(sapay)   ��ü�޿����,
        min(sapay)   �����޿�,
        max(sapay)   �ִ�޿�,
        min(sahire)  �����Ի�����,
        max(sahire)  �ֱ��Ի�����
     from sawon

-- ������ �ִ�޿��� ����
   select * from sawon
   where sapay = (select max(sapay) from sawon)
   
-- ������ �޿���պ��� ���̹޴� ���� ����
   select * from sawon
   where sapay > (select avg(sapay) from sawon)
   
   
-- 10���μ��� �ִ�޿��� ����
   --1)10���μ��� �ִ�޿�
   select 
      max(sapay) 
   from sawon 
   where deptno=10
   
   select * from sawon
   where sapay = 
       (select max(sapay) from sawon where deptno=10) 
       and 
       deptno=10   
   
   --���μ��� �ִ�޿��ڸ� ����
   select * from sawon
   where 
         (sapay = (select max(sapay) from sawon 
                  where deptno=10) 
         and deptno=10)
         or
         (sapay = (select max(sapay) from sawon 
                  where deptno=20) 
         and deptno=20)
         or
         (sapay = (select max(sapay) from sawon 
                  where deptno=30) 
         and deptno=30)
         or
         (sapay = (select max(sapay) from sawon 
                  where deptno=40) 
         and deptno=40)
   
   --�������
   select * from sawon s1
   where sapay=
         (select max(sapay) from sawon where deptno=s1.deptno)
   
   
   


*/