-- ����Ŭ �ڷ���
-- 1) CHAR
    - ���� ����
    - CHAR(size BYTE|CAHR)
      CHAR == CHAR(1)
      CHAR(10)
      CHAR(10 byte)
      CHAR(10 char)    
      �⺻�� : 1
      sizeũ���� �������� ���� ������
      1����Ʈ ~ 2000����Ʈ
      �ѱ�(3����Ʈ) ���� (1����Ʈ)
      
-- 2) NCHAR[(size)] ==N(UNICODE) + CHAR
    - NCHAR[(size)] --> ����
    - �⺻1����, �ּ� 1����
    - �ִ� 2000bytes
    - ���� ����
    ��) NCHAR(20) -> 20���� ���尡�� 2���� �����ϴ��� �������� ����������
    - NCHAR() -> NCHAR(1) 1����
    - ����(byte)X
    create table test (
                aa char(3),    -- char(3 byte)
                bb char(3 char),  --> 3����
                cc nchar(3));   --> 3����

    INSERT INTO test(aa,bb,cc) values('ȫ�浿','ȫ�浿','ȫ�浿');
--ORA-12899: value too large for column "SCOTT"."TEST"."AA" (actual: 9, maximum: 3) aaĮ��  �ִ� 3����Ʈ �Է� 9����Ʈ ����
    INSERT INTO test(aa,bb,cc) values('ȫ','ȫ�浿','ȫ�浿'); -- ���� ����
    
-- ��������: CHAR, NCHAR : �ִ�ũ�� 2000byte
    -- ���ڿ� ũ���۵� ������ ���� �Ҵ�

-- ��������
-- 3) VARCHAR2(size[BYTE ? CHAR])
-- �ִ� ũ��: 4000byte , ��������
-- ����� �ִ밪�� �����ؾ� ��
-- �������� �������Է� �÷����� ����Ǹ�, �ԷµǴ� �����Ͱ� ����� �뷮���� ������, ������ �پ���, 
-- ����� �뷮���� �ԷµǴ� �����ͷ��� �� ũ�� ������ ��ȯ�Ѵ�.
��) ��������/��������
    name CHAR(10 CHAR)      -> 3���� �Է½� ���� ���� �������� ä��
    name VARCHAR2(10 CHAR)  -> 10���� ���� ������ 3���� �Է½� �������� ��ȯ��
                    �� �ִ� ���ڿ��� ����
    VARCHAR2(10) = VARCHAR2(10 byte)
    VARCHAR2  = VARCHAR2(1) = VARCHAR2(1 byte)
    
-- 4) NVARCHAR2(size)
    -- N + VARCHAR2
    -- NVARCHAR2 ������Ÿ���� ���� unicode ������Ÿ�Կ��� ���ȴ�.
    -- NVARCHAR2�� ����� �÷��� ĳ���͸� ������ �� �ִ�, ����Ʈ�δ� �ʵ�
    
-- 5) LONG - ����Ŭ: ���� �ڷ���, �ִ밪: 2GB, ��������
-- �� ������ �����ϴµ� ���̸�, ����� ������ select ������ �⺻������ 80���ڸ� ���̹Ƿ� set long 500ó�� ������ �����ؾ� ���δ�.

-- 6) NUMBER[(p[,s])] ���ڸ� ��Ÿ���� �ڷ���(����,�Ǽ�)
--      NUMPER
--      NUMBER(p) : precision : ��Ȯ�� : ��ü �ڸ��� 1~38
--      NUMBER(p,s) : scale : ������ �ڸ� ���� �ڸ��� : -83~127
--      NUMBER(4): ����
--      NUMBER(5,2): �Ǽ�
--  ��)  NUMBER(3,7): -> 0.0000[][][]
--      KOR NUMBER == NUMBER(38,127)
--      kor NUMBER(3) == kor NUMBER(3,0)
CREATE table tbl_number(
    kor NUMBER(3),      -- -999 ~ 999   ��������(0~100)
    eng NUMBER(3,0),
    mat NUMBER(3),
    tot NUMBER(3),
    avg NUMBER(5,2)
);

