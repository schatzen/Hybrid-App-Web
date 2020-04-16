/*

--일련번호관리객체
create sequence  seq_board_idx

--게시판 테이블
create table board
(
   idx     int,				--일련번호
   subject varchar2(500),	--제목
   content clob,			--내용
   ip	   varchar2(100),	--아이피
   regdate date,			--작성일자
   readhit int,				--조회수
   use_yn  char(1),			--사용유무(삭제)
   ref     int,				--참조글번호
   step    int,				--순서
   depth   int,				--깊이
   m_idx   int,				--회원일련번호
   m_name  varchar2(100)	--회원명
)

--기본키
alter table board
  add constraint pk_board_idx primary key(idx);
  
--참조키  
alter table board
  add constraint fk_board_m_idx foreign key(m_idx)
                                references member(idx)
                                on delete cascade
                                
--sample
--새글쓰기
insert into board values(seq_board_idx.nextVal,
                         '내가1등',
                         '일등했다~~',
                         '192.168.0.79',
                         sysdate,
                         0,
                         'y',
                         seq_board_idx.currVal,
                         0,
                         0,
                         4,
                         '홍길동');
                         
--삭제게시물                         
insert into board values(seq_board_idx.nextVal,
                         '난 몇등이지',
                         '몇등~~',
                         '192.168.0.79',
                         sysdate,
                         0,
                         'n',
                         seq_board_idx.currVal,
                         0,
                         0,
                         4,
                         '홍길동');                         

--답글쓰기
insert into board values(seq_board_idx.nextVal,
                         '좋겠다 1등해서',
                         '난 2등인데~~',
                         '192.168.0.79',
                         sysdate,
                         0,
                         'y',
                         1,
                         1,
                         1,
                         5,
                         '박길동');

insert into board values(seq_board_idx.nextVal,
                         '대답좀 해봐',
                         '난 2등이래두~~',
                         '192.168.0.79',
                         sysdate,
                         0,
                         'y',
                         1,
                         2,
                         2,
                         5,
                         '박길동');
 
update board set use_yn='n' where idx=1;
update board set use_yn='y' where idx=4;                         
                                                                         
commit

select * from member
select * from board  order by ref desc,step asc

                                                                            
                                                                                

-- Paging 처리를 위한 SQL
select * from
( 
	select 
	   rank() over(order by ref desc,step asc) no,
	   b.*,
	   ( select count(*) from comment_tb  where b_idx=b.idx ) comment_cnt
	from
	   ( select * from board ) b
) 
where no between 1 and 10

--전체게시물수
select nvl(count(*),0) from board
      
  
  
  
  
  



*/