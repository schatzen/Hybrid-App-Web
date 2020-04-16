/*

  --일련번호관리 객체
  create sequence  seq_member_idx
  
  --회원 Table
  drop table member
  
  create table member
  (
  	 idx  		int,					--일련번호
  	 name 		varchar2(100) not null,	--이름
  	 id   		varchar2(100) not null,	--아이디
  	 pwd  		varchar2(100) not null,	--비밀번호
  	 zipcode 	varchar2(10),			--우편번호
  	 addr		varchar2(100),			--주소  	
  	 ip			varchar2(100),			--IP
  	 grade      varchar2(100),          --회원구분(일반,관리자) 
  	 regdate	date,					--가입일자
  	 modifydate date					--수정일자		
  )
  
  --기본키
  alter table member
    add constraint pk_member_idx primary key(idx);
    
  --id  unique제약
  alter table member
    add constraint unique_member_id unique(id);
  
  --회원등급
  alter table member
    add constraint ck_member_grade check(grade in('일반','관리자')); 
    
      
-- Sample data
  insert into member values(
                seq_member_idx.nextVal,
                '일길동',
                'one',
                '1234',
                '12345',
                '서울 마포 노고산동 111',
                '127.0.0.1',
                '일반',
                sysdate,
                sysdate                
  );   
  
  
  insert into member values(
                seq_member_idx.nextVal,
                '김관리',
                'admin',
                '1234',
                '12345',
                '서울 마포 노고산동 111',
                '127.0.0.1',
                '관리자',
                sysdate,
                sysdate                
  );
  select * from member  
  
  commit
      
    
  
  



*/