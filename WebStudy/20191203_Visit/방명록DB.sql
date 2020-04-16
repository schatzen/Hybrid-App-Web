/*

--일련번호 관리객체
create sequence seq_visit_idx

--테이블
create table visit
(
	idx  	int,						--일련번호
	name 	varchar2(100)  not null,	--작성자
	content varchar2(2000) not null,	--내용
	pwd 	varchar2(100)  not null,	--비밀번호
	ip  	varchar2(100)  not null,	--IP
	regdate date						--등록일자
)

--기본키
alter table visit
  add constraint pk_visit_idx primary key(idx)
  
--Sample Data
insert into visit values(seq_visit_idx.nextVal,
                         '일길동',
                         '내가 1등이다~~',
                         '1234',
                         '127.0.0.1',
                         sysdate);
                         
--수정
update visit set name='일길동',
                 content='내가 1등이닷@@',
                 pwd='1234',
                 ip='192.168.0.20',
                 regdate=sysdate
where idx=1
                                          
--삭제
delete from visit where idx=2                         
                         
                         
--최근글을 앞에 배치                         
select * from visit order by idx desc

--idx에 해당되는 글 1건 얻어오기
select * from visit where idx=1
                                                  
                         
                             
  
  




*/