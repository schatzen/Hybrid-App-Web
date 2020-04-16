/*

--일련번호 관리객체
create sequence seq_photo_idx

--테이블
create table photo
(
   p_idx int,					--일련번호
   p_subject  varchar2(100),	--제목
   p_content  varchar2(1000),	--내용
   p_filename varchar2(500),	--파일명
   p_ip       varchar2(100),	--IP
   p_regdate  date,				--등록일자
   m_idx int					--회원번호					 
)

--기본키
alter table photo
  add constraint pk_photo_p_idx primary key(p_idx);

--외래키
alter table photo
  add constraint fk_photo_m_idx foreign key(m_idx)
                                references member(idx);










*/