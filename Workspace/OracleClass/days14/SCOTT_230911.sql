--�͸� ���ν��� ���� RECORD �� ����
--�͸� ���ν��� ���� %TYPE �� ���� ����
DECLARE
  Vdeptno NUMBER(2);
  vdname  dept.DNAME%TYPE;
  vempno  emp.EMPNO%TYPE;
  vename  emp.ENAME%TYPE;
  vpay    NUMBER;
BEGIN
  SELECT d.DEPTNO,D.DNAME,E.EMPNO,E.ENAME,sal+NVL(E.COMM,0)pay
    INTO Vdeptno,vdname,vempno,vename,vpay
  FROM dept d JOIN emp e ON d.deptno = e.deptno
  WHERE empno = 7369;
  DBMS_OUTPUT.PUT_LINE(Vdeptno ||','||vdname||','||vempno||','||vename||','||vpay);
--EXCEPTION
END;

--�͸� ���ν��� ���� %ROWTYPE �� ���� ���
DECLARE
  vdrow dept%ROWTYPE;
  verow emp%ROWTYPE;
  vpay NUMBER;
BEGIN
  SELECT d.DEPTNO,D.DNAME,E.EMPNO,E.ENAME,sal+NVL(E.COMM,0)pay
    INTO vdrow.deptno,vdrow.dname,verow.empno,verow.ename,vpay
  FROM dept d JOIN emp e ON d.deptno = e.deptno
  WHERE empno = 7369;
  DBMS_OUTPUT.PUT_LINE(vdrow.deptno||','||vdrow.dname||','||verow.empno||','||verow.ename||','||vpay);
--EXCEPTION
END;

--�͸� ���ν��� ���� RECORD �� ����
DECLARE
  --����� ���� ����ü Ÿ�� ����
  TYPE EmpDeptType IS RECORD
  (
    deptno NUMBER(2),
    dname  dept.DNAME%TYPE,
    empno  emp.EMPNO%TYPE,
    ename  emp.ENAME%TYPE,
    pay    NUMBER
  );
  vderow EmpDeptType;
BEGIN
  SELECT d.DEPTNO,D.DNAME,E.EMPNO,E.ENAME,sal+NVL(E.COMM,0)pay
    INTO vderow.deptno,vderow.dname,vderow.empno,vderow.ename,vderow.pay
  FROM dept d JOIN emp e ON d.deptno = e.deptno
  WHERE empno = 7369;
  DBMS_OUTPUT.PUT_LINE(vderow.deptno||','||vderow.dname||','||vderow.empno||','||vderow.ename||','||vderow.pay);
--EXCEPTION
END;

--CURSOR(Ŀ��)
-- �ݵ�� Ŀ���� ����ؼ� fetch(��������)
--ORA-01422: exact fetch returns more than requested number of rows
DECLARE
  --����� ���� ����ü Ÿ�� ����
  TYPE EmpDeptType IS RECORD
  (
    deptno NUMBER(2),
    dname  dept.DNAME%TYPE,
    empno  emp.EMPNO%TYPE,
    ename  emp.ENAME%TYPE,
    pay    NUMBER
  );
  vderow EmpDeptType;
BEGIN
-- 1���� ������ (�Ͻ��� Ŀ��)
  SELECT d.DEPTNO,D.DNAME,E.EMPNO,E.ENAME,sal+NVL(E.COMM,0)pay
    INTO vderow.deptno,vderow.dname,vderow.empno,vderow.ename,vderow.pay
  FROM dept d JOIN emp e ON d.deptno = e.deptno;
  --WHERE empno = 7369;
  DBMS_OUTPUT.PUT_LINE(vderow.deptno||','||vderow.dname||','||vderow.empno||','||vderow.ename||','||vderow.pay);
--EXCEPTION
END;

