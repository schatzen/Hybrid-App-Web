/*

--�Ϸù�ȣ ������ü
create sequence seq_photo_idx

--���̺�
create table photo
(
   p_idx int,					--�Ϸù�ȣ
   p_subject  varchar2(100),	--����
   p_content  varchar2(1000),	--����
   p_filename varchar2(500),	--���ϸ�
   p_ip       varchar2(100),	--IP
   p_regdate  date,				--�������
   m_idx int					--ȸ����ȣ					 
)

--�⺻Ű
alter table photo
  add constraint pk_photo_p_idx primary key(p_idx);

--�ܷ�Ű
alter table photo
  add constraint fk_photo_m_idx foreign key(m_idx)
                                references member(idx);










*/