--SCOTT--

SELECT
    *
FROM
    tabs;

-- SQL ������� ����
--optimizer

--DQL��: SELECT

-- ��� ����� ���� ��ȸ
SELECT
    *
FROM
    all_users;
--HR ����(���ð���)
--����: ���� -�׽�Ʈ ����: ORA-28000: the account is locked

--HR ���� ���� Ȯ��
//table or view does not exist
SELECT
    *
FROM
    dba_users;
---- dba_xxx = �����ڸ� ��밡��

-- DQL: SELECT
-- 1) �����͸� �������� �� ����ϴ� sql��
-- 2) ���: �ϳ� �̻��� ���̺�, ��
-- 3) ����ڰ� ������ ���̺�, ��
--  SELECT ����
SELECT
    *
FROM
    emp;


/*�����ġ�
    [subquery_factoring_clause] subquery [for_update_clause];

��subquery ���ġ�
   {query_block ?
    subquery {UNION [ALL] ? INTERSECT ? MINUS }... ? (subquery)} 
   [order_by_clause] 

��query_block ���ġ�
   SELECT [hint] [DISTINCT ? UNIQUE ? ALL] select_list
   FROM {table_reference ? join_clause ? (join_clause)},...
     [where_clause] 
     [hierarchical_query_clause] 
     [group_by_clause]
     [HAVING condition]
     [model_clause]

��subquery factoring_clause���ġ�
   WITH {query AS (subquery),...}
*/
--[SELECT �� �ۼ�����, ó������ ����]
[WITH ��] 1
SELECT �� 6
FROM �� 2
[WHERE ��] 3
-- ���� �� hierarchical_query_clause
[GROUP BY ��] 4
[HAVING �� 5]
[ORDER BY] �� 7

-- scott ����ڰ� ������ ���̺� ���� ��ȸ

SELECT * --��ȸ �� ���, ��� Į�� ��� 
FROM user_tables; --��(vies) ������ ����

INSERT INTO EMP VALUES
(7876,'ADAMS','CLERK',7788,to_date('13-7-87', 'dd-MM-yy')-51,1100,NULL,20);  

INSERT INTO EMP VALUES
(7788,'SCOTT','ANALYST',7566,to_date('13-7-87', 'dd-MM-yy')-85,3000,NULL,20);
commit;
--emp(���) ���̺��� ��� ����(�����ȣ, �����, �Ի�����)�� ��ȸ
SELECT empno, ename, hiredate
FROM emp;
FROM scott.emp;

-- emp ���̺��� ���� Ȯ��
DESCRIBE emp;
DESC emp;

--dept ���̺��� ����Ȯ��
DESC dept;
-- dept ���̺��� ��� Į�� ��ȸ
SELECT * FROM dept;

-- emp ���̺��� job�� ��ȭ
SELECT job FROM emp;
-- �� ������� job ������ ��ȸ
CLERK
SALESMAN
SALESMAN
MANAGER
SALESMAN
MANAGER
MANAGER
PRESIDENT
SALESMAN
CLERK
ANALYST
CLERK
CLERK
ANALYST
-- ������� job�� ������ ��ȸ DISTINCT: �ߺ�����
SELECT DISTINCT job FROM emp;
CLERK
SALESMAN
PRESIDENT
MANAGER
ANALYST
-- emp���̺��� job ������ ���� �ľ� : 5����
SELECT count(DISTINCT job) FROM emp ;

SELECT DISTINCT job, ename FROM emp; -// ����

-- emp ���̺����� ������� �����, �Ի����� ��ȸ
SELECT ename, hiredate FROM
emp;
--80(RR)/12(MM)/17(DD) �����

-- [����]emp ���̺����� ����� �μ� ��ȣ, �����, �޿�(sal + comm) ��ȸ
-- null Ŀ�̼� ��Ȯ��(null)�� 0����ó�� 4��: nvl, nvl2, nullif, coalesce
SELECT
    deptno,
    ename,
    nvl2(comm, sal + comm, sal) AS total
FROM
    emp;

SELECT
    deptno,
    ename,
    nvl(sal + comm, sal) AS "PAY"
FROM
    emp;

SELECT
    deptno,
    ename,
    nvl(sal + comm, sal) "PAY"
FROM
    emp;

SELECT
    deptno,
    ename,
    nvl(sal + comm, sal)      pay,
    nvl(sal + comm, sal) * 12 AS year
FROM
    emp;
