commit;

SELECT *
FROM tbl_dept;

DROP TABLE tbl_dept;
-- �𵨸� ����--
������̺�
�� ������
�� ��������

(1) ���� Ÿ��: ��ü�� �ϳ��� ���̺�� ����
����Ӽ�(�÷�)
[][][][][][][��][��][��][��][��][��]
[][][][][][][��][��][��][NULL][NULL][NULL]  �������̸�
[][][][][][][NULL][NULL][NULL][��][��][��]   ���� �����̸� 
null�� ����Ǵ� �÷��� ����
(2) ���� Ÿ��: ������, �������� ���...���� Ÿ���� ���� ��ŭ ���̺�� ����
������������̺�
[][][][][][][��][��][��]
����������� ���̺�
[][][][][][][��][��][��]

(3)
������̺�
[][][][][][] --�������� Į��
���������̺�
[��][��][��] --�������� ������ Į��
�������� ���̺�
[��][��][��] -- ���������� ������ Į��


��������-�ʿ� ���� (����) -> jdbc-> html,css,js -> jsp/sevlet ó��

-- ������ (SEQUENCE)
-- �ڵ� �Ϸù�ȣ ����
-- dept ���̺��� deptno�� �������� �����ؼ� ���
;
SELECT MAX(deptno)
FROM dept;

--
�����ġ�
	CREATE SEQUENCE ��������
	[ INCREMENT BY ����]
	[ START WITH ����]
	[ MAXVALUE n ? NOMAXVALUE]
	[ MINVALUE n ? NOMINVALUE]
	[ CYCLE ? NOCYCLE]
	[ CACHE n ? NOCACHE];
    
    CREATE SEQUENCE seq_deptno;
    ��� �ɼ� ������
    [ INCREMENT BY 1]  10
	[ START WITH 1]    50
	[ MAXVALUE 9999999999999999999999999999 ]  90
	[ MINVALUE 1 ]
	[  NOCYCLE  ]
	[ CACHE 20     NOCACHE;
    
    DROP SEQUENCE seq_deptno;
    
    CREATE SEQUENCE seq_deptno
     INCREMENT BY 10
	 START WITH 50
	 MAXVALUE  90
	 NOCACHE;
    
    
    INSERT INTO dept VALUES (seq_deptno.NEXTVAL,'QC',NULL);
    SELECT *
    FROM dept;
    
    SELECT seq_deptno.CURRVAL
    FROM dual;
    ROLLBACK;
    -- 50 
    
    CREATE SEQUENCE seq_test;
    DROP SEQUENCE seq_deptno;
    --EQ_TEST.CURRVAL is not yet defined in this session  -> NEXTVAL���� ���� ����ؾ� ��
    SELECT seq_test.CURRVAL
    FROM dual;
    
    
SELECT *
FROM user_sequences;
FROM seq;


---------
--PL/SQL--
--  Procedural Language extensions to SQL
--������ ���(����,���) + Ȯ�� SQL
-- ��� ������ �� ���
-- ����)
[DECLARE]
    1)���� ��
BEGIN
    2)���� ��
    SELECT
    INSERT
    UPDATE
    DELETE
    ...
[EXCEPTION]
    3)���� ó�� ��
END
-- PL/SQL�� 6���� ����
    1) �͸� ���ν���
    2) ���� ���ν���
    3) ���� �Լ�
    4) ��Ű��
    5) Ʈ����
    --6) ��ü X
;
��)
DESC insa;
--1) �͸� ���ν���
-- ���� ���� �Ҵ��ϴ� ���
    1) :=
    2)  SELECT �Ǵ� fetch �� ���� INTO ��

DECLARE
-- ���� ��: ���� ����
-- �Ϲݺ��� v, �Ű����� p
    --vname VARCHAR2(20);
    --vpay NUMBER(10);
    vname INSA.name%TYPE; -- Ÿ���� ����
    vpay NUMBER(10);
    vpi CONSTANT NUMBER := 3.141592;
    vmessage VARCHAR(100);
BEGIN
-- ���� ��
    SELECT name,basicpay+sudang
        INTO vname, vpay
    FROM insa
    WHERE num = 1001;
    --DBMS_OUTPUT.PUT_LINE('�����=' || vname);
    --DBMS_OUTPUT.PUT_LINE('�޿�=' || vpay);
    vmessage := vname || ',' || vpay;
    DBMS_OUTPUT.PUT_LINE('��� :' || vmessage);
--EXCEPTION
END;

-- ����) 30�� �μ��� �������� ��� �ͼ� 10�� �μ��� ���������� ����
SELECT *
FROM dept;

DECLARE
    vloc dept.loc%TYPE;
BEGIN
    SELECT loc INTO vloc
    FROM dept
    WHERE deptno = 30;
    
    UPDATE dept
    SET loc = vloc
    WHERE deptno = 10;
--EXCEPTION
END;

