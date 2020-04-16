/*

--�Ϸù�ȣ������ü
create sequence  seq_board_idx

--�Խ��� ���̺�
create table board
(
   idx     int,				--�Ϸù�ȣ
   subject varchar2(500),	--����
   content clob,			--����
   ip	   varchar2(100),	--������
   regdate date,			--�ۼ�����
   readhit int,				--��ȸ��
   use_yn  char(1),			--�������(����)
   ref     int,				--�����۹�ȣ
   step    int,				--����
   depth   int,				--����
   m_idx   int,				--ȸ���Ϸù�ȣ
   m_name  varchar2(100)	--ȸ����
)

--�⺻Ű
alter table board
  add constraint pk_board_idx primary key(idx);
  
--����Ű  
alter table board
  add constraint fk_board_m_idx foreign key(m_idx)
                                references member(idx)
                                on delete cascade
                                
--sample
--���۾���
insert into board values(seq_board_idx.nextVal,
                         '����1��',
                         '�ϵ��ߴ�~~',
                         '192.168.0.79',
                         sysdate,
                         0,
                         'y',
                         seq_board_idx.currVal,
                         0,
                         0,
                         4,
                         'ȫ�浿');
                         
--�����Խù�                         
insert into board values(seq_board_idx.nextVal,
                         '�� �������',
                         '���~~',
                         '192.168.0.79',
                         sysdate,
                         0,
                         'n',
                         seq_board_idx.currVal,
                         0,
                         0,
                         4,
                         'ȫ�浿');                         

--��۾���
insert into board values(seq_board_idx.nextVal,
                         '���ڴ� 1���ؼ�',
                         '�� 2���ε�~~',
                         '192.168.0.79',
                         sysdate,
                         0,
                         'y',
                         1,
                         1,
                         1,
                         5,
                         '�ڱ浿');

insert into board values(seq_board_idx.nextVal,
                         '����� �غ�',
                         '�� 2���̷���~~',
                         '192.168.0.79',
                         sysdate,
                         0,
                         'y',
                         1,
                         2,
                         2,
                         5,
                         '�ڱ浿');
 
update board set use_yn='n' where idx=1;
update board set use_yn='y' where idx=4;                         
                                                                         
commit

select * from member
select * from board  order by ref desc,step asc

                                                                            
                                                                                

-- Paging ó���� ���� SQL
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

--��ü�Խù���
select nvl(count(*),0) from board
      
  
  
  
  
  



*/