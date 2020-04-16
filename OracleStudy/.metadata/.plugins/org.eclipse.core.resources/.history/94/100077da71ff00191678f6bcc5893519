/*
--테이블생성
create table test_member
(
 --필드명      자료형
   id      varchar2(100),
   pwd     varchar2(100),
   name    varchar2(100),
   age     number(3),  -- 999
   regdate date,       
   gender  char(6),
   memo    clob,         --대용량 문자데이터
   year    int 
)

--sample data 추가

insert into test_member 
values('hong','1234','홍길동',30,sysdate,
       '남자','가입합니다',1980);

insert into test_member 
values('hong gil sun','1234','홍길순',31,
       '2019-11-3','여자','가입합니다',1979);

--수정
update test_member set id='hong_gil_sun'
where name='홍길순';

--삭제
delete from test_member
where name='홍길동';
       
                     
--조회                 DBO.테이블명
select * from test.test_member;

## CRUD ## <= DML(Data Manipulation Language)
Create - insert(생성)
Read   - select(조회)
Update - update(수정)
Delete - delete(삭제)
 





*/