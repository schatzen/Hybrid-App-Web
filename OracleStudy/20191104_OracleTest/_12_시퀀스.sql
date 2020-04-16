/*

시퀀스(sequence)
 : 일련번호 관리객체
 
1.생성
create sequence  seq_test 

select 
     seq_test.nextVal 다음값,
     seq_test.currVal 현재값 
from dual;




create table tb10
(
   idx int ,
   constraint pk_tb10_idx primary key(idx)
)

--tb10에 idx값을 관리할 시퀀스
create sequence seq_tb10_idx

insert into tb10 values(seq_tb10_idx.nextVal);
insert into tb10 values(seq_tb10_idx.nextVal);
insert into tb10 values(seq_tb10_idx.nextVal);
insert into tb10 values(seq_tb10_idx.nextVal);
insert into tb10 values(seq_tb10_idx.nextVal);
insert into tb10 values(seq_tb10_idx.nextVal);

select * from tb10

--시퀀스 사용하지 않을시
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





