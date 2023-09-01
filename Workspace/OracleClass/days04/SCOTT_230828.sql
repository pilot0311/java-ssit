SELECT deptno,ename, NVL(sal+comm, sal) AS pay FROM emp
where NVL(sal+comm, sal) BETWEEN 1000 AND 3000 and deptno != 30
ORDER BY ename;

WITH e AS 
(
SELECT deptno,ename, NVL(sal+comm, sal) AS pay FROM emp
)
SELECT* FROM e 
WHERE pay BETWEEN 1000 AND 3000 and deptno != 30
ORDER BY ename;

SELECT * FROM (SELECT deptno,ename, NVL(sal+comm, sal)pay FROM emp)e 
WHERE e.pay BETWEEN 1000 AND 3000 and e.deptno != 30
ORDER BY e.ename;

SELECT
    'AbCdE',
    upper('AbCdE'),
    lower('AbCdE'),
    initcap('abCdE')
FROM
    dual;
 
SELECT DISTINCT job ,(SELECT COUNT(DISTINCT job) FROM emp)job�� FROM emp;   
SELECT job ,COUNT(job) FROM emp GROUP BY job;
    
SELECT ssn, SUBSTR(ssn,1,2)year,
EXTRACT(MONTH FROM to_date(SUBSTR(ssn,1,6)))month, 
SUBSTR(ssn,5,2)AS "DATE", 
SUBSTR(ssn,8,1)gender
FROM insa;



SELECT ename, HIREDATE, 
TO_CHAR(HIREDATE, 'yy')YEAR, 
SUBSTR(HIREDATE,4,2)month, 
EXTRACT(DAY FROM HIREDATE)AS "DATE"
FROM emp;

SELECT *
FROM (SELECT name, SUBSTR(ssn,1,8)||'******' rrn FROM insa)e
WHERE e.rrn LIKE '7%' and e.rrn LIKE '%-1%'
ORDER BY rrn;

SELECT name, ssn AS rrn
FROM insa
WHERE ssn LIKE '7%' and ssn LIKE '__12%'
ORDER BY ssn;

SELECT EMPNO,ENAME,JOB, nvl(CAST(mgr AS VARCHAR(4)),'BOSS') AS mgr, HIREDATE,SAL,NVL(COMM,0)comm,DEPTNO
FROM emp;

SELECT num, name,nvl(tel,'����ó ��� �ȵ�')as tel
FROM insa;

SELECT ename
        , NULLIF(ename,'SMITH')
FROM emp;
 
 SELECT sal, comm
        ,sal + NVL(comm,0)pay
        ,sal + NVL2(comm,comm,0)pay
        ,COALESCE(sal + comm, sal) 
 FROM emp;

SELECT num, name, NVL(NULLIF(substr(ssn,8,1),'2'),'X')tel
FROM insa
WHERE buseo = '���ߺ�';

SELECT  num, name, tel, nvl2(NULLIF(SUBSTR(ssn, 8, 1), '2'),'O','X' )gender
FROM insa
WHERE buseo = '���ߺ�';

--RR/YY����
SELECT SYSDATE
        , TO_CHAR(sysdate,'cc')
        , TO_CHAR(sysdate,'scc')
FROM dual;
 -- '05/01/10'
SELECT '05/01/10'
        , TO_CHAR(TO_DATE('05/01/10','RR/MM/DD'),'YYYY')rr
        , TO_CHAR(TO_DATE('05/01/10','YY/MM/DD'),'YYYY')yy
        , TO_CHAR(TO_DATE('97/01/10','RR/MM/DD'),'YYYY')rr
        , TO_CHAR(TO_DATE('97/01/10','YY/MM/DD'),'YYYY')yy
FROM dual;
 
SELECT ename,hiredate
        , TO_CHAR(hiredate,'YYYY')
FROM emp; 
 
SELECT *
FROM dept;

INSERT INTO dept (deptno, dname, loc) VALUES (50, 'QC', 'SEOUL');

UPDATE dept SET dname = concat(dname,'2'), loc = 'POHANG'
WHERE deptno = 50;

DELETE FROM dept where deptno = 50;
DELETE FROM dept where deptno = (SELECT deptno FROM dept where dname = 'QC2');

--REPLACE
--REPLACE (char, search_string [, replacement_string] )
--�̸� �ӿ� m ���� ���Խ� *�κ���
SELECT ename, REPLACE(UPPER(ename),UPPER('m'),'*')
FROM emp
--WHERE lower(ename) LIKE '%m%';
--WHERE ename LIKE CONCAT(CONCAT('%',UPPER('m')),'%');
WHERE ename LIKE '%' || UPPER('m') || '%';
--WHERE ename LIKE upper('%m%');