-- 5) CURSOR(Ŀ��)
1. pl.sql �� ������ ����Ǵ� select���� �ǹ��Ѵ�
2. ���� ���ڵ�� ������ �۾��������� sql���� �����ϰ� �� ����� �����ϱ� ���ؼ� cursor�� ����Ѵ�
3. Ŀ�� 2���� ����
    1) ������(implicit cursor) == �Ͻ��� == �ڵ�
      �Ϲ������� ���ȴ� SQL���� ������ Ŀ���� �Ѵ�. �� �� ���࿡ �ϳ��� ����� ��ȯ�ϴ� SQL���� �ǹ� ��
    2) �����(explicit cursor)
      SQL���� �������� �� �� ����� ���� ���� ��쿡 ������ Ŀ���� ����ϸ� �ش� SQL���� ������ �߻���
      ������ ������ Ŀ���� ���Ǵ� ��Į�� ������ �� ���� �ϳ��� ���� ������ �� �ֱ� ������
      �̷��� ���� ���� ���� ��ȯ�Ǵ� SQL���� �����ϴ� ��쿡�� �ݵ�� ����� Ŀ���� ����ؾ� ��
      (1)����� Ŀ���� ����ϴ� ����
          ��. Ŀ�� ����   : SELECT���� �ۼ�
          ��. Ŀ�� OPEN   : SELECT���� ����
          ��. Ŀ�� FETCH  : ������� ���� �ִ� Ŀ���� ���� ��������(FETCH) -> �ݺ����� ����ؼ� ó��
                                                                      Ŀ���� �Ӽ�
                                                                      %NOTFOUND   : Ŀ���� ���� ������ ����
                                                                      %FOUND      : Ŀ���� ���� �ִ��� ����
                                                                      %ISOPEN     : ���� Ŀ�� ����
                                                                      %ROUWCOUNT  : Ŀ���� ����ؼ� ���� ���� ��
          ��. Ŀ�� CLOSE
--CURSOR(Ŀ��) ����
DECLARE
  TYPE EmpDeptType IS RECORD
  (
    deptno NUMBER(2),
    dname  dept.DNAME%TYPE,
    empno  emp.EMPNO%TYPE,
    ename  emp.ENAME%TYPE,
    pay    NUMBER
  );
  vderow EmpDeptType;
  --1) Ŀ�� ����
  -- CURSOR Ŀ���� IS SELECT�� ;   == CURSOR ���� ����
  CURSOR edcursor IS ( SELECT d.DEPTNO,d.DNAME,e.EMPNO,e.ENAME,sal+NVL(e.COMM,0)pay
                       FROM dept d JOIN emp e ON d.deptno = e.deptno );
BEGIN
  --2) Ŀ�� ���� OPEN
  -- ����) OPEN Ŀ����;
  OPEN edcursor;
  --3) Ŀ�� FETCH
  LOOP
    FETCH edcursor INTO vderow;
     --                      '���ڿ�'  t/f
    --DBMS_OUTPUT.PUT_LINE(edcursor%ISOPEN);
    IF  edcursor%ISOPEN THEN
      DBMS_OUTPUT.PUT_LINE('TRUE');
    ELSE
      DBMS_OUTPUT.PUT_LINE('FALSE');
    END IF;
    DBMS_OUTPUT.PUT_LINE(vderow.deptno||','||vderow.dname||','||vderow.empno||','||vderow.ename||','||vderow.pay);
    EXIT WHEN edcursor%NOTFOUND;
  END LOOP;
 
  --4) Ŀ������ CLOSE
  -- ����) CLOSE Ŀ����
  CLOSE edcursor;
--EXCEPTION
END;          


--6) �͸����ν��� ����  FOR ������ؼ� Ŀ��
DECLARE
  TYPE EmpDeptType IS RECORD
  (
    deptno NUMBER(2),
    dname  dept.DNAME%TYPE,
    empno  emp.EMPNO%TYPE,
    ename  emp.ENAME%TYPE,
    pay    NUMBER
  );
  vderow EmpDeptType;
  --1) Ŀ�� ����
  -- CURSOR Ŀ���� IS SELECT�� ;   == CURSOR ���� ����
  CURSOR edcursor IS ( SELECT d.DEPTNO,d.DNAME,e.EMPNO,e.ENAME,sal+NVL(e.COMM,0)pay
                       FROM dept d JOIN emp e ON d.deptno = e.deptno );