-- ����Ŭ null�ǹ� 0�̶�� �ǹ̰� �ƴ� ���� �װ��� �𸥴ٴ� �ǹ� == ��Ȯ�� ���̳� ���� ������� ���� ���� �ǹ�
-- �� null ���� -> null

-- emp ���̺����� ��� ��������� ��ȸ

SELECT
    *
FROM
    emp;

-- emp ���̺����� deptno�� 30�� �μ��� ��� deptno, ename, job, hiredate, pay
-- ����Ŭ �� ������: = ? != ? ^= ? <> ? >  ? <  ? <= ? >=
SELECT
    deptno,
    ename,
    job,
    hiredate,
    nvl(sal + comm, sal) AS pay
FROM
    emp
WHERE
    deptno = 30;
    
    SELECT
    emp.deptno,
    emp.ename,
    emp.job,
    emp.hiredate,
    nvl(emp.sal + emp.comm, sal) AS pay
FROM
    emp
WHERE
    deptno = 30;
    
-- �μ� ���� ��ȸ
SELECT
    *
FROM
    dept;
    
10	ACCOUNTING	NEW YORK
20	RESEARCH	DALLAS
30	SALES	CHICAGO
40	OPERATIONS	BOSTON

-- ���� emp ���̺����� 20 �� 30 �μ����� ���� ��ȸ
-- ����Ŭ ���� ������ and or not
SELECT
    *
FROM
    emp
    where deptno in(20, 30);
    where deptno BETWEEN 20 AND 30;
    where deptno >=20 and deptno <= 30;
WHERE
    deptno = 30
    OR deptno = 20;  -- 0.032��
    and job = 'CLERK';  --�˻��� �ش��ϴ� ���ڿ��� ��ҹ��� ������

/* �ɽ��ؼ� �����Ѱ�
SELECT
    *
FROM
    emp,
    dept
WHERE
    emp.deptno IN ( 20, 30 )
    AND emp.deptno = dept.deptno;

SELECT
    *
FROM
    emp,
    dept
WHERE
    ( emp.deptno = 20
      OR emp.deptno = 30 )
    AND emp.deptno = dept.deptno;
    */
    
    --scott ���� + insa.sqp ��� ���̺�����, insert�� 
    
    CREATE TABLE insa(
        num NUMBER(5) NOT NULL CONSTRAINT insa_pk PRIMARY KEY   --�����ȣ
       ,name VARCHAR2(20) NOT NULL  -- �����
       ,ssn  VARCHAR2(14) NOT NULL  -- �ֹε�Ϲ�ȣ
       ,ibsaDate DATE     NOT NULL  -- �Ի�����
       ,city  VARCHAR2(10)  -- �������
       ,tel   VARCHAR2(15)  -- ����ó
       ,buseo VARCHAR2(15) NOT NULL -- �μ�
       ,jikwi VARCHAR2(15) NOT NULL -- ����
       ,basicPay NUMBER(10) NOT NULL    -- �⺻��
       ,sudang NUMBER(10) NOT NULL  -- ����
);

INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1001, 'ȫ�浿', '771212-1022432', '1998-10-11', '����', '011-2356-4528', '��ȹ��', 
   '����', 2610000, 200000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1002, '�̼���', '801007-1544236', '2000-11-29', '���', '010-4758-6532', '�ѹ���', 
   '���', 1320000, 200000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1003, '�̼���', '770922-2312547', '1999-02-25', '��õ', '010-4231-1236', '���ߺ�', 
   '����', 2550000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1004, '������', '790304-1788896', '2000-10-01', '����', '019-5236-4221', '������', 
   '�븮', 1954200, 170000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1005, '�Ѽ���', '811112-1566789', '2004-08-13', '����', '018-5211-3542', '�ѹ���', 
   '���', 1420000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1006, '�̱���', '780505-2978541', '2002-02-11', '��õ', '010-3214-5357', '���ߺ�', 
   '����', 2265000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1007, '����ö', '780506-1625148', '1998-03-16', '����', '011-2345-2525', '���ߺ�', 
   '�븮', 1250000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1008, '�迵��', '821011-2362514', '2002-04-30', '����', '016-2222-4444', 'ȫ����',    
