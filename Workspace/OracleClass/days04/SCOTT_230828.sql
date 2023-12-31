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
 
SELECT DISTINCT job ,(SELECT COUNT(DISTINCT job) FROM emp)job수 FROM emp;   
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

SELECT num, name,nvl(tel,'연락처 등록 안됨')as tel
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
WHERE buseo = '개발부';

SELECT  num, name, tel, nvl2(NULLIF(SUBSTR(ssn, 8, 1), '2'),'O','X' )gender
FROM insa
WHERE buseo = '개발부';

--RR/YY차이
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
--이름 속에 m 문자 포함시 *로변경
SELECT ename, REPLACE(UPPER(ename),UPPER('m'),'*')
FROM emp
--WHERE lower(ename) LIKE '%m%';
--WHERE ename LIKE CONCAT(CONCAT('%',UPPER('m')),'%');
WHERE ename LIKE '%' || UPPER('m') || '%';
--WHERE ename LIKE upper('%m%');

--문제 emp테이블 에서 ename la 대소문자 구분없이 있는 사원 조회
SELECT ename
        , REPLACE(ename, 'LA', '<span style="color:red">'||ename||'<span>')
FROM emp
--WHERE UPPER(ename) LIKE '%LA%';
WHERE REGEXP_LIKE(ename, 'la','i');
-- 정규 표현식을 사용할수 있는 함수
--regexp_like (search_string, pattern [,match_option])
--REGEXP_LIKE(ename, 'la','i'); 'i' == 대소문자 구분없음을 의미
--match_option : i(대소문자 구분X), c(대소문자 구분O), m(멀티라인), X(공백문자 무시)
--함수
--복수형(그룹)함수 (group function)
SELECT COUNT(*)
FROM emp;
-- 단일행 함수(single row function)
SELECT LOWER(ename)
FROM emp;

--
SELECT *
FROM test
--WHERE REGEXP_LIKE(name, '^[한백]');
WHERE REGEXP_LIKE(name, '강산$');

--insa 테이블에서 남자 사원만
SELECT *
FROM insa
WHERE REGEXP_LIKE(ssn,'^7\d{5}-[13579]'); 
WHERE REGEXP_LIKE(ssn,'^7.{6}[13579]'); 

--문제 insa테이블에서 성이 김씨, 이씨 만 조회
SELECT name
FROM insa
WHERE REGEXP_LIKE(name,'^[김이][가-힣]{2}');
WHERE name LIKE '김__' or name LIKE '이__';
--문제 insa테이블에서 성이 김씨, 이씨 제외 조회
SELECT name
FROM insa
WHERE REGEXP_LIKE(name,'^[^김이][가-힣]{2}');
WHERE NOT REGEXP_LIKE(name,'^[김,이].{2}');
WHERE NOT (name LIKE '김__' or name LIKE '이__');


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

--SET OPERATOR(집합 연산자)
--(1) SQL 문에서 집합 연산자를 사용하기 위해서는 집합 연산의 대상이 되는 두 테이블의 컬럼 수가 같고
--(2) 대응되는 컬럼끼리 데이터 타입이 동일해야 한다.
--(3) 컬럼이름은 달라도 상관 없으며
--(4) 집합 연산의 결과로 출력되는 컬럼의 이름은 첫 번째 select 절의 컬럼 이름을 따른다.
--(5) ORDER BY 절은 첫 번째와 두 번째 SELECT 문이 끝난 제일 후미에 넣어야 한다.
-- 종류
--  합집합: UNION, UNION ALL
--          UNION ALL은 중복된 부분 모두 출력
--          UNION은 중복된 부분 한번만 출력
--  교집합: INTERSECT
--  차집합: MINUS

--emp + insa 모든 사원 정보를 조회
SELECT empno, ename, hiredate --, deptno   -- NUMBER형
FROM emp
UNION ALL
SELECT num,name,ibsadate --, buseo -- VARCHAR 형
FROM insa;

