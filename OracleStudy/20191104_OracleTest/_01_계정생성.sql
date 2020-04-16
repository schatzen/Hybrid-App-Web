-- 1줄 주석
/*
    범위주석 
*/

/*

1.계정생성 (DDL)
              (계정)              (비번) 
  create user test identified by test
  
2.권한부여 (DCL)  
            (권한명)
  grant connect,resource to test
  
  --권한회수
  revoke connect from test

3.계정잠금/해제(DDL)  
  alter user test account lock
  alter user test account unlock
  
4.계정삭제 (DDL)  
  create user test1 identified by test1
  drop user test1
  
  
*/