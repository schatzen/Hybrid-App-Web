/*

--��ٱ��� �Ϸù�ȣ
create sequence seq_cart_idx

--��ٱ��� ���̺�
create table cart
(
  c_idx  int,
  c_cnt  int  not null,
  p_idx  int,
  m_idx  int,
  constraint  pk_cart_c_idx primary key(c_idx)
)

--��ǰ���̺�(product)�� idx�� p_idx���� �ܷ�Ű ����
--�������� ����
alter table cart
  drop constraint fk_cart_p_idx

alter table cart
  add constraint fk_cart_p_idx foreign key(p_idx) 
                               references product(idx) on delete cascade

--�������� ����                                                        
alter table cart
  drop constraint fk_cart_m_idx
  
alter table cart
  add constraint fk_cart_m_idx foreign key(m_idx) 
                               references member(idx) on delete cascade 



select * from product;
select * from member;

insert into cart values(seq_cart_idx.nextVal,1,1,2);
insert into cart values(seq_cart_idx.nextVal,1,2,2);
insert into cart values(seq_cart_idx.nextVal,1,3,2);

select * from cart

commit

-- Join�� ���ؼ� ��ȸ������ ����
create or replace view cart_view
as
	select
	   idx p_idx,c_idx,m_idx, p_num,p_name,p_price,p_saleprice,
	   c_cnt, c_cnt* p_saleprice amount
	from product p inner join  cart c  on p.idx = c.p_idx 
	     inner join member m           on c.m_idx = m.idx 

select * from cart_view where m_idx=2;

--��ٱ��� ��ǰ�� �Ѱ�
select sum(amount) from cart_view where m_idx=2;













*/