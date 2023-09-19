-- 동적 쿼리
-- 실행 시점에 SQL이 결정 상태
1. 동적 SQL을 사용하는 3가지 상황
    1) 컴파일 시에 SQL문장이 확정되지 않은 경우(가장 많이 사용되는 경우)
        WHERE 조건절...
    2) PL/SQL 블럭 안에서 DDL 문을 사용하는 경우
        CREATE, ALTER, DROP
        예) 여러개 게시판 생상
            저장할 컬럼 (날짜,내용,제목)
            체크한 컬럼으로 동적으로 게시판 생성
    3) PL/SQL블럭 안에서
        ALTER SYSTEM/SESSION 명령어를 사용할 경우

2. PL/SQL에서 동적 쿼리를 사용하는 2가지 방법
    1) NDS(Native DYNAMIC SQL)원시 동적 쿼리
        EXEC[UTE] IMMEDIATE 문
        형식)
        EXEC[UTE] IMMEDIATE 동적커리문
            [INTO 변수명,변수명...]
            [USING [IN/OUT/IN] OUT파라미터...]
    2) DBMS_SQL 패키지 (수업에서는 X)

3. 동적쿼리 예제
    1) 익명 프로시저
    DECLARE
        vsql VARCHAR2(2000);
        vdeptno emp.DEPTNO%TYPE;
        vempno  emp.EMPNO%TYPE;
        vename  emp.ENAME%TYPE;
        vjob    emp.JOB%TYPE;
    BEGIN
        vsql := ' SELECT deptno,empno,ename,job ';
        vsql := vsql || ' FROM emp ';
        vsql := vsql || ' WHERE empno = 7369 ';

        EXECUTE IMMEDIATE vsql
            INTO vdeptno, vempno, vename, vjob;
        
        DBMS_OUTPUT.PUT_LINE(vdeptno || ',' || vempno || ',' || vename || ',' || vjob);
    --EXCEPTION
    END;

    --저장 프로시저
    CREATE OR REPLACE PROCEDURE up_ndsemp
    (
        pempno emp.EMPNO%TYPE
    )
    IS
        vsql VARCHAR2(2000);
        vdeptno emp.DEPTNO%TYPE;
        vempno  emp.EMPNO%TYPE;
        vename  emp.ENAME%TYPE;
        vjob    emp.JOB%TYPE;
    BEGIN
        -- 바인드변수 :empno
        vsql := ' SELECT deptno,empno,ename,job ';
        vsql := vsql || ' FROM emp ';
        vsql := vsql || ' WHERE empno =:pempno ';

        EXECUTE IMMEDIATE vsql
            INTO vdeptno, vempno, vename, vjob
            USING IN pempno;
        
        DBMS_OUTPUT.PUT_LINE(vdeptno || ',' || vempno || ',' || vename || ',' || vjob);
    --EXCEPTION
    END;

EXEC up_ndsemp(7369);

-- 문제 dept테이블에 새로운 부서 추가하는 동적 쿼리를 사용하는 저장 프로시저
SELECT *
FROM dept;

--seq_dept 시퀀스 50, 10 ,nocache

CREATE SEQUENCE  "SCOTT"."SEQ_DEPT"  
MINVALUE 1 
MAXVALUE 90 
INCREMENT BY 10 
START WITH 50
NOCACHE  NOORDER  NOCYCLE ;

CREATE OR REPLACE PROCEDURE up_ndsInsDept
(
    pdname  dept.DNAME%TYPE := null,
    ploc    dept.LOC%TYPE DEFAULT NULL
)
IS
    vsql VARCHAR2(2000);
BEGIN
    vsql := ' INSERT INTO dept (deptno, dname, loc) ';
    vsql := vsql || ' VALUES (SEQ_DEPT.NEXTVAL, :pdname, :ploc) ';

    EXECUTE IMMEDIATE vsql
        --INTO 
        USING pdname,ploc;

    DBMS_OUTPUT.PUT_LINE('INSERT 성공');
    COMMIT;
END;

EXEC up_ndsInsDept('QC','SEOUL');

SELECT *
FROM dept;

-- 사용자가 원하는 형태의 게시판을 생성(DDL문) 동적쿼리
DECLARE
    vtablename VARCHAR2(100);
    vsql VARCHAR2(2000);
BEGIN
    vtablename := 'tbl_board';

    vsql := ' CREATE TABLE ' || vtablename;
    vsql := vsql || ' ( ' ;
    vsql := vsql || ' id NUMBER PRIMARY KEY ' ;
    vsql := vsql || ' , name VARCHAR2(20) ' ;
    vsql := vsql || ' ) ' ;
    DBMS_OUTPUT.PUT_LINE(vsql);

    EXECUTE IMMEDIATE vsql;