--UNION, UNION ALL의 차이점
--(1)인사 테이블의 개발부 조회
--(2)인사 테이블의 출신 지역: 인천
SELECT name,city,buseo
FROM insa
WHERE city = '인천'  --9명(개발부 6명)
UNION ALL              --UNION = 17명    UNION ALL = 23명 (인천이거나 개발부)
SELECT name, city, buseo
FROM insa
WHERE buseo = '개발부';    --14명
--(3) INTERSECT
SELECT name,city,buseo
FROM insa
WHERE city = '인천'  --9명(개발부 6명)
INTERSECT            -- 6명 (인천이고 개발부 인사람들)
SELECT name, city, buseo
FROM insa
WHERE buseo = '개발부';    --14명
--(4) MINUS
SELECT name,city,buseo
FROM insa
WHERE city = '인천'  --9명(개발부 6명)
MINUS            -- 3명 (인천이고 개발부는 아닌 사람들)
SELECT name, city, buseo
FROM insa
WHERE buseo = '개발부';    --14명
--(5) ORDER BY 절은 첫 번째와 두 번째 SELECT 문이 끝난 제일 후미에 넣어야 한다.
SELECT name,city,buseo
FROM insa
WHERE city = '인천'  
MINUS
SELECT name, city, buseo
FROM insa
WHERE buseo = '개발부'
ORDER by name;

SELECT name, ssn, NVL2(NULLIF(MOD(SUBSTR(ssn,8,1),2),0),'O','X')gender 
FROM insa;

--집합연산자 (SET OPERATOR)
--1) 남자
-- UNION
--2) 여자
SELECT name,ssn, 'O' gender
FROM insa
WHERE MOD(SUBSTR(ssn,8,1),2)= 1
UNION
SELECT name,ssn, 'X' gender
FROM insa
WHERE MOD(SUBSTR(ssn,8,1),2)= 0;

-- IS [NOT] NAN, IS [NOT] INFINITE = 이 조건은 표현식이 무한대이거나 또는 정의되지 않은 경우에 사용되는 연산자이다. 
-- IS [NOT] NAN = NOT A NUMBER
-- IS [NOT] INFINITE : 무한대

-- 오라클 함수 정의 : ora_help function 정리
1. 오라클 함수 기능
2. 오라클 함수 종류 
--------------------
(1) 숫자 함수
    -- ROUND(number,반올림위치 양수,음수)반올림함수
    -- CEIL()올림함수
    --FLOOR()내림(절삭)함수
        ㄴTRUNC(number, 절삭할 위치 양수, 음수) 숫자값을 특정 위치에서 내림(절삭) 
        ;
        SELECT ROUND(15.193)a --15 소수점 첫번째 자리에서 반올림
                --, ROUND(15.193,0)
                , ROUND(15.193,1)b --15.2 소수점 두번째 자리에서 반올림
                --, ROUND(15.193,n) -- 소수점 n+1자리에서 반올림
                , ROUND(15.193,-1) --20 소수점 기준 왼쪽한칸(1의자리)에서 반올림
                , ROUND(15.193,-2) --0 소수점 기준 왼쪽두칸(10의자리)에서 반올림
        FROM dual;
        --지정된 숫자보다 같거나 큰 정수 중에 최소 값
        SELECT CEIL(15.193) -- 16 소수점 첫번째 자리에서 올림
                ,CEIL(15.913) --16
        FROM dual;
        --지정된 숫자보다 작거나 같은 정수 중 최대 값
        SELECT FLOOR(15.193) --15 
                ,FLOOR(15.913) --15
        FROM dual;
        -- FLOOR() 과 TRUNC() 차이
        SELECT FLOOR(15.193) --15
                ,  FLOOR(15.193*10)/10 -- 15.1
                , TRUNC(15.193) --15 == FLOOR(15.193)
                , TRUNC(15.193,1) --15.1 TRUNC는 특정 위치에서 절삭 가능
                , TRUNC(15.193,-1) --10 ROUND()반올림함수 처럼 음수도 가능
        FROM dual;
        -- 소수 3번째 자리에서 반올림하시오
        SELECT 10/3
                ,ROUND(10/3,2)
        FROM dual;
        
        --나머지 구하는 함수 MOD(), REMAINDER()
        SELECT MOD(19,4) --3
                ,REMAINDER(19,4) -- -1
        FROM dual;
        --MOD(n2,n1) = n2-n1*FLOOR(n2/n1)
        --REMAINDER(n2,n1) = n2-n1*ROUND(n2/n1)
        
        --ABS() 절대값
        --SIGN() 부호에 따라 1, -1 반환 0이면 0반환
        SELECT ABS(100), ABS(-100)
                , SIGN(100), SIGN(-100), SIGN(0) -- 1,-1,0
                , POWER(2,3)  -- 8 n1^n2
                , SQRT(2) -- n의 제곱근(ROOT)값
        FROM dual;
            