BEGIN
 
  --3) Ŀ�� FETCH  for�� ����ϱ�
  FOR vderow IN edcursor
  LOOP
    DBMS_OUTPUT.PUT_LINE(vderow.deptno||','||vderow.dname||','||vderow.empno||','||vderow.ename||','||vderow.pay);
  END LOOP;
--EXCEPTION
END;

-- 6-2) FOR �� ���� ���� ���� ����, Ŀ�� ����� -> for��, open,close���� ����
DECLARE
BEGIN
  --3) Ŀ�� FETCH  for�� ����ϱ�
  FOR vderow IN ( SELECT d.DEPTNO,d.DNAME,e.EMPNO,e.ENAME,sal+NVL(e.COMM,0)pay
                  FROM dept d JOIN emp e ON d.deptno = e.deptno )
  LOOP
    DBMS_OUTPUT.PUT_LINE(vderow.deptno||','||vderow.dname||','||vderow.empno||','||vderow.ename||','||vderow.pay);
  END LOOP;
--EXCEPTION
END;


-- ���� ���ν���(stored procideur)
-- 1) PL/SQL�� ���� ��ǥ���� ����
-- 2) �����ͺ��̽� ��ü ����
-- 3) ����

CREATE [OR REPLACE] PROCEDURE [���ν����̸�] --up_���ν�����
 (--�Ű�����,�Ķ����,���� p���λ�
  argument1 [mode] data_type1,
  argument2 [mode] data_type2,
     ...............
 )
  IS [AS]
    -- ���� ��: ���� ���� v���λ�
  BEGIN
    -- ���� ��
  EXCEPTION
    --����ó�� ��
  END;

-- 4) ���� ���ν����� �����ϴ� 3���� ���
      (1) EXEC[UTE]
      (2) �͸� ���ν��� �ȿ��� ����
      (3) �� �ٸ� ���� ���ν��� �ȿ��� ����

--�ǽ�
CREATE TABLE tbl_emp
AS
(
  SELECT * FROM emp
);
-- 1) �����ڰ� ���� �����ϴ� ���� --> �������ν���
--    ����) ��� ��ȣ�� �Է� �޾Ƽ� �ش� ����� �����ϴ� ����
DELETE FROM tbl_emp
WHERE empno = 7369;
COMMIT;

-- ���� delete ���� ���ν����� �����
CREATE OR REPLACE PROCEDURE up_delEMP
(
  -- ���� ���ν����� �Ķ���� ���� �� �ڷ����� ũ�� X
  -- ���� ���ν����� �Ķ���� ������ ���� �� �޸� ������
  --pempno NUMBER(4);
  --pempno NUMBER
  --pempno �Ķ���͸�� emp.EMPNO%TYPE
  --        �� IN(�Է¿�,�⺻��),OUT(��¿�), IN OUT(����¿�)
  pempno IN emp.EMPNO%TYPE
)
IS
BEGIN
  DELETE FROM tbl_emp
  WHERE empno = pempno;
  COMMIT;
--EXCEPTION
  --����ó��
END;

--����
(1)execute ��
EXECUTE up_delemp(pempno=>7369);
EXECUTE up_delemp(7934);
(2) �͸� ���ν��� �ȿ��� ���� ���ν��� ����
BEGIN
  up_delemp(7902);
END;
(3) �� �ٸ� ���� ���ν��� �ȿ��� ����
CREATE OR REPLACE PROCEDURE up_delemp_test
IS
BEGIN 
  up_delemp(7900);
END;

EXEC up_delemp_test;

-- ����)
--1) dept ���̺� �����ؼ� tbl_dept ����
CREATE TABLE tbl_dept
AS(
  SELECT * FROM dept
);
--2) �μ��� ���� �� �Է� �޾Ƽ� ���ο� �μ��� �߰��ϴ� ���� ���ν����� ���� up_insertdept
CREATE OR REPLACE PROCEDURE up_insertdept
(
  --pDEPTNO IN dept.DEPTNO%TYPE,
  pDNAME  IN dept.DNAME%TYPE,
  pLOC    IN DEPT.LOC%TYPE
)
IS
  vdeptno dept.DEPTNO%TYPE;