INSERT INTO tbl_number (kor,eng,mat,tot,avg) VALUES(90.89,85,100);
   -- ORA-00947: not enough values �Էµ� �� ����
INSERT INTO tbl_number (kor,eng,mat) VALUES(90.89,85,100);
-- 91	85	100		 -> 90.89-> �ݿø� �Ǿ 91
INSERT INTO tbl_number (kor,eng,mat) VALUES(90,85,300);
INSERT INTO tbl_number (kor,eng,mat) VALUES(90.89,85,-999);
INSERT INTO tbl_number (kor,eng,mat) VALUES(80,75,30);

-- [PL?SQLfor/while �ݸ�-> ������ ������ 0~100����
INSERT INTO tbl_number (kor,eng,mat) VALUES(TRUNC(dbms_random.value(0,101)),
                                            TRUNC(dbms_random.value(0,101)),
                                            TRUNC(dbms_random.value(0,101)));

-- ��� �л��� ����, ��� ���(UPDATE)
UPDATE tbl_number
SET tot = kor+eng+mat, avg = (kor+eng+mat)/3;
-- �� �л��� ���� ����
UPDATE tbl_number
--SET avg = 999.1234567
SET avg = 99999
-- ORA-01438: value larger than specified precision allowed for this column : ������ �������� ŭ
WHERE avg = 92;     --������ Ű (primary key) �й�
-- 999.12
desc emp;
desc dept;

-- 7) FLOAT(p) == NUMBER

-- 8) DATE ��¥ + �ð�(��) 7byte
        TIMESTAMP
    ��) �л������� �����ϰ� �����ϴ� ���̺� ����
    �й� : NUMBER(7) �Ǵ� (CHAR) �������� �ѱ�x, var X
    �̸� : �������� NVARCHAR2(10) �ѱ� 10���� ���� ����
                    ���̺� ����(Į�� ũ��)
    ��,��,��,�� : NUMBER(3) + üũ ��������(0~100 ����)
    ��� : NUMBER(5,2) --100.00
    ��� : NUMBER(3)
    ���� : ����  [DATE], TIMESTAMP X
    �ֹε�� ��ȣ: CHAR(14), NCHAR X
    
-- 9) TIMESTAMP : DATE Ȯ��
        TIMESTAMP(6) == TIMESTAMP
        TIMESTAMP(0)
        TIMESTAMP(9)
        
-- 10) 2�� ������(0,1) RAW(size), LONG RAW
--      2RAW�� �ִ밪�� 2000����Ʈ�� �ݵ�� size�� ����ؾ� �ϸ� LONG RAW�� 2GB���� ����
    ��) �̹��� ����, ���� ���� -> 2�� ������ -> DB ����
    
-- 11) BLOB : Binary Large OBject
--      Binary �����͸� 4GB���� ���� 
--      BFILE : Binary �����͸� �ܺο� file���·� (264 -1����Ʈ)���� ����

-- 12) CLOB: Character �����͸� 4GB���� ����    --�۳���
--     NCLOB: Unicode �����͸� 4GB���� ����

-- COUNT OVER() : ������ ���� ������ ������� ��ȯ
SELECT buseo,name, basicpay
    --, COUNT(*)OVER(ORDER BY basicpay ASC)
    , COUNT(*)OVER(PARTITION BY buseo ORDER BY basicpay ASC)
FROM insa;

SELECT buseo,name, basicpay
  --  , SUM(basicpay)OVER(ORDER BY basicpay ASC)
    , SUM(basicpay)OVER(PARTITION BY buseo ORDER BY basicpay ASC)
FROM insa;

-- �� ������ �޿� ��հ� ���� �޿����� ����

SELECT city, name, basicpay
    , AVG(basicpay)OVER(PARTITION BY city ORDER BY city)
    , basicpay - AVG(basicpay)OVER(PARTITION BY city ORDER BY city)
FROM insa

-- ���̺� ����, ����, ����
-- ���̺� ���ڵ�(��,�ο�)�� �߰� ���� ����

-- 1) ���̺�? : ������ �����
-- 2) DB �𵨸� -> ���̺� ����
��) �Խ����� �Խñ��� ������ ���̺� ����
    1) ���̺��: tbl_board
    2)            �÷���       �ڷ���         ũ��                       NULL ���            ����
        �۹�ȣ(PK) seq         ����(����)      NUMBER(38)                 NOT NULL          �Խñ� �ۼ��� ����
        �ۼ���     writer      ����           VARCHAR2(20 BYTE)          NOT NULL              
        ��й�ȣ   passwd       ����           VARCHAR2(15)               NOT NULL
        ����      title        ����           VARCHAR2(100)              NOT NULL
        ����      content      ����           CLOB                      
        �ۼ���    regdate      ��¥            DATE                      DEFAULT SYSDATE
        ���
    3) �Խñ��� ������ �� �ִ� ������ Ű : �۹�ȣ
    4) �ʼ� �Է� ����: NOT NULL(NN) ��������,
    5) �ۼ����� ���� �ý����� ��¥,�ð� ������ �ڵ� �Է�: 
����
 CREATE [GLOBAL TEMPORARY] TABLE [schema.] table
      ( 
        ���̸�  ������Ÿ�� [DEFAULT ǥ����] [��������] 
       [,���̸�  ������Ÿ�� [DEFAULT ǥ����] [��������] ] 
       [,...]  
      ); 

      
CREATE TABLE TBL_BOARD
      ( 
       seq      NUMBER(38)                  NOT NULL PRIMARY KEY ,
       writer   VARCHAR2(20 BYTE)           NOT NULL,
       passwd   VARCHAR2(15)                NOT NULL,
       title    VARCHAR2(100)               NOT NULL,
       content  CLOB,                      
       regdate  DATE        DEFAULT SYSDATE
      ); 
desc tbl_board;

-- ��ȸ�� �÷�x - ���̺� ���� �� ���ο� �÷� �߰�
-- ���̺� ����
-- ALTER TABLE (DDL)
-- CREATE TABLE(DDL)
-- DROP TABLE (DDL)

? alter table ... add �÷�  �Ǵ� ��������                   -- ���ο� �÷��� ���̺� �߰�
�÷� �߰��� ���̺��� ���� �����Ѵٸ�, ���� �߰��Ǵ� �÷��� �̹� �����ϴ� ��� ���� ���� NULL�� �ʱ�ȭ�Ѵ�.
? alter table ... modify �÷�                 -- �÷��� ���̺��� ����
? alter table ... drop[constraint] ��������    --���� ������ ���̺��� ����
? alter table ... drop column �÷�            -- �÷��� ���̺��� ����
;
INSERT INTO tbl_board (seq,writer,passwd,title,content,regdate)
                VALUES(1,'admin','1234','test -1','test -1',SYSDATE);
INSERT INTO tbl_board (seq,writer,passwd,title,content,regdate)
                VALUES(2,'admin','1234','test -2','test -2',SYSDATE);

--ORA-00001: unique constraint (SCOTT.SYS_C007017) violated : ���ϼ� ���� ��������: pk(seq)�� �ߺ��� �� ����
INSERT INTO tbl_board VALUES(4,'pilot','1234','test -4','test -4',SYSDATE);
-- ���̺� �÷� ������� VALUE()�ڵ�
commit;
SELECT *
FROM tbl_board;
--tbl_board�� ���� ���� ��� ��ȸ
SELECT *
FROM user_constraints
WHERE table_name LIKE UPPER('%board');

-- ��ȸ�� �÷�x - ���̺� ���� �� ���ο� �÷� �߰�
-- �÷� �߰��� ���̺��� ���� �����Ѵٸ�, ���� �߰��Ǵ� �÷��� �̹� �����ϴ� ��� ���� ���� NULL�� �ʱ�ȭ�Ѵ�.
--  DEFAULT���� �ٰ�� �̹� �����ϴ� �൵ DEFAULT������ �ʱ�ȭ ��
-- readed NUMBER
ALTER TABLE tbl_board ADD readed NUMBER DEFAULT 0;
SELECT *
FROM tbl_board;