--���� emp���̺� ���� ename la ��ҹ��� ���о��� �ִ� ��� ��ȸ
SELECT ename
        , REPLACE(ename, 'LA', '<span style="color:red">'||ename||'<span>')
FROM emp
--WHERE UPPER(ename) LIKE '%LA%';
WHERE REGEXP_LIKE(ename, 'la','i');
-- ���� ǥ������ ����Ҽ� �ִ� �Լ�
--regexp_like (search_string, pattern [,match_option])
--REGEXP_LIKE(ename, 'la','i'); 'i' == ��ҹ��� ���о����� �ǹ�
--match_option : i(��ҹ��� ����X), c(��ҹ��� ����O), m(��Ƽ����), X(���鹮�� ����)
--�Լ�
--������(�׷�)�Լ� (group function)
SELECT COUNT(*)
FROM emp;
-- ������ �Լ�(single row function)
SELECT LOWER(ename)
FROM emp;

--
SELECT *
FROM test
--WHERE REGEXP_LIKE(name, '^[�ѹ�]');
WHERE REGEXP_LIKE(name, '����$');

--insa ���̺��� ���� �����
SELECT *
FROM insa
WHERE REGEXP_LIKE(ssn,'^7\d{5}-[13579]'); 
WHERE REGEXP_LIKE(ssn,'^7.{6}[13579]'); 

--���� insa���̺��� ���� �达, �̾� �� ��ȸ
SELECT name
FROM insa
WHERE REGEXP_LIKE(name,'^[����][��-�R]{2}');
WHERE name LIKE '��__' or name LIKE '��__';
--���� insa���̺��� ���� �达, �̾� ���� ��ȸ
SELECT name
FROM insa
WHERE REGEXP_LIKE(name,'^[^����][��-�R]{2}');
WHERE NOT REGEXP_LIKE(name,'^[��,��].{2}');
WHERE NOT (name LIKE '��__' or name LIKE '��__');


WITH temp AS(
SELECT deptno,empno,ename, nvl(sal+comm,sal)pay FROM emp 
)
SELECT *
FROM temp
WHERE pay >= ALL(SELECT pay FROM TEMP) OR pay <= ALL(SELECT pay FROM TEMP);

SELECT * FROM emp where sal >= ALL  (SELECT sal FROM emp) or sal <= ALL  (SELECT sal FROM emp);
--MIN() MAX()
SELECT emp.*, nvl(sal+comm,sal)PAY 
FROM emp 
where nvl(sal+comm,sal)=(SELECT MAX(nvl(sal+comm,sal)) FROM emp) 
        OR nvl(sal+comm,sal) =(SELECT MIN(nvl(sal+comm,sal)) FROM emp);

--SET OPERATOR(���� ������)
--(1) SQL ������ ���� �����ڸ� ����ϱ� ���ؼ��� ���� ������ ����� �Ǵ� �� ���̺��� �÷� ���� ����
--(2) �����Ǵ� �÷����� ������ Ÿ���� �����ؾ� �Ѵ�.
--(3) �÷��̸��� �޶� ��� ������
--(4) ���� ������ ����� ��µǴ� �÷��� �̸��� ù ��° select ���� �÷� �̸��� ������.
--(5) ORDER BY ���� ù ��°�� �� ��° SELECT ���� ���� ���� �Ĺ̿� �־�� �Ѵ�.
-- ����
--  ������: UNION, UNION ALL
--          UNION ALL�� �ߺ��� �κ� ��� ���
--          UNION�� �ߺ��� �κ� �ѹ��� ���
--  ������: INTERSECT
--  ������: MINUS

--emp + insa ��� ��� ������ ��ȸ
SELECT empno, ename, hiredate --, deptno   -- NUMBER��
FROM emp
UNION ALL
SELECT num,name,ibsadate --, buseo -- VARCHAR ��
FROM insa;

