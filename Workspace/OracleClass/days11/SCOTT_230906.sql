--JOIN
--join ����

--����) å id, å���� �ܰ� �Ǹż��� ����(��) �Ǹűݾ�

SELECT b.b_id, b.title, d.price,p.p_su,g.g_name, d.price*p.p_su
FROM book b, danga d, panmai p, gogaek g
WHERE b.b_id = d.b_id AND p.b_id = b.b_id AND p.g_id = g.g_id;

SELECT b.b_id, b.title, d.price,p.p_su,g.g_name, d.price*p.p_su �Ǹűݾ�
FROM book b JOIN danga  d ON b.b_id = d.b_id JOIN panmai p ON p.b_id = b.b_id JOIN gogaek g ON p.g_id = g.g_id;

--����) ���ǵ� å���� ���� �� ����� �Ǹ� �Ǿ����� ��ȸ
SELECT b.b_id, title, price, SUM(p_su)
FROM book b JOIN danga  d ON b.b_id = d.b_id JOIN panmai p ON p.b_id = b.b_id
GROUP BY b.b_id,b.title,d.price
ORDER BY b.b_id;

SELECT DISTINCT b.b_id, title, price, SUM(p_su)OVER(PARTITION BY b.b_id)
FROM book b JOIN danga  d ON b.b_id = d.b_id JOIN panmai p ON p.b_id = b.b_id
ORDER BY b.b_id;

--���� å �Ǹŵ� ���� �ִ� åID���� --SEMIJOIN
SELECT b.b_id,title, price
FROM book b JOIN danga d ON b.b_id=d.b_id
WHERE EXISTS (SELECT b_id
                    FROM panmai p
                    WHERE b.b_id = p.b_id);
--���� å �Ǹŵ� ���� ���� åID���� --ANTIJOIN
SELECT b.b_id,title, price
FROM book b JOIN danga d ON b.b_id=d.b_id
WHERE b.b_id NOT IN (SELECT b_id
                    FROM panmai p
                    WHERE b.b_id = p.b_id);
                    
WITH E AS (
SELECT b.B_ID as b_id, title, price 
,SUM(p_su) ���Ǹż�
FROM book b  
LEFT JOIN danga d ON b.b_id = d.b_id
LEFT JOIN PANMAI p ON b.b_id = p.b_id
GROUP BY b.B_ID, title, price)
SELECT E.b_id, E.title
FROM E
WHERE E.���Ǹż� IS NULL;

-- �Ǹŵ� ���� ���� å�� 0���� �����ؼ� ���
SELECT b.b_id, title, price, NVL(SUM(p_su),0)���Ǹż���
FROM book b JOIN danga  d ON b.b_id = d.b_id LEFT JOIN panmai p ON p.b_id = b.b_id
GROUP BY b.b_id,b.title,d.price
ORDER BY b.b_id;

SELECT DISTINCT b.b_id, title, NVL(SUM(p_su)OVER(PARTITION BY b.b_id),0)���Ǹż���
FROM book b  LEFT JOIN panmai p ON p.b_id = b.b_id
ORDER BY b.b_id;

-- ���� ���� �ǸűǼ��� ���� å�� ���� ������ ��� id title ���Ǹ� �Ǽ�
-- TOP -n ���
SELECT t.*
FROM (
SELECT b.b_id, title, SUM(p_su)���Ǹż���
FROM book b  JOIN panmai p ON p.b_id = b.b_id
GROUP BY b.b_id,b.title
ORDER BY NVL(SUM(p_su),0) DESC
)t
WHERE rownum <=3;
-- RANK() ���
SELECT  b_id, title,���Ǹż���
FROM (
SELECT b.b_id, title, SUM(p_su)���Ǹż���,
        RANK()OVER(ORDER BY SUM(p_su) DESC)r
FROM book b  JOIN panmai p ON p.b_id = b.b_id
GROUP BY b.b_id,b.title
)t
WHERE r <=3;

