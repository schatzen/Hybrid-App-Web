/*

������(sequence)
 : �Ϸù�ȣ ������ü
 
1.����
create sequence  seq_test 

select 
     seq_test.nextVal ������,
     seq_test.currVal ���簪 
from dual;




create table tb10
(
   idx int ,
   constraint pk_tb10_idx primary key(idx)
)

--tb10�� idx���� ������ ������
create sequence seq_tb10_idx

insert into tb10 values(seq_tb10_idx.nextVal);
insert into tb10 values(seq_tb10_idx.nextVal);
insert into tb10 values(seq_tb10_idx.nextVal);
insert into tb10 values(seq_tb10_idx.nextVal);
insert into tb10 values(seq_tb10_idx.nextVal);
insert into tb10 values(seq_tb10_idx.nextVal);

select * from tb10

--������ ������� ������
create table tb11
(
   idx int ,
   constraint pk_tb11_idx primary key(idx)
)

select nvl(max(idx),0)+1 from tb11

insert into tb11 values((select nvl(max(idx),0)+1 from tb11));
insert into tb11 values((select nvl(max(idx),0)+1 from tb11));
insert into tb11 values((select nvl(max(idx),0)+1 from tb11));
insert into tb11 values((select nvl(max(idx),0)+1 from tb11));

select * from tb11
*/