BEGIN

  SELECT MAX(deptno) INTO vdeptno FROM dept;

  vdeptno := vdeptno+10;

  INSERT INTO TBL_DEPT VALUES (vdeptno,pDNAME,pLOC);
  COMMIT;
END;
--3) ���� ���μ��� ����
EXEC up_insertdept('QC','SEOUL');

DELETE FROM tbl_dept
WHERE deptno = 50;
commit;


--SEQUENCE ���
CREATE SEQUENCE seq_tbldept
INCREMENT BY 10
START WITH 50
MAXVALUE 90
NOCYCLE
NOCACHE;

CREATE OR REPLACE PROCEDURE up_insertdept
(
  --pDEPTNO IN dept.DEPTNO%TYPE,
  pDNAME  IN dept.DNAME%TYPE  :=NULL,
  pLOC    IN DEPT.LOC%TYPE    DEFAULT NULL
)
IS
  
BEGIN


  INSERT INTO TBL_DEPT VALUES (seq_tbldept.NEXTVAL,pDNAME,pLOC);
  COMMIT;
END;


--�μ��� O, ������ X
--EXEC up_insertdept('QC');
EXEC up_insertdept('QC',NULL);
EXEC up_insertdept(pDNAME => 'QC3');
----�μ��� X, ������ O
-- EXEC up_insertdept('SEOUL');
EXEC up_insertdept(pLOC => 'SEOUL3');

-- [����] tbl_dept ���̺��� ���� : up_updateDept
-- 1) ������ �μ���ȣ
-- 2) �μ��� ����
-- 3) ������ ����
-- 4) �μ��� + ������ ��θ� ����

EXEC up_updateDept(50, 'X', 'Y');
EXEC up_updateDept(50, pdname => 'QC5');
EXEC up_updateDept(80, ploc => 'SEOUL');
EXEC up_updateDept(50, pdname => 'SM', ploc => 'PO');

SELECT *
FROM tbl_dept;

CREATE OR REPLACE PROCEDURE up_updateDept(
    pdeptno tbl_dept.deptno%TYPE 
    , pdname tbl_dept.dname%TYPE DEFAULT NULL
    , ploc tbl_dept.loc%TYPE DEFAULT NULL
)
IS
BEGIN
    UPDATE tbl_dept
    SET dname = NVL(pdname, dname), 
    loc = CASE 
            WHEN ploc IS NULL THEN loc
            ELSE ploc
          END
    WHERE deptno = pdeptno;
    COMMIT;
END;

CREATE OR REPLACE PROCEDURE up_updateDept(
    pdeptno tbl_dept.deptno%TYPE 
    , pdname tbl_dept.dname%TYPE DEFAULT NULL
    , ploc tbl_dept.loc%TYPE DEFAULT NULL
)
IS
    vdname dept.dname%TYPE;
    vloc dept.loc%TYPE;
BEGIN
    SELECT dname, loc 
        INTO vdname, vloc
    FROM tbl_dept
    WHERE deptno = pdeptno;
    
    IF pdname IS NULL AND ploc IS NULL THEN
        UPDATE tbl_dept
        SET dname = vdname, loc = vloc
        WHERE deptno = pdeptno;
    ELSIF pdname IS NULL THEN
        UPDATE tbl_dept
        SET dname = vdname, loc = ploc
        WHERE deptno = pdeptno;
    ELSIF ploc IS NULL THE
        UPDATE tbl_dept
        SET dname = pdname, loc = vloc
        WHERE deptno = pdeptno;
    ELSE
        UPDATE tbl_dept
        SET dname = vdname, loc = vloc
        WHERE deptno = pdeptno;
    END IF;

    UPDATE tbl_dept
    SET dname = NVL(pdname, dname), loc = NVL(ploc, loc)
    WHERE deptno = pdeptno;
    COMMIT;
END;

-- [������] ���� �μ��� ������ ��
EXEC up_updateDept(100);

-- �μ� ��ȣ�� �Է� �޾Ƽ� �ش� �μ������� ������ ����ϴ� ���� ���ν���
-- up_selectEMP
-- ��� ��� ��ȸ
CREATE OR REPLACE PROCEDURE up_selectEMP