--UNION, UNION ALL�� ������
--(1)�λ� ���̺��� ���ߺ� ��ȸ
--(2)�λ� ���̺��� ��� ����: ��õ
SELECT name,city,buseo
FROM insa
WHERE city = '��õ'  --9��(���ߺ� 6��)
UNION ALL              --UNION = 17��    UNION ALL = 23�� (��õ�̰ų� ���ߺ�)
SELECT name, city, buseo
FROM insa
WHERE buseo = '���ߺ�';    --14��
--(3) INTERSECT
SELECT name,city,buseo
FROM insa
WHERE city = '��õ'  --9��(���ߺ� 6��)
INTERSECT            -- 6�� (��õ�̰� ���ߺ� �λ����)
SELECT name, city, buseo
FROM insa
WHERE buseo = '���ߺ�';    --14��
--(4) MINUS
SELECT name,city,buseo
FROM insa
WHERE city = '��õ'  --9��(���ߺ� 6��)
MINUS            -- 3�� (��õ�̰� ���ߺδ� �ƴ� �����)
SELECT name, city, buseo
FROM insa
WHERE buseo = '���ߺ�';    --14��
--(5) ORDER BY ���� ù ��°�� �� ��° SELECT ���� ���� ���� �Ĺ̿� �־�� �Ѵ�.
SELECT name,city,buseo
FROM insa
WHERE city = '��õ'  
MINUS
SELECT name, city, buseo
FROM insa
WHERE buseo = '���ߺ�'
ORDER by name;

SELECT name, ssn, NVL2(NULLIF(MOD(SUBSTR(ssn,8,1),2),0),'O','X')gender 
FROM insa;

--���տ����� (SET OPERATOR)
--1) ����
-- UNION
--2) ����
SELECT name,ssn, 'O' gender
FROM insa
WHERE MOD(SUBSTR(ssn,8,1),2)= 1
UNION
SELECT name,ssn, 'X' gender
FROM insa
WHERE MOD(SUBSTR(ssn,8,1),2)= 0;

-- IS [NOT] NAN, IS [NOT] INFINITE = �� ������ ǥ������ ���Ѵ��̰ų� �Ǵ� ���ǵ��� ���� ��쿡 ���Ǵ� �������̴�. 
-- IS [NOT] NAN = NOT A NUMBER
-- IS [NOT] INFINITE : ���Ѵ�

-- ����Ŭ �Լ� ���� : ora_help function ����
1. ����Ŭ �Լ� ���
2. ����Ŭ �Լ� ���� 
--------------------
(1) ���� �Լ�
    -- ROUND(number,�ݿø���ġ ���,����)�ݿø��Լ�
    -- CEIL()�ø��Լ�
    --FLOOR()����(����)�Լ�
        ��TRUNC(number, ������ ��ġ ���, ����) ���ڰ��� Ư�� ��ġ���� ����(����) 
        ;
        SELECT ROUND(15.193)a --15 �Ҽ��� ù��° �ڸ����� �ݿø�
                --, ROUND(15.193,0)
                , ROUND(15.193,1)b --15.2 �Ҽ��� �ι�° �ڸ����� �ݿø�
                --, ROUND(15.193,n) -- �Ҽ��� n+1�ڸ����� �ݿø�
                , ROUND(15.193,-1) --20 �Ҽ��� ���� ������ĭ(1���ڸ�)���� �ݿø�
                , ROUND(15.193,-2) --0 �Ҽ��� ���� ���ʵ�ĭ(10���ڸ�)���� �ݿø�
        FROM dual;
        --������ ���ں��� ���ų� ū ���� �߿� �ּ� ��
        SELECT CEIL(15.193) -- 16 �Ҽ��� ù��° �ڸ����� �ø�
                ,CEIL(15.913) --16
        FROM dual;
        --������ ���ں��� �۰ų� ���� ���� �� �ִ� ��
        SELECT FLOOR(15.193) --15 
                ,FLOOR(15.913) --15
        FROM dual;
        -- FLOOR() �� TRUNC() ����
        SELECT FLOOR(15.193) --15
                ,  FLOOR(15.193*10)/10 -- 15.1
                , TRUNC(15.193) --15 == FLOOR(15.193)
                , TRUNC(15.193,1) --15.1 TRUNC�� Ư�� ��ġ���� ���� ����
                , TRUNC(15.193,-1) --10 ROUND()�ݿø��Լ� ó�� ������ ����
        FROM dual;
        -- �Ҽ� 3��° �ڸ����� �ݿø��Ͻÿ�
        SELECT 10/3
                ,ROUND(10/3,2)
        FROM dual;
        
        --������ ���ϴ� �Լ� MOD(), REMAINDER()
        SELECT MOD(19,4) --3
                ,REMAINDER(19,4) -- -1
        FROM dual;
        --MOD(n2,n1) = n2-n1*FLOOR(n2/n1)
        --REMAINDER(n2,n1) = n2-n1*ROUND(n2/n1)
        
        --ABS() ���밪
        --SIGN() ��ȣ�� ���� 1, -1 ��ȯ 0�̸� 0��ȯ
        SELECT ABS(100), ABS(-100)
                , SIGN(100), SIGN(-100), SIGN(0) -- 1,-1,0
                , POWER(2,3)  -- 8 n1^n2
                , SQRT(2) -- n�� ������(ROOT)��
        FROM dual;
            