'���', 950000 , 145000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1009, '������', '810810-1552147', '2003-10-10', '���', '019-1111-2222', '�λ��', 
   '���', 840000 , 220400);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1010, '������', '751010-1122233', '1997-08-08', '�λ�', '011-3214-5555', '������', 
   '����', 2540000, 130000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1011, '������', '801010-2987897', '2000-07-07', '����', '010-8888-4422', '������', 
   '���', 1020000, 140000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1012, '���ѱ�', '760909-1333333', '1999-10-16', '����', '018-2222-4242', 'ȫ����', 
   '���', 880000 , 114000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1013, '���̼�', '790102-2777777', '1998-06-07', '���', '019-6666-4444', 'ȫ����', 
   '�븮', 1601000, 103000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1014, 'Ȳ����', '810707-2574812', '2002-02-15', '��õ', '010-3214-5467', '���ߺ�', 
   '���', 1100000, 130000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1015, '������', '800606-2954687', '1999-07-26', '���', '016-2548-3365', '�ѹ���', 
   '���', 1050000, 104000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1016, '�̻���', '781010-1666678', '2001-11-29', '���', '010-4526-1234', '���ߺ�', 
   '����', 2350000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1017, '�����', '820507-1452365', '2000-08-28', '��õ', '010-3254-2542', '���ߺ�', 
   '���', 950000 , 210000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1018, '�̼���', '801028-1849534', '2004-08-08', '����', '018-1333-3333', '���ߺ�', 
   '���', 880000 , 123000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1019, '�ڹ���', '780710-1985632', '1999-12-10', '����', '017-4747-4848', '�λ��', 
   '����', 2300000, 165000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1020, '������', '800304-2741258', '2003-10-10', '����', '011-9595-8585', '�����', 
   '���', 880000 , 140000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1021, 'ȫ�泲', '801010-1111111', '2001-09-07', '���', '011-9999-7575', '���ߺ�', 
   '���', 875000 , 120000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1022, '�̿���', '800501-2312456', '2003-02-25', '����', '017-5214-5282', '��ȹ��', 
   '�븮', 1960000, 180000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1023, '���μ�', '731211-1214576', '1995-02-23', '����', NULL           , '������', 
   '����', 2500000, 170000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1024, '�踻��', '830225-2633334', '1999-08-28', '����', '011-5248-7789', '��ȹ��', 
   '�븮', 1900000, 170000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1025, '�����', '801103-1654442', '2000-10-01', '����', '010-4563-2587', '������', 
   '���', 1100000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1026, '�����', '810907-2015457', '2002-08-28', '���', '010-2112-5225', '������', 
   '���', 1050000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1027, '�迵��', '801216-1898752', '2000-10-18', '����', '019-8523-1478', '�ѹ���', 
   '����', 2340000, 170000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1028, '�̳���', '810101-1010101', '2001-09-07', '����', '016-1818-4848', '�λ��', 
   '���', 892000 , 110000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1029, '�踻��', '800301-2020202', '2000-09-08', '����', '016-3535-3636', '�ѹ���', 
   '���', 920000 , 124000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1030, '������', '790210-2101010', '1999-10-17', '�λ�', '019-6564-6752', '�ѹ���', 
   '����', 2304000, 124000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1031, '����ȯ', '771115-1687988', '2001-01-21', '����', '019-5552-7511', '��ȹ��', 
   '����', 2450000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1032, '�ɽ���', '810206-2222222', '2000-05-05', '����', '016-8888-7474', '�����', 
   '���', 880000 , 108000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1033, '��̳�', '780505-2999999', '1998-06-07', '����', '011-2444-4444', '������', 
   '���', 1020000, 104000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1034, '������', '820505-1325468', '2005-09-26', '���', '011-3697-7412', '��ȹ��', 
   '���', 1100000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1035, '������', '831010-2153252', '2002-05-16', '��õ', NULL           , '���ߺ�', 
   '���', 1050000, 140000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1036, '���翵', '701126-2852147', '2003-08-10', '����', '011-9999-9999', '�����', 
   '���', 960400 , 190000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1037, '�ּ���', '770129-1456987', '1998-10-15', '��õ', '011-7777-7777', 'ȫ����', 
   '����', 2350000, 187000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1038, '���μ�', '791009-2321456', '1999-11-15', '�λ�', '010-6542-7412', '������', 
   '�븮', 2000000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1039, '������', '800504-2000032', '2003-12-28', '���', '010-2587-7895', '������', 
   '�븮', 2010000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1040, '�ڼ���', '790509-1635214', '2000-09-10', '���', '016-4444-7777', '�λ��', 
   '�븮', 2100000, 130000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1041, '�����', '721217-1951357', '2001-12-10', '�泲', '016-4444-5555', '�����', 
   '����', 2300000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1042, 'ä����', '810709-2000054', '2003-10-17', '���', '011-5125-5511', '���ߺ�', 
   '���', 1020000, 200000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1043, '��̿�', '830504-2471523', '2003-09-24', '����', '016-8548-6547', '������', 
   '���', 1100000, 210000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1044, '����ȯ', '820305-1475286', '2004-01-21', '����', '011-5555-7548', '������', 
   '���', 1060000, 220000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1045, 'ȫ����', '690906-1985214', '2003-03-16', '����', '011-7777-7777', '������', 
   '���', 960000 , 152000);			
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1046, '����', '760105-1458752', '1999-05-04', '�泲', '017-3333-3333', '�ѹ���', 
   '����', 2650000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1047, '�긶��', '780505-1234567', '2001-07-15', '����', '018-0505-0505', '������', 
   '�븮', 2100000, 112000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1048, '�̱��', '790604-1415141', '2001-06-07', '����', NULL           , '���ߺ�', 
   '�븮', 2050000, 106000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1049, '�̹̼�', '830908-2456548', '2000-04-07', '��õ', '010-6654-8854', '���ߺ�', 
   '���', 1300000, 130000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1050, '�̹���', '810403-2828287', '2003-06-07', '���', '011-8585-5252', 'ȫ����', 
   '�븮', 1950000, 103000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1051, '�ǿ���', '790303-2155554', '2000-06-04', '����', '011-5555-7548', '������', 
   '����', 2260000, 104000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1052, '�ǿ���', '820406-2000456', '2000-10-10', '���', '010-3644-5577', '��ȹ��', 
   '���', 1020000, 105000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1053, '��̽�', '800715-1313131', '1999-12-12', '����', '011-7585-7474', '�����', 
   '���', 960000 , 108000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1054, '����ȣ', '810705-1212141', '1999-10-16', '����', '016-1919-4242', 'ȫ����', 
   '���', 980000 , 114000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1055, '���ѳ�', '820506-2425153', '2004-06-07', '����', '016-2424-4242', '������', 
   '���', 1000000, 104000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1056, '������', '800605-1456987', '2004-08-13', '��õ', '010-7549-8654', '������', 
   '�븮', 1950000, 200000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1057, '�̹̰�', '780406-2003214', '1998-02-11', '���', '016-6542-7546', '�����', 
   '����', 2520000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1058, '�����', '800709-1321456', '2003-08-08', '��õ', '010-2415-5444', '��ȹ��', 
   '�븮', 1950000, 180000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1059, '�Ӽ���', '810809-2121244', '2001-10-10', '����', '011-4151-4154', '���ߺ�', 
   '���', 890000 , 102000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1060, '��ž�', '810809-2111111', '2001-10-10', '����', '011-4151-4444', '���ߺ�', 
   '���', 900000 , 102000);