--����) 10�� �μ��� �߿� �ְ� sal�� �޴� ����� ���� ��ȸ
-- 1) Top -n ���
SELECT *
FROM(
SELECT *
FROM emp
WHERE deptno = 10
ORDER BY sal desc
)t
WHERE ROWNUM =1;
-- 2) rank
SELECT *
FROM(
SELECT e.*
    , RANK()OVER(ORDER BY sal DESC)sal_rank
FROM emp e
WHERE deptno = 10
)
WHERE sal_rank =1;
--3)���� ����
SELECT *
FROM emp
WHERE deptno = 10 AND sal = (SELECT MAX(sal) FROM emp WHERE deptno = 10);
-- 4) �͸� ���ν��� ����ؼ� ó��
DECLARE
    vmax_sal_10 emp.sal%TYPE;
    vempno emp.empno%TYPE;
    vename emp.ename%TYPE;
    vjob emp.job%TYPE;
    vsal emp.sal%TYPE;
    vhiredate emp.hiredate%TYPE;
    vdeptno emp.deptno%TYPE;
BEGIN

SELECT MAX(sal) INTO vmax_sal_10
FROM emp 
WHERE deptno = 10;

SELECT empno,ename,job,sal,hiredate,deptno
       INTO vempno,vename,vjob,vsal,vhiredate,vdeptno
FROM emp
WHERE deptno = 10 AND sal = vmax_sal_10;

DBMS_OUTPUT.PUT_LINE('�����ȣ: ' || vempno);
DBMS_OUTPUT.PUT_LINE('�����: ' || vename);
DBMS_OUTPUT.PUT_LINE('�Ի�����: ' || vhiredate);
--EXCEPTION
END;

-- PL/SQL ���� �������� ���ڵ带 �����ͼ� ó���ϱ� ���ؼ��� �ݵ�� Ŀ��(cursor)�� ����ؾ� �Ѵ�
--ORA-01422: exact fetch returns more than requested number of rows
DECLARE
    vname INSA.name%TYPE; -- Ÿ���� ����
    vpay NUMBER(10);
    vmessage VARCHAR(100);
BEGIN
    SELECT name,basicpay+sudang
        INTO vname, vpay
    FROM insa;
    
    --���
    vmessage := vname || ',' || vpay;
    DBMS_OUTPUT.PUT_LINE('��� :' || vmessage);
--EXCEPTION
END;
--
--[4-2]
DECLARE
    vmax_sal_10 emp.sal%TYPE;
   vrow emp%ROWTYPE;  -- ���ڵ��� ����
BEGIN

SELECT MAX(sal) INTO vmax_sal_10
FROM emp 
WHERE deptno = 10;

SELECT empno,ename,job,sal,hiredate,deptno
       INTO vrow.empno,vrow.ename,vrow.job,vrow.sal,vrow.hiredate,vrow.deptno
FROM emp
WHERE deptno = 10 AND sal = vmax_sal_10;

DBMS_OUTPUT.PUT_LINE('�����ȣ: ' || vrow.empno);
DBMS_OUTPUT.PUT_LINE('�����: ' || vrow.ename);
DBMS_OUTPUT.PUT_LINE('�Ի�����: ' || vrow.hiredate);
--EXCEPTION
END;
------------
--IF...THEN...ELSE ��
--�ڹ�
if(����){
}
--
if(����){
}else{
}
--
if(����){
}else if(����){
}else if(����){
}else if(����){
}else{
}

--PL/SQL
IF (���ǽ�) THEN
END IF;
--
IF (���ǽ�) THEN
ELSE
END IF;
--
IF (���ǽ�) THEN
ELSIF (���ǽ�) THEN
ELSIF (���ǽ�) THEN
ELSIF (���ǽ�) THEN
ELSE
END IF;
--
--���� ������ �ϳ� �����ؼ� ������ �Է� �޾Ƽ� ¦�� Ȧ�� ���
DECLARE
  vnum NUMBER(4) := 0;
  vresult nvarchar2(2) := 'Ȧ��';
BEGIN
  vnum := :bindnumber;
  
IF (MOD(vnum,2)=0) THEN
    vresult := '¦��';
--ELSE
   -- vresult := 'Ȧ��';
END IF;
  DBMS_OUTPUT.PUT_LINE(vnum||':'||vresult);
--EXCEPTION
END;

-- ���� ���������Է� �޾Ƽ� �� ~ �� ���



DECLARE
  vkor NUMBER(4) := 0;
  vgrade varchar2(3) := '��';
BEGIN
  vkor := :bindnumber;
IF(vkor BETWEEN 0 AND 100) THEN 
    IF (vkor BETWEEN 90 AND 100) THEN
    vgrade := '��';
    ELSIF (vkor BETWEEN 80 AND 89) THEN
    vgrade := '��';
    ELSIF (vkor BETWEEN 70 AND 79) THEN
    vgrade := '��';
    ELSIF (vkor BETWEEN 60 AND 69) THEN
    vgrade := '��';
    ELSIF (vkor < 60 ) THEN
    vgrade := '��';
    END IF;
  DBMS_OUTPUT.PUT_LINE(vkor||':'||vgrade);