-- 1) �Խñ� �ۼ�(INSERT ��) content X readed 0 DATE SYSDATE 
INSERT INTO tbl_board (writer, seq, title, passwd)
             VALUES('pilot',(SELECT NVL(MAX(seq),0)+1 FROM tbl_board), 'test -5', '1234');
COMMIT;
SELECT *
FROM tbl_board;

-- 2) content�� null�� ��� -> '�ù�' �Խñ� ����
--ORA-00932: inconsistent datatypes: expected - got CLOB
UPDATE tbl_board 
SET content = '�ù�'
WHERE content IS NULL;  --where�� ������ ��� ���ڵ带 ����

-- 3) pilot �ۼ����� ��� �Խñ��� ����
DELETE FROM tbl_board
where writer = 'pilot';

-- 4) �÷��� �ڷ����� ũ�� ����
--ALTER TABLE ... MODIFY
-- ���� ��� �÷��� �����Ͱ� ���ų� null ���� ������ ��쿡�� size�� ���� �� �ִ�.
-- �÷� ũ���� ������ ����� �������� ũ�⺸�� ���ų� Ŭ ��쿡�� �����ϴ�.
-- NOT NULL �÷��� ��쿡�� size�� Ȯ�븸 �����ϴ�.
-- �÷��� �⺻�� ������ �� ���Ŀ� ���ԵǴ� ����� ������ �ش�.
DESC tbl_board;
--WRITER  NOT NULL VARCHAR2(20) -> 40
����
ALTER TABLE ���̺��
        MODIFY (�÷��� datatype [DEFAULT ��]
               [,�÷��� datatype]...);

SELECT MAX(VSIZE(writer)) --5
FROM tbl_board;

ALTER TABLE tbl_board MODIFY (writer VARCHAR2(40));

-- 5) title �÷��� ���� -> subject
ALTER TABLE tbl_board
RENAME COLUMN title TO subject;

-- 6) bigo �÷� �߰�(��Ÿ ����) -> bigo ����
ALTER TABLE tbl_board
ADD bigo VARCHAR2(100);

DESC tbl_board;
SELECT *
FROM tbl_board;

-- ALTER TABLE ... DROP COLUMN: ���̺��� �����ϴ� ���� �ƴ϶�, Ư�� ���̺��� �÷��̳� constraint�� ������ �� ����Ѵ�
    ? �÷��� �����ϸ� �ش� �÷��� ����� �����͵� �Բ� �����ȴ�.
    ? �ѹ��� �ϳ��� �÷��� ������ �� �ִ�.
    ? ���� �� ���̺��� ��� �ϳ��� �÷��� �����ؾ� �Ѵ�.
    ? DDL������ ������ �÷��� ������ �� ����.

ALTER TABLE tbl_board
DROP COLUMN bigo;

DROP TABLE tbl_board;

-- 7) ���̺���� ����
RENAME ���̺�� TO ���̺��
-----------------------------
-- 2) ���̺��� �����ϴ� ���: ��������(subquery)�� �̿���
    ��. �̹� ������ ���̺� ���� + ���ڵ�(��)����
    ��. subquery��� �ؼ� ���̺� ����
    ��. (1)���̺� ���� + (2) ������ ���� + (3)�������� ����X (NN�� �����)
    ��. 
    ;
    
CREATE TABLE tbl_emp(empno,ename,job,hiredate,mgr,pay,deptno    )
AS
(
SELECT empno,ename,job,hiredate,mgr,sal+NVL(comm,0)pay,deptno    
FROM emp
);
DESC tbl_emp;
SELECT *
FROM tbl_emp;

-- ���� ���� ���� X
SELECT *
FROM user_constraints
WHERE table_name = 'TBL_EMP';

-- ���������� �̿��ؼ� ���̺� ���� + ������ ���� X(���̺��� ������ ����)
CREATE TABLE tbl_emp
AS
SELECT *
FROM emp
WHERE 1 = 0;

SELECT *
FROM tbl_emp;

DROP TABLE tbl_empgrade;
COMMIT;

