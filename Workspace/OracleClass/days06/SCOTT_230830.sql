--[1]
SELECT buseo, COUNT(*)c  
FROM insa e
GROUP BY buseo
ORDER BY c;
--GROUP BY�� ���� �Լ��� �����Լ� �ܿ��� �ü� ����.
--[1-2]
SELECT distinct buseo,(SELECT COUNT(*)FROM insa s WHERE i.buseo=s.buseo)c
FROM insa i
ORDER BY c;

WITH m AS(
SELECT distinct buseo
FROM insa i
)
SELECT buseo,(SELECT COUNT(*)FROM insa s WHERE buseo=m.buseo)c
FROM m;
-- �߰� ����: insa���̺� ���� ���ڻ����, ���� ����� ��ȸ
-- �����Լ��� null �����ϰ� ���, COUNT(*)�� null���� ���
SELECT COUNT(DECODE(MOD(SUBSTR(ssn,-7,1),2),1,1))����,
        SUM(DECODE(MOD(SUBSTR(ssn,-7,1),2),0,1))����,
        COUNT(*)��ü
FROM insa;
-- GROUP BY ���
SELECT DECODE(MOD(SUBSTR(ssn,-7,1),2),1,'����','����')gender,COUNT(*)
FROM insa
GROUP BY MOD(SUBSTR(ssn,-7,1),2);
-- �߰� Ǯ��: emp���̺��� �� �μ��� �����
-- 1 GROUP BY deptno
SELECT deptno, COUNT(*)
FROM emp
GROUP BY deptno
UNION
SELECT null, COUNT(*)
FROM emp;

--[2-3]
SELECT i.*, BASICPAY+SUDANG pay
FROM insa i
WHERE BASICPAY+SUDANG =((SELECT MAX(BASICPAY+SUDANG)FROM insa WHERE i.buseo = buseo));
--[2-2]
SELECT buseo, MAX(BASICPAY+SUDANG)
FROM insa
GROUP BY buseo;
--[2-1]
SELECT BUSEO,NAME,BASICPAY+SUDANG pay
FROM insa 
WHERE buseo = '�ѹ���' AND BASICPAY+SUDANG >= (SELECT max(BASICPAY+SUDANG)FROM insa WHERE  buseo = '�ѹ���')
UNION ALL
SELECT BUSEO,NAME,BASICPAY+SUDANG pay
FROM insa 
WHERE BASICPAY+SUDANG = (SELECT max(BASICPAY+SUDANG)FROM insa WHERE  buseo = '��ȹ��')
UNION ALL
SELECT BUSEO,NAME,BASICPAY+SUDANG pay
FROM insa 
WHERE BASICPAY+SUDANG = (SELECT max(BASICPAY+SUDANG)FROM insa WHERE  buseo = '������');
--[3]
SELECT TO_CHAR(LAST_DAY(SYSDATE),'DD')
        , EXTRACT(DAY FROM LAST_DAY(SYSDATE))
FROM dual;
--[4]
SELECT NEXT_DAY(SYSDATE,'��')
FROM dual;
--[5]
SELECT HIREDATE, ADD_MONTHS(hiredate,125)+20  ADD_MONT
FROM emp
ORDER BY  ADD_MONT;

--[6]
UPDATE insa
SET ssn = SUBSTR(ssn,1,2)||TO_CHAR(SYSDATE,'MMDD')||SUBSTR(ssn,7)
WHERE num in(1001,1002);
commit;
ROLLBACK;

SELECT *
FROM insa;

SELECT name, ssn, ibsadate
FROM insa
WHERE num in(1001,1002);
--[6-2]
SELECT name, ssn, 
DECODE(SIGN(MONTHS_BETWEEN(TO_DATE(TO_CHAR(SYSDATE,'YY')||SUBSTR(SSN,3,4)),SYSDATE)),-1,'���� ��',1,'���� ��','����')birth
FROM insa;

