--[1]
SELECT TO_CHAR(SYSDATE,'YYYY"��"MM"��"DD"��" AM HH24:MI:SS (DY)')
FROM dual;

--[2]
SELECT TO_DATE('2023.12.27')-TRUNC(SYSDATE),
       ABS(TRUNC(SYSDATE)-TO_DATE('2023.12.27'))
FROM dual;
--[3]
SELECT empno, TO_CHAR(empno,'099999'),
        LPAD(empno,6,0)
FROM emp;
--[4]
WITH temp AS (
SELECT deptno,empno, ename, sal+NVL(comm,0)pay 
FROM emp e
)
SELECT t.*,DECODE(t.deptno,10,pay*1.15,20,pay*1.3,pay*1.05)�λ�ȱ޿�
FROM temp t;
--[4-2]
WITH temp AS (
SELECT deptno,empno, ename, sal+NVL(comm,0)pay 
FROM emp e
)
SELECT t.*,CASE deptno
                WHEN 10 THEN pay*1.15
                WHEN 20 THEN pay*1.3
                ELSE pay*1.05
            END �λ��_�޿�
FROM temp t;

--[5]
SELECT d.deptno, COUNT(e.deptno)
FROM dept d LEFT JOIN emp e ON e.deptno = d.deptno
GROUP BY d.deptno
HAVING COUNT(e.deptno)<=3;

SELECT d.deptno, COUNT(e.deptno)
FROM dept d , emp e
WHERE d.deptno = e.deptno(+)
GROUP BY d.deptno
HAVING COUNT(e.deptno)<=3;

--[5-2]
SELECT COUNT(DECODE(deptno,10,1)),
        COUNT(DECODE(deptno,20,2)),
        COUNT(DECODE(deptno,30,3)),
        COUNT(DECODE(deptno,40,4))
FROM emp;
--[7]
SELECT deptno, job, SUM(NVL(sal+comm,sal))sum_pay 
FROM emp
GROUP BY deptno,job
ORDER BY deptno;
--[8]
SELECT deptno, SUM(NVL(sal+comm,sal))sum_pay 
FROM emp
GROUP BY deptno
ORDER BY deptno;
--[8-2]
WITH temp AS (
SELECT deptno, sal+NVL(comm,0)pay 
FROM emp e
)
SELECT SUM(DECODE(t.deptno,10,pay)),
        SUM(DECODE(t.deptno,20,pay)),
        SUM(DECODE(t.deptno,30,pay))
FROM temp t;

--[9]
SELECT D.DEPTNO, J.JOB, COALESCE(SUM(E.SAL), 0) AS TOTAL_SALARY
FROM (SELECT  DISTINCT DEPTNO FROM EMP) D
CROSS JOIN (SELECT DISTINCT JOB FROM EMP) J
LEFT JOIN EMP E ON D.DEPTNO = E.DEPTNO AND J.JOB = E.JOB
GROUP BY D.DEPTNO, J.JOB
ORDER BY D.DEPTNO, J.JOB;
--[9-t] ORACLE 10g [patition BY outer join] ����
WITH j AS(
SELECT DISTINCT job
FROM emp
)
SELECT deptno,j.job, NVL(SUM(NVL(sal+comm,sal)),0)sum_pay
FROM j LEFT OUTER JOIN emp e PARTITION BY (e.deptno) ON j.job = e.job
GROUP BY deptno,j.job
ORDER BY deptno;


--[10]
SELECT empno, dname, ename, hiredate
FROM emp e JOIN dept d ON e.deptno=d.deptno;

