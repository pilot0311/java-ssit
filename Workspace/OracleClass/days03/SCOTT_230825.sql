SELECT
    job,
    COUNT(job)
FROM
    emp
GROUP BY
    job;

SELECT
    deptno,
    ename,
    hiredate,
    sal,
    comm,
    nvl(sal + comm, sal) AS pay
FROM
    emp
WHERE
    comm IS NULL
ORDER BY
    deptno,
    pay DESC;

SELECT
    buseo,
    name,
    ssn,
    city
FROM
    insa
WHERE
    city NOT IN ( '����', '���', '��õ' )
ORDER BY
    buseo,
    city;

SELECT
    deptno,
    ename,
    hiredate
FROM
    emp
WHERE
    deptno IN ( 10, 20 )
ORDER BY
    deptno;

SELECT
    buseo,
    name,
    basicpay + sudang AS pay
FROM
    insa
WHERE
    basicpay + sudang BETWEEN 2000000 AND 2500000
ORDER BY
    buseo,
    pay DESC;

WITH e AS (
    SELECT
        buseo,
        name,
        basicpay + sudang AS pay
    FROM
        insa
    WHERE
        basicpay + sudang BETWEEN 2000000 AND 2500000
)--, d AS
--(
--SELECT deptno, dname
--FROM dept
--)
SELECT
    buseo,
    name,
    pay
FROM
    e
ORDER BY
    buseo,
    pay DESC;
--�ζ��� ��(INLINE VIEW) + with ����
--FROM ������ ���������� ����Ͽ� ������ �ӽ� ���̴�
-- ��: ������ ���� ���̺�
SELECT
    e.buseo,
    e.name,
    e.pay
FROM
    (
        SELECT
            buseo,
            name,
            basicpay + sudang AS pay
        FROM
            insa
    ) e --> �ζ��� �� 
WHERE
    e.pay BETWEEN 2000000 AND 2500000
ORDER BY
    e.buseo,
    e.pay DESC;

-- dual ?  power�÷� 1��, ���ڵ�x
-- ���� ��¥�� ��ȸ
SELECT
    sysdate
FROM
    dual;

SELECT
    EXTRACT(YEAR FROM sysdate),
    EXTRACT(MONTH FROM sysdate),
    EXTRACT(DAY FROM sysdate),
    to_char(sysdate, 'yy')
FROM
    dual;

SELECT
    empno,
    ename,
    hiredate,
    EXTRACT(YEAR FROM hiredate)
FROM
    emp;

-- 2��� ����
--DML : INSERT, UPDATE, DELETE + TCL : COMMIT, ROLLBACK
/*
DELETE 
FROM ���̺��
[WHERE ������]
*/
SELECT
    *
FROM
    emp;

DELETE FROM emp
WHERE
    empno IN ( 7876, 7788 );
--: ���ǹ� ������ emp�� ��� �� ����
COMMIT; -- Ŀ�Խ� �ѹ� �Ұ�
ROLLBACK;

SELECT
    empno,
    ename,
    hiredate
FROM
    emp
WHERE
    to_char(hiredate, 'yy') = '81'
ORDER BY
    hiredate;

SELECT
    empno,
    ename,
    hiredate
FROM
    emp
WHERE
    EXTRACT(YEAR FROM hiredate) = 1981
ORDER BY
    hiredate;

SELECT
    empno,
    ename,
    hiredate
FROM
    emp
WHERE
    substr(hiredate, 1, 2) = '81'
ORDER BY
    hiredate;
-- SUBSTR(���ڿ�, ������ġ, ����)
SELECT
    substr('abcdesfg', 3, 2), --3��° ���ں��� 2����
    substr('abcdefg', 3),   --  3��° ���ں��� ������
    substr('abcdefg', - 3, 2) --  �ڿ��� 3��° ���ں��� 2����
FROM
    dual;

-- ���� insa ���̺��� �̸�, �ֹι�ȣ, �⵵,��,��,����,���� ��ȸ ��ȸ �ֹι�ȣ�� 721237-1*****
--replace(first_name, 'e', '*')
-- date ����� ��Ī���� ���Ұ�
SELECT
    name,
    ssn,
    concat(substr(ssn, 1, 8),
           translate(substr(ssn, 9),
                     '1234567890',
                     '**********')) AS rrn,
    substr(ssn, 1, 2)               AS year,
    substr(ssn, 3, 2)               AS month,
    substr(ssn, 5, 2)               AS "date",
    substr(ssn, 8, 1)               AS gender,
    substr(ssn, - 1, 1)
