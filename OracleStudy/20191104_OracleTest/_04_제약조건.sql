/*
   ### 제약조건(Constraint)
   : Data Integrity(데이터 무결성)을 지키기한 제한사항
   
   ex) 성별입력
       gender varchar2(10)  default '남자'
       '남 자' '남자' '남' 'male' 'man' 'M' '여자'  '여' 'female'
       ##조건
       where gender='남자' or gender='남' or gender='male'
       
   1.null(허용) or not null(필드입력):기본값 null
   2.unique : 엔티티무결성->동일값허용 안된다(유일값)
   3.check  : 도메인무결성:조건에 만족하는 값만 허용 
   4.default: 기본값
   5.primary key : not null + unique + index 
   6.foreign key : 유효한 값에 대한 비교값을 외부테이블의 도메인에서 참조
    (도메인무결성) 부모키가 될수 있는 조건=> unique 
   
   
--ex1) not null : 필수입력
              null : null허용
              
   create table tb1
   (
      name varchar2(100) not null,
      tel  varchar2(100) null
   )
   
   insert into tb1 values('일길동','010-111-1111')
   insert into tb1(name) values('이길동')
   insert into tb1(name,tel) values('삼길동',null)
   
   --error확인
   insert into tb1(tel) values('010-222-2222')
      
   select * from tb1
   
--ex2) unique : 도메인내 중복값 허용안함(고유값)
       cf)제약조건은 중복해서 사용가능
   create table tb2
   (
      id  varchar2(100)  unique not null,
      name varchar2(100) not null 
   )
   insert into tb2 values('one','하나')
   --제약 위배(unique)
   --무결성 제약 조건(TEST.SYS_C004003)에 위배됩니다
   insert into tb2 values('one','김하나')
    
   create table tb22
   (
      id   varchar2(100)  not null,
      name varchar2(100)  not null 
   ) 
   
   --제약조건 추가(이름을 부여)
   alter table tb22
     add constraint unique_tb22_id unique(id) 
                      (제약조건명)
                      
   insert into tb22 values('two','둘')
   --무결성 제약 조건(TEST.UNIQUE_TB22_ID)에 위배됩니다
   insert into tb22 values('two','김둘')
   
   create table tb222
   (
      id   varchar2(100)  not null,
      name varchar2(100)  not null,
      --제약조건
      constraint unique_tb222_id unique(id) 
   ) 
   
--ex3) check제약  
   create table tb3
   (
      name   varchar2(100) not null,
      gender varchar2(100)
   )

   --제약조건명:ck_tb3_gender 
   alter table tb3
      add constraint ck_tb3_gender 
                     check(gender='남자' or gender='여자') 
                     
   insert into tb3 values('일길동','남자')
   --체크 제약조건(TEST.CK_TB3_GENDER)이 위배되었습니다                   
   insert into tb3 values('이길동','남 자')
   
   create table tb33
   (
      name varchar2(100) not null,
      kor  number(3),
      eng  int,
      mat  int
   )
   
   alter table tb33
      add constraint ck_tb33_kor
                     check(kor>=0 and kor<=100) 
                     
   alter table tb33
      add constraint ck_tb33_eng
                     check(eng>=0 and eng<=100) 
                                                                                                                      
   alter table tb33
      add constraint ck_tb33_mat
                     check(mat>=0 and mat<=100)                                                                                                                       

   cf)java:(kor>=0 && kor<=100)
   --체크 제약조건(TEST.CK_TB33_KOR)이 위배되었습니다
   insert into tb33 values('일길동',101,99,88)
   
   --체크 제약조건(TEST.CK_TB33_ENG)이 위배되었습니다
   insert into tb33 values('이길동',100,-99,88)
   
   --체크 제약조건(TEST.CK_TB33_MAT)이 위배되었습니다
   insert into tb33 values('삼길동',100,99,888)
   
   cf) Dictionary Table(사용객체에 대한정보 기록해놓은 테이블)
            제약조건만 저장해놓은 테이블: user_constraints   
   
   --제약조건 확인 SQL
   select 
         constraint_type,
         constraint_name,
         owner,
         table_name
   from  user_constraints
   where table_name='TB33'

--ex4) default
   create table tb4
   (
      name   varchar2(100) not null,
      gender varchar2(100) default '남자',
      age    int           default 1
   )   
   
   insert into tb4 values('일길동','남자',20)
   insert into tb4(name) values('이길동')
   insert into tb4 values('일길동',default,default)
   
   select * from tb4
   
--ex5) primary key(기본키)
       : 레코드를 구분할수 있는 대표키
       : not null + unique + index 조합된 형식의 제약조건   
       : 테이블내에서는 무조건 기본키가 있어야 된다.
    
    create table tb5
    (
       idx  int,
       name varchar2(100) not null,
       id   varchar2(100) not null unique
    )   
    
    --기본키 추가
    alter table tb5
      add constraint pk_tb5_idx primary key(idx)
    
    --NULL을 ("TEST"."TB5"."IDX") 안에 삽입할 수 없습니다  
    insert into tb5 values(null,'널길동','hong') 
    
    insert into tb5 values(1,'일길동','one')
    --무결성 제약 조건(TEST.PK_TB5_IDX)에 위배됩니다
    insert into tb5 values(1,'이길동','two')  
     
       
--ex6) foreign key(외래키)    
       :유효한 값에 대한 비교값을 외부테이블의 도메인에서 참조                   

  create table student
  (
     hakbun int,
     name   		varchar2(100) not null,
     tel    		varchar2(100) not null,
     parent_name 	varchar2(100) not null,
     parent_job  	varchar2(100) not null,
     constraint pk_student_hakbun primary key(hakbun)        
  )
  
  insert into student values(1,'일길동','111-1111',
                               '일아비','자영업');                                                          
  insert into student values(2,'이길동','222-1111',
                               '이아비','회사원');             
  select * from student                
               
  commit             
   
  --성적테이블
  create table sungjuk
  (
     idx int,
     hakbun int,
     kor int,
     eng int,
     mat int
  )
  
  --기본키
  alter table sungjuk
     add constraint pk_sungjuk_idx primary key(idx)
  
  --외래키
  alter table sungjuk
     add constraint fk_sungjuk_hakbun  
                    foreign key(hakbun) 
                    references student(hakbun)  
  --성적 입력
  insert into sungjuk values(1,1,100,90,60);
  insert into sungjuk values(2,2,80,90,60);
  
  --무결성 제약조건(TEST.FK_SUNGJUK_HAKBUN)이 위배되었습니다 
  --부모 키가 없습니다
  insert into sungjuk values(3,3,100,90,60);   
         
  --join:테이블 합쳐서 조회하는 방법 
  select * from student,sungjuk
  where  student.hakbun=sungjuk.hakbun
               
   
             


       
                 
         

*/