--[11]
 SELECT buseo,COUNT(*)gender
 FROM insa
 WHERE MOD(SUBSTR(ssn,8,1),2)=0
 GROUP BY buseo, MOD(SUBSTR(ssn,8,1),2)
 HAVING COUNT(*)>=5
 ORDER BY buseo;
 
 -----------------------------------------------------
 SELECT *
 FROM emp;
 
 SELECT *
 FROM salgrade;
 
 SELECT deptno,ename,sal,
        CASE
            WHEN sal>= 700 AND sal<=1200 THEN 1
            WHEN sal BETWEEN 1201 AND 1400 THEN 2
            WHEN sal BETWEEN 1401 AND 2000 THEN 3
            WHEN sal BETWEEN 2001 AND 3000 THEN 4
            WHEN sal BETWEEN 3001 AND 9999 THEN 5
        END grade
 FROM emp;
 -- join
 -- NON-EQUI JOIN : JOIN �� ON BETWEEN a AND b
 -- ����Ǵ� �÷��� ��Ȯ�� ��ġ���� �ʴ� ��쿡 ���Ǵ� JOIN�� �����̴�.
 -- WHERE ���� BETWEEN ... AND ... �����ڸ� ����Ѵ�.
 -- ����Ŭ������ ON ���� �̿��Ͽ� NON-EQUI JOIN�� ������ ������ �����Ѵ�.

-- NON-EQUI JOIN
 SELECT deptno, ename, sal, 
        losal||'~'||hisal
        ,grade
 FROM emp e JOIN salgrade s ON e.sal BETWEEN s.losal AND s.hisal;
 
 SELECT deptno, ename
 FROM emp
 ORDER BY deptno;
 
 --LISTAGG()
 SELECT d.deptno,
        LISTAGG(NVL(ename,'�������'),'/') WITHIN GROUP(ORDER BY sal)AS enmae
 FROM emp e RIGHT JOIN dept d ON e.deptno = d.deptno
 GROUP BY d.deptno;
 
 -- GROUPING SETS ��
 -- ��) GROUP BY exp1
 --     UNION ALL
 -- ��) GROUP BY exp2
 --> GROUPING SETS(exp1,exp2)
 
 SELECT deptno, COUNT(*)
 FROM emp
 GROUP BY deptno;
 --UNION ALL
 SELECT job, COUNT(*)
 FROM emp
 GROUP BY job;
 
 --GROUPING SETS ��
 SELECT deptno, job,COUNT(*)
 FROM emp
 GROUP BY GROUPING SETS(deptno, job);
 
 -- emp���̺��� �޿��� ���� ���� �޴� ��� ���� ��ȸ
 SELECT deptno,empno,ename,sal+NVL(comm,0)pay
 FROM emp
 WHERE sal+NVL(comm,0) = (SELECT MAX(sal+NVL(comm,0)) FROM emp);
 WHERE sal+NVL(comm,0) >= ALL(SELECT sal+NVL(comm,0) FROM emp);
 
 
 --RANK ���� �Լ�
 -- TOP-N �м� : top-N �м��� �ִ밪�̳� �ּҰ��� ���� �÷��� ������ �� �����ϰ� ���Ǵ� �м�����̴�.
 -- inline view���� ORDER BY ���� ����� �� �����Ƿ� �����͸� ���ϴ� ������ ���ĵ� �����ϴ�.
 -- ROWNUM �÷��� subquery���� ��ȯ�Ǵ� �� �࿡ �������� ��ȣ�� �ο��ϴ� pseudo(�ǻ�, ��¥) �÷��̴�.
 -- n���� < �Ǵ� >=�� ����Ͽ� �����ϸ�, ��ȯ�� ���� ������ �����Ѵ�.
 -- 1) ORDER BY ���ĵ� �ζ��κ�
 -- 2) ROWNUM �ǻ�Į��: �ึ�� ������� ��ȣ�� �ο��ϴ� Į��
 -- 3) WHERE ������ <, <=  

 SELECT rowid,rownum,ename
 FROM emp;
 -- emp���̺��� �޿��� ���� ���� �޴� ��� ���� ��ȸ
 --TOP-5
 SELECT ROWNUM, e.*
 FROM (
        SELECT deptno,ename,hiredate, sal+NVL(comm,0)pay
        FROM emp
        ORDER BY pay DESC
 ) e
 WHERE ROWNUM >= 1;
  --WHERE ROWNUM BETWEEN 3 AND 5;  xx ���� : ������ ù���� ���� ����ϱ⿡ �߰� ���� �����ü����� 
  
 --RANK()
 -- �� �Լ��� �׷� ������ ��ġ�� ����Ͽ� ��ȯ�Ѵ�.
 -- �ش� ���� ���� �켱������ ����(�ߺ� ���� �����)
 -- ��ȯ�Ǵ� ������Ÿ���� NUMBER�̴�.
 -- ����
 --1) RANK()
 --2) DENSE_RANK
 --3) PERCENT_RANK
 --4) FIRST, LAST
 --5) ROW_NUMBER :  ROW_NUMBER () OVER ([query_partition_clause] order_by_clause )                
 --     ��   �� �Լ��� �м�(analytic) �Լ��μ�, ���Һ��� ���ĵ� ����� ���� ������ �ο��ϴ� ����̴�.
 --         ������ ��ü ���� Ư�� �÷��� �������� �и��ϴ� ������� GROUP BY ������ �׷�ȭ�ϴ� ����� ���� �����̴�.
 --HR ����
 SELECT ROW_NUMBER() OVER (ORDER BY salary DESC),first_name,salary
 FROM  employees;