FROM
    insa;
-- 771212-[1]022432 ����⵵ 1900,1800,2000 + 77 --> 1977

--Ű����(�����) ���̺�
SELECT
    *
FROM
    dictionary
WHERE
    table_name LIKE 'V$WORDS%';

SELECT
    *
FROM
    emp
WHERE
    mgr IS NULL;

SELECT
    *
FROM
    emp
WHERE
    mgr IS NOT NULL;

SELECT
    'AbCdE',
    upper('AbCdE'),
    lower('AbCdE'),
    initcap('AbCdE')
FROM
    dual;
--TO_CHAR(��¥)
--TO_CHAR(����)                   ���ڰ� ���ڿ��� �ٲ�
SELECT
    name,
    basicpay + sudang                          AS pay,
    ibsadate,
    to_char(basicpay + sudang, 'L999,999,999') pay  -- 2810000 -> 2,810,000
FROM
    insa;

SELECT
    empno,
    ename,
    job,
    nvl(CAST(mgr AS VARCHAR(4)),
        'CEO') AS mgr,
    hiredate
FROM
    emp
WHERE
    mgr IS NULL;

SELECT
    empno,
    ename,
    job,
    nvl(to_char(mgr),
        'CEO') AS mgr,
    hiredate
FROM
    emp
WHERE
    mgr IS NULL;
    
    -- ����Ŭ �ڷ���
    -- ����Ŭ ������
        1) ��� ������: + - * /  ������ ���ϴ� ������X �Լ�: mod()
SELECT
    1 + 2  -- 3
    ,1 - 2  -- -1
    ,1 * 2  -- 2
    ,1 / 2 d  -- 0.5
    --,2/0     -- �Ǽ� divisor is equal to zero
    --,3.14/0  -- ���� divisor is equal to zero
    --, 1%2   -- ������%X invalid characte
    ,MOD(1,2)as d   -- 1
FROM
    dual;
    
    --dual? -> PUBLIC SYNONYM    sys.��ü�� == dual
--SCOTT ����ڰ� �����ϰ� �ִ� ���̺� ��ȸ
--dba_xxx, all_xxx, user_xxx ������ 
SELECT *
FROM user_tables; -- ���� ����ڰ� ������ ���̺� ������ ��ȸ
FROM dba_tables;    -- DBA�� ����� �� �ִ� ��� ���̺� ���� ��ȸ
FROM all_tables;    -- ���� ����ڰ� ������ ���̺� + ���� �ο��� ���̺� ������ ��ȸ
FROM user_tables;
    
SELECT SYSDATE, CURRENT_DATE
FROM dual;
    

--sys �ó�� �������� �Ѿ��
--3) ������ �ó�Կ� ���� ��ü �����ڷ� �����Ѵ�. - scott
--4) �ó�Կ� ������ �ο��Ѵ�.

GRANT SELECT ON emp TO HR;

SELECT *
FROM arirnag;

2) ?? ���� ���ڿ�
DROP TABLE ���̺�� CASCADE;    DDL ���� �ڵ����� �� ����, PL/SQL ���� ����

SELECT 'DROP TABLE ' || table_name || ' CASCADE'  -- ��� ���̺� ���� ���� ����
FROM user_tables;
/*
DROP TABLE DEPT CASCADE
DROP TABLE EMP CASCADE
DROP TABLE BONUS CASCADE
DROP TABLE SALGRADE CASCADE
DROP TABLE INSA CASCADE
*/

--3) ����� ���� ������
-- CREATE OPERATOR

--4) ������ ���� ������  PRIOR, CONNECT_BY_ROOT�� ������ ���� �������� 

5) �� ������ = != <> ^= > < >= <=
    SQL ������
    ANY, SOME
    ALL
-- 10, 20, 30 ,40
SELECT deptno
FROM dept;