IS
  vdeptno tbl_emp.deptno%TYPE;
  venmae tbl_emp.ename%TYPE;
  vhiredate tbl_emp.hiredate%TYPE;
  CURSOR curemp IS (SELECT deptno,ename,hiredate FROM tbl_emp);
BEGIN
OPEN curemp;
LOOP
  FETCH curemp INTO vdeptno,venmae,vhiredate;

EXIT WHEN curemp%NOTFOUND;
END LOOP;
DBMS_OUTPUT.PUT_LINE(vdeptno||','||venmae||','||vhiredate);
CLOSE curemp;
END;
-- ������ ����� ��ȸ
CREATE OR REPLACE PROCEDURE up_selectEMP
(
    pdeptno tbl_dept.deptno%TYPE 
)
IS
  vdeptno tbl_emp.deptno%TYPE;
  venmae tbl_emp.ename%TYPE;
  vhiredate tbl_emp.hiredate%TYPE;
  CURSOR curemp IS (SELECT deptno,ename,hiredate FROM tbl_emp WHERE deptno = pdeptno);
BEGIN
OPEN curemp;
LOOP
  FETCH curemp INTO vdeptno,venmae,vhiredate;
  DBMS_OUTPUT.PUT_LINE(vdeptno||','||venmae||','||vhiredate);
EXIT WHEN curemp%NOTFOUND;
END LOOP;

CLOSE curemp;
END;

EXEC up_selectEMP (20);
--�Ű� ���� ���� ��� 10�� �μ��� ���
CREATE OR REPLACE PROCEDURE up_selectEMP
(
    pdeptno tbl_dept.deptno%TYPE DEFAULT 10
)
IS
  vdeptno tbl_emp.deptno%TYPE;
  venmae tbl_emp.ename%TYPE;
  vhiredate tbl_emp.hiredate%TYPE;
  CURSOR curemp IS (SELECT deptno,ename,hiredate FROM tbl_emp WHERE deptno = pdeptno);
BEGIN
OPEN curemp;
LOOP
  FETCH curemp INTO vdeptno,venmae,vhiredate;
  DBMS_OUTPUT.PUT_LINE(vdeptno||','||venmae||','||vhiredate);
EXIT WHEN curemp%NOTFOUND;
END LOOP;

CLOSE curemp;
END;

EXEC up_selectEMP(20);

-- Ŀ�� �Ķ���͸� �̿��ϴ� ���
CREATE OR REPLACE PROCEDURE up_selectEMP
(
    pdeptno tbl_dept.deptno%TYPE DEFAULT 10
)
IS
  vdeptno tbl_emp.deptno%TYPE;
  venmae tbl_emp.ename%TYPE;
  vhiredate tbl_emp.hiredate%TYPE;
  CURSOR curemp(cpdeptno tbl_dept.deptno%TYPE) IS (SELECT deptno,ename,hiredate FROM tbl_emp WHERE deptno = cpdeptno);
BEGIN
OPEN curemp(pdeptno);
LOOP
  FETCH curemp INTO vdeptno,venmae,vhiredate;
  DBMS_OUTPUT.PUT_LINE(vdeptno||','||venmae||','||vhiredate);
EXIT WHEN curemp%NOTFOUND;
END LOOP;

CLOSE curemp;
END;

EXEC up_selectEMP;

--FOR ����ϴ� CURSOR
CREATE OR REPLACE PROCEDURE up_selectEMP
(
    pdeptno tbl_dept.deptno%TYPE DEFAULT 10
)
IS
BEGIN
FOR erow IN (SELECT deptno,ename,hiredate FROM tbl_emp WHERE deptno = pdeptno)
LOOP
  DBMS_OUTPUT.PUT_LINE(erow.deptno||','||erow.ename||','||erow.hiredate);
END LOOP;
END;

EXEC up_selectEMP(20);

--  �Է¿�(IN) �Ű������� ���� ���ν������� ���
--  ��¿�(OUT) �Ű������� ���� ���ν������� ���
SELECT num,ssn
FROM insa;

--IN num 
--OUT rrn 771212-1******

CREATE OR REPLACE PROCEDURE up_insarrn
(
  pnum IN insa.NUM%TYPE,
  pname OUT insa.name%TYPE,
  prrn OUT VARCHAR2
)
IS
  vrrn insa.SSN%TYPE;
  vname insa.name%TYPE;