-- SCOTT���� 
SELECT e.*
FROM(
SELECT deptno, ename, sal+NVL(comm,0)pay,
        ROW_NUMBER() OVER(ORDER BY sal+NVL(comm,0) DESC)rank
FROM emp
) e
WHERE rank BETWEEN 3 AND 5;
WHERE rank <=3;
WHERE rank =1;

-- emp ���̺��� �� �μ��� �ְ� �޿� �޴� ����� ������ ��ȸ

SELECT e.*, d.dname
FROM(
SELECT deptno, ename, sal+NVL(comm,0)pay,
        ROW_NUMBER() OVER(PARTITION BY deptno ORDER BY sal+NVL(comm,0) DESC)rank
FROM emp

) e JOIN dept d ON e.deptno = d.deptno
WHERE rank = 1;
--
SELECT t.*
FROM (
SELECT d.deptno,dname,ename,sal+NVL(comm,0)pay,hiredate,grade,
        ROW_NUMBER() OVER(PARTITION BY d.deptno ORDER BY sal+NVL(comm,0) DESC)rank
FROM dept d JOIN emp e ON d.deptno = e.deptno JOIN salgrade s ON e.sal BETWEEN s.losal AND s.hisal
)t
WHERE rank = 1;
--
-- RANK(), DENSE_RANK() �ߺ����� ���O/�ߺ����� ���X
-- RANK() OVER( [query_partition_clause] order_by_clause)
--�׷� ������ ���ʷ� �� ���� rank�� ����Ͽ� NUMBER ������Ÿ������ ������ ��ȯ�Ѵ�.
--�ش� ���� ���� �켱������ ����

SELECT empno,ename,sal,
        ROW_NUMBER()OVER(ORDER BY sal DESC)rn_rank,
        RANK()OVER(ORDER BY sal DESC)r_rank,
        DENSE_RANK()OVER(ORDER BY sal DESC)dr_rank
FROM emp;

SELECT empno,ename,sal,
        ROW_NUMBER()OVER(PARTITION BY deptno ORDER BY sal DESC)rn_rank,
        RANK()OVER(PARTITION BY deptno ORDER BY sal DESC)r_rank,
        DENSE_RANK()OVER(PARTITION BY deptno ORDER BY sal DESC)dr_rank
FROM emp;

-- [���� ����] emp ���̺��� �� ��� �޿��� �μ� ����, ��� ��ü�� ����
SELECT e.deptno,ename,NVL(sal+comm,sal)pay,
        RANK()OVER(PARTITION BY e.deptno ORDER BY NVL(sal+comm,sal) DESC)r_rank,
        RANK()OVER( ORDER BY NVL(sal+comm,sal) DESC)all_rank
FROM emp e
ORDER BY deptno;

-- insa ����� ���
-- ���� ����� : 31
-- ���� ����� : 29
-- ��ü ����� : 60

