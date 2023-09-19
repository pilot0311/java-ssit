-- PL/SQL ����ó��
-- 1) �̸� ���ǵ� ���� ó�� ���SELECT
    ename,sal
FROM emp
WHERE sal = 1250; --2��
WHERE sal = 6000; --0��
WHERE sal = 800;  --1��

CREATE OR REPLACE PROCEDURE up_emplist
(
    psal emp.sal%TYPE
)
IS
    vename emp.ename%TYPE;
    vsal emp.sal%TYPE;
BEGIN
    SELECT ename,sal INTO vename, vsal
    FROM emp
    WHERE sal = psal;
    DBMS_OUTPUT.PUT_LINE(vename ||','||vsal);
EXCEPTION
    WHEN NO_DATA_FOUND THEN 
        RAISE_APPLICATION_ERROR(-20002,'> QUERY DATA NOT FOUND');
    WHEN TOO_MANY_ROWS THEN
        RAISE_APPLICATION_ERROR(-20003,'> QUERY TOO_MANY_ROWS_FOUND');
    WHEN OTHERS THEN    --�� �� ��� ���� �߻� ���
        RAISE_APPLICATION_ERROR(-20004,'> QUERY OTHERS EXCEPTION FOUND');
END;

EXEC up_emplist(800);
EXEC up_emplist(6000);  --ORA-01403: no data found
EXEC up_emplist(1250);  --ORA-01422: exact fetch returns more than requested number of rows

--2) �̸� ���ǵ��� ���� ����ó�� ���

SELECT *
FROM dept;

INSERT INTO dept VALUES (40,'QC','SEOUL');  --ORA-00001: unique constraint (SCOTT.PK_DEPT) violated
INSERT INTO emp (empno,ename,deptno) VALUES (9999,'admin',90);  --ORA-02291: integrity constraint (SCOTT.FK_DEPTNO) violated - parent key not found

CREATE OR REPLACE PROCEDURE up_insemp
(
    pempno emp.empno%TYPE,
    pename emp.ename%TYPE,
    pdeptno emp.deptno%TYPE
)
IS
    NO_FK_FOUND EXCEPTION;
    PRAGMA EXCEPTION_INIT (NO_FK_FOUND,-02291);
BEGIN
    INSERT INTO emp (empno,ename,deptno) VALUES (pempno,pename,pdeptno);
    COMMIT;
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN 
        RAISE_APPLICATION_ERROR(-20001,'> QUERY PK ����');
    WHEN NO_FK_FOUND THEN
        RAISE_APPLICATION_ERROR(-20002,'> QUERY deptno FK ����');
    WHEN OTHERS THEN    --�� �� ��� ���� �߻� ���
        RAISE_APPLICATION_ERROR(-20004,'> QUERY OTHERS EXCEPTION FOUND');
END;

EXEC up_insemp (9999,'admin',90);

--3) ����ڰ� �����ϴ� ���� ó�� ���
��) psal [a~b]�Է�
    ������� 0�̶�� ������ ���� �߻�...

CREATE OR REPLACE PROCEDURE up_empexception
(
    psal emp.sal%TYPE
)
IS
    vempcount NUMBER;
    NO_EMP_EXCEPTION EXCEPTION;
BEGIN
    SELECT COUNT(*) INTO vempcount
    FROM emp
    WHERE sal BETWEEN psal -100 AND psal+100;

    IF vempcount = 0 THEN
        RAISE NO_EMP_EXCEPTION;
    ELSE
        DBMS_OUTPUT.PUT_LINE('>�����: '||vempcount);
    END IF;
EXCEPTION
    WHEN NO_EMP_EXCEPTION THEN
        RAISE_APPLICATION_ERROR(-20004,'> QUERY�� ����� ����');
    WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR(-20004,'> QUERY OTHERS EXCEPTION FOUND');
END;
EXEC up_empexception (900); --2��
EXEC up_empexception (6000);    --0��   --ORA-06510: PL/SQL: unhandled user-defined exception
--ORA-20004: > QUERY�� ����� ����

--REGEXP_LIKE (USER_PWD,'/^.*(?=.{8,12})(?=*[a-zA-Z])(?=.*[0-9])(?=.[!"#$%'()*+,-.\/:;<=>?@[]^_`{|}~]).*$/')"#$%'()*+,-.\/:;<=>?@[]^_`{|}~]).*$/')

REGEXP_LIKE (USER_PWD,'/^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!"#$%'()*+,\-./:;<=>?@\[]^_`{|}~]).{8,12}$/')


GRANT CREATE VIEW TO cgv_db;=>?@\[]^_`{|}~]).{8,12}
    $
        /')


GRANT CREATE VIEW TO cgv_db;