SELECT name, ssn, 
       SUBSTR(ssn,3,4)birth,
       TO_CHAR(SYSDATE,'MMDD')today,
       DECODE(SIGN(TO_CHAR(SYSDATE,'MMDD') - SUBSTR(ssn,3,4)),1,'���� ��',-1,'���� ��','����')as "t-b"
FROM insa;


--[6-3]
SELECT 
    SUM(DECODE(SIGN(TO_CHAR(SYSDATE,'MMDD') - SUBSTR(ssn,3,4)), 1, 1)) AS "���� ��",
    SUM(DECODE(SIGN(TO_CHAR(SYSDATE,'MMDD') - SUBSTR(ssn,3,4)), 0, 1)) AS "���� ����",
    SUM(DECODE(SIGN(TO_CHAR(SYSDATE,'MMDD') - SUBSTR(ssn,3,4)), -1, 1)) AS "���� ��"
FROM insa i;
WITH temp AS(
SELECT SIGN(TO_CHAR(SYSDATE,'MMDD') - SUBSTR(ssn,3,4))s FROM insa
)
SELECT 
    COUNT(DECODE(s, 1, 1)) AS "���� ��",
    COUNT(DECODE(s, 0, 1)) AS "���� ����",
    COUNT(DECODE(s, -1, 1)) AS "���� ��",
    COUNT(*)"��ü ��"
FROM temp;
    
SELECT 
    COUNT(SIGN(TO_CHAR(SYSDATE,'MMDD') - SUBSTR(ssn,3,4)))
FROM insa
GROUP BY SIGN(TO_CHAR(SYSDATE,'MMDD') - SUBSTR(ssn,3,4));
--[9]
SELECT 
         SYSDATE, TO_DATE('98/03/11')�������
        , ROUND(SYSDATE - TO_DATE('98/03/11'))�ϼ�
        , ROUND(MONTHS_BETWEEN(SYSDATE,TO_DATE('98/03/11')),1)������
        , ROUND(MONTHS_BETWEEN(SYSDATE,TO_DATE('98/03/11'))/12,1)���
FROM dual;
--[10]
SELECT  SYSDATE,
        TO_CHAR(SYSDATE,'W'),
        TO_CHAR(SYSDATE,'WW'),
        TO_CHAR(TO_DATE('2022/1/1'),'IW'),
        TO_CHAR(TO_DATE('2022/1/1'),'WW'),
        TO_CHAR(TO_DATE('2022/1/2'),'IW'),
        TO_CHAR(TO_DATE('2022/1/2'),'WW'),
        TO_CHAR(TO_DATE('2022/1/3'),'IW'),
        TO_CHAR(TO_DATE('2022/1/3'),'WW'),
        TO_CHAR(TO_DATE('2022/1/8'),'IW'),
        TO_CHAR(TO_DATE('2022/1/8'),'WW')
FROM dual;
--[11]
SELECT  TO_CHAR(LAST_DAY(SYSDATE),'DD'),
        ADD_MONTHS(SYSDATE,1),
        TRUNC(ADD_MONTHS(SYSDATE,1),'MONTH')-1
FROM dual;

SELECT  TO_DATE('2022','YYYY'), --22/08/01
        TO_DATE('2022.02','YYYY.MM'), --22/02/01
        TO_DATE('03','MM') --23/03/01