SELECT *
FROM emp
WHERE deptno > SOME (SELECT deptno FROM dept);
WHERE deptno <= ANY (SELECT deptno FROM dept);  -- �ϳ��� ���̸� ��
WHERE deptno <= ALL (SELECT deptno FROM dept);  -- ��� ���̿��� ��
WHERE deptno �� ������ ALL (��������);
WHERE deptno <= 10;

6) �� ������: AND OR NOT

7) SQL ������
    (1) [NOT] IN(list)
    (2) [NOT] BETWEEN A and B
    (3) IS [NOT] NULL
    (4) ANY, SOME, ALL : WHERE���� ��������
    (5) EXISTS: ��� �������� 
    (6) ���� ���� �˻� �� 
        ��.[NOT] LIKE ������
        - ���� ���� �˻��� �� ���Ǵ� SQL ������
        - ���ϵ� ī��: %, _
        - % : ����ǥ���� �� * �� ���� ������ ���ڰ� 0�� �̻��
        - _ : ������ ���� 1����
        - ���ϵ� ī�带 �Ϲ� ���� ó�� ����ϰ� ���� �� ESCAPE�ɼ� ���
        ��.REGEXP_LIKE �Լ�
            REGEXP_xxx : ����ǥ���� ����ϴ� �Լ�
        ��) emp ������̺� R ���ڷ� �����ϴ� ����� �˻�
            insa���̺� ������� '��'���� ����� �˻�
             insa���̺� ������� '��'�� �� ��� ����� �˻�
             insa���̺� ������� ��������'��'�� �� ��� ����� �˻�
            ;
            SELECT *
            FROM insa
            WHERE name LIKE '%��'; -- '��'�� ������
            WHERE name LIKE '%��%'; -- ��� �ֵ� '��' �� ������ TRUE
            WHERE name LIKE '��%';   --%: ����ǥ���� * 
            WHERE name LIKE '���� ���ϵ�ī�� [% _]'; --LIKE������ ���
            WHERE SUBSTR(name, 1, 1) = '��';
            
            ��)insa ���̺� 81��� ��� ���� ��ȸ
            SELECT *
            FROM insa
            WHERE ssn LIKE '81%';
            
            ����) insa ���̺��� ���� ����� ��ȸ
            SELECT *
            FROM insa
            where ssn LIKE '%-1%';
            
            ����) �̸��� �� ���� ���ڰ� '��'
            SELECT *
            FROM insa
            where name LIKE '_��%';
            
            --�μ� ���� ���̺�
            -- deptno(�μ� ��ȣ), dname(�μ��̸�), loc(������)
            10	ACCOUNTING	NEW YORK
            20	RESEARCH	DALLAS
            30	SALES	CHICAGO
            40	OPERATIONS	BOSTON
            
            SELECT *
            FROM dept;
            
            -- ���ο� �μ� �߰�
            -- DML - DELETE, UPDATE, INSERT + COMMIT, ROLLBACK
            INSERT INTO ���̺�� (Į����,Į����...) VALUES (��, ��,...);
            
            INSERT INTO dept (deptno, dname, loc) VALUES (50, '�ѱ�_����', 'SEOUL');
            --unique constraint (SCOTT.PK_DEPT) violated ���ϼ� �������� ����: PRIMARY KEY: �ߺ� X
            INSERT INTO dept (deptno, dname, loc) VALUES (60, '��100%��', 'SEOUL');
            COMMIT;
            
            DESC dept;

            --�˻� �μ��� '_��' �˻�
            SELECT * 
            FROM dept; 
            WHERE dname LIKE '%\_��%' ESCAPE '\'; --ESCAPE \
            
            ����: �μ��� % �˻�
            SELECT * 
            FROM dept 
            WHERE dname LIKE '%\%%' ESCAPE '\'; --ESCAPE \
            
            -- ���� DML - UPDATE
            UPDATE ���̺��
            SET �÷���= �����Ұ�[, �÷���= �����Ұ�,...]
            [WHERE ����]; (where�� ������ �� ���̺��� ��� �÷��� �����)
            ;
            UPDATE dept 
            SET LOC = 'KOREA'
            WHERE loc = 'SEOUL';
            COMMIT;
            
            DELETE FROM dept
            WHERE loc = 'KOREA';
            COMMIT;
            
            

SELECT * FROM user_tables;
-- ����Ŭ �Լ