SELECT  DECODE(MOD(SUBSTR(ssn,-7,1),2),1,'����','����')||'�����' gender,
        COUNT(*)
FROM insa
GROUP BY MOD(SUBSTR(ssn,-7,1),2);

--ROLLUP, CUBE �Լ� : ROLLUP�� GROUP BY ���� �׷� ���ǿ� ���� ��ü ���� �׷�ȭ �ϰ�, �� �׷쿡 ���� �κ����� ���ϴ� �������̴�.
-- GROUP BY [ROLLUP ? CUBE]�׷����ϰ����ϴ� �÷���,...
-- GROUPING SETS �� GROUP BY ���� ���
SELECT DECODE(MOD(SUBSTR(ssn,-7,1),2),1,'����',0,'����','��ü')||'�����' gender,
        COUNT(*)
FROM insa
GROUP BY CUBE(MOD(SUBSTR(ssn,-7,1),2));
GROUP BY ROLLUP(MOD(SUBSTR(ssn,-7,1),2));

SELECT buseo,jikwi, sum(basicpay)sum_pay
FROM insa
GROUP BY CUBE(buseo, jikwi)
--GROUP BY buseo, ROLLUP(jikwi)
--GROUP BY ROLLUP(buseo, jikwi)
ORDER BY buseo;

--���� emp ���̺��� ���廡�� �Ի��� ����� ���� �ʰ� �Ի��� ����� ���� �ϼ�
WITH h AS(
SELECT ename,hiredate,
    RANK()OVER(ORDER BY hiredate)rank
FROM emp
)
SELECT MAX(hiredate)-MIN(hiredate)
FROM h
WHERE rank = 1 OR rank = (SELECT COUNT(*) FROM emp);

--���� : insa���̺��� �� ������� �����̸� ��� �ؼ� �̸� ssn ������ ���
-- 1) ssn �ֹε�� ��ȣ
-- 2) ���س⵵ - ���� ���� �������� -1
WITH birth AS(
SELECT name,ssn, CASE 
                    WHEN REGEXP_LIKE(SUBSTR(ssn,-7,1),'^[1256]') THEN '19'||SUBSTR(ssn,1,6)
                    WHEN REGEXP_LIKE(SUBSTR(ssn,-7,1),'^[3478]') THEN '20'||SUBSTR(ssn,1,6)
                    ELSE '18'||SUBSTR(ssn,0,6)
                 END yyyymmdd
FROM insa
)
SELECT name,ssn, FLOOR(MONTHS_BETWEEN(SYSDATE,TO_DATE(yyyymmdd))/12) age
FROM birth b;
-- ���� �Ѱ� + ������ ����
WITH birth AS(
SELECT name,ssn, CASE 
                    WHEN REGEXP_LIKE(SUBSTR(ssn,-7,1),'^[1256]') THEN '19'||SUBSTR(ssn,1,6)
                    WHEN REGEXP_LIKE(SUBSTR(ssn,-7,1),'^[3478]') THEN '20'||SUBSTR(ssn,1,6)
                    ELSE '18'||SUBSTR(ssn,0,6)
                 END yyyymmdd
FROM insa
)
SELECT name,ssn, FLOOR(MONTHS_BETWEEN(SYSDATE,TO_DATE(yyyymmdd))/12) american_age,
        CASE
            WHEN SYSDATE - TO_DATE(SUBSTR(ssn,3,4),'MMDD') <0 THEN FLOOR(MONTHS_BETWEEN(SYSDATE,TO_DATE(yyyymmdd))/12)+1
            ELSE  FLOOR(MONTHS_BETWEEN(SYSDATE,TO_DATE(yyyymmdd))/12)
        END COUNT_age
FROM birth b;

SELECT SYSDATE - TO_DATE('0311','MMDD')
FROM dual;


-- ������� �ϽŰ�
SELECT t.name, t.ssn
    , t.now_year - t.birth_year + 
      CASE is_birth_check
        WHEN -1 THEN -1
        ELSE 0
      END american_age
    , t.now_year - t.birth_year + 1 counting_age
