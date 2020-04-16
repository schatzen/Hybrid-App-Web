/*
   ### ��������(Constraint)
   : Data Integrity(������ ���Ἲ)�� ��Ű���� ���ѻ���
   
   ex) �����Է�
       gender varchar2(10)  default '����'
       '�� ��' '����' '��' 'male' 'man' 'M' '����'  '��' 'female'
       ##����
       where gender='����' or gender='��' or gender='male'
       
   1.null(���) or not null(�ʵ��Է�):�⺻�� null
   2.unique : ��ƼƼ���Ἲ->���ϰ���� �ȵȴ�(���ϰ�)
   3.check  : �����ι��Ἲ:���ǿ� �����ϴ� ���� ��� 
   4.default: �⺻��
   5.primary key : not null + unique + index 
   6.foreign key : ��ȿ�� ���� ���� �񱳰��� �ܺ����̺��� �����ο��� ����
    (�����ι��Ἲ) �θ�Ű�� �ɼ� �ִ� ����=> unique 
   
   
--ex1) not null : �ʼ��Է�
              null : null���
              
   create table tb1
   (
      name varchar2(100) not null,
      tel  varchar2(100) null
   )
   
   insert into tb1 values('�ϱ浿','010-111-1111')
   insert into tb1(name) values('�̱浿')
   insert into tb1(name,tel) values('��浿',null)
   
   --errorȮ��
   insert into tb1(tel) values('010-222-2222')
      
   select * from tb1
   
--ex2) unique : �����γ� �ߺ��� ������(������)
       cf)���������� �ߺ��ؼ� ��밡��
   create table tb2
   (
      id  varchar2(100)  unique not null,
      name varchar2(100) not null 
   )
   insert into tb2 values('one','�ϳ�')
   --���� ����(unique)
   --���Ἲ ���� ����(TEST.SYS_C004003)�� ����˴ϴ�
   insert into tb2 values('one','���ϳ�')
    
   create table tb22
   (
      id   varchar2(100)  not null,
      name varchar2(100)  not null 
   ) 
   
   --�������� �߰�(�̸��� �ο�)
   alter table tb22
     add constraint unique_tb22_id unique(id) 
                      (�������Ǹ�)
                      
   insert into tb22 values('two','��')
   --���Ἲ ���� ����(TEST.UNIQUE_TB22_ID)�� ����˴ϴ�
   insert into tb22 values('two','���')
   
   create table tb222
   (
      id   varchar2(100)  not null,
      name varchar2(100)  not null,
      --��������
      constraint unique_tb222_id unique(id) 
   ) 
   
--ex3) check����  
   create table tb3
   (
      name   varchar2(100) not null,
      gender varchar2(100)
   )

   --�������Ǹ�:ck_tb3_gender 
   alter table tb3
      add constraint ck_tb3_gender 
                     check(gender='����' or gender='����') 
                     
   insert into tb3 values('�ϱ浿','����')
   --üũ ��������(TEST.CK_TB3_GENDER)�� ����Ǿ����ϴ�                   
   insert into tb3 values('�̱浿','�� ��')
   
   create table tb33
   (
      name varchar2(100) not null,
      kor  number(3),
      eng  int,
      mat  int
   )
   
   alter table tb33
      add constraint ck_tb33_kor
                     check(kor>=0 and kor<=100) 
                     
   alter table tb33
      add constraint ck_tb33_eng
                     check(eng>=0 and eng<=100) 
                                                                                                                      
   alter table tb33
      add constraint ck_tb33_mat
                     check(mat>=0 and mat<=100)                                                                                                                       

   cf)java:(kor>=0 && kor<=100)
   --üũ ��������(TEST.CK_TB33_KOR)�� ����Ǿ����ϴ�
   insert into tb33 values('�ϱ浿',101,99,88)
   
   --üũ ��������(TEST.CK_TB33_ENG)�� ����Ǿ����ϴ�
   insert into tb33 values('�̱浿',100,-99,88)
   
   --üũ ��������(TEST.CK_TB33_MAT)�� ����Ǿ����ϴ�
   insert into tb33 values('��浿',100,99,888)
   
   cf) Dictionary Table(��밴ü�� �������� ����س��� ���̺�)
            �������Ǹ� �����س��� ���̺�: user_constraints   
   
   --�������� Ȯ�� SQL
   select 
         constraint_type,
         constraint_name,
         owner,
         table_name
   from  user_constraints
   where table_name='TB33'

--ex4) default
   create table tb4
   (
      name   varchar2(100) not null,
      gender varchar2(100) default '����',
      age    int           default 1
   )   
   
   insert into tb4 values('�ϱ浿','����',20)
   insert into tb4(name) values('�̱浿')
   insert into tb4 values('�ϱ浿',default,default)
   
   select * from tb4
   
--ex5) primary key(�⺻Ű)
       : ���ڵ带 �����Ҽ� �ִ� ��ǥŰ
       : not null + unique + index ���յ� ������ ��������   
       : ���̺������� ������ �⺻Ű�� �־�� �ȴ�.
    
    create table tb5
    (
       idx  int,
       name varchar2(100) not null,
       id   varchar2(100) not null unique
    )   
    
    --�⺻Ű �߰�
    alter table tb5
      add constraint pk_tb5_idx primary key(idx)
    
    --NULL�� ("TEST"."TB5"."IDX") �ȿ� ������ �� �����ϴ�  
    insert into tb5 values(null,'�α浿','hong') 
    
    insert into tb5 values(1,'�ϱ浿','one')
    --���Ἲ ���� ����(TEST.PK_TB5_IDX)�� ����˴ϴ�
    insert into tb5 values(1,'�̱浿','two')  
     
       
--ex6) foreign key(�ܷ�Ű)    
       :��ȿ�� ���� ���� �񱳰��� �ܺ����̺��� �����ο��� ����                   

  create table student
  (
     hakbun int,
     name   		varchar2(100) not null,
     tel    		varchar2(100) not null,
     parent_name 	varchar2(100) not null,
     parent_job  	varchar2(100) not null,
     constraint pk_student_hakbun primary key(hakbun)        
  )
  
  insert into student values(1,'�ϱ浿','111-1111',
                               '�Ͼƺ�','�ڿ���');                                                          
  insert into student values(2,'�̱浿','222-1111',
                               '�̾ƺ�','ȸ���');             
  select * from student                
               
  commit             
   
  --�������̺�
  create table sungjuk
  (
     idx int,
     hakbun int,
     kor int,
     eng int,
     mat int
  )
  
  --�⺻Ű
  alter table sungjuk
     add constraint pk_sungjuk_idx primary key(idx)
  
  --�ܷ�Ű
  alter table sungjuk
     add constraint fk_sungjuk_hakbun  
                    foreign key(hakbun) 
                    references student(hakbun)  
  --���� �Է�
  insert into sungjuk values(1,1,100,90,60);
  insert into sungjuk values(2,2,80,90,60);
  
  --���Ἲ ��������(TEST.FK_SUNGJUK_HAKBUN)�� ����Ǿ����ϴ� 
  --�θ� Ű�� �����ϴ�
  insert into sungjuk values(3,3,100,90,60);   
         
  --join:���̺� ���ļ� ��ȸ�ϴ� ��� 
  select * from student,sungjuk
  where  student.hakbun=sungjuk.hakbun
               
   
             


       
                 
         

*/