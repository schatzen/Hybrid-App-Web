/*
--1.��������� : +  -  *  /
              mod(������,����) <=������ ���ϴ� �Լ�
  --dual table : ������ ���߱� ���� �ӽ����̺�
  
  //Number �Լ�
  select 1+1,5-1,3*2, round(10/3,1),  mod(10,3) from dual      
 
--2.�񱳿����� :  > >= < <= 
        ����?  :  = 
    �����ʳ�?  :  !=  ,  <>                    
    
    --����� 3000���� ���̹޴� ���� ����  
    select * from sawon where sapay>3000 
    
    --10���μ� ���� ����
    select * from sawon where deptno=10
    
    --10���μ��� �ƴ� ���� ����
    select * from sawon where deptno != 10
    select * from sawon where deptno <> 10

--3.�Ϲݳ������� :  and   or   not
//               cf)   &&   ||    !  <= java 

    --10���μ��� �������� ����
    select * from sawon 
    where  (deptno=10) and (sasex='����')
    
    --10,20�� �μ����� ����
    select * from sawon
    where (deptno=10)  or  (deptno=20)
    
    select * from sawon
    where deptno in(10,20)
    
    --���ڰ� �ƴ� ���� ����
    select * from sawon
    where not (sasex='����') -- <= DB Ʃ�׿����� �����������
    
    select * from sawon
    where sasex<>'����'
    
--4.��Ÿ
      �ʵ� between A and B : A~B���̳�?
      �ʵ� in(A,B,C)       : �ʵ�=A or �ʵ�=B or �ʵ�=C     

    --���(sapay)�� 3500~4000���̹޴� ��������
    select * from sawon
    where (sapay>=3500) and (sapay<=4000)
    
    select * from sawon
    where sapay between 3500 and 4000
    
    




*/