-- �� ������� �޿�
-- �� ������� �� �޿� ��
-- �� ����� ��
-- �� ������� ���
SELECT SUM(sal + NVL(comm,0))pay
        , COUNT(sal + NVL(comm,0))count
        , SUM(sal + NVL(comm,0))/COUNT(sal + NVL(comm,0)) avg
        , AVG(sal + NVL(comm,0))avg_pay
        , MAX(sal + NVL(comm,0))max_oay
        , MIN(sal + NVL(comm,0))min_pay
        , STDDEV(sal + NVL(comm,0))stddev_pay --ǥ������ : �л��� ������
        , VARIANCE(sal + NVL(comm,0))variance_pay -- �л� : (����� pay - avg_pay)^2 �����
FROM emp;
-- [1]
SELECT name, ssn, NVL2(NULLIF(SUBSTR(SSN,8,1),'2'),'O','X')gender
FROM insa;
--[1-2]
WITH t AS (
SELECT name, ssn , MOd(SUBSTR(SSN,-7,1),2)gender
FROM insa
)
SELECT t.name, t.ssn, REPLACE(REPLACE(t.gender,1,'X'),0,'O')gender
FROM t;
--[1-3]
SELECT name, ssn, 'X'gender
FROM insa
WHERE SUBSTR(SSN,8,1) = '2'
UNION
SELECT name, ssn, 'O'gender
FROM insa
WHERE SUBSTR(SSN,8,1) = '1';
--[2]
SELECT name, ibsadate
FROM insa
WHERE EXTRACT(YEAR FROM ibsadate)=2000;
WHERE TO_CHAR(ibsadate,'YYYY')='2000';
WHERE ibsadate >= '2000.1.1';
--[4]
SELECT  ename, sal+NVL(comm,0)pay 
        , ROUND(avg_pay,2)avg_pay
        , CEIL((sal+NVL(comm,0)-avg_pay)*100)/100 AS "�� �ø�" 
        , ROUND(sal+NVL(comm,0)-avg_pay,2) AS "�� �ݿø�"
        , TRUNC(sal+NVL(comm,0)-avg_pay,2) AS "�� ����"
FROM emp, (SELECT AVG(sal+NVL(comm,0))avg_pay FROM emp)e;

--[4-1]
WITH e AS (
SELECT ename,sal+NVL(comm,0)pay,(SELECT AVG( sal+NVL(comm,0)) FROM emp)avg_pay FROM emp
)
SELECT  ename,pay 
        , ROUND(avg_pay,2)avg_pay
        , CEIL((pay-avg_pay)*100)/100 AS "�� �ø�" 
        , ROUND(pay-avg_pay,2) AS "�� �ݿø�"
        , TRUNC(pay-avg_pay,2) AS "�� ����"
FROM  e;

--[4-2]�����Լ�
SELECT  ename, sal+NVL(comm,0)pay 
        , ROUND(avg_pay,2)avg_pay
        , '����'
FROM emp, (SELECT AVG(sal+NVL(comm,0))avg_pay FROM emp)e
WHERE sal+NVL(comm,0) > ROUND(avg_pay,2)
UNION
SELECT  ename, sal+NVL(comm,0)pay 
        , ROUND(avg_pay,2)avg_pay
        , '����'
FROM emp, (SELECT AVG(sal+NVL(comm,0))avg_pay FROM emp)e
WHERE sal+NVL(comm,0) < ROUND(avg_pay,2);
--[4-2]
SELECT  ename, sal+NVL(comm,0)pay 
        , ROUND(avg_pay,2)avg_pay
        , NVL2(TO_CHAR(NULLIF(SIGN((sal+NVL(comm,0)-avg_pay)),-1)),'����','����')AS "�޿�-��ձ޿�"
FROM emp, (SELECT AVG(sal+NVL(comm,0))avg_pay FROM emp)e;

--[4-2-1]
SELECT ename, pay, ROUND(avg_pay)avg_pay, NVL2(NULLIF(SIGN(pay-avg_pay),-1),'����','����') as "pay-avg_pay"
FROM (SELECT ename,sal+NVL(comm,0)pay,(SELECT AVG( sal+NVL(comm,0)) FROM emp)avg_pay FROM emp)e;
--[5]
SELECT CEIL(154/15)
FROM dual;
--[5-2]
SELECT CEIL(COUNT(*)/14)
FROM insa;
--[6] max() min()
SELECT empno,ename,job,MGR,hiredate, nvl(sal+comm,sal)PAY,deptno 
FROM emp 
where nvl(sal+comm,sal)IN((SELECT MAX(nvl(sal+comm,sal)) FROM emp), (SELECT MIN(nvl(sal+comm,sal)) FROM emp));
--[6] union ����ؼ� �ϱ�

--[6] all������
SELECT empno,ename,job,MGR,hiredate, nvl(sal+comm,sal)PAY,deptno 
FROM emp 
WHERE nvl(sal+comm,sal) >= ALL(SELECT nvl(sal+comm,sal) FROM emp)
OR  nvl(sal+comm,sal) <= ALL(SELECT nvl(sal+comm,sal) FROM emp);
--[7]
SELECT ENAME, SAL,COMM
FROM emp
WHERE NVL(comm,0)<=400;
--[7-2] LNNVL() LNNVL(condition)
--Where ���� ������ true�̰ų� UNKNOWN�̸� FALSE�� ��ȯ�ϰ� ������ false�̸� TRUE�� ��ȯ�Ѵ�

true -> false
null -> false
false -> true
;
SELECT ENAME, SAL,COMM
FROM emp
WHERE LNNVL(comm>400);

--[8]
select dname, ename, sal
from emp e, dept d
where (e.deptno, sal) in((select deptno, max(sal)
                            from emp e1
                            group by deptno))
and  e.deptno = d.deptno;

SELECT MAX(sal+NVL(comm,0))max_pay
FROM emp
GROUP BY deptno
ORDER BY deptno;

--[8-1]
SELECT *
FROM emp
WHERE sal in((SELECT max(sal)FROM emp GROUP BY deptno));
--[8-3] ������� ����
SELECT *
FROM emp e
WHERE sal + NVL(comm,0) = (SELECT MAX(sal + NVL(comm,0)) FROM emp WHERE e.deptno = deptno);


--[8-2]groub by �Ⱦ���? union�̳� and or ���� ���� �ɵ�?

--[9]
SELECT SUBSTR('031)1234-5678',INSTR('031)1234-5678',')')+1,INSTR('031)1234-5678','-')-INSTR('031)1234-5678',')')-1)
FROM dual;
--[12]
SELECT deptno, ENAME, sal+NVL(comm,0)PAY, ROUND(sal+NVL(comm,0),-2)/100 BAR_LENGTH,
        LPAD(' ',ROUND(sal+NVL(comm,0),-2)/100+1,'#')
FROM emp
WHERE deptno = 30
ORDER BY pay desc;
--[13]
SELECT name, ssn, RPAD(SUBSTR(ssn,1,8),length(ssn),'*')
FROM insa;
--[14]
SELECT SYSDATE -- ����Ŭ ��¥ DATE   23/08/29
      , SYSTIMESTAMP -- ����Ŭ ��¥ TIMESTAMP    23/08/29 14:29:49.396000000 +09:00
      , TRUNC( SYSDATE, 'YEAR' ) -- 23/01/01
      , TRUNC( SYSDATE, 'MONTH' )      --23/08/01
      , TRUNC( SYSDATE  ) --23/08/29 : �ð�,��,�� ����
FROM dual;
--TRUNC() : ���� �Լ�, ����, ��¥, Ư�� ��ġ���� ����
--FLOOR() : ���� �Լ�, ����, �Ҽ��� 1��° �ڸ����� ����

--[15]
WITH e AS (
SELECT ename,sal,comm,sal+NVL(comm,0)pay,(SELECT AVG( sal+NVL(comm,0)) FROM emp)avg_pay FROM emp
)
SELECT  SUM(pay)
FROM e
WHERE pay>=avg_pay;
--[16]
WITH e AS (
SELECT ename,sal+NVL(comm,0)pay ,5000 max_pay FROM emp
)
SELECT  ename,pay, max_pay, TO_CHAR(pay/max_pay*100)||'%' AS "�ۼ�Ʈ"
        , ROUND(pay/max_pay*100,-1)/10"�� ����"
       , LPAD(' ',ROUND(pay/max_pay*100,-1)/10+1,'*')"�����"
FROM e;
----- ����
WITH e AS (
SELECT  ename,sal+NVL(comm,0)pay 
        ,(SELECT MAX(sal+NVL(comm,0))FROM emp) max_pay
        , ((sal+NVL(comm,0))/5000)*100 AS percent 
FROM emp
)
SELECT  ename,pay, max_pay, TO_CHAR(percent)||'%' AS "�ۼ�Ʈ"
        , ROUND(percent,-1)/10"�� ����"
        , LPAD(' ',ROUND(percent,-1)/10+1,'*')"�����"
        , RPAD( ROUND(percent,-1)/10,ROUND(percent,-1)/10+length(ROUND(percent,-1)/10),'*')"������+�����"
