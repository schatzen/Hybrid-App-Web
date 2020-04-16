/*

--����Ϸù�ȣ
create sequence seq_comment_idx


--������̺�
drop table comment_tb

create table comment_tb
(
	idx int,				--�Ϸù�ȣ
	content varchar2(1000),	--����
	ip      varchar2(100),	--������
	regdate date,			--�ۼ�����
	m_name  varchar2(100),	--�ۼ��ڸ�
	m_idx   int,			--�ۼ��� idx
	b_idx   int				--�Խù� idx
)

--�⺻Ű
alter table comment_tb
  add constraint  pk_comment_idx primary key(idx);
  
--�ܷ�Ű
alter table comment_tb
  add constraint  fk_comment_m_idx foreign key(m_idx)
                                   references member(idx) 
                                   on delete cascade;  
alter table comment_tb
  add constraint  fk_comment_b_idx foreign key(b_idx)
                                   references board(idx)
                                   on delete cascade;
                                   
                                     

--����¡ ó������ SQL
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