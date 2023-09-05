CREATE TABLE tbl_empdeptgrade (deptno, dname,empno,ename,pay,grade)
AS
SELECT e.deptno, d.dname,e.empno,e.ename,sal+NVL(comm,0) pay,s.grade
FROM emp e,dept d,SALGRADE s 
WHERE e.deptno = d.deptno AND sal+NVL(comm,0) BETWEEN s.losal AND s.hisal;

commit;

CREATE TABLE tbl_score (num, name)
AS
SELECT num,name
FROM insa;



ALTER TABLE tbl_score ADD (kor NUMBER(3) DEFAULT 0, 
                            eng NUMBER(3) DEFAULT 0,
                            mat NUMBER(3) DEFAULT 0,
                            tot NUMBER(3) DEFAULT 0,
                            avg NUMBER(5,2) DEFAULT 0,
                            grade CHAR(1 char),
                            rank NUMBER(3));
UPDATE tbl_score SET
                kor = FLOOR(dbms_random.value(0,101)),
                eng = FLOOR(dbms_random.value(0,101)),
                mat = FLOOR(dbms_random.value(0,101));                         
 
 UPDATE tbl_score SET
                tot = kor+eng+mat,
                avg = (kor+eng+mat)/3;    
ALTER TABLE tbl_score MODIFY (grade VARCHAR2(5 CHAR));
DESC tbl_score;
UPDATE tbl_score SET grade = CASE
                WHEN avg >=60 AND kor >= 40 AND eng >= 40 AND mat >= 40 THEN '�հ�'
                WHEN avg >= 60 AND (kor < 40 OR eng < 40 OR mat < 40) THEN '����'
                ELSE '���հ�'
                END;  
            
UPDATE tbl_score s SET rank = (SELECT t.r FROM
                                  (SELECT num,RANK()OVER(ORDER BY avg DESC) r
                                    FROM tbl_score)t
                                    WHERE s.num = t.num
                                    );  
                
 UPDATE tbl_score s SET rank = 0;  
 
MERGE INTO tbl_score b
    USING (SELECT num,RANK()OVER(ORDER BY tot DESC)r FROM tbl_score)e
    ON (b.num = e.num)
    WHEN MATCHED THEN 
        UPDATE SET b.rank = e.r;
                                   
COMMIT;
SELECT *
FROM tbl_score;

DESC emp;
SELECT *
FROM user_constraints
WHERE table_name = 'EMP';

INSERT INTO emp VALUES (8000,'pilot','CLERK',7788,'23/9/5',4000,1500,40);

CREATE TABLE tbl_emp10 AS (SELECT * FROM emp WHERE 1=0);
CREATE TABLE tbl_emp20 AS (SELECT * FROM emp WHERE 1=0);
CREATE TABLE tbl_emp30 AS (SELECT * FROM emp WHERE 1=0);
CREATE TABLE tbl_emp40 AS (SELECT * FROM emp WHERE 1=0);

INSERT FIRST
        WHEN deptno =10 THEN
            INTO tbl_emp10 VALUES(empno,ename,job,mgr,hiredate,sal,comm,deptno)
        WHEN deptno =20 THEN
            INTO tbl_emp20 VALUES(empno,ename,job,mgr,hiredate,sal,comm,deptno)
        WHEN deptno =30 THEN
            INTO tbl_emp30 VALUES(empno,ename,job,mgr,hiredate,sal,comm,deptno)
        WHEN deptno =40 THEN
            INTO tbl_emp40 VALUES(empno,ename,job,mgr,hiredate,sal,comm,deptno)
SELECT * FROM emp;

commit;
select *
FROM tbl_emp40;


CREATE TABLE tbl_merge1
(
     id number primary key
   , name varchar2(20)
   , pay number
   , sudang number             
);
    
CREATE TABLE tbl_merge2
(
   id number primary key 
   , sudang number             
);

INSERT INTO tbl_merge1 (id, name, pay, sudang) VALUES (1, 'a', 100, 10);
INSERT INTO tbl_merge1 (id, name, pay, sudang) VALUES (2, 'b', 150, 20);
INSERT INTO tbl_merge1 (id, name, pay, sudang) VALUES (3, 'c', 130, 0);