BEGIN
  SELECT ssn,name INTO vrrn, vname
  FROM insa
  WHERE num = pnum;

  prrn := SUBSTR(vrrn,1,8) || '******';
  pname := vname;
END;
-- ��¿� �Ű����� �׽�Ʈ(�͸� ���ν���)
DECLARE
  vrrn insa.ssn%TYPE;
  vname insa.name%TYPE;
BEGIN
  up_insarrn(1001,vname,vrrn);
  DBMS_OUTPUT.PUT_LINE(vname||','||vrrn);
--EXCEPTION
END;

-- ����¿�(IN OUT) �Ű����� ���
-- �ֹε�� ��ȣ 14�ڸ��� �Է¿� �Ű����� -> �ֹε�� ���ڸ� 6�ڸ��� ���¿� �Ű�����
CREATE OR REPLACE PROCEDURE up_rrn
(
  prrn  IN OUT VARCHAR2
)
IS
BEGIN
  prrn := SUBSTR(prrn,1,6);
END;

DECLARE
  vrrn VARCHAR2(14) := '771212-1234567';
BEGIN
  up_rrn(vrrn);
  DBMS_OUTPUT.PUT_LINE(vrrn);
END;

--  1)  ���� ���ν��� ���� ����
--  2)  ���� �Լ�(STORED FUNCTION)
--  3)  Ʈ����, ����ó��, ��Ű��
--  4)  ���� ����

CREATE TABLE tbl_score(
    num NUMBER(4) PRIMARY KEY
    , name VARCHAR2(20)
    , kor NUMBER(3)
    , eng NUMBER(3)
    , mat NUMBER(3)
    , tot NUMBER(3)
    , avg NUMBER(5, 2)
    , rank NUMBER(3)
    , grade CHAR(1 CHAR)
);

-- ��ȣ, �̸�, ��, ��, �� -> �Ķ����
CREATE OR REPLACE PROCEDURE up_insertScore (
    pnum NUMBER
    , pname VARCHAR2
    , pkor NUMBER
    , peng NUMBER
    , pmat NUMBER
)
IS
    vtot NUMBER(3);
    vavg NUMBER(5, 2);
    vrank NUMBER(4);
    vgrade VARCHAR2(4);
BEGIN
    vtot := pkor + peng + pmat;
    vavg := vtot / 3;
    --vrank := (SELECT COUNT(*)+1 FROM tbl_score WHERE tot>vtot);

  IF vavg >= 90 THEN vgrade := 'A';
  ELSIF vavg >= 80 THEN vgrade := 'B';
  ELSIF vavg >=70 THEN vgrade := 'C';
  ELSIF vavg >= 60 THEN vgrade := 'D';
  ELSE
    vgrade := 'F';
  END IF;

    
    INSERT INTO tbl_score(num, name, kor, eng, mat, tot, avg, rank, grade)
    VALUES(pnum, pname, pkor, peng, pmat,vtot,vavg,vrank,vgrade);

  UPDATE tbl_score a
  SET rank = (SELECT COUNT(*)+1 FROM tbl_score WHERE tot>a.tot);

--EXCEPTION
END; 

EXEC up_insertScore(1001,'ȫ�浿',70,90,80);
EXEC up_insertScore(1002,'ȫ�浿',100,90,80);
EXEC up_insertScore(1003,'ȫ�浿',70,100,90);

SELECT *
FROM tbl_score;

--��� �л��� ��� ó��


CREATE OR REPLACE PROCEDURE up_updateScore
(
    pnum  NUMBER  
  , pkor  NUMBER := NULL
  , peng  NUMBER := NULL 
  , pmat  NUMBER  := NULL
)
IS
  vtot NUMBER(3);
  vavg  NUMBER(5,2);
  vrank NUMBER(4);
  vgrade CHAR(1 CHAR);
  
  vkor  NUMBER(3);
  veng  NUMBER(3);
  vmat  NUMBER(3);
