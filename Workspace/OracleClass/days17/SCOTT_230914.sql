-- ���� ����
-- ���� ������ SQL�� ���� ����
1. ���� SQL�� ����ϴ� 3���� ��Ȳ
    1) ������ �ÿ� SQL������ Ȯ������ ���� ���(���� ���� ���Ǵ� ���)
        WHERE ������...
    2) PL/SQL �� �ȿ��� DDL ���� ����ϴ� ���
        CREATE, ALTER, DROP
        ��) ������ �Խ��� ����
            ������ �÷� (��¥,����,����)
            üũ�� �÷����� �������� �Խ��� ����
    3) PL/SQL�� �ȿ���
        ALTER SYSTEM/SESSION ��ɾ ����� ���

2. PL/SQL���� ���� ������ ����ϴ� 2���� ���
    1) NDS(Native DYNAMIC SQL)���� ���� ����
        EXEC[UTE] IMMEDIATE ��
        ����)
        EXEC[UTE] IMMEDIATE ����Ŀ����
            [INTO ������,������...]
            [USING [IN/OUT/IN] OUT�Ķ����...]
    2) DBMS_SQL ��Ű�� (���������� X)

3. �������� ����
    1) �͸� ���ν���
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

    --���� ���ν���
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
        -- ���ε庯�� :empno
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

-- ���� dept���̺� ���ο� �μ� �߰��ϴ� ���� ������ ����ϴ� ���� ���ν���
SELECT *
FROM dept;

--seq_dept ������ 50, 10 ,nocache

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

    DBMS_OUTPUT.PUT_LINE('INSERT ����');
    COMMIT;
END;

EXEC up_ndsInsDept('QC','SEOUL');

SELECT *
FROM dept;

-- ����ڰ� ���ϴ� ������ �Խ����� ����(DDL��) ��������
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

-- OPEN - FOR �� : select ��� �������� �� + �ݺ� ó��
    OPEN Ŀ��
    FOR Ŀ�� �ݺ� ó��
    -- ���� SQL���� ���� -> �����(�������� ��) + Ŀ�� ó��

-- ����
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
  -- OPEN FOR�� 
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

-- ���� ���� �˻� ����
-- [�μ���ȣ, �μ���, ������] ����
-- �˻��� �Է� ����

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

    -- EXECUTE IMMEDIATE --����
    -- OPEN FOR �� ���
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
   psearchCondition NUMBER -- 1. �μ���ȣ, 2.�����, 3. ��
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
  -- OPEN FOR�� 
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