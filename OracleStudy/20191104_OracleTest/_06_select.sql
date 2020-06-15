/*

--heading: select����� ����� �ʵ��

select
    sabun     ���,
    saname as �����,
    sajob     ����,
    sapay     "�� ��",        --�⺻�ʵ�(�÷�)
    sapay*0.1 as bonus        --��(��)�� �ʵ�
from  sawon

--���ڿ� ���տ���(+) : ||
select 
   saname || sajob || '�� ���� �� ���� ��������' as �����λ�
from sawon

--�Լ����
select 
     sabun,saname,sahire,
     to_char(sahire,'YYYY') as year,
     to_char(sahire,'MM') as month,
     to_char(sahire,'DD') as day
from sawon
where to_char(sahire,'MM') in('03','04','05')


Q1)������̺����� 20���μ��� ���������� ���� ����
select * from sawon
where deptno=20  and sajob='����'

Q2)������̺����� ����� 3000~3500�޴� �������� ����
select * from sawon
where (sapay between 3000 and 3500) and (sasex='����')

Q3)������̺����� �Ի�⵵�� 1990~1995����� �Ի��� ����
select * from sawon
where to_char(sahire,'YYYY') between '1990' and '1995'

select * from sawon
where to_number(to_char(sahire,'YYYY')) between 1990 and 1995


Q4)������̺����� ��,������ �Ի��� ���� ����
select * from sawon
where to_char(sahire,'MM') in('03','04','05','09','10','11')


select * from sawon
where floor(to_number(to_char(sahire,'MM'))/3) in(1,3)


--     Integer.parseInt('123')
select to_number('123')*10 from dual;


*/