(2) 문자 함수
    -- UPPER()
    -- LOWER()
    -- INITCAP()
    -- CONCAT()
    -- SUBSTR()
    ;
    -- LENGTH() 문자열 길이
    SELECT DISTINCT job
            , LENGTH(job)
    FROM emp;
    
    -- emp테이블에서 ename에 L문자가 있는 사원 조회
    -- L 문자가 있는 위치값 조회
    -- INSTR() 특정문자가 있는 위치 조회
    -- INSTR(string, substring [, position [,occurrence])
    -- string문자열에 substring문자열을 [position부터 [occurrence번째]] 위치
    SELECT ename, INSTR(ename, 'L')
    FROM emp
    WHERE REGEXP_LIKE(ename,'l','i');
    WHERE ename LIKE '%M%';
    
    select instr('corporate floor','or') -- 2 
    , instr('corporate floor','or',4)  -- 2 4번째 위치 부터 or 
    , instr('corporate floor','or',1,3) -- 14 1번째 위치 부터 3번째 or 위치
    , instr('corporate floor','or',3,2)        -- 14 3번째 위치부터 2번째 or 위치
    , instr('corporate floor','or',-1,3) --2 뒤에서 부터 3번째 or 위치
    from dual;

    -- RPAD/LPAD == 지정된 길이에서 문자값을 채우고 남은 공간을 우(좌)측부터 특정값으로 채워 리턴한다
    -- 형식 RPAD (expr1, n [, expr2] )
    SELECT ename, sal + NVl(comm,0) pay
           -- ,LPAD(sal + NVl(comm,0),10,'*') -- 총10자리 중 출력하고 남은 자리는 왼쪽부터 *로 채움
           -- ,RPAD(sal + NVl(comm,0),10,'*')
           -- 10의자리 반올림 후 100마다 #
           , ROUND(sal + NVl(comm,0),-2)RPAY
           , ROUND(sal + NVl(comm,0),-2)/100 a
           , RPAD(' ',ROUND(sal + NVl(comm,0),-2)/100+1,'#')p
           , RPAD(ROUND(sal + NVl(comm,0),-2)/100,ROUND(sal + NVl(comm,0),-2)/100+LENGTH(ROUND(sal + NVl(comm,0),-2)/100),'#')
    FROM emp;
    -- 자바.String.trim() 앞/뒤 공백 제거하는 함수    
    --LTRIM()/RTRIM()/TRIM() 문자값 중에서 왼/오 으로 부터 특정 문자와 일치하는 문자 값 제거 
    -- 형식: RTRIM(char [,set] )
    SELECT '[' || '   admin   ' || ']'
            ,'[' || LTRIM('   admin   ') || ']' --왼쪽 공백 제거
            ,'[' || RTRIM('   admin   ',' ') || ']' -- 오른쪽 공백 제거
            ,'[' || TRIM('   admin   ') || ']' --TRIM은 2번째매개변수 사용불가
            ,'[' || LTRIM('xyxyadminxyxy','xy') || ']'  -- 왼쪽 xy제거됨
            ,'[' || RTRIM('xyxyadminxyxy','xy') || ']'  -- 오른쪽 xy제거됨
    FROM dual;
    
    --ASCII() : 문자를 아스키 코드로 반환
    --CHR() : 아스키코드를 해당하는 문자로 반환
    SELECT ASCII('A'),ASCII('a'),ASCII('0')
            ,CHR(65), CHR(97), CHR(48)
    FROM dual;
    
    -- GREATEST()/LEAST() : 나열한 숫자나 문자중 가장 큰값/작은값 반환
    SELECT GREATEST(3,5,2,4,1)
            , LEAST(3,5,2,4,1)
            , GREATEST('MBC','TVC','SBS')
    FROM dual;
    
    --REPLACE() 문자열 치환
    
    -- VSIZE() 지정된 문자열의 크기를 숫자로 반환
    SELECT VSIZE('a'), VSIZE('한')  --영어 1바이트 한글 3바이트
    FROM dual;
    
    
(3) 날짜 함수
(4) 변환 함수
(5) 일반 함수
    - 정규 표현식 함수
(6) 집계 함수
--------------------