BEGIN
   SELECT kor, eng, mat INTO vkor, veng, vmat
   FROM tbl_score
   WHERE num = pnum;
   
   vtot := NVL(pkor, vkor) + NVL(peng, veng) + NVL(pmat, vmat);
   vavg := vtot / 3 ;
   
   IF vavg >= 90 THEN
     vgrade := 'A';
  ELSIF vavg >= 80 THEN
     vgrade := 'B';
  ELSIF vavg >= 70 THEN
     vgrade := 'C';
  ELSIF vavg >= 60 THEN
    vgrade := 'D';
  ELSE
    vgrade := 'F';
  END IF; 
  
  UPDATE tbl_score
  SET kor = NVL(pkor, vkor), 
      eng = NVL(peng, veng), 
      mat = NVL(pmat, vmat), 
      tot = vtot,
      avg = vavg,
      grade = vgrade
  WHERE num = pnum;
  
  -- ��� �л����� ��� �ű� �ٽ� 
  UPDATE  tbl_score a
  SET rank = ( SELECT COUNT(*)+1 FROM tbl_score WHERE tot > a.tot ); 
  
  COMMIT;
   
   

-- EXCEPTION
END;



EXEC up_updateScore( 1001, 34, 45, 90 );
EXEC up_updateScore( 1001, pkor =>34 );
EXEC up_updateScore( 1001, pkor =>34, pmat => 90 );
EXEC up_updateScore( 1002, peng =>45, pmat => 90 );


SELECT *
FROM tbl_score;

--���� EXEC up_deletescore(1002) �й����� �л� ���� �� ��� �л� ��� �ٽ�
CREATE OR REPLACE PROCEDURE up_deletescore
(
  pnum NUMBER
)
IS
BEGIN
DELETE FROM tbl_score
WHERE
    num = pnum;

UPDATE  tbl_score a
  SET rank = ( SELECT COUNT(*)+1 FROM tbl_score WHERE tot > a.tot ); 
  
  COMMIT;
END;

EXEC up_deletescore(1002);

SELECT *
FROM tbl_score;
--���� EXEC up_selectscore ��� �л��� ���� ���

CREATE OR REPLACE PROCEDURE up_selectscore
IS
  CURSOR scursor IS (SELECT num,name,kor,eng,mat,tot,avg,rank,grade FROM tbl_score);
  vrow tbl_score%ROWTYPE;
BEGIN
  OPEN scursor;
  LOOP
    FETCH scursor INTO vrow;
  EXIT WHEN scursor%NOTFOUND;
  DBMS_OUTPUT.PUT_LINE(vrow.num||','||vrow.name||','||vrow.kor||','||vrow.eng||','||vrow.mat||','||
                          vrow.tot||','||vrow.avg||','||vrow.rank||','||vrow.grade);
  END LOOP;
  CLOSE scursor;
END;

EXEC up_selectscore;

CREATE OR REPLACE FUNCTION uf_�Լ���
(

)
RETURN ���� �ڷ���
IS
BEGIN


  RETURN ���ϰ�;
END;


SELECT num, name, ssn, DECODE(MOD(SUBSTR(ssn,-7,1),2),1,'����','����')����,
      uf_gender(ssn), uf_age(ssm)
FROM insa;

--���� �Լ�
CREATE OR REPLACE FUNCTION uf_gender
(
  prrn VARCHAR2
)
RETURN VARCHAR2
IS
  vgender VARCHAR2(6);
BEGIN
  IF MOD(SUBSTR(prrn,-7,1),2) = 1 THEN vgender := '����';
  ELSE
    vgender := '����';
  END IF;
  RETURN vgender;
--EXCEPTION
END;

CREATE OR REPLACE FUNCTION uf_age
(
  prrn VARCHAR2
)
RETURN NUMBER
IS
  vage NUMBER(3);
  vbirth VARCHAR2(20);
  vcentury NUMBER(2);
BEGIN
      vbirth := SUBSTR(prrn,1,6);
      vcentury := CASE
                WHEN SUBSTR(prrn,-7,1) IN (1,2,5,6) THEN  19
                WHEN SUBSTR(prrn,-7,1) IN (3,4,7,8) THEN  20
                ELSE 18
              END;
  vbirth := vcentury || vbirth;