-- �⵵�� ���� �Ǹ� ��Ȳ
(�Ǹų⵵,�Ǹűݾ�);
SELECT TO_CHAR(p.p_date,'YYYY')||'�⵵',SUM(p.p_su),SUM(d.price*p.p_su)
FROM danga  d  JOIN panmai p ON p.b_id = d.b_id
GROUP BY TO_CHAR(p.p_date,'YYYY');

(�Ǹų⵵,�Ǹſ�,�Ǹűݾ�);
SELECT TO_CHAR(p.p_date,'YYYY')||'�⵵' �⵵,TO_CHAR(p.p_date,'MM')||'��' ��,SUM(p.p_su)����,SUM(d.price*p.p_su)�ݾ�
FROM danga  d  JOIN panmai p ON p.b_id = d.b_id
GROUP BY TO_CHAR(p.p_date,'YYYY'),TO_CHAR(p.p_date,'MM')
ORDER BY TO_CHAR(p.p_date,'YYYY'),TO_CHAR(p.p_date,'MM');

-- ���� ������ �Ǹ���Ȳ ��ȸ
-- �⵵ ����id ������ ���Ǹűݾ�
SELECT b.b_id, b.title, d.price,p.p_su,g.g_name, d.price*p.p_su �Ǹűݾ�
FROM book b JOIN danga  d ON b.b_id = d.b_id JOIN panmai p ON p.b_id = b.b_id JOIN gogaek g ON p.g_id = g.g_id;

SELECT TO_CHAR(p.p_date,'YYYY')year,g.g_id,g.g_name,SUM(d.price*p.p_su)�ݾ�
FROM danga  d  JOIN panmai p ON p.b_id = d.b_id JOIN gogaek g ON p.g_id = g.g_id
GROUP BY TO_CHAR(p.p_date,'YYYY'),g.g_id,g.g_name
ORDER BY TO_CHAR(p.p_date,'YYYY'),g.g_id,g.g_name;

-- ���� ������ �Ǹ���Ȳ
-- �����ڵ� ������ - �Ǹűݾ��� ����(0.00)

--��� �⵵
WITH t AS(
            SELECT SUM(d.price*p.p_su)r FROM danga  d  JOIN panmai p ON p.b_id = d.b_id
)
SELECT TO_CHAR(p.p_date,'YYYY')year,g.g_id,g.g_name,SUM(d.price*p.p_su)�ݾ�
    ,ROUND(SUM(d.price*p.p_su)/t.r,2)*100 AS ����
FROM danga  d  JOIN panmai p ON p.b_id = d.b_id JOIN gogaek g ON p.g_id = g.g_id,t
GROUP BY TO_CHAR(p.p_date,'YYYY'),g.g_id,g.g_name,r
ORDER BY TO_CHAR(p.p_date,'YYYY'),g.g_id,g.g_name;
--23�⵵
WITH t AS(
            SELECT SUM(d.price*p.p_su)r FROM danga  d  JOIN panmai p ON p.b_id = d.b_id
            WHERE TO_CHAR(p.p_date,'YYYY') = '2023'
)
SELECT TO_CHAR(p.p_date,'YYYY')year,g.g_id,g.g_name,SUM(d.price*p.p_su)�ݾ�
    ,ROUND(SUM(d.price*p.p_su)/t.r,2)*100 AS ����
FROM danga  d  JOIN panmai p ON p.b_id = d.b_id JOIN gogaek g ON p.g_id = g.g_id,t
WHERE TO_CHAR(p.p_date,'YYYY') = '2023'
GROUP BY TO_CHAR(p.p_date,'YYYY'),g.g_id,g.g_name,r
ORDER BY TO_CHAR(p.p_date,'YYYY'),g.g_id,g.g_name;

-- ���� å�� ���Ǹ� �ݾ��� 15000�� �̻��� å : id ���� �ܰ� ���ǸűǼ� ���Ǹ� �ݾ�
SELECT b.b_id, title, price, SUM(p_su),SUM(p_su*price)
FROM book b JOIN danga  d ON b.b_id = d.b_id JOIN panmai p ON p.b_id = b.b_id
GROUP BY b.b_id,b.title,d.price
HAVING SUM(p_su*price) >=15000
ORDER BY b.b_id;