END;

DESC tbl_board;

-- OPEN - FOR 문 : select 결과 여러개의 행 + 반복 처리
    OPEN 커서
    FOR 커서 반복 처리
    -- 동적 SQL문을 실행 -> 결과물(여러개의 행) + 커서 처리

-- 예제
CREATE OR REPLACE PROCEDURE  up_ndsSelEmp
(
   pdeptno emp.deptno%TYPE
)
IS
  vsql  VARCHAR2(2000);
  vcur  SYS_REFCURSOR;  -- 9i  REF CURSOR
  vrow emp%ROWTYPE;
BEGIN
  vsql := 'SELECT * ';
  vsql := vsql || ' FROM emp ';
  vsql := vsql || ' WHERE  deptno = :pdeptno ';
  
  -- X  EXECUTE IMMEDIATE vsql;
  -- OPEN FOR문 
  OPEN vcur  FOR vsql      USING pdeptno; 
  
  LOOP
    FETCH vcur INTO vrow;
--     DBMS_OUTPUT.PUT_LINE( vrow.empno || ' ' || vrow.ename );
    EXIT WHEN vcur%NOTFOUND;
     DBMS_OUTPUT.PUT_LINE( vrow.empno || ' ' 
     || vrow.ename );
  END LOOP; 
  CLOSE vcur; 
  
--EXCEPTION
END;

EXEC up_ndsSelEmp(30);

-- 동적 쿼리 검색 예제
-- [부서번호, 부서명, 지역명] 선택
-- 검색어 입력 엔터

CREATE OR REPLACE PROCEDURE up_ndsSelEmp
(
    pdeptno emp.deptno%TYPE
)
IS
    vsql VARCHAR2(2000);
    vcur SYS_REFCURSOR;     -- 9i REF CURSOR
    vrow emp%ROWTYPE;
BEGIN
    vsql := ' SELECT * ';
    vsql := vsql || ' FROM emp ';
    vsql := vsql || ' WHERE deptno = :pdeptno ';

    -- EXECUTE IMMEDIATE --못씀
    -- OPEN FOR 문 사용
    OPEN vcur FOR vsql
    USING pdeptno;

LOOP
    FETCH vcur INTO vrow;
    EXIT WHEN vcur%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(vrow.empno || ',' || vrow.ename);
END LOOP;
CLOSE vcur;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RAISE_APPLICATION_ERROR(-20001,'> DATA NOT FOUND');
    WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR(-20004,'> OTHER ERRORS...');
END;
END;

-------------------------------

CREATE OR REPLACE PROCEDURE  up_ndsSearchEmp
(
   psearchCondition NUMBER -- 1. 부서번호, 2.사원명, 3. 잡
   , psearchWord VARCHAR2
)
IS
  vsql  VARCHAR2(2000);
  vcur  SYS_REFCURSOR;  -- 9i  REF CURSOR
  vrow emp%ROWTYPE;
BEGIN
  vsql := 'SELECT * ';
  vsql := vsql || ' FROM emp ';
  
  IF psearchCondition = 1 THEN 
    vsql := vsql || ' WHERE  deptno = :psearchWord ';
  ELSIF psearchCondition = 2 THEN
    vsql := vsql || ' WHERE  REGEXP_LIKE( ename , :psearchWord )';
  ELSIF psearchCondition = 3 THEN
    vsql := vsql || ' WHERE  REGEXP_LIKE( job , :psearchWord , ''i'')';
  END IF;
  
   
  
  -- X  EXECUTE IMMEDIATE vsql;
  -- OPEN FOR문 
  OPEN vcur  FOR vsql      USING psearchWord; 
  
  LOOP
    FETCH vcur INTO vrow; 
    EXIT WHEN vcur%NOTFOUND;
     DBMS_OUTPUT.PUT_LINE( vrow.empno || ' ' 
     || vrow.ename  ||' '|| vrow.job );
  END LOOP; 
  CLOSE vcur; 
  
EXCEPTION
  WHEN NO_DATA_FOUND THEN
    RAISE_APPLICATION_ERROR(-20001, '>DAATA NOT FOUND...');
  WHEN OTHERS THEN 
    RAISE_APPLICATION_ERROR(-20004, '>OTHER ERROR...');
END;  
  
EXEC UP_NDSSEARCHEMP(1, '20'); 
EXEC UP_NDSSEARCHEMP(2, 'L'); 
EXEC UP_NDSSEARCHEMP(3, 's'); 
  
  
  CREATE
    user
    cgv_db
    identified
    by
        1234;