COMMIT;

SELECT * FROM insa;
--[1]
SELECT name, city, buseo, jikwi FROM insa where city = '����';
-- �̸� �������� ����
SELECT name, city, buseo, jikwi FROM insa where city = '����' ORDER BY name;
-- �μ��� �������� ���� -> �̸��� ��������
SELECT name, city, buseo, jikwi FROM insa where city = '����' ORDER BY buseo,name DESC;
SELECT name, city, buseo, jikwi FROM insa where city = '����' ORDER BY 3,1 desc;
--[2]
SELECT name, city, basicpay, ssn FROM insa where city = '����' and BASICPAY >= 1500000 ORDER BY basicpay;
--[3]
SELECT name, city, buseo FROM insa where city = '����' or buseo = '���ߺ�';
--[4]
SELECT name, city, buseo FROM insa where city in('����', '���');
--[5] �޿� ���� �޴� ��� �� ��������
SELECT name, city, buseo, basicpay + SUDANG as �޿� 
FROM insa 
where (basicpay + SUDANG) >= 2500000
ORDER BY �޿� DESC;
-- SELECT���� ó�� ���������� where���� ��Ī���� ���� ����, order���� ��� ����

-- ���� ��簡 ����(mgr) ����� ���� ��ȸ
-- mgr�� null�� ��� ��ȸ
-- ���� where mgr = null : ���� 'null' ã��
SELECT * FROM emp where mgr IS NULL;
-- empno, ename, job, mgr, hiredate   mgr = null-> BOSS
SELECT empno, ename, job, nvl(cast(mgr as varchar(4)) , 'BOSS') as MGR, hiredate FROM emp where mgr is null;