(2) ���� �Լ�
    -- UPPER()
    -- LOWER()
    -- INITCAP()
    -- CONCAT()
    -- SUBSTR()
    ;
    -- LENGTH() ���ڿ� ����
    SELECT DISTINCT job
            , LENGTH(job)
    FROM emp;
    
    -- emp���̺��� ename�� L���ڰ� �ִ� ��� ��ȸ
    -- L ���ڰ� �ִ� ��ġ�� ��ȸ
    -- INSTR() Ư�����ڰ� �ִ� ��ġ ��ȸ
    -- INSTR(string, substring [, position [,occurrence])
    -- string���ڿ��� substring���ڿ��� [position���� [occurrence��°]] ��ġ
    SELECT ename, INSTR(ename, 'L')
    FROM emp
    WHERE REGEXP_LIKE(ename,'l','i');
    WHERE ename LIKE '%M%';
    
    select instr('corporate floor','or') -- 2 
    , instr('corporate floor','or',4)  -- 2 4��° ��ġ ���� or 
    , instr('corporate floor','or',1,3) -- 14 1��° ��ġ ���� 3��° or ��ġ
    , instr('corporate floor','or',3,2)        -- 14 3��° ��ġ���� 2��° or ��ġ
    , instr('corporate floor','or',-1,3) --2 �ڿ��� ���� 3��° or ��ġ
    from dual;

    -- RPAD/LPAD == ������ ���̿��� ���ڰ��� ä��� ���� ������ ��(��)������ Ư�������� ä�� �����Ѵ�
    -- ���� RPAD (expr1, n [, expr2] )
    SELECT ename, sal + NVl(comm,0) pay
           -- ,LPAD(sal + NVl(comm,0),10,'*') -- ��10�ڸ� �� ����ϰ� ���� �ڸ��� ���ʺ��� *�� ä��
           -- ,RPAD(sal + NVl(comm,0),10,'*')
           -- 10���ڸ� �ݿø� �� 100���� #
           , ROUND(sal + NVl(comm,0),-2)RPAY
           , ROUND(sal + NVl(comm,0),-2)/100 a
           , RPAD(' ',ROUND(sal + NVl(comm,0),-2)/100+1,'#')p
           , RPAD(ROUND(sal + NVl(comm,0),-2)/100,ROUND(sal + NVl(comm,0),-2)/100+LENGTH(ROUND(sal + NVl(comm,0),-2)/100),'#')
    FROM emp;
    -- �ڹ�.String.trim() ��/�� ���� �����ϴ� �Լ�    
    --LTRIM()/RTRIM()/TRIM() ���ڰ� �߿��� ��/�� ���� ���� Ư�� ���ڿ� ��ġ�ϴ� ���� �� ���� 
    -- ����: RTRIM(char [,set] )
    SELECT '[' || '   admin   ' || ']'
            ,'[' || LTRIM('   admin   ') || ']' --���� ���� ����
            ,'[' || RTRIM('   admin   ',' ') || ']' -- ������ ���� ����
            ,'[' || TRIM('   admin   ') || ']' --TRIM�� 2��°�Ű����� ���Ұ�
            ,'[' || LTRIM('xyxyadminxyxy','xy') || ']'  -- ���� xy���ŵ�
            ,'[' || RTRIM('xyxyadminxyxy','xy') || ']'  -- ������ xy���ŵ�
    FROM dual;
    
    --ASCII() : ���ڸ� �ƽ�Ű �ڵ�� ��ȯ
    --CHR() : �ƽ�Ű�ڵ带 �ش��ϴ� ���ڷ� ��ȯ
    SELECT ASCII('A'),ASCII('a'),ASCII('0')
            ,CHR(65), CHR(97), CHR(48)
    FROM dual;
    
    -- GREATEST()/LEAST() : ������ ���ڳ� ������ ���� ū��/������ ��ȯ
    SELECT GREATEST(3,5,2,4,1)
            , LEAST(3,5,2,4,1)
            , GREATEST('MBC','TVC','SBS')
    FROM dual;
    
    --REPLACE() ���ڿ� ġȯ
    
    -- VSIZE() ������ ���ڿ��� ũ�⸦ ���ڷ� ��ȯ
    SELECT VSIZE('a'), VSIZE('��')  --���� 1����Ʈ �ѱ� 3����Ʈ
    FROM dual;
    
    
(3) ��¥ �Լ�
(4) ��ȯ �Լ�
(5) �Ϲ� �Լ�
    - ���� ǥ���� �Լ�
(6) ���� �Լ�
--------------------