SELECT b.b_id, title, price, SUM(p_su)
FROM book b JOIN danga  d ON b.b_id = d.b_id JOIN panmai p ON p.b_id = b.b_id
GROUP BY b.b_id,b.title,d.price
HAVING SUM(p_su) >=10
ORDER BY b.b_id;
--
-- JOIN + ������, �Լ�, SQL --

--��(view)
-- FROM ���̺� �Ǵ� ��
-- user_tables, user_constraints, user_users = ��...
-- 1) �������̺� : ��� �Ѱ� �̻��� �⺻ ���̺��̳� �ٸ� �並 �̿��Ͽ� �����Ǵ� ���� ���̺�(virtual table)�̴�.
-- 2) ��ü ������ �߿��� �Ϻθ� ������ �� �ֵ��� �����ϱ� ���� ���
-- 3) ��� ������ ���� ���̺� �信 ���� ���Ǹ� �����ϰ� ��ũ�� ���� ������ �Ҵ���� �ʴ´�
--��� ����
-- 1) ����(security) ������, ����ڿ��� ���Ǽ�(flexibility)�� �����ϱ� ���� ������ �޼��ϱ� ���ؼ��̴�.
-- �� ����� ���ؼ��� ���� �ʿ�
--���� Ȯ��
SELECT *
FROM user_sys_privs;