ELSE
  DBMS_OUTPUT.PUT_LINE(vkor||': 0~100 ���̸� ����');
END IF;
--EXCEPTION
END;
--------

DECLARE
  vkor NUMBER(4) := 0;
  vgrade varchar2(3) := '��';
BEGIN
  vkor := :bindnumber;
IF(vkor BETWEEN 0 AND 100) THEN
   vgrade := CASE TRUNC(vkor/10)
    WHEN 10 THEN  '��'
    WHEN 9 THEN '��'
    WHEN 8 THEN '��'
    WHEN 7 THEN '��'
    WHEN 6 THEN '��'
    ELSE'��'
    END;
  DBMS_OUTPUT.PUT_LINE(vkor||':'||vgrade);
ELSE
  DBMS_OUTPUT.PUT_LINE(vkor||': 0~100 ���̸� ����');
END IF;
--EXCEPTION
END;

--


-- oracle
LOOP
--
--
EXIT WHEN ����
END LOOP;

��) 1~10 = 55
DECLARE
    vi NUMBER := 1;
    vsum NUMBER := 0;
BEGIN
    LOOP
      IF vi = 10 THEN
        DBMS_OUTPUT.PUT(vi);
      ELSE
        DBMS_OUTPUT.PUT(vi || '+');
      END IF;
      --vsum += vi;
      vsum := vsum + vi;
    EXIT WHEN vi = 10;
      vi := vi + 1;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('=' || vsum);
--EXCEPTION
END;


-- WHILE ... LOOP(������ �ݺ�)��
WHILE(���ǽ�)
LOOP
--
--
END LOOP;
--��) 1~10 = 55
DECLARE
    vi NUMBER := 1;
    vsum NUMBER := 0;
BEGIN
    WHILE(vi <= 10)
    LOOP
      IF vi = 10 THEN
        DBMS_OUTPUT.PUT(vi);
      ELSE
        DBMS_OUTPUT.PUT(vi || '+');
      END IF;
      vsum := vsum + vi;
      vi := vi + 1;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('=' || vsum);
--EXCEPTION
END;

-- FOR...LOOP(������ �ݺ�)��
FOR �ݺ����� IN [REVERSE] ���۰�.. ����
LOOP
-- �ݺ�ó�� ����
--
END LOOP;
-- ��) 1~ 10 =55
DECLARE 
  vi NUMBER := 1;
  vsum NUMBER := 0;
BEGIN
  FOR vi IN 1.. 10
  LOOP
    DBMS_OUTPUT.PUT(vi || '+');
    vsum := vsum + vi;
  END LOOP;
  DBMS_OUTPUT.PUT_LINE('=' || vsum);
--EXCEPTION
END;
-----------------------------
DECLARE 
  --vi NUMBER := 1;
  vsum NUMBER := 0;
BEGIN
  FOR vi IN REVERSE 1.. 10
  LOOP
    DBMS_OUTPUT.PUT(vi || '+');
    vsum := vsum + vi;
  END LOOP;
  DBMS_OUTPUT.PUT_LINE('=' || vsum);
--EXCEPTION
END;
---
--DECLARE
BEGIN
  
  GOTO first_proc;
  
  <<second_proc>>
  DBMS_OUTPUT.PUT_LINE('> 2 ó��');
  GOTO third_proc;
  
  <<first_proc>>
  DBMS_OUTPUT.PUT_LINE('> 1 ó��');
  GOTO second_proc;
  
   <<third_proc>>
  DBMS_OUTPUT.PUT_LINE('> 3 ó��');
  

--EXCEPTION
END;

-- ������(2~9) ���
1) WHILE LOOP ~ END LOOP ���
2) FOR LOOP ~ END LOOP

DECLARE
vi1 number := 2;
vi2 number := 1;
vresult number := 0;
BEGIN
FOR vi1 IN 2..9
LOOP
  FOR vi2 IN 1..9
  LOOP
  DBMS_OUTPUT.PUT_LINE(vi1 || '*' || vi2 || '=' || vi1*vi2);
  END LOOP;
END LOOP;

END;


DECLARE
vi1 number := 2;
vi2 number := 1;
vresult number := 0;
BEGIN
WHILE(vi1 <= 9)
LOOP
DBMS_OUTPUT.PUT_LINE(vi1 ||'��');
  WHILE(vi2 <= 9)
  LOOP
  DBMS_OUTPUT.PUT(vi1 || '*' || vi2 || '=' || vi1*vi2||'   ');
  vi2 := vi2 + 1;
  END LOOP;
DBMS_OUTPUT.PUT_LINE(' ');
vi1 := vi1 + 1;
vi2 := 1;
END LOOP;

END;




SELECT
  *
FROM
  EMP;

  --����� �ڵ� �׽���?