FROM dual;
--[11-2]
SELECT TO_CHAR(SYSDATE, 'IW'),TO_CHAR(SYSDATE, 'W')
FROM dual;
--[12]
SELECT ename, NVL(sal+comm,sal), NVL2(comm,sal+comm,sal), COALESCE(sal+comm,sal)
FROM emp;
--[12-2]
SELECT ename, NVL(mgr,-1), NVL2(mgr,mgr,-1), COALESCE(mgr,-1)
FROM emp;
--[13]
SELECT name,ssn, DECODE(MOD(SUBSTR(ssn,8,1),2),1,'����','����')gender
 FROM insa;
 -- DECODE()Ȯ�� -> CASE
 /* ����
 CASE �÷���|ǥ���� WHEN ����1 THEN ���1
			  [WHEN ����2 THEN ���2
                                ......
			   WHEN ����n THEN ���n
			  ELSE ���4]
	END
*/
 --���� ���� ������ �־� ���ǿ� ���� ��� �ش� ���� �����ϴ� �Լ�(DECODE�� Ȯ����)
 -- CASE �Լ������� �������, ���迬��, ������� ���� �پ��� �񱳰� �����ϴ�. ���� WHEN ������ ǥ������ �پ��ϰ� ������ �� �ִ�.
 -- CASE ǥ������ ANSI SQL ���ĵ� �����Ѵ�.
 -- ���ǹ��� ���ǹ� ���̿��� �ĸ��� ������� �ʴ´�.
 -- CASE ���� �ݵ�� END�� ������ �Ѵ�.
 -- ����� ����ؾ� �ϴ� �κ��� NULL�� ����ؼ��� �ʵȴ�.
 -- CASE ��ɾ� ������ ����ϴ� �÷���/ǥ���İ� ����, ����� ǥ���Ǵ� �����͵��� ��� ������ Ÿ���� �����ؾ� �Ѵ�
 SELECT name, ssn,
        CASE MOD(SUBSTR(ssn,8,1),2) WHEN 1 THEN '����'
                                    --WHEN 0 THEN '����'
                                    ELSE '����'
        END gender,
        CASE
            WHEN  MOD(SUBSTR(ssn,8,1),2) = 1 THEN '����'
            ELSE '����'
        END gender
FROM insa;
-- 6-2�� ���� CASE �Լ��� �ٲٱ�     /6-3�� �غ���
SELECT name, ssn, 
       TO_CHAR(SYSDATE,'MMDD') - SUBSTR(ssn,3,4),
       CASE
            WHEN (TO_CHAR(SYSDATE,'MMDD') - SUBSTR(ssn,3,4)) >0 THEN '���� ��' 
            WHEN (TO_CHAR(SYSDATE,'MMDD') - SUBSTR(ssn,3,4)) <0 THEN '���� ��'
            ELSE '���� ����'
       END 
