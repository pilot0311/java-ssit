--[1]
SELECT t.*
FROM (
        SELECT e.*, RANK()OVER(ORDER BY sal DESC)rank FROM emp e
)t
WHERE rank <=(SELECT COUNT(*) FROM emp)*0.2;
--[2]
WITH a AS (
SELECT SUM(sal+nvl(comm,0))sum
FROM emp
)
SELECT e.ename ,e.sal+nvl(comm,0) pay,sum TOTALPAY,TO_CHAR(ROUND(((sal+nvl(comm,0))/sum)*100,2),'99.00')||'%' ����
FROM emp e, a;
--[3]
WITH birth AS(
SELECT name,ssn, CASE 
                    WHEN SUBSTR(ssn, -7, 1) IN (1,2,5,6) THEN '19'||SUBSTR(ssn,1,6)
                    WHEN SUBSTR(ssn, -7, 1) IN (3,4,7,8) THEN '20'||SUBSTR(ssn,1,6)
                    ELSE '18'||SUBSTR(ssn,0,6)
                 END yyyymmdd
FROM insa
)
SELECT name,ssn, FLOOR(MONTHS_BETWEEN(SYSDATE,TO_DATE(yyyymmdd))/12) age
FROM birth b;
--[3] + ������
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
-- [4]
SELECT COUNT(*)�ѻ����,COUNT(DECODE(MOD(SUBSTR(ssn,8,1),2),1,1))���ڻ���� ,
        COUNT(DECODE(MOD(SUBSTR(ssn,8,1),2),0,1))���ڻ����,
        SUM(DECODE(MOD(SUBSTR(ssn,8,1),2),1,basicpay))���������_�ѱ޿���,
        SUM(DECODE(MOD(SUBSTR(ssn,8,1),2),0,basicpay))���������_�ѱ޿���,
        MAX(DECODE(MOD(SUBSTR(ssn,8,1),2),1,basicpay))"����-max",
        MAX(DECODE(MOD(SUBSTR(ssn,8,1),2),0,basicpay))"����-max"
FROM insa;

SELECT DECODE(MOD(SUBSTR(ssn,8,1),2),1,'����',0,'����','��ü�����')gender,COUNT(*)
FROM insa
GROUP BY ROLLUP(MOD(SUBSTR(ssn,8,1),2))
UNION
SELECT DECODE(MOD(SUBSTR(ssn,8,1),2),1,'���ڱ޿���',0,'���ڱ޿���','��ü������޿���'),SUM(basicpay)
FROM insa
GROUP BY ROLLUP(MOD(SUBSTR(ssn,8,1),2));

    
--[5]
SELECT t.*
FROM (
    SELECT  DEPTNO, ENAME,sal+NVL(comm,0)pay, RANK()OVER(PARTITION BY deptno ORDER BY sal+NVL(comm,0)desc)rank FROM emp e
)t
WHERE rank =1;

SELECT e.deptno, e.ename, e.sal+NVL(e.comm,0)pay
FROM(
SELECT deptno, MAX(sal+NVL(comm,0))max_pay
FROM emp
GROUP BY deptno
)t , emp e
WHERE t.deptno = e.deptno 
        AND t.max_pay= e.sal+NVL(e.comm,0)
ORDER BY e.deptno;
--[6]
SELECT deptno,COUNT(*),SUM(sal+NVL(comm,0)),ROUND(AVG(sal+NVL(comm,0)),2)
FROM emp
GROUP BY deptno
ORDER BY deptno;

--[7]