-- ���� dept, dname,empno,ename,hiredate,pay,grade
-- tbl_empgrade
CREATE TABLE tbl_empgrade (dept, dname,empno,ename,hiredate,pay,grade)
AS
SELECT e.deptno, d.dname,e.empno,e.ename,e.hiredate,sal+NVL(comm,0) pay,s.grade
FROM emp e,dept d,SALGRADE s 
WHERE e.deptno = d.deptno AND sal+NVL(comm,0) BETWEEN s.losal AND s.hisal;

SELECT *
FROM tbl_empgrade;
COMMIT;

-- INSERT
INSERT INTO ���̺�� [(Į����,...)] VALUES (�÷��� ...);
DML - COMMIT(�Ϸ�), ROLLBACK(���)
--
--Multi + table insert ��
-- �ϳ��� insert ������ �ϳ��� ���̺� �ϳ��� ��(row)���� �Է����� �ʰ� �ϳ��� insert ������ ���� ���� ���̺� ���ÿ� �ϳ��� ���� �Է��ϴ� ���̴�.
-- ����
-- 1) unconditional insert all
-- 2) conditional insert all 
-- 3) conditional first insert
-- 4) pivoting insert 

-- 1) unconditional insert all
Unconditional insert all ���� ���ǰ� ������� ����Ǿ��� ���� ���� ���̺� �����͸� �Է��Ѵ�.

? ���������κ��� �ѹ��� �ϳ��� ���� ��ȯ�޾� ���� insert ���� �����Ѵ�.
? into ���� values ���� ����� �÷��� ������ ������ Ÿ���� �����ؾ� �Ѵ�.

�����ġ�
	INSERT ALL | FIRST
	  [INTO ���̺�1 VALUES (�÷�1,�÷�2,...)]
	  [INTO ���̺�2 VALUES (�÷�1,�÷�2,...)]
	  .......
	Subquery;

���⼭ 
 ALL : ���������� ��� ������ �ش��ϴ� insert ���� ��� �Է�
 FIRST : ���������� ��� ������ �ش��ϴ� ù ��° insert ���� �Է�
 subquery : �Է� ������ ������ �����ϱ� ���� ���������� �� ���� �ϳ��� ���� ��ȯ�Ͽ� �� insert �� ����
-- ��) 

CREATE TABLE dept_10 AS (SELECT * FROM dept WHERE 1=0);
CREATE TABLE dept_20 AS (SELECT * FROM dept WHERE 1=0);
CREATE TABLE dept_30 AS (SELECT * FROM dept WHERE 1=0);
CREATE TABLE dept_40 AS (SELECT * FROM dept WHERE 1=0);

INSERT ALL
    INTO dept_10 VALUES(deptno,dname,loc)
    INTO dept_20 VALUES(deptno,dname,loc)
    INTO dept_30 VALUES(deptno,dname,loc)
    INTO dept_40 VALUES(deptno,dname,loc)
SELECT deptno,dname,loc FROM dept;

SELECT *
FROM emp;
ROLLBACK;
emp_10, emp_20, emp_30, emp_40 ���̺� ���� ��
emp�� select ��ȸ�ϴ� ���� �������� �� �μ����� 4���� ������ ���̺� insert
CREATE TABLE emp_10 AS (SELECT * FROM emp WHERE 1=0);
CREATE TABLE emp_20 AS (SELECT * FROM emp WHERE 1=0);
CREATE TABLE emp_30 AS (SELECT * FROM emp WHERE 1=0);
CREATE TABLE emp_40 AS (SELECT * FROM emp WHERE 1=0);

-- ������ �ִ� ���� ���̺� �μ�Ʈ ��
2) conditional insert all 
--INSERT ALL
3) conditional first insert
INSERT FIRST
   WHEN deptno = 10 THEN
    INTO emp_10 VALUES(empno,ename,job,mgr,hiredate,sal,comm,deptno)
    WHEN deptno = 20 THEN
    INTO emp_20 VALUES(empno,ename,job,mgr,hiredate,sal,comm,deptno)
    WHEN deptno = 30 THEN
    INTO emp_30 VALUES(empno,ename,job,mgr,hiredate,sal,comm,deptno)
    ELSE
    INTO emp_40 VALUES(empno,ename,job,mgr,hiredate,sal,comm,deptno)