INSERT INTO tbl_merge2 (id, sudang) VALUES (2,5);
INSERT INTO tbl_merge2 (id, sudang) VALUES (3,10);
INSERT INTO tbl_merge2 (id, sudang) VALUES (4,20);
commit;

3) tbl_merge1�� tbl_merge2�� ���� ( id, sudang )�ϼ���... ;

MERGE INTO tbl_merge2 m2
    USING (SELECT id, sudang FROM tbl_merge1) m1
    ON (m2.id = m1.id)
    WHEN MATCHED THEN
        UPDATE SET m2.sudang = m2.sudang + m1.sudang
        WHEN NOT MATCHED THEN INSERT (m2.id,m2.sudang) VALUES (m1.id,m1.sudang);
    
2	5
3	10
4	20

2	25
3	10
4	20
1	10       
COMMIT;
        SELECT *
        FROM tbl_merge2;

DROP TABLE tbl_merge2 PURGE;  --���� ����
DROP TABLE tbl_merge1;
-----------------------------------
-- ���� ���� CONSTRAINTS: DML�� ���� �߸��� ������ ����(����,����,����) ����
-- ���Ἲ : �������� ��Ȯ���� �ϰ����� �����ϰ�, �����Ϳ� ��հ� �������� ������ �����ϴ� ��
-- data integrity(������ ���Ἲ): �����͸� ��ȣ�ϰ�, �׻� ������ �����͸� �����ϴ� ��
-- ��(row)�� �Է�, ����, ������ �� ����Ǵ� ��Ģ���� ���Ǹ� ���̺� ���� �����ǰ� �ִ� ��� ���̺��� ���� ������ ���ؼ��� ���ȴ�
-- ������ ���Ἲ ����
-- 1) ��ü ���Ἲ(Entity Integrity): ���̺� ����Ǵ� Ʃ���� ���ϼ��� �����ϱ� ���� ���� ����
--    Ʃ���� ���ϼ��� �����ϱ� ���Ͽ� �ϳ� �̻��� �Ӽ����� �����Ǵ� �ĺ��ڸ� �����ϸ�, �̷��� �ĺ��ڸ� �⺻Ű(primary key)�� ��
--    �⺻ Ű�� ���ϼ�(uniqueness)�� �ּҼ�(minimality)�� �����ؾ� �Ѵ�. 
--    ���ϼ��� �⺻ Ű�� �����ϴ� �Ӽ� ����(�÷� ����)�� ���� �����̼ǿ��� �����ؾ� �Ѵٴ� ������ ���Ѵ�. 
--    �ּҼ��� �⺻ Ű�� �����ϴ� �Ӽ������� ���ϼ��� ��ġ�� �ʴ� �ּ��� �Ӽ����� �����ؾ� �Ѵٴ� ������ ���Ѵ�. 
--    �⺻ Ű�� �����ϴ� ��� �Ӽ� ���� null�� �� �� ����.                
-- 2) ���� ���Ἲ(Relational Integrity): ���̺� ���� �������� �ϰ����� �����ϱ� ���� ���������̴�
--    �ϳ��� �����̼ǿ� �ִ� �Ӽ� ���� �ٸ� �����̼ǿ� �ִ� �Ӽ� ���� �����ϱ� ���ؼ��� �����Ǵ� �Ӽ� ���� �ݵ�� �ش� �����̼ǿ� �����ؾ� �Ѵ�
--    ���� ���Ἲ ��Ģ���� �ٸ� �����̼��� �÷� ���� �����ϴ� �÷��� �ܷ� Ű(foreign key)�� �ϰ� 
--    �ٸ� �����̼ǿ��� �����Ǵ� �÷��� ���� Ű(reference key)�� �Ѵ�. 
--    �ܷ� Ű�� �ݵ�� ���� Ű�� ���� ��ġ�ϰų� null�� ������ �Ѵ�
-- 3) ������ ���Ἲ(domain integrity): �Ӽ����� ��� ������ ���� ������ �����ϱ� ���� ���������̴�
--    ������ ���Ἲ ��Ģ������ �Ӽ��� ������ Ÿ��, ����, �⺻ Ű, ���ϼ�, null ���, ��� ���� ������ ���� �پ��� ���������� ������ �� �ִ�.