FROM (
    SELECT name, ssn
        , TO_CHAR(SYSDATE, 'YYYY') now_year
        , CASE  
             WHEN  SUBSTR(ssn, -7, 1) IN ( 1,2,5,6 ) THEN 1900
             WHEN  SUBSTR(ssn, -7, 1) IN ( 3,4,7,8 ) THEN 2000
             ELSE 1800
           END + SUBSTR(ssn, 0, 2) birth_year
        , SIGN( TRUNC(SYSDATE) - TO_DATE( SUBSTR(ssn, 3, 4), 'MMDD') ) is_birth_check
    FROM insa
) t;

--������ ��
-- ORACLE : dbms_random ��Ű��
SELECT
        --SYS.dbms_random.value,  --0<=�Ǽ�<1
        --SYS.dbms_random.value(0,100), --0<= �Ǽ� <100
        --SYS.dbms_random.string('U',5), -- �빮�� 5����
        --SYS.dbms_random.string('L',5),   -- �ҹ��� 5����
        --SYS.dbms_random.string('A',5), -- ���ĺ� ��ҹ��� 5
        --SYS.dbms_random.string('X',5), -- ���ĺ� �빮�� + ���� 5
        SYS.dbms_random.string('T',5) --���ĺ� �빮�� + Ư�� ���� 5
FROM dual;

-- 0<=���� <=100
-- 1<= lotto <=45
-- 150<= v ���� <=200

SELECT
        FLOOR(SYS.dbms_random.value(0,101)),
        FLOOR(SYS.dbms_random.value(0,45))+1,
         FLOOR(SYS.dbms_random.value(150,200))
FROM dual;

-- �Ǻ�(pivot)����
-- ��.
SELECT DISTINCT job
FROM emp;
--��. �� job ���
SELECT  COUNT(DECODE(job,'CLERK',1))CLERK,
        COUNT(DECODE(job,'SALESMAN',1))SALESMAN,
        COUNT(DECODE(job,'PRESIDENT',1))PRESIDENT,
        COUNT(DECODE(job,'MANAGER',1))MANAGER,
        COUNT(DECODE(job,'ANALYST',1))ANALYST,
        COUNT(*)
FROM emp;

--��. PIVOT ���
--      ��(���� �߽����� ȸ�� ��Ű��)
/* ����
SELECT * 
  FROM (�ǹ� ��� ������)
 PIVOT (�׷��Լ�(�����÷�) FOR �ǹ��÷� IN(�ǹ��÷� �� AS ��Ī...))
*/
SELECT * 
  FROM (SELECT job  
         FROM emp
       )
   PIVOT(
         count(*)
          FOR job IN('CLERK','SALESMAN','PRESIDENT','MANAGER','ANALYST'));
          
--��)
SELECT * 
  FROM (SELECT 
        job ,
        TO_CHAR(hiredate, 'FMMM') || '��' hire_month
         FROM emp
       )
   PIVOT(
         count(*)
          FOR hire_month IN ('1��', '2��')
        );

-- emp ���̺��� (���μ���)�� job���� �ο����� ���� ���

SELECT * 
  FROM (SELECT deptno,job  
         FROM emp
       )
   PIVOT(
         count(job)
          FOR job IN('CLERK','SALESMAN','PRESIDENT','MANAGER','ANALYST'))
          ORDER BY deptno;

--40 ,0,0,0,0
SELECT *
  FROM (SELECT d.deptno,job  
         FROM emp e RIGHT JOIN dept d ON e.deptno = d.deptno
       )
   PIVOT(
         count(job)
          FOR job IN('CLERK','SALESMAN','PRESIDENT','MANAGER','ANALYST'))
          ORDER BY deptno;
                  
SELECT * 
FROM (
    SELECT 
    -- job, 
    deptno , sal, ename   
    FROM emp 
    )
PIVOT(
    MAX(sal) AS �ְ��, MAX(ename) AS �ְ�޿���  FOR deptno IN ('10', '20', '30')
);