vage := FLOOR(MONTHS_BETWEEN(SYSDATE,TO_DATE(vbirth,'YYYYMMDD'))/12);
RETURN vage;
END;

-- �����
CREATE OR REPLACE FUNCTION UF_AGE
   ( 
       prrn VARCHAR2
       , ca NUMBER
   )
   RETURN NUMBER
   IS
     �� NUMBER(4); -- ���� �⵵ 2023
     �� NUMBER(4); -- ���� �⵵
     �� NUMBER(1); -- ���� ���� ���� -1 0 1 
     vcounting_age NUMBER(3);
     vamerican_age NUMBER(3);
   BEGIN     
      �� := TO_CHAR( SYSDATE, 'YYYY' ); 
      �� := SUBSTR( prrn, 0, 2 ) + CASE
                                    WHEN SUBSTR( prrn, -7, 1 ) IN (1,2,5,6) THEN 1900
                                    WHEN SUBSTR( prrn, -7, 1 ) IN (3,4,7,8) THEN 2000
                                    WHEN SUBSTR( prrn, -7, 1 ) IN (9,0) THEN 1800
                                   END;
      �� := SIGN( TO_CHAR( SYSDATE, 'MMDD' ) - SUBSTR( prrn, 3, 4 ) );
      
      vcounting_age :=  �� - �� + 1 ;
      -- ����(95,36): PLS-00204: function or pseudo-column 'DECODE' may be used inside a SQL statement only
      -- vamerican_age := �� - �� + DECODE( ��, -1, -1, 0 ) ;  -- PL/SQL������ ����� �� ����.
      vamerican_age := �� - �� + CASE  ��
                                     WHEN -1 THEN -1  
                                     ELSE 0
                                 END;  
      
      IF ca = 1 THEN
         RETURN vcounting_age;
      ELSE
         RETURN vamerican_age;
      END IF;   
   -- EXCEPTION
   END;


   -- �ֹε�� ���� ���� ������� �� ��ȯ �ϴ� ���� �Լ��� ����� �׽�Ʈ
  -- uf_birth

CREATE OR REPLACE FUNCTION uf_birth
(
  prrn VARCHAR2
)
RETURN VARCHAR2
IS
  vbirth VARCHAR2(20);
  vcentury NUMBER(2);
BEGIN
  vbirth := SUBSTR(prrn,1,6);
  vcentury := CASE
                WHEN SUBSTR(prrn,-7,1) IN (1,2,5,6) THEN  19
                WHEN SUBSTR(prrn,-7,1) IN (3,4,7,8) THEN  20
                ELSE 18
              END;
  vbirth := vcentury || vbirth;
  vbirth := TO_CHAR(TO_DATE(vbirth,'YYYYMMDD'),'YYYY.MM.DD (DY)');
  RETURN vbirth;
END;

SELECT num, name, ssn,uf_gender(ssn), uf_age(ssn),uf_birth(ssn)
FROM insa;
--
-- �Ű������� cursor �ޱ�
CREATE OR REPLACE PROCEDURE up_selectInsa
(
  pInsaCursor IN SYS_REFCURSOR
)
IS
  vname insa.name%TYPE;
  vcity insa.city%TYPE;
  vbasicpay insa.BASICPAY%TYPE;
BEGIN
  LOOP
    FETCH pInsaCursor INTO vname,vcity,vbasicpay;
    EXIT WHEN pInsaCursor%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(vname||','||vcity||','||vbasicpay);
  END LOOP;
--EXCEPTION
END;

-- ���� up_selectInsa �׽�Ʈ + �� �ٸ� ���� ���ν��� �ȿ��� Ŀ�� �����ؼ� ���� ���ν����� �Ķ���ͷ� �־ �׽�Ʈ
CREATE OR REPLACE PROCEDURE up_selectInsa_TEST
IS
  vInsaCursor SYS_REFCURSOR;
BEGIN
  --OPEN Ŀ�� for��
  OPEN vInsaCursor FOR SELECT name,city,BASICPAY FROM insa;
  up_selectInsa(vInsaCursor);
  CLOSE vInsaCursor;
END;

EXEC up_selectInsa_TEST;