FROM insa;

 --[14]
 --��ü ������� �޿� ����
 SELECT TO_CHAR(SUM(sal+NVL(COMM,0)),'L999,999')pay
 FROM emp;
 -- ��� �޿�
 SELECT TO_CHAR(AVG(sal+NVL(comm,0)),'9999.00')avg_pay
 FROM emp;
 --��� �޿� �̻��� ������� �޿� ����(�ζ��� + ��ø �������� ���)
 SELECT SUM(t.pay)
 FROM(
        SELECT empno,ename,sal+NVl(comm,0)pay
        FROM emp
        WHERE sal+NVl(comm,0) >= (
                                    SELECT AVG(sal+NVL(comm,0)) 
                                    FROM emp)
    )t;
 --��� �޿� �̻��� ������� �޿� ����(DECODE ���)
 WITH temp AS (
 SELECT empno, ename , sal+NVl(comm,0)pay
        , (SELECT AVG(sal+NVl(comm,0)) FROM emp)avg_pay
 FROM emp
 )
 SELECT SUM(DECODE(SIGN(t.pay - t.avg_pay),-1,null,t.pay))avg_pay_total
 FROM temp t;
 --��� �޿� �̻��� ������� �޿� ����(CASE ���)
 WITH temp AS (
 SELECT empno, ename , sal+NVl(comm,0)pay
        , (SELECT AVG(sal+NVl(comm,0)) FROM emp)avg_pay
 FROM emp
 )
 SELECT SUM(CASE
                WHEN t.pay - t.avg_pay >=0 THEN t.pay             
            END
            )avg_pay_total
 FROM temp t;
 
 --��� �޿� �̻��� ������� �޿� ����(join �ȹ��)
 WITH a AS(
 SELECT TO_CHAR(AVG(sal+NVL(comm,0)),'9999.00')avg_pay
 FROM emp
 ),
 b AS (
 SELECT empno,ename,sal+NVl(comm,0)pay
 FROM emp
 )
 SELECT *
 FROM b JOIN a   -- join
 ON b.pay >= a.avg_pay;
 
 --[15]
 SELECT deptno
 FROM dept d
 WHERE (SELECT COUNT(*) FROM emp WHERE deptno = d.deptno) != 0;
 --[15-1]
 SELECT deptno
 FROM dept d
 WHERE (SELECT COUNT(*) FROM emp WHERE deptno = d.deptno) = 0;
 
 SELECT deptno
 FROM dept
 MINUS
 SELECT DISTINCT deptno
 FROM emp;
 --JOIN : ���ų� ���� �ٸ� �� �� �̻��� ���̺��� �÷��� �˻��� �� ����Ѵ�. �̶�, where���� join ������ �ۼ��Ͽ� ���̺��� �����Ѵ�.
 --�� �μ���ȣ,�μ���,�����ȣ,�����,�Ի����� ��ȸ(emp)
 SELECT e.deptno,d.dname, e.empno,e.ename,e.hiredate
 FROM emp e, dept d
 WHERE e.deptno = d.deptno;
 --GROUP BY e.deptno,d.dname;
 -- JOIN ON ���� ����
 SELECT e.deptno,d.dname ,e.empno,e.ename,e.hiredate
 FROM emp e JOIN dept d
 ON e.deptno = d.deptno;

 SELECT d.deptno,d.dname ,e.empno,e.ename,e.hiredate
 FROM emp e JOIN dept d
 ON e.deptno = d.deptno;
 --[15] join���� Ǯ��
 --  EQUI(INNER) JOIN : �� �� �̻��� ���̺� ����Ǵ� �÷����� ������ ��ġ�ϴ� ��쿡 ����ϴ� ���� �Ϲ����� join ������
 -- OUTER JOIN : 
 SELECT d.deptno,d.dname, COUNT(e.deptno)
 FROM dept d LEFT JOIN emp e ON d.deptno = e.deptno
 GROUP BY d.deptno,d.dname
 ORDER BY d.deptno;
 --
 SELECT d.deptno,d.dname, COUNT(e.deptno)
 FROM dept d LEFT JOIN emp e ON d.deptno = e.deptno
 GROUP BY d.deptno, d.dname
 HAVING COUNT(e.deptno)=0
 ORDER BY d.deptno;
 
 
 SELECT buseo, jikwi,DECODE(MOD(SUBSTR(ssn,8,1),2),1,'����','����')gender, COUNT(*)
 FROM insa
 GROUP BY buseo, jikwi, MOD(SUBSTR(ssn,8,1),2)
 ORDER BY buseo,jikwi;
 
 --[17] DECODE()
 SELECT e.*, DECODE(deptno,10,pay*1.15,20,pay*1.1,30,pay*1.05,pay*1.2)�λ�޿�
 FROM (SELECT deptno, ename, sal+NVl(comm,0)pay FROM emp)e;
 -- CASE()
 SELECT e.*, CASE deptno
                WHEN 10 THEN pay*1.15
                WHEN 20 THEN pay*1.1
                WHEN 30 THEN pay*1.05
                ELSE pay*1.2
           END �λ�޿�
 FROM (SELECT deptno, ename, sal+NVl(comm,0)pay FROM emp)e;
 
 --[18]
 SELECT COUNT(DECODE(deptno,10,1)),COUNT(DECODE(deptno,20,1)),COUNT(DECODE(deptno,30,1)),COUNT(DECODE(deptno,40,1))
 FROM emp;
 
 