FROM e;

--���� : emp���̺��� pay ������ ��� �ű��
SELECT t.*, (SELECT count(*)+1 FROM emp e where t.pay < e.sal+NVL(e.comm,0))pay_rank
FROM (SELECT ename, sal+NVL(comm,0)pay FROM emp)t
ORDER BY pay_rank;

----------------
--��¥ �Լ�
--[1]SYSDATE : ��/��/�� �ð�/��/�� ��ȯ �⺻����� �ϱ��� TO_CHAR(date,'����')�� ����� �ð�/��/�� ���
SELECT SYSDATE  --23/08/29
    , TO_CHAR(SYSDATE,'YYYY/MM/DD AM HH24:MI:ss (DAY)')  -- 22023/08/29 ���� 15:40:22 (ȭ����)
    , TO_CHAR(SYSDATE,'DS TS')  -- 2023/08/29 ���� 3:32:35
     , TO_CHAR(SYSDATE,'DL')    -- 2023�� 8�� 29�� ȭ����
FROM dual;
-- �� �� ��� ° �� ww,  �� �� ��� ° �� w,  �� �� ��� ° �� : iw
SELECT SYSDATE
    , TO_CHAR(SYSDATE, 'WW') --  35 7�ϴ���
    , TO_CHAR(SYSDATE, 'IW') -- 35  ���� ����
    , TO_CHAR(SYSDATE, 'W') -- 5
FROM dual;
-- [2]ROUND(��¥,[����]) : ���� �ݿø��� �� ������ ������ ������ ������ ����ϰ�, ���� �� ���� �� �� ������ ����Ѵ�. 
--                    ���� �ݿø��ϴ� ���� 15�� �̻��̸� ���� �� 1���� ����ϰ�, ���� ������ ���� �� 1���� ����Ѵ�. 
--                    ���� �ݿø��ϴ� ��쿡�� 6���� ������ ������ 1��1���� ����ϰ�, ���� ������ �� �� 1��1���� ����Ѵ� .
SELECT SYSDATE
        , TO_CHAR(SYSDATE,'DL TS')  -- 2023�� 8�� 29�� ȭ���� ���� 3:46:32
        ,ROUND(SYSDATE) -- 23/08/30  12��(����)�� ������ �ݿø��Ͽ� 30�� 
        ,ROUND(SYSDATE,'DD')    -- 23/08/30
        ,ROUND(SYSDATE,'MONTH') --23/09/01
        ,ROUND(SYSDATE,'YEAR') --24/01/01
FROM dual;

--[2]TRUNC(date) ���� �����ϸ� �׳� ������ ����ϰ�, ���� �����ϸ� �� �� 1���� ����ϰ�, ���� �����ϸ�, �ݳ� 1��1���� ����Ѵ�.
-- ������ ROUND�� ����
SELECT SYSDATE
        , TO_CHAR(SYSDATE,'DL TS')  -- 2023�� 8�� 29�� ȭ���� ���� 3:46:32
        ,TRUNC(SYSDATE) -- 23/08/29
        ,TRUNC(SYSDATE,'DD')    -- 23/08/29
        ,TRUNC(SYSDATE,'MONTH') --23/08/01
        ,TRUNC(SYSDATE,'YEAR') --23/01/01
FROM dual;
--[3]MONTHS_BETWEEN(date1,date2) �� ���� ��¥���� �������� ����
    ����       ���      �� �� 
��¥ + ����  =  ��¥ ��¥�� �ϼ��� ���Ͽ� ��¥ ��� 
��¥ - ����  =  ��¥ ��¥�� �ϼ��� ���Ͽ� ��¥ ��� 
��¥ + ����/24 = ��¥ ��¥�� �ð��� ���Ͽ� ��¥ ��� 
��¥ - ��¥  =  �ϼ�  ��¥�� ��¥�� ���Ͽ� �ϼ� ��� 
;
-- emp ������� �ٹ��ϼ�, �ٹ�������, �ٹ����
SELECT ename, hiredate
        , SYSDATE
        , ROUND(SYSDATE - hiredate)�ٹ��ϼ� -- ��¥ - ��¥ = �ϼ�
        , ROUND(MONTHS_BETWEEN(SYSDATE,hiredate),1)�ٹ�����
        , ROUND(MONTHS_BETWEEN(SYSDATE,hiredate)/12,1) �ٹ����
