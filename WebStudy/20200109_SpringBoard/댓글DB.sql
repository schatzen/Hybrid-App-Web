/*

--댓글일련번호
create sequence seq_comment_idx


--댓글테이블
drop table comment_tb

create table comment_tb
(
	idx int,				--일련번호
	content varchar2(1000),	--내용
	ip      varchar2(100),	--아이피
	regdate date,			--작성일자
	m_name  varchar2(100),	--작성자명
	m_idx   int,			--작성자 idx
	b_idx   int				--게시물 idx
)

--기본키
alter table comment_tb
  add constraint  pk_comment_idx primary key(idx);
  
--외래키
alter table comment_tb
  add constraint  fk_comment_m_idx foreign key(m_idx)
                                   references member(idx) 
                                   on delete cascade;  
alter table comment_tb
  add constraint  fk_comment_b_idx foreign key(b_idx)
                                   references board(idx)
                                   on delete cascade;
                                   
                                     

--페이징 처리위한 SQL
select * from      
  (
      select rank() over(order by idx desc) no,
      c.*
      from
         ( select * from comment_tb where b_idx=63) c
  )   
  where no between 6 and 10




select * from comment_tb where b_idx=60;



*/