-- ����
CREATE [OR REPLACE] [FORCE | NOFORCE] VIEW ���̸�
		[(alias[,alias]...]
	AS subquery
	[WITH CHECK OPTION]
	[WITH READ ONLY];
-- �� ����
-- �Ź� ���� ��ȸ ���� ���
-- ���պ� -> DML ������
CREATE OR REPLACE VIEW panView
AS
SELECT b.b_id, b.title, d.price,g.g_id,g.g_name,p.p_date, p.p_su
    ,p.p_su*price amt
FROM book b JOIN danga  d ON b.b_id = d.b_id JOIN panmai p ON p.b_id = b.b_id JOIN gogaek g ON p.g_id = g.g_id
ORDER BY p.p_date DESC;

SELECT *
FROM panView;

DESC panView;
-- �並 �̿��� ���Ǹ� �ݾ�
SELECT SUM(amt) 
FROM panView;

-- �� �ҽ� Ȯ��: DB ��ü, ��������
SELECT *
FROM user_views;

-- ����� CREATE OR REPLACE VIEW
-- ��� ����
DROP VIEW panview;

-- ���� �⵵, ��, ���ڵ�, �Ǹűؾ���(�⵵�� ��)
CREATE OR REPLACE VIEW gogaekView
AS
SELECT TO_CHAR(p_date,'YYYY')�Ǹų⵵,TO_CHAR(p_date,'MM')�Ǹſ�,
        g.g_id,g_name,SUM(p_su*price)���Ǹűݾ�
FROM danga  d  JOIN panmai p ON p.b_id = d.b_id JOIN gogaek g ON p.g_id = g.g_id
GROUP BY TO_CHAR(p_date,'YYYY'),TO_CHAR(p_date,'MM'), g.g_id,g_name
ORDER BY 1,2
;

SELECT *
FROM gogaekView;
--
SELECT *
FROM tab -->user_tables
WHERE tabtype = 'VIEW';
-- ��: DML �۾� ���� [�ǽ�]
-- �� ���ú� -> ���� ���� ���̺� ����
-- �� ���պ� X

CREATE TABLE testa (
    aid NUMBER PRIMARY KEY
    ,name VARCHAR2(20) NOT NULL
    ,tel VARCHAR2(20) NOT NULL
    ,memo VARCHAR2(100)
);

CREATE TABLE testb (
    bid NUMBER PRIMARY KEY
    ,aid NUMBER CONSTRAINT fk_testb_aid REFERENCES testa(aid)
                                ON DELETE CASCADE
    ,score NUMBER(3)
);

INSERT INTO testa (aid, NAME, tel) VALUES (1, 'a', '1');
INSERT INTO testa (aid, name, tel) VALUES (2, 'b', '2');
INSERT INTO testa (aid, name, tel) VALUES (3, 'c', '3');
INSERT INTO testa (aid, name, tel) VALUES (4, 'd', '4');

INSERT INTO testb (bid, aid, score) VALUES (1, 1, 80);
INSERT INTO testb (bid, aid, score) VALUES (2, 2, 70);
INSERT INTO testb (bid, aid, score) VALUES (3, 3, 90);
INSERT INTO testb (bid, aid, score) VALUES (4, 4, 100);

COMMIT;

SELECT * FROM testa;
SELECT * FROM testb;

--�ܼ� �� ���� + DML �۾�
DESC testa;
CREATE OR REPLACE VIEW aView
AS
SELECT aid,name,memo
FROM testa;

-- �ܼ��� ����ؼ� insert �۾�
--INSERT INTO aView (aid,name,memo) VALUES (5,'f','5');
--INSERT INTO testa (aid,name,memo) VALUES (5,'f','5');
--cannot insert NULL into ("SCOTT"."TESTA"."TEL") testa�� not null �������� ����
--�� ���� memo = null ���
CREATE OR REPLACE VIEW aView
AS
SELECT aid,name,tel
FROM testa;

INSERT INTO aView (aid,name,tel) VALUES (5,'f','5'); --1 �� ��(��) ���ԵǾ����ϴ�.
commit;
DELETE FROM aView WHERE aid = 5; --1 �� ��(��) �����Ǿ����ϴ�.

DROP VIEW aView;  --view ����

--���պ� ����
CREATE OR REPLACE VIEW abView
AS
    SELECT a.aid,name,tel,bid,score
    FROM testa a JOIN testb b ON a.aid = b.aid
;
INSERT INTO abView (aid,name,tel,bid,score) VALUES (5,'f','5',5,5);
--���� : ���ÿ� �� ���̺��� ������ ���� insert�Ҽ� ������

INSERT INTO abView (aid,name,tel) VALUES (5,'f','5');
-- �����̺��� ���븸 ���� ����
UPDATE abView
SET score = 90
WHERE bid = 1;
ROLLBACK;
-- ���� : �����̺��� ������ ���� X

DELETE FROM abView
WHERE aid = 1;

SELECT * FROM testa;
SELECT * FROM testb;
ROLLBACK;
-- ������ 90�� �̻��� �� ����
CREATE OR REPLACE VIEW bView
AS
    SELECT bid, aid, score
    FROM testb
    WHERE score >=90;
    -- bid �� 3�� ���� score = 70 ������ ����
UPDATE bView
SET score = 70
WHERE bid=3;
ROLLBACK;
SELECT *
FROM bView;
-- WITH CHECK OPTION
CREATE OR REPLACE VIEW bView
AS
    SELECT bid, aid, score
    FROM testb
    WHERE score >=90
WITH CHECK OPTION CONSTRAINT CK_bView
    ;
    
UPDATE bView
SET score = 70
WHERE bid=3;
-- ORA-01402: view WITH CHECK OPTION where-clause violation 
SELECT *
FROM bView;

DROP VIEW aView;
DROP VIEW bView;
DROP VIEW abView;
DROP VIEW GOGAEKVIEW;
SELECT *
FROM tab
WHERE tabtype = 'VIEW';

-- MATERIALIZED VIEW (������ ��)
-- ���� �����͸� ������ �ִ� ��

-- [������ ����]--
SELECT LEVEL
FROM dual;
-- LEVEL �÷�?
--ORA-01788: CONNECT BY clause required in this query block --CONNECT BY�� �ʿ�

SELECT LEVEL
FROM dual
CONNECT BY LEVEL <=31; --������

SELECT *
FROM emp;

LEVEL -> CONNECT BY -> LEVEL���� -> ������ ����
LEVEL: ������ ���ǹ����� �˻��� ����� ���� �������� ���� ��ȣ�� ǥ���ϴ� �ǻ�Į��
-- 2���� ������� ���̺�
-- �ǹ� -> ������, ���� -> ������ ���� ǥ��(����,��ȸ)
-- 1) ���̺�: �θ�-�ڽ� �÷� �߰�
-- 2) SELECT : START WITH, CONNECT BY ������ ����ϸ� ������ ����

SELECT *
FROM emp;
-- ������ ���ǹ����� where ���� ������ where ���� JOIN ���� �����ϰ� �ִ��Ŀ� ���� �ٸ��� ����ȴ�. 
-- JOIN���� ���� ���, �켱 connect by ���� ������ ��, where ���� ������ �����Ѵ�.
SELECT empno,ename,mgr,sal,LEVEL
FROM emp
WHERE mgr = 7698        -- 7698�� ���� ���� ������
START WITH mgr IS NULL
CONNECT BY PRIOR empno = mgr; --�ڽ� = �θ� top-down �������

create table tbl_test(
    deptno number(3) not null primary key,
    dname varchar2(24) not null,
    college number(3),
    loc varchar2(10)
    );
    
INSERT INTO tbl_test VALUES        ( 101,  '��ǻ�Ͱ��а�', 100,  '1ȣ��');
INSERT INTO tbl_test VALUES        (102,  '��Ƽ�̵���а�', 100,  '2ȣ��');
INSERT INTO tbl_test VALUES        (201,  '���ڰ��а� ',   200,  '3ȣ��');
INSERT INTO tbl_test VALUES        (202,  '�����а�',    200,  '4ȣ��');
INSERT INTO tbl_test VALUES        (100,  '�����̵���к�', 10 , null );
INSERT INTO tbl_test VALUES        (200,  '��īƮ�δн��к�',10 , null);
INSERT INTO tbl_test VALUES        (10,  '��������',null , null);
COMMIT;

SELECT *
FROM tbl_test;

SELECT t.*,LEVEL
FROM tbl_test t
START WITH deptno = 10
CONNECT BY PRIOR deptno = college;

SELECT LPAD('��',(LEVEL-1)*3)||dname
FROM tbl_test t
START WITH dname = '��������'
CONNECT BY PRIOR deptno = college;
--where�� ���� �װ����� ���ŵǰ� �ڽ� ���� �������� �ʴ´�
SELECT LPAD('��',(LEVEL-1)*3)||dname
FROM tbl_test t
WHERE dname !='�����̵���к�'
START WITH dname = '��������'
CONNECT BY PRIOR deptno = college;
--CONNECT BY �� ���� ������ �װ����� ���� ��嵵 ������
SELECT LPAD('��',(LEVEL-1)*3)||dname
FROM tbl_test t
START WITH dname = '��������'
CONNECT BY PRIOR deptno = college
AND dname != '�����̵���к�';
------------------------- HR

SELECT  last_name "employee",
        [CONNECT_BY_ISCYCLE "Cycle"],
        LEVEL, 
        [SYS_CONNECT_BY_PATH(last_name, '/') "Path"]
FROM employees
WHERE LEVEL <=3 and department_id = 80
    START WITH last_name ='King'
    CONNECT BY [NOCYCLE] PRIOR employee_id = manager_id AND LEVEL <= 4
    ORDER BY "employee", "Cycle", LEVEL, "Path";

-------------------------------------
1. START WITH �ֻ������� : ������ �������� �ֻ��� ������ ���� �ĺ��ϴ� ����
2. CONNECT BY ���� : ������ ������ � ������ ����Ǵ����� ����ϴ� ����.
   PRIOR : ������ ���������� ����� �� �ִ� ������, '�ռ���, ������'
   
   SELECT e.empno
        , LPAD(' ',(LEVEL-1)*4)||ename
        , LEVEL
        , SYS_CONNECT_BY_PATH(ename,'/')
        , CONNECT_BY_ROOT  ename
        , CONNECT_BY_ISLEAF
   FROM emp e, dept d
   WHERE  e.deptno = d.deptno
   START WITH e.mgr IS NULL
   CONNECT BY PRIOR e.empno = e.mgr
   ORDER SIBLINGS BY d.dname;
   
   SELECT e.empno
        , LPAD(' ',(LEVEL-1)*4)||ename
        , LEVEL
        , SYS_CONNECT_BY_PATH(ename,'/')
        , CONNECT_BY_ROOT  ename
        , CONNECT_BY_ISLEAF
   FROM emp e
   START WITH e.mgr IS NULL
   CONNECT BY PRIOR e.empno = e.mgr;
   