SELECT * FROM EMP;

SELECT * 
FROM emp_40;
ROLLBACK;

-- INSERT ALL / INSERT FIRST ������
-- ALL : �����ϴ� ��� insert ����
-- FIRST : �����ϴ� ù��° insert ����
INSERT FIRST
  WHEN deptno = 10 THEN
    INTO emp_10 VALUES(empno,ename,job,mgr,hiredate,sal,comm,deptno)
  WHEN job = 'CLERK' THEN
    INTO emp_20 VALUES(empno,ename,job,mgr,hiredate,sal,comm,deptno)
  ELSE
    INTO emp_40 VALUES(empno,ename,job,mgr,hiredate,sal,comm,deptno)
SELECT * FROM emp;

SELECT * FROM emp WHERE job = 'CLERK' AND deptno = 10;
ROLLBACK;
SELECT * FROM emp_40;

-- 4) pivoting insert

create table sales(
    employee_id       number(6),
    week_id            number(2),
    sales_mon          number(8,2),
    sales_tue          number(8,2),
    sales_wed          number(8,2),
    sales_thu          number(8,2),
    sales_fri          number(8,2));
    
insert into sales values(1101,4,100,150,80,60,120);

insert into sales values(1102,5,300,300,230,120,150);
commit;

create table sales_data(
    employee_id        number(6),
    week_id            number(2),
    sales              number(8,2));
    
SELECT * FROM sales;
SELECT * FROM sales_data;

insert all
    into sales_data values(employee_id, week_id, sales_mon)
    into sales_data values(employee_id, week_id, sales_tue)
    into sales_data values(employee_id, week_id, sales_wed)
    into sales_data values(employee_id, week_id, sales_thu)
    into sales_data values(employee_id, week_id, sales_fri)
    select employee_id, week_id, sales_mon, sales_tue, sales_wed,
           sales_thu, sales_fri
    from sales;

SELECT * FROM sales_data;

SELECT *
FROM emp_40;
DELETE FROM emp_10;  --> emp_10�� ��� �� ���� 
TRUNCATE TABLE emp_20;  --> emp_20�� ��� �� ���� + commit
DROP TABLE emp_30; --> ���̺� ��ü�� ����

-- ���� insa ���̺��� num, name �÷����� ���� �ؼ� ���ο� tbl_score ���̺� ����
(num<=1005);
CREATE TABLE tbl_score (num, name)
AS
SELECT num,name
FROM insa
WHERE num <= 1005;

SELECT *
FROM tbl_score;

-- ���� tbl_score ���̺� ������ �� �� �� ��� �÷� �߰�
(���� ������ �⺻�� 0), grade - char(1 char);
ALTER TABLE tbl_score ADD (kor NUMBER(3) DEFAULT 0, 
                            eng NUMBER(3) DEFAULT 0,
                            mat NUMBER(3) DEFAULT 0,
                            tot NUMBER(3) DEFAULT 0,
                            avg NUMBER(5,2) DEFAULT 0,
                            grade CHAR(1 char),
                            rank NUMBER(3));
                         

DESC tbl_score;
SELECT *
FROM tbl_score;
-- ���� 1001 -1005�� �л��� kor,eng,mat,������ ������ ������ ������Ʈ
;
UPDATE tbl_score SET
                kor = FLOOR(dbms_random.value(0,101)),
                eng = FLOOR(dbms_random.value(0,101)),
                mat = FLOOR(dbms_random.value(0,101));
COMMIT; 
SELECT *
FROM tbl_score;


-- ���� 1005 �л��� ������ -> 1001�л� ������ ����
--UPDATE tbl_score SET
--                kor = (SELECT kor FROM tbl_score WHERE num = 1005),
--                eng = (SELECT eng FROM tbl_score WHERE num = 1005),
--                mat = (SELECT mat FROM tbl_score WHERE num = 1005)
--WHERE num = 1001;

UPDATE tbl_score
SET(kor,eng,mat) = (SELECT kor,eng,mat FROM tbl_score WHERE num = 1005)
WHERE num = 1001;

-- [����] ��� �л��� ���� ����� ����
--()���� : ����� �Ҽ��� 2�ڸ�
UPDATE tbl_score SET
                tot = kor+eng+mat, 
                avg = (kor+eng+mat)/3;
       
-- ����) ��� �� 'A','B','C','D','E'
--              90,80,  70, 60

UPDATE tbl_score SET grade = CASE
                WHEN avg >=90 THEN 'A'
                WHEN avg BETWEEN 80 AND 89 THEN 'B'
                WHEN avg BETWEEN 70 AND 79 THEN 'C'
                WHEN avg BETWEEN 60 AND 69 THEN 'D'
                ELSE 'F'
                END;
                
 --  [1]              
UPDATE tbl_score p SET rank = ( 
                                SELECT ranks
                                FROM (
                                        SELECT RANK()OVER(ORDER BY tot DESC)ranks
                                            ,ROWID rid
                                        FROM tbl_score
                                )c
                                WHERE p.ROWID = c.rid
                                );
       --[2]                         
  UPDATE tbl_score s SET rank = (SELECT COUNT(*)+1 FROM tbl_score t where (t.avg > s.avg) );         
           --[3]
UPDATE tbl_score p SET rank = ( 
                            SELECT t.r
                            FROM(
                                SELECT num,tot, RANK()OVER(ORDER BY tot DESC)r
                                FROM tbl_score
                                )t
                            WHERE t.num = p.num
                                );
                         
    
    -- ��� �л����� ���� ������ 20�� ����... 100�� �Ѿ 100����...
    
    UPDATE tbl_score
    SET eng = CASE
                WHEN eng >= 80 THEN 100
                ELSE eng+20
                END;
    
    -- ������ ������ ������ �Ǹ� ������ �л����� ����, ��� ��ü �л��� ����� �޶�����...
    -- PL/SQL 5������ �� ����: ��Ű��(package),Ʈ���� (Trigger)
    
SELECT empno,ename,sal, 
        ROW_NUMBER()OVER(ORDER BY sal DESC)rn,
        RANK()OVER(ORDER BY sal DESC)r,
        DENSE_RANK()OVER(ORDER BY sal DESC)dr
FROM emp;

-- ���� ���л��鸸 ���� ������ 5�� �� ���� ��Ű�� �����ۼ�
--tbl_score ���̺� ���� Į�� X insa���̺� ssn
-- (insa join)
UPDATE tbl_score s SET kor = 
                    (   SELECT c.k
                        FROM(
                            SELECT t.num,DECODE(MOD(SUBSTR(ssn,8,1),2),1,kor+5,kor)k
                            FROM tbl_score t join insa i ON t.num = i.num
                                )c
                        WHERE c.num = s.num);
--[2]
UPDATE tbl_score s SET kor = CASE
                WHEN kor >= 95 THEN 100
                ELSE kor+5
                END
WHERE num = ANY(SELECT num FROM insa
                    WHERE num <= 1005 AND MOD(SUBSTR(ssn,8,1),2)=1
                    );


ROLLBACK;
commit;
SELECT *
FROM tbl_score;

SELECT DECODE(SUBSTR(ssn,8,1),1,kor,kor+5)
FROM tbl_score t join insa i ON t.num = i.num;


-- �׽���
UPDATE tbl_score s SET kor = 
                    (   SELECT c.k
                        FROM(
                            SELECT t.num,DECODE(MOD(SUBSTR(ssn,8,1),2),1,
                            CASE 
                                WHEN kor >=95 THEN 100
                                ELSE kor+5
                            END
                            ,kor)k
                            FROM tbl_score t join insa i ON t.num = i.num
                                )c
                        WHERE c.num = s.num);
        
-- merge(����): ������ ���� �� ���� ���̺��� ���Ͽ� �ϳ��� ���̺�� ��ġ�� ���� ������ �����̴�        
        �����ġ�
    MERGE [hint] INTO [schema.] {table ? view} [t_alias]
      USING {{[schema.] {table ? view}} ?
            subquery} [t_alias]
      ON (condition) [merge_update_clause] [merge_insert_clause] [error_logging_clause];

��merge_update_clause ���ġ�
   WHEN MATCHED THEN UPDATE SET {column = {expr ? DEFAULT},...}
     [where_clause] [DELETE where_clause]

��merge_insert_clause ���ġ�
   WHEN MATCHED THEN INSERT [(column,...)]
    VALUES ({expr,... ? DEFAULT}) [where_clause]
   
��where_clause ���ġ�
   WHERE condition

��error_logging_clause ���ġ�
   LOG ERROR [INTO [schema.] table] [(simple_expression)]
     [REJECT LIMIT {integer ? UNLIMITED}]


-- ����
create table tbl_emp(
    id number primary key,      --> primary key = NOT NULL + UNIQE �������� 
    name varchar2(10) not null,
    salary  number,
    bonus number default 100);

DESC tbl_emp;
        
insert into tbl_emp(id,name,salary) values(1001,'jijoe',150);
insert into tbl_emp(id,name,salary) values(1002,'cho',130);
insert into tbl_emp(id,name,salary) values(1003,'kim',140);
commit;
select * from tbl_emp;

create table tbl_bonus(id number, bonus number default 100);
insert into tbl_bonus(id) (select e.id from tbl_emp e);
COMMIT;
select * from tbl_bonus;


insert into tbl_bonus VALUES (1004,50);
commit;
-- tbl_emp���̺��� 1004ID ���� ��� ����

--����(merge) tbl_emp�� tbl_bonus �� ���̺�

MERGE INTO tbl_bonus b
  USING (SELECT id,salary FROM tbl_emp) e
  ON (b.id = e.id)
  WHEN MATCHED THEN 
            UPDATE SET b.bonus = b.bonus + e.salary*0.01
   WHEN NOT MATCHED THEN INSERT (b.id,b.bonus) VALUES (e.id,e.salary*0.01);
                    --where

SELECT *
FROM tbl_emp;
SELECT *
FROM tbl_bonus;
SELECT *
FROM tbl_score;
commit;

MERGE INTO tbl_score b
    USING (SELECT num,RANK()OVER(ORDER BY tot DESC)r FROM tbl_score)e
    ON (b.num = e.num)
    WHEN MATCHED THEN 
        UPDATE SET b.rank = e.r;
        
------------------
SELECT 
      NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 1, TO_CHAR( dates, 'DD')) ), ' ')  ��
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 2, TO_CHAR( dates, 'DD')) ), ' ')  ��
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 3, TO_CHAR( dates, 'DD')) ), ' ')  ȭ
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 4, TO_CHAR( dates, 'DD')) ), ' ')  ��
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 5, TO_CHAR( dates, 'DD')) ), ' ')  ��
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 6, TO_CHAR( dates, 'DD')) ), ' ')  ��
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 7, TO_CHAR( dates, 'DD')) ), ' ')  ��
FROM (
        SELECT TO_DATE(:yyyymm , 'YYYYMM') + LEVEL - 1  dates
        FROM dual
        CONNECT BY LEVEL <= EXTRACT ( DAY FROM LAST_DAY(TO_DATE(:yyyymm , 'YYYYMM') ) )
)  t 
GROUP BY CASE
                -- 1/2/3/4/5/6/7               2022/04/1�� ����
            WHEN TO_CHAR( dates, 'D' ) < TO_CHAR( TO_DATE( :yyyymm,'YYYYMM' ), 'D' ) 
                 THEN TO_CHAR( dates, 'W' ) + 1
            ELSE TO_NUMBER( TO_CHAR( dates, 'W' ) )
        END
ORDER BY CASE
            WHEN TO_CHAR( dates, 'D' ) < TO_CHAR( TO_DATE( :yyyymm,'YYYYMM' ), 'D' ) THEN TO_CHAR( dates, 'W' ) + 1
            ELSE TO_NUMBER( TO_CHAR( dates, 'W' ) )
        END;
        
        
        
        -------------------


        
        
        
        
                        
                        
�� DB�𵨸� ��
�� �� ��ǥ
�� �������� 
��/��/��/ȭ/��/��/��/��/�� : 1~2�ð� ���� ����
�� ��ǥ
