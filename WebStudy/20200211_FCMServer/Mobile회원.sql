/*
 
--모바일회원테이블
create table mobile_member
(
   idx int,
   name varchar2(100) not null,
   id   varchar2(100) not null,
   pwd  varchar2(100),
   device_token varchar2(255),
   constraint pk_mobile_member_idx primary key(idx),
   constraint uq_mobile_member_id  unique(id) 
)

--sample insert
insert into mobile_member values(
        (select nvl(max(idx),0)+1 from mobile_member),
        '이길동',
        'two',
        '1234',
        null
);

select * from mobile_member
commit










*/