3. ORDER [SIBLINGS] BY : �μ������� ���ĵʰ� ���ÿ� ������ �������� ����
4. CONNECT_BY_ROOT : ������ �������� �ֻ��� �ο츦 ��ȯ�ϴ� ������.
5. CONNECT_BY_ISLEAF : CONNECT BY ���ǿ� ���ǵ� ���迡 ���� 
   �ش� ���� ������ �ڽ����̸� 1, �׷��� ������ 0 �� ��ȯ�ϴ� �ǻ��÷�
6. SYS_CONNECT_BY_PATH(column, char)  : ��Ʈ ��忡�� �����ؼ� �ڽ��� ����� 
   ����� ��� ������ ��ȯ�ϴ� �Լ�.
7. CONNECT_BY_ISCYCLE : ����Ŭ�� ������ ������ ����(�ݺ�) �˰����� ����Ѵ�. 
  �׷���, �θ�-�ڽ� ���� �߸� �����ϸ� ���ѷ����� Ÿ�� ���� �߻��Ѵ�.   
  �̶��� ������ �߻��ϴ� ������ ã�� �߸��� �����͸� �����ؾ� �ϴ� ��, 
  �̸� ���ؼ��� 
    ����  CONNECT BY���� NOCYCLE �߰�
    SELECT ���� CONNECT_BY_ISCYCLE �ǻ� �÷��� ����� ã�� �� �ִ�. 
  ��, ���� �ο찡 �ڽ��� ���� �ִ� �� ���ÿ� �� �ڽ� �ο찡 �θ�ο� �̸� 1,
     �׷��� ������ 0 ��ȯ.

- 1) 7566 JONES�� mgr�� 7839���� 7369��  ����;
UPDATE emp
SET mgr = 7369
WHERE empno = 7566;
-- 2)
SELECT  deptno, empno, LPAD(' ', 3*(LEVEL-1)) ||  ename
, LEVEL
, SYS_CONNECT_BY_PATH(ename, '/')
FROM emp   
START WITH  mgr IS NULL
CONNECT BY PRIOR  empno =  mgr   ;
-- 3)
ROLLBACK;
-- 4)
SELECT  deptno, empno, LPAD(' ', 3*(LEVEL-1)) ||  ename
, LEVEL
, SYS_CONNECT_BY_PATH(ename, '/')
, CONNECT_BY_ISCYCLE IsLoop
FROM emp   
START WITH  mgr IS NULL
CONNECT BY NOCYCLE PRIOR  empno =  mgr;
----------------------------------
-- ������ ���̽� �𵨸� + �����ۼ�(PL/SQL)
1. �����ͺ��̽� �𵨸� ����
    - ���� ������ �������� ���μ����� ���������� �����ͺ��̽�ȭ ��Ű�� ����
    ��) �� �ֹ�/����/��� ��ǰ
    1) ���� ����
        ���� ���μ��� �м�
        (���� �䱸 �м���)
    2) ������ �𵨸� (ER-Diagram)
    3) ���� �𵨸� (����ȭ)
    4) ������ �𵨸�(�� ����ȭ) 

2. �����ͺ��̽� �𵨸� �ܰ�
    1) ***���� �м�***
        ��. ���� ������ ���� �⺻ ���İ� ��� �ʿ� + (���� 1~3���� ����)
          ��) �������� ����Ʈ + ��
                ���, ���� �ʿ�
                ȸ����� ���, ���� (��������ǥ,�ս�,�ڻ� ���) ����
        ��. ���� ������� ���� ó�� ���� ��� ���μ��� �м�
        ��. ����� ���ͺ�
        ��. ��� ����(����,��ǥ,����) �ľ��ؼ� �����ͷ� ���� �Ǿ����� �׸� ��Ȯ�ϰ� �ľ� �ʿ�
        ��. ��׶��� ���μ��� �ľ�, �پ��� ������ �پ��� ����� ���� �ľ�
        ��. �� ������� [�䱸 �м���] �ۼ�...
    2)
    3)
    4)