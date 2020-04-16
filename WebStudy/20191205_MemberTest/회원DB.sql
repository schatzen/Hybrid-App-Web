/*

  --�Ϸù�ȣ���� ��ü
  create sequence  seq_member_idx
  
  --ȸ�� Table
  drop table member
  
  create table member
  (
  	 idx  		int,					--�Ϸù�ȣ
  	 name 		varchar2(100) not null,	--�̸�
  	 id   		varchar2(100) not null,	--���̵�
  	 pwd  		varchar2(100) not null,	--��й�ȣ
  	 zipcode 	varchar2(10),			--�����ȣ
  	 addr		varchar2(100),			--�ּ�  	
  	 ip			varchar2(100),			--IP
  	 grade      varchar2(100),          --ȸ������(�Ϲ�,������) 
  	 regdate	date,					--��������
  	 modifydate date					--��������		
  )
  
  --�⺻Ű
  alter table member
    add constraint pk_member_idx primary key(idx);
    
  --id  unique����
  alter table member
    add constraint unique_member_id unique(id);
  
  --ȸ�����
  alter table member
    add constraint ck_member_grade check(grade in('�Ϲ�','������')); 
    
      
-- Sample data
  insert into member values(
                seq_member_idx.nextVal,
                '�ϱ浿',
                'one',
                '1234',
                '12345',
                '���� ���� ���굿 111',
                '127.0.0.1',
                '�Ϲ�',
                sysdate,
                sysdate                
  );   
  
  
  insert into member values(
                seq_member_idx.nextVal,
                '�����',
                'admin',
                '1234',
                '12345',
                '���� ���� ���굿 111',
                '127.0.0.1',
                '������',
                sysdate,
                sysdate                
  );
  select * from member  
  
  commit
      
    
  
  



*/