FROM emp;
 -- 1�ð���
 SELECT SYSDATE
        , TO_CHAR(SYSDATE, 'TS') --���� 4:15:25
        , SYSDATE +1  --�Ϸ� ��
        , SYSDATE + 10 -- 23/09/08 10�� ��
        , TO_CHAR(SYSDATE + 1/24,'TS') --���� 5:15:25
 FROM dual;
 -- [4]ADD_MONTHS(date, month) :  Ư�� ���� ���� ���� ��¥�� ����ϴ� �Լ�
SELECT SYSDATE --23/08/29
        , ADD_MONTHS(SYSDATE,3) -- 23/11/29 3���� ��
        , ADD_MONTHS(SYSDATE,-1) -- 23/07/29 1���� ��
FROM dual;
 --[5]LAST_DAY(date) : �ش� ��¥�� ���� ���� ������ ��¥�� ��ȯ
 SELECT SYSDATE a--23/08/29
        , LAST_DAY(SYSDATE) -- 23/08/31 ���� ��¥�� �ִ´��� ������ ��¥
        , TO_CHAR(LAST_DAY(SYSDATE),'DD DY') -- 31 �� �̹� ���� ������ ��¥�� ����
        , TO_CHAR(TRUNC(SYSDATE,'MONTH'),'DY') -- �̹��� 1���� ���� ȭ
        --, TO_CHAR(LAST_DAY(ADD_MONTHS(SYSDATE,-1))+1,'DY')
 FROM dual;
 -- [6]NEXT_DAY(date,char) date�κ��� �� ������ char�� ����� ������ ���
 SELECT TO_CHAR(SYSDATE,'DL') -- 2023�� 8�� 29�� ȭ����
        , NEXT_DAY(SYSDATE,'�ݿ���') --23/09/01
 FROM dual;
 --datetime ����
 --CURRENT_DATE
 SELECT SYSDATE --23/08/29
        , CURRENT_DATE  --23/08/29
 FROM dual;
 
 
 
 --��ȯ �Լ��� ���� : ����ڿ� ���ؼ� ��������� ������ Ÿ���� ��ȯ���ִ� �Լ�
--[1] TO_NUMBER() ���� Ÿ���� ���� Ÿ������ ��ȯ
SELECT '100', TO_NUMBER('100')
FROM dual;
--[2] TO_CHAR() : ����, ��¥ Ÿ���� ���� Ÿ������ ��ȯ
-- TO_CHAR( n [,'fmt' [,'nlsparam']])
--[3] TO_DATE() : ����, ���� Ÿ���� ��¥ Ÿ������ ��ȯ
-- TO_DATE( char [,'fmt' [,'nlsparam']])
-- ����: ������(23.7.13(��)) �κ��� 100�� �Ǵ³�
 SELECT  TO_CHAR(TO_DATE('23.7.13(��)','YY.MM.DD(DY)')+100,'DL')
 FROM dual;
 
 --����
 --�Ϲ��Լ�
 -- DECODE() == if()
 -- DECODE(expr,  search1,result1 [,search2,result2,...] [,default] );
 -- �������� ������ �־� ���ǿ� ���� ��� �ش� ���� ��ȯ
 -- �� ������ '='�� �����ϴ�.
 -- select���� decode ����� from ���� ���� ��𿡼��� ����� �� �ִ�.
 -- PL/SQL �ȿ��� ��� �� �� �ִ� �Լ�
 -- �ڹ�
 /*
 IF (x == 10){ 
  RETURN C;
}else{
  return D
  }
����Ŭ DECODE() �Լ�
DECODE(x,10,C,D)
 
 �ڹ� else if
 if( A == B){
    return T;
 }else if(A == C){
    return F;
 }else {
    return X;
 }
 ����Ŭ DECODE() �Լ�
 DECODE(A,B,T,C,F,X)
 */
 -- insa ���̺��� �ֹε�� ��ȣ�� ������ "����" "����" ���
 SELECT name,ssn, DECODE(MOD(SUBSTR(ssn,8,1),2),1,'����','����')gender
 FROM insa;
 -- ���� emp���̺��� 10�� �μ��� �޿� 15%�λ�, 20�� �μ��� �޿� 30% �λ�, �׿ܺμ��� 5%�λ� ��� : �μ���ȣ ����� �޿� �λ�޿� �λ��
 SELECT e.*, DECODE(deptno,10,pay*1.15,20,pay*1.3,pay*1.05)�λ�޿�, DECODE(deptno,10,pay*0.15,20,pay*0.3,pay*0.05)�λ��
 FROM (SELECT deptno, ename, sal+NVl(comm,0)pay FROM emp)e;
 
  
 -- WW/W/IW����   WW = 7�� ���� IW = ��~�� ���� 