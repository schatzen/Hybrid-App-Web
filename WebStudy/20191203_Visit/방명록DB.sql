/*

--�Ϸù�ȣ ������ü
create sequence seq_visit_idx

--���̺�
create table visit
(
	idx  	int,						--�Ϸù�ȣ
	name 	varchar2(100)  not null,	--�ۼ���
	content varchar2(2000) not null,	--����
	pwd 	varchar2(100)  not null,	--��й�ȣ
	ip  	varchar2(100)  not null,	--IP
	regdate date						--�������
)

--�⺻Ű
alter table visit
  add constraint pk_visit_idx primary key(idx)
  
--Sample Data
insert into visit values(seq_visit_idx.nextVal,
                         '�ϱ浿',
                         '���� 1���̴�~~',
                         '1234',
                         '127.0.0.1',
                         sysdate);
                         
--����
update visit set name='�ϱ浿',
                 content='���� 1���̴�@@',
                 pwd='1234',
                 ip='192.168.0.20',
                 regdate=sysdate
where idx=1
                                          
--����
delete from visit where idx=2                         
                         
                         
--�ֱٱ��� �տ� ��ġ                         
select * from visit order by idx desc

--idx�� �ش�Ǵ� �� 1�� ������
select * from visit where idx=1
                                                  
                         
                             
  
  




*/