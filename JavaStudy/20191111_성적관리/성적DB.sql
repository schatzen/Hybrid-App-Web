/*

--일련번호 관리객체
create sequence seq_sungtb_idx


--테이블생성
create table sungtb
(
   idx int,
   name varchar2(100) not null,
   kor  int  default 0,
   eng  int  default 0,
   mat  int  default 0
)

--기본키
alter table sungtb  
   add constraint pk_sungtb_idx primary key(idx);
   
--check : 0~100사이값(도메인 무결성)
alter table sungtb
   add constraint ck_sungtb_kor check(kor between 0 and 100);
   
alter table sungtb
   add constraint ck_sungtb_eng check(eng between 0 and 100);
   
alter table sungtb
   add constraint ck_sungtb_mat check(mat between 0 and 100);         
   
--sample data
insert into sungtb values(seq_sungtb_idx.nextVal,'일길동',90,80,70);
insert into sungtb values(seq_sungtb_idx.nextVal,'이길동',90,90,70);
insert into sungtb values(seq_sungtb_idx.nextVal,'삼길동',90,80,90);
insert into sungtb values(seq_sungtb_idx.nextVal,'사길동',100,100,100);
insert into sungtb values(seq_sungtb_idx.nextVal,'오길동',70,80,70);
insert into sungtb values(seq_sungtb_idx.nextVal,'육길동',100,100,100);

insert into sungtb values(seq_sungtb_idx.nextVal,'칠길동',100,100,100);

--data update(수정)
update sungtb 
     set name='일길동',kor=100,eng=100,mat=100
where idx=1


--data delete(삭제)
delete from sungtb where idx=21



--방법1)
select 
  ss.*,
  rank() over(order by tot desc) as rank
from
(
	select 
	  s.*,
	  (kor+eng+mat) as tot,
	  round((kor+eng+mat)/3,1) as avg
	from (select * from sungtb) s
) ss
order by idx

--방법2
create or replace view sungtb_view
as
    select 
	  s.*,
	  (kor+eng+mat) as tot,
	  round((kor+eng+mat)/3,1) as avg,
	  rank() over(order by (kor+eng+mat) desc) as rank
	from (select * from sungtb) s
	order by idx

--조회
select * from sungtb_view


commit




*/