SELECT t.*
          , ROUND((�μ������/�ѻ����)*100, 1) || '%' "��/��%"
          , ROUND((���������/�ѻ����)*100, 1) || '%' "�μ�/��%"
          , ROUND((���������/�μ������)*100, 1) || '%' "��/��%"
   FROM (
          SELECT buseo
                 , (SELECT COUNT(*) FROM insa) "�ѻ����"
                 , (SELECT COUNT(*) FROM insa WHERE i.buseo=buseo) "�μ������"
                 , DECODE(MOD(SUBSTR(ssn, 8, 1), 2), '1', 'M', 'F') "����"
                 , COUNT(*) "���������"
          FROM insa i
          GROUP BY buseo, MOD(SUBSTR(ssn, 8, 1), 2)
          ORDER BY buseo
   ) t;
   --
   SELECT temp.*
         , ROUND((�μ������/�ѻ����)*100, 1) || '%' "��/��%"
         , ROUND((���������/�ѻ����)*100, 1) || '%' "�μ�/��%"
         , ROUND((���������/�μ������)*100, 1) || '%' "��/��%"
   FROM(
   SELECT buseo �μ���
          ,(SELECT COUNT(*) FROM insa)�ѻ����
          ,(SELECT COUNT(*) FROM insa WHERE buseo = t.buseo)�μ������
          ,gender ����
          ,COUNT(*)���������
          
   FROM(
   SELECT buseo, name, ssn, DECODE(MOD(SUBSTR(ssn,-7,1),2),1,'M','F')gender
   FROM insa
   )t
   GROUP BY buseo,gender
   ORDER BY buseo
   )temp;
   
  --[8]
  WITH c AS (
    SELECT DISTINCT city
    FROM insa
)
SELECT buseo, c.city, COUNT(buseo)
FROM insa i PARTITION BY (i.buseo) RIGHT OUTER JOIN c   ON i.city = c.city
GROUP BY buseo, c.city
ORDER BY buseo,c.city; 
--
SELECT buseo, t.city, COUNT(*)
FROM insa i PARTITION BY (BUSEO) RIGHT JOIN (SELECT DISTINCT city FROM insa )t ON i.city = t.city
GROUP BY buseo,t.city
ORDER BY buseo, t.city;
 
 SELECT DISTINCT city
 FROM insa;
 
 --emp ���̺� job�� ����� ��ȸ
 SELECT deptno,t.job, COUNT(empno)
 FROM  emp e  PARTITION BY (deptno) RIGHT JOIN (SELECT DISTINCT job FROM emp)t ON t.job = e.job
 GROUP BY e.deptno,t.job
 ORDER BY e.deptno,t.job;
-- [9-1] 
      SELECT
             COUNT (DECODE( job, 'CLERK', 1) ) CLERK
            ,COUNT (DECODE( job, 'SALESMAN', 1) ) SALESMAN
            ,COUNT (DECODE( job, 'PRESIDENT', 1) ) PRESIDENT
            ,COUNT (DECODE( job, 'MANAGER', 1) ) MANAGER
            ,COUNT (DECODE( job, 'ANALYST', 1) ) ANALYST
        FROM emp;
        
--[9-2]
SELECT *
FROM(SELECT job FROM emp
)
PIVOT(COUNT(*)
        FOR job IN('CLERK', 'SALESMAN', 'PRESIDENT', 'MANAGER', 'ANALYST' )
);

--[10]
 SELECT *
 FROM(SELECT job,TO_CHAR(hiredate,'YYYY')h_year, TO_CHAR(hiredate,'MM')h_month FROM emp
 )
 PIVOT( COUNT(*)
  FOR h_month IN ( 1,2,3,4,5,6,7,8,9,10,11,12 ) 
 )ORDER BY job ASC;
 
--[11]
SELECT FLOOR( dbms_random.value( 100000,1000000 ) )
FROM dual;

--[12]
SELECT d.deptno
     , LISTAGG( NVL(ename,'�������') , '/') WITHIN GROUP ( ORDER BY ename )AS ename    
FROM emp e RIGHT JOIN dept d ON e.deptno = d.deptno
GROUP BY d.deptno;

--[13]
SELECT MAX(sal),MIN(sal)
FROM emp
WHERE deptno = 30;

SELECT deptno,MAX(sal),MIN(sal)
FROM emp
GROUP BY deptno
HAVING deptno = 30;
--[13-2]
SELECT *
FROM emp
WHERE sal IN ((SELECT MAX(sal)FROM emp WHERE deptno = 30),(SELECT MIN(sal)FROM emp WHERE deptno = 30)) AND deptno =30;

WITH t AS (
SELECT MAX(sal)max,MIN(sal)min
FROM emp
WHERE deptno = 30
)
SELECT e.*
FROM emp e,t
WHERE sal IN(t.max,t.min) AND deptno = 30;

--[14]
SELECT *
FROM(
SELECT d.deptno,d.dname,COUNT(e.empno)�����, RANK()OVER(ORDER BY COUNT(*) desc)rank
FROM emp e RIGHT JOIN dept d ON e.deptno = d.deptno
GROUP BY d.deptno,d.dname
)t
WHERE rank IN(1,(SELECT COUNT(*) FROM dept));
--[1]
WITH temp AS (
 SELECT d.deptno,dname,COUNT(empno)cnt
 FROM emp e, dept d
 WHERE e.deptno(+) = d.deptno
 GROUP BY d.deptno,dname
)
SELECT *
FROM temp
WHERE cnt IN((SELECT MAX(cnt)FROM temp),(SELECT MIN(cnt)FROM temp));
--[2]
WITH a AS (
SELECT d.deptno,dname,COUNT(empno)cnt
FROM emp e, dept d
 WHERE e.deptno(+) = d.deptno
 GROUP BY d.deptno,dname
 ), b AS (
 SELECT MIN(cnt)mincnt,MAX(cnt)maxcnt
 FROM a
 )
 SELECT a.*
 FROM a,b
 WHERE a.cnt IN(b.maxcnt,b.mincnt);
 
 --[3]�м� �Լ� : FIRST, LAST
 -- �����Լ��� �Բ� ���Ǿ� �־��� �׷쿡 ���� ���� ������ ������ �Ű� ����� ����
 WITH a AS (
 SELECT d.deptno,dname,COUNT(empno)cnt
 FROM emp e, dept d
 WHERE e.deptno(+) = d.deptno
 GROUP BY d.deptno,dname
 )
 SELECT 
    MIN(deptno)KEEP(DENSE_RANK FIRST ORDER BY cnt) AS deptno
    ,MIN(cnt)
    ,MAX(deptno)KEEP(DENSE_RANK LAST ORDER BY cnt) AS deptno
    ,MAX(cnt)
 FROM a;
 
SELECT COUNT(*)
FROM dept;

-------------------------
--[�м��Լ�]: ���̺� �ִ� �࿡ ���� Ư�� �׷캰�� ���� ���� ���� �Ҷ� ����ϴ� �Լ�
1) ROW_NUMBER()
2) RANK()
3) DENSE_RANK()
4) CUME_DIST(): �־��� �׷쿡 ���� ������� ���� ������ ���� ��ȯ
                ��������(����): 0<�Ǽ�<=1
    ��) �μ��� �޿��� ���� ���� ������ �� ��ȸ
    SELECT deptno, ename, sal
        , CUME_DIST()OVER(PARTITION BY deptno ORDER BY sal) dept_dist
    FROM emp;
5) PERCENT_RANK(): �ش� �׷� ���� ����� ����
                    0<= �Ǽ� <=1
                    ���������: �׷� �ȿ��� �ش� �ο�(��)�� ������ [���� ���� ����]    
    SELECT deptno, ename, sal
        , PERCENT_RANK()OVER(PARTITION BY deptno ORDER BY sal) dept_per
    FROM emp;
    -- ��
    SELECT deptno, ename, sal
        , PERCENT_RANK()OVER(PARTITION BY deptno ORDER BY sal) dept_per
        , CUME_DIST()OVER(PARTITION BY deptno ORDER BY sal) dept_dist
    FROM emp
    WHERE deptno = 30;
                PERCENT_RANK     CUME_DIST    
30	JAMES	950	    0	0.1666666666666666666666666666666666666667 (1/6)
30	WARD	1250	0.2(1/5)	0.5     (3/6)
30	MARTIN	1250	0.2(1/5)	0.5
30	TURNER	1500	0.6(3/5)	0.6666666666666666666666666666666666666667 (4/6)
30	ALLEN	1600	0.8(4/5)	0.8333333333333333333333333333333333333333 (5/6)
30	BLAKE	2850	1	1

6) NTILE(expr): ��Ƽ�� ���� expr�� ��õ� ��ŭ ������ ����� ��ȯ �ϴ� �Լ�
    ���� �ϴ� ���� ��Ŷ(bucket)�̶�� �Ѵ�
    
    SELECT deptno,ename,sal
        , NTILE(4)OVER (ORDER BY sal)ntiles
    FROM emp;
    
    SELECT buseo,name,basicpay
        , NTILE(2)OVER(PARTITION BY buseo ORDER BY basicpay)
    FROM insa;
    
7) WIDTH_BUCKET(expr, min_value, max_value, num_bucket)
    NTILE() �Լ��� ������ �Լ�
    ������: (�ּҰ�, �ִ밪 ��������)
    ��)
    SELECT deptno, ename,sal
        , NTILE(4)OVER (ORDER BY sal ASC)ntiles
        , WIDTH_BUCKET(sal, 0, 5000, 4)withbuckets
    FROM emp;
    
8) LAG(expr, offset, default_value)
    : �־��� �׷�� ������ ���� �ٸ� �࿡ �ִ� ���� ���� �� �� ����ϴ� �Լ�
    ��(���� ��)
   LEAD(expr, offset, default_value)
    : �־��� �׷�� ������ ���� �ٸ� �࿡ �ִ� ���� ���� �� �� ����ϴ� �Լ�
    �� (���� ��)
    SELECT ename,hiredate,sal
        , LAG(sal,1,0)OVER(ORDER BY hiredate)AS prev_sal
        , LAG(sal,2,-1)OVER(ORDER BY hiredate)AS prev_sal
        , LEAD(sal,1,-1)OVER(ORDER BY hiredate)AS next_sal
    FROM emp
    WHERE deptno =30;

--
SELECT '***ADMIN***'
    ,REPLACE('***ADMIN***','*','')
    ,REPLACE('***AD**MIN***','*','')
    ,TRIM('*' FROM '***AD**MIN***')
    ,TRIM(' ' FROM '   AD**MIN   ')
FROM dual;

-- ����Ŭ �ڷ��� --
1) CHAR[size[BYTE|CHAR]]
    CHAR == CHAR(1)
    CHAR(10)
    CHAR(10 byte)
    CHAR(10 char)    
    �⺻�� : 1
    sizeũ���� �������� ���� ������
    1����Ʈ ~ 2000����Ʈ
    
    �̸� ���ڿ�: ename CHAR -> 1����Ʈ�� 3����Ʈ�� �ѱ� �Է� �Ұ�
                ename CHAR(10) -> 10����Ʈ -> ���� 3����Ʈ ������ص� ���� ũ��� �������� ����������
                �ֹε�� ��ȣ���� ������ ���� �Է½� ���
                ename CHAR(10 char)-> ���� �ѱ� ���� ���� 10[����] �Է°���
                
create table test (aa char, bb char(3), cc char(3 char));
DESC test;
AA    CHAR(1)      --1����Ʈ
BB    CHAR(3)      --3����Ʈ 
CC    CHAR(3 CHAR) -- ���� 3��

insert into test (aa,bb,cc) values('a','aaaa','aaaa'); --1����Ʈ 4����Ʈ 4����Ʈ
--ORA-12899: value too large for column "SCOTT"."TEST"."BB" (actual: 4, maximum: 3) bbĮ�� �ִ� ũ�� 3�ε� 4����Ʈ �Է���
insert into test values('a','aaa','aaaa');
-- ORA-12899: value too large for column "SCOTT"."TEST"."CC" (actual: 4, maximum: 3)ccĮ�� �ִ� ũ�� 3�����ε� 4���� �Է���
insert into test values('a','aaa','aaa'); -- ���� �Է�
insert into test values('b','��','�츮'); -- ���� �Է�
insert into test values('c','�츮','�츮'); -- �ѱ��� �ѱ��ڴ� 3����Ʈ
--ORA-12899: value too large for column "SCOTT"."TEST"."BB" (actual: 6, maximum: 3) bbĮ�� ũ�� 3����Ʈ �Է¹��� 6����Ʈ

COMMIT;
SELECT *
FROM test;