DROP TABLE dept;
--ORA-02449: unique/primary keys in table referenced by foreign keys
INSERT INTO emp (empno) VALUES (7839); -- ��ü ���Ἲ ���� unique constraint (SCOTT.PK_EMP) violated
INSERT INTO emp (empno,deptno) VALUES (7739,50); -- ���� ���Ἲ ���� 
--ntegrity constraint (SCOTT.FK_DEPTNO) violated - parent key not found
INSERT INTO emp (empno) VALUES ('abc'); -- ������ ���Ἲ ����

������̺�
�����ȣ        ������ Ű PK
�ֹε�Ϲ�ȣ     ������Ű == �ߺ������ȴ� Ű UK
����           NUMBER(3) ����(-999~999) ->  0~100üũ : CK INSERT UPDATE 101 : ������ ���Ἲ ����

-- �������� ���� ���
1) �÷�   ���� ���   (in-line ���)
2) ���̺� ����  ���  (out-of-line ���)

CREATE TABLE sample(
    id varchar2(20) PK,NN,CK,UK ��� -> �÷� ���� ���
    ,pwd varchar2(20) PK,NN,CK,UK ���
    , CONSTRAINTS id NN�������� X (NOT NULL ���������� ���̺� ����������� ���� �Ұ� �ݵ�� �÷��������θ� ���� ����)
    , CONSTRAINTS id + pwd �������� ����Ű�� ����(���̺� ���� ������θ� ���� �� �� �ִ�)
    , CONSTRAINTS �������� -> ���̺� ���� ���
    );

-- ���� ������ �����ϴ� ����
1) ���̺� ������ �� - CREATE TABLE ��
2) ���̺� ������ �� - ALTER TABLE ��

-- ���� ������ ���� 5 ����
1) PRIMARY KEY(PK): �ش� �÷� ���� �ݵ�� �����ؾ� �ϸ�, �����ؾ� ��
                    (NOT NULL�� UNIQUE ���������� ������ ����) 
2) FOREIGN KEY(FK) �ش� �÷� ���� �����Ǵ� ���̺��� �÷� �� ���� �ϳ��� ��ġ�ϰų� NULL�� ���� 
3) UNIQUE KEY(UK) ���̺����� �ش� �÷� ���� �׻� �����ؾ� �� 
4) NOT NULL(NN) �÷��� NULL ���� ������ �� ����. 
5) CHECK(CK) �ش� �÷��� ���� ������ ������ ���� ������ ���� ���� 
;
-- �ǽ�)
1) �÷� ���� ���� ���� ����
CREATE TABLE tbl_constraint1(
   -- empno NUMBER(4) NOT NULL PRIMARY KEY
    empno NUMBER(4) NOT NULL CONSTRAINT PK_tblconstraint1_empno PRIMARY KEY     --���� ���� �̸� �ޱ�
    , ename VARCHAR2(20)
    , deptno NUMBER(2) CONSTRAINT FK_tblconstraint1_deptno
                        REFERENCES dept(deptno)                  --dept(deptno)�� �����ϴ� �ܷ�Ű(FK)
    , kor NUMBER(3) CONSTRAINT CK_tblconstraint1_kor CHECK (kor BETWEEN 0 AND 100) -- 0~100���̸� �Է°����� �������� CK 
    , email VARCHAR2(250) CONSTRAINT UK_tblconstraint1_email UNIQUE -- ������ ��, ���ϼ� ���� ���� (UK)
    , city VARCHAR2(20) CONSTRAINT CK_tblconstraint1_city 
                        CHECK (city IN ('����','�λ�','�뱸','����'))-- ����,�λ�,�뱸,���� �� �ϳ��� ���
);
SYS_C007028	C NOT NULL ��������
SYS_C007029	P   PK ��������   --SYS_C007029 �ý����� �˾Ƽ� ������ �������� �̸�
-- ���� ���� ����
[����]
ALTER TABLE ���̺�� 
DROP [CONSTRAINT constraint�� | PRIMARY KEY | UNIQUE(�÷���)]
[CASCADE];
--��
ALTER TABLE tbl_constraint1
DROP CONSTRAINT PK_tbl_constraint1_empno;
--��. PK�������� �̸� ���� ���� ����
ALTER TABLE tbl_constraint1
DROP PRIMARY KEY;

SELECT *
FROM user_CONSTRAINTS
WHERE table_name = UPPER('tbl_constraint1');

DROP TABLE tbl_constraint1;

2) ���̺� ���� ���� ���� ����
CREATE TABLE tbl_constraint2(
    empno NUMBER(4) NOT NULL
    , ename VARCHAR2(20)
    , deptno NUMBER(2)
    , kor NUMBER(3)
    , email VARCHAR2(250)
    , city VARCHAR2(20)
    , CONSTRAINT PK_tbl_constraint2_empno PRIMARY KEY(empno)
    , CONSTRAINT FK_tbl_constraint2_deptno FOREIGN KEY(deptno) REFERENCES dept (deptno)
    , CONSTRAINT CK_tblconstraint2_kor CHECK (kor BETWEEN 0 AND 100)
    , CONSTRAINT UK_tblconstraint2_email UNIQUE (email)
    , CONSTRAINT CK_tblconstraint1_city CHECK (city IN ('����','�λ�','�뱸','����'))
);
SELECT *
FROM user_CONSTRAINTS
WHERE table_name = UPPER('tbl_constraint2');
DROP TABLE tbl_constraint2;
3) ���̺� ���� �Ŀ� pk�������� ����
CREATE TABLE tbl_constraint3(
    empno NUMBER(4) 
    , ename VARCHAR2(20)
    , deptno NUMBER(2)
);
-- ���̺� ����
ALTER TABLE tbl_constraint3
ADD CONSTRAINT PK_tbl_constraint3_empno PRIMARY KEY(empno);

ALTER TABLE tbl_constraint3
ADD CONSTRAINT FK_tbl_constraint3_deptno FOREIGN KEY(deptno) REFERENCES dept (deptno);

DROP TABLE tbl_constraint3;
SELECT *
FROM user_CONSTRAINTS
WHERE table_name = UPPER('tbl_constraint3');

-- �������� Ȱ��ȭ
ALTER TABLE ���̺��
ENABLE CONSTRAINT �������Ǹ�
-- �������� ��Ȱ��ȭ
ALTER TABLE ���̺��
DISABLE CONSTRAINT �������Ǹ�

--
DROP TABLE ���̺��; --���̺� ���������� ���� (��������)
DROP TABLE ���̺�� PURGE; -- �����뿡 ���� �ʰ� ���� ����
DROP TABLE ���̺�� CASCADE CONSTRAINT; -- ���̺��(dept) �� ���̺��� �����ϴ� ����Ű(FK)(emp.deptno)�� ���ÿ� ����
-- ALTER TABLE ���̺��
-- ADD (�÷�...)
-- ADD (��������...)
���÷������� ���ġ�
    �÷��� ������Ÿ�� CONSTRAINT constraint��
	REFERENCES �������̺�� (�����÷���) 
             [ON DELETE CASCADE | ON DELETE SET NULL]

emp
    , deptno NUMBER(2) CONSTRAINT FK_EMP_DEPTNO REFERENCES dept(deptno)
              ON DELETE CASCADE;  -- emp ���̺��� 30�� ����鵵 ���� �����ȴ�
              ON DELETE SET NULL; -- emp ���̺��� 30�� ������� deptno = null �� ����
--
DELETE FROM dept
WHERE deptno =30; -- ���� ���Ἲ ����, ��� ���̺� 30�� ����� �����ϰ� �ִ�
ON DELETE CASCADE;  -- emp ���̺��� 30�� ����鵵 ���� �����ȴ�
ON DELETE SET NULL; -- emp ���̺��� 30�� ������� deptno = null �� ����


-- �ǽ�
-- ON DELETE CASCADE;  -- emp ���̺��� 30�� ����鵵 ���� �����ȴ�
CREATE TABLE tbl_emp AS (SELECT * FROM emp);
CREATE TABLE tbl_dept AS (SELECT * FROM dept);

ALTER TABLE tbl_dept
ADD CONSTRAINT PK_tbl_dept_deptno PRIMARY KEY(deptno);

ALTER TABLE tbl_emp
ADD (CONSTRAINT PK_tbl_emp_empno PRIMARY KEY(empno)
    , CONSTRAINT FK_tbl_emp_deptno FOREIGN KEY(deptno) REFERENCES tbl_dept(deptno) ON DELETE CASCADE);

SELECT *
FROM tbl_emp;
DELETE FROM tbl_dept
WHERE deptno =30;

select*
FROM tbl_emp;

SELECT *
FROM user_constraints
WHERE table_name = UPPER('tbl_emp');

-- join
--å ���̺�
 CREATE TABLE book(
       b_id     VARCHAR2(10)    NOT NULL PRIMARY KEY   -- åID
      ,title      VARCHAR2(100) NOT NULL  -- å ����
      ,c_name  VARCHAR2(100)    NOT NULL     -- c �̸�
     -- ,  price  NUMBER(7) NOT NULL
 );
-- Table BOOK��(��) �����Ǿ����ϴ�.
INSERT INTO book (b_id, title, c_name) VALUES ('a-1', '�����ͺ��̽�', '����');
INSERT INTO book (b_id, title, c_name) VALUES ('a-2', '�����ͺ��̽�', '���');
INSERT INTO book (b_id, title, c_name) VALUES ('b-1', '�ü��', '�λ�');
INSERT INTO book (b_id, title, c_name) VALUES ('b-2', '�ü��', '��õ');
INSERT INTO book (b_id, title, c_name) VALUES ('c-1', '����', '���');
INSERT INTO book (b_id, title, c_name) VALUES ('d-1', '����', '�뱸');
INSERT INTO book (b_id, title, c_name) VALUES ('e-1', '�Ŀ�����Ʈ', '�λ�');
INSERT INTO book (b_id, title, c_name) VALUES ('f-1', '������', '��õ');
INSERT INTO book (b_id, title, c_name) VALUES ('f-2', '������', '����');

COMMIT;

SELECT *
FROM book;
--�ܰ� ���̺�(å�� ����)
 CREATE TABLE danga(
      b_id  VARCHAR2(10)  NOT NULL  -- PK , FK  (�ĺ�����)
      ,price  NUMBER(7) NOT NULL    -- å ����
      
      ,CONSTRAINT PK_dangga_id PRIMARY KEY(b_id)
      ,CONSTRAINT FK_dangga_id FOREIGN KEY (b_id)
              REFERENCES book(b_id)
              ON DELETE CASCADE
);

book -b_id(pk), title, c_name
danga - b_id(pk,fk), price

INSERT INTO danga (b_id, price) VALUES ('a-1', 300);
INSERT INTO danga (b_id, price) VALUES ('a-2', 500);
INSERT INTO danga (b_id, price) VALUES ('b-1', 450);
INSERT INTO danga (b_id, price) VALUES ('b-2', 440);
INSERT INTO danga (b_id, price) VALUES ('c-1', 320);
INSERT INTO danga (b_id, price) VALUES ('d-1', 321);
INSERT INTO danga (b_id, price) VALUES ('e-1', 250);
INSERT INTO danga (b_id, price) VALUES ('f-1', 510);
INSERT INTO danga (b_id, price) VALUES ('f-2', 400);

COMMIT;

SELECT*
FROM danga;
--
-- ���� ���̺�
 CREATE TABLE au_book(
       id   number(5)  NOT NULL PRIMARY KEY
      ,b_id VARCHAR2(10)  NOT NULL  CONSTRAINT FK_AUBOOK_BID
            REFERENCES book(b_id) ON DELETE CASCADE
      ,name VARCHAR2(20)  NOT NULL
);

INSERT INTO au_book (id, b_id, name) VALUES (1, 'a-1', '���Ȱ�');
INSERT INTO au_book (id, b_id, name) VALUES (2, 'b-1', '�տ���');
INSERT INTO au_book (id, b_id, name) VALUES (3, 'a-1', '�����');
INSERT INTO au_book (id, b_id, name) VALUES (4, 'b-1', '������');
INSERT INTO au_book (id, b_id, name) VALUES (5, 'c-1', '������');
INSERT INTO au_book (id, b_id, name) VALUES (6, 'd-1', '���ϴ�');
INSERT INTO au_book (id, b_id, name) VALUES (7, 'a-1', '�ɽ���');
INSERT INTO au_book (id, b_id, name) VALUES (8, 'd-1', '��÷');
INSERT INTO au_book (id, b_id, name) VALUES (9, 'e-1', '���ѳ�');
INSERT INTO au_book (id, b_id, name) VALUES (10, 'f-1', '������');
INSERT INTO au_book (id, b_id, name) VALUES (11, 'f-2', '�̿���');

COMMIT;

SELECT * 
FROM au_book;
       
-- �Ǹ� ���ǻ� -> å -> ����          
-- �� ���̺�(����)
CREATE TABLE gogaek(
      g_id       NUMBER(5) NOT NULL PRIMARY KEY 
      ,g_name   VARCHAR2(20) NOT NULL
      ,g_tel      VARCHAR2(20)
);

INSERT INTO gogaek (g_id, g_name, g_tel) VALUES (1, '�츮����', '111-1111');
INSERT INTO gogaek (g_id, g_name, g_tel) VALUES (2, '���ü���', '111-1111');
INSERT INTO gogaek (g_id, g_name, g_tel) VALUES (3, '��������', '333-3333');
INSERT INTO gogaek (g_id, g_name, g_tel) VALUES (4, '���Ｍ��', '444-4444');
INSERT INTO gogaek (g_id, g_name, g_tel) VALUES (5, '��������', '555-5555');
INSERT INTO gogaek (g_id, g_name, g_tel) VALUES (6, '��������', '666-6666');
INSERT INTO gogaek (g_id, g_name, g_tel) VALUES (7, '���ϼ���', '777-7777');

COMMIT;

SELECT *
FROM gogaek;

-- �Ǹ� ���̺�
CREATE TABLE panmai(
       id         NUMBER(5) NOT NULL PRIMARY KEY
      ,g_id       NUMBER(5) NOT NULL CONSTRAINT FK_PANMAI_GID
                     REFERENCES gogaek(g_id) ON DELETE CASCADE
      ,b_id       VARCHAR2(10)  NOT NULL CONSTRAINT FK_PANMAI_BID
                     REFERENCES book(b_id) ON DELETE CASCADE
      ,p_date     DATE DEFAULT SYSDATE
      ,p_su       NUMBER(5)  NOT NULL
);

INSERT INTO panmai (id, g_id, b_id, p_date, p_su) VALUES (1, 1, 'a-1', '2000-10-10', 10);
INSERT INTO panmai (id, g_id, b_id, p_date, p_su) VALUES (2, 2, 'a-1', '2000-03-04', 20);
INSERT INTO panmai (id, g_id, b_id, p_date, p_su) VALUES (3, 1, 'b-1', DEFAULT, 13);
INSERT INTO panmai (id, g_id, b_id, p_date, p_su) VALUES (4, 4, 'c-1', '2000-07-07', 5);
INSERT INTO panmai (id, g_id, b_id, p_date, p_su) VALUES (5, 4, 'd-1', DEFAULT, 31);
INSERT INTO panmai (id, g_id, b_id, p_date, p_su) VALUES (6, 6, 'f-1', DEFAULT, 21);
INSERT INTO panmai (id, g_id, b_id, p_date, p_su) VALUES (7, 7, 'a-1', DEFAULT, 26);
INSERT INTO panmai (id, g_id, b_id, p_date, p_su) VALUES (8, 6, 'a-1', DEFAULT, 17);
INSERT INTO panmai (id, g_id, b_id, p_date, p_su) VALUES (9, 6, 'b-1', DEFAULT, 5);
INSERT INTO panmai (id, g_id, b_id, p_date, p_su) VALUES (10, 7, 'a-2', '2000-10-10', 15);

COMMIT;

SELECT *
FROM panmai;   

-- join ����
-- 1) EQUI JOIN 
-- �� �� �̻��� ���̺� ����Ǵ� �÷����� ������ ��ġ�ϴ� ��쿡 ����ϴ� ���� �Ϲ����� join ����
-- WHERE ���� '='(��ȣ)�� ����Ѵ�.
-- ��.pk = ��.fk
-- ����Ŭ������ natural join�� ����
-- USING���� ����ص� ����...

--[����] å ID�� å���� ���ǻ�(c_name),�ܰ� ���� ���
-- 1)��ü��.�÷���
SELECT book.b_id,book.title,book.c_name,danga.price
FROM book, danga
WHERE book.b_id = danga.b_id;  -- EQUI JOIN 
-- 2) ��Ī.�÷���
SELECT b.b_id,title,c_name,price
FROM book b, danga d
WHERE b.b_id = d.b_id;  -- EQUI JOIN 
-- 3) join-on ����
SELECT b.b_id,title,c_name,price
FROM book b JOIN danga d ON b.b_id = d.b_id;
-- 4) USING �� ��� - ��ü��.�÷��� �Ǵ� ��Ī��.�÷��� X
SELECT b_id,title,c_name,price
FROM book JOIN danga USING(b_id);
-- 5) ����Ŭ : NATURAL JOIN ���
SELECT b_id,title,c_name,price
FROM book NATURAL JOIN danga;

--[����] åid å���� �Ǹż��� �ܰ� ������ �Ǹűݾ� ���
1),
SELECT b.b_id,b.title,p.p_su,d.price,g.g_name,(p.p_su*d.price)�Ǹűݾ�
FROM book b,panmai p, danga d, gogaek g 
WHERE b.b_id = p.b_id AND d.b_id = b.b_id AND p.g_id=g.g_id;
2)join-on
SELECT b.b_id,b.title,p.p_su,d.price,g.g_name,(p.p_su*d.price)�Ǹűݾ�
FROM book b JOIN panmai p ON b.b_id = p.b_id JOIN danga d ON  d.b_id = b.b_id JOIN gogaek g ON p.g_id=g.g_id;
3) USING
SELECT b_id,title,p_su,price,g_name,(p_su*price)�Ǹűݾ�
FROM book JOIN panmai USING(b_id)  JOIN danga USING(b_id) JOIN gogaek USING(g_id);

-- 2) NON-EQUI JOIN 
-- ����Ǵ� �÷��� ��Ȯ�� ��ġ���� �ʴ� ��쿡 ���Ǵ� JOIN�� �����̴�.
-- WHERE ���� BETWEEN ... AND ... �����ڸ� ����Ѵ�.
-- ����Ŭ������ ON ���� �̿��Ͽ� NON-EQUI JOIN�� ������ ������ �����Ѵ�
-- emp + salgrade
--
SELECT deptno,ename,sal,losal ||'~'|| hisal,grade
FROM emp e, salgrade s
WHERE sal BETWEEN losal AND hisal;
--
SELECT deptno,ename,sal,losal ||'~'|| hisal,grade
FROM emp e JOIN salgrade s ON sal BETWEEN losal AND hisal;

-- 3) INNER JOIN == EQUI JOIN 
-- simple join�̶�� �ϸ�, �� �̻��� ���̺��� join ������ �����ϴ� �ุ ��ȯ�Ѵ�.
--emp /dept join
SELECT d.deptno,dname,ename,sal
FROM emp e, dept d
WHERE e.deptno = d.deptno;
-- deptno = null �� KING �� emp�� ���� deptno=40 �� �� ������ ���� == ���ʿ� �� �ִ� �μ��� ����

-- 4) OUTER JOIN
-- JOIN ������ �������� �ʴ� ���� ���� ���� �߰����� join�� �����̴�.
-- �Ϲ����� join���� ���� �� ���� �����͸� ���ϰ� ���� �� ����ϸ�, '(+)' �����ڸ� ����Ѵ�.
-- ����Ŭ������ LEFT(RIGHT) [OUTER] JOIN�� ����
-- ����� �ٳ����� (+)���
SELECT d.deptno,dname,ename,sal
FROM emp e, dept d
WHERE e.deptno = d.deptno(+);
-- LEFT [OUTER] JOIN
SELECT d.deptno,dname,ename,sal
FROM emp e LEFT OUTER JOIN dept d ON e.deptno = d.deptno;
-- �μ��� ������(+)���
SELECT d.deptno,dname,ename,sal
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno;
-- RIGHT JOIN ----OUTER��������
SELECT d.deptno,dname,ename,sal
FROM emp e RIGHT JOIN dept d ON e.deptno = d.deptno;
-- �μ� ��� �� ������ 
SELECT d.deptno,dname,ename,sal
FROM emp e FULL JOIN dept d ON e.deptno = d.deptno;

-- 5) SELF JOIN
-- �ڽ��� ���̺��� alias�� ����Ͽ� ��ġ �� ���� ���̺���ó�� JOIN�ϴ� �����̴�.
-- ����Ŭ������ JOIN �� ON ���� �̿��Ͽ� SELF JOIN�� ������ ������ �����Ѵ�.

-- deptno, empno, ���� ����� �μ���ȣ/ ��� ��ȣ/�����
SELECT e.deptno,e.empno,e.ename,e.mgr,j.deptno,j.empno,j.ename 
FROM emp e, emp j  --self join
WHERE e.mgr = j.empno;

SELECT e.deptno,e.empno,e.ename,e.mgr,j.deptno,j.empno,j.ename 
FROM emp e JOIN emp j ON e.mgr = j.empno; --self join

-- 6) CROSS JOIN : Cartesian Product(������)�� �����ϴ� join
SELECT *
FROM emp CROSS JOIN dept;  -- ��� emp�� �హ�� 14 * dept�� �� ����4 = 56���� ����
FROM emp,dept;

-- 7) ANTIJOIN :  NOT IN  ���������� ��� �ӿ� �ش� �÷��� �������� �ʴ� ���� NOT IN�� �����
-- ���������� NOT IN�� �÷��� ��ȯ��
SELECT employee_id, first_name, last_name,
     manager_id, department_id
FROM employees
WHERE department_id NOT IN (  -- ANTIJOIN
                            SELECT department_id 
                            FROM departments
                            WHERE location_id = 1700
                            );
SELECT *
FROM employees;

SELECT *
FROM LOCATIONS
WHERE location_id = 1700;

-- 8) SEMIJOIN : EXISTS  ���������� ��� �ӿ� �ִ� �÷� 
-- ���������� EXISTS�ϴ� �÷��� ��ȯ��
SELECT * 
FROM departments d
WHERE EXISTS (
                SELECT * FROM employees e
                 WHERE d.department_id = e.department_id
                     AND e.salary > 2500
                );
-- ���α׷��ӽ� 1 �� �̻��ѵ�?
SELECT  F.FLAVOR,SUM(F.TOTAL_ORDER + J.TOTAL_ORDER) FROM FIRST_HALF F, JULY J
WHERE F.FLAVOR = J.FLAVOR AND rownum <=3
GROUP BY F.FLAVOR
ORDER BY SUM(F.TOTAL_ORDER + J.TOTAL_ORDER) DESC;

SELECT b.book_id,a.AUTHOR_NAME,b.PUBLISHED_DATE
FROM book b,AUTHOR a
WHERE b.AUTHOR_ID = a.AUTHOR_ID AND b.book_id IN(2,3)
ORDER BY b.PUBLISHED_DATE;

SELECT ANIMAL_ID,NAME
FROM ANIMAL_OUTS o
WHERE ANIMAL_ID NOT IN(
                        SELECT ANIMAL_ID
                        FROM ANIMAL_INS i
                        WHERE o.ANIMAL_ID = i.ANIMAL_ID
                        )



���� :  
��   : DB�𵨸�
��   : DB�𵨸� ��ǥ
��~��: DB����
��   : ��ǥ