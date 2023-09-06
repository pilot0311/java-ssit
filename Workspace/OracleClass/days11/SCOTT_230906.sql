--JOIN
--join 종류

--문제) 책 id, 책제목 단가 판매수량 서점(고객) 판매금액

SELECT b.b_id, b.title, d.price,p.p_su,g.g_name, d.price*p.p_su
FROM book b, danga d, panmai p, gogaek g
WHERE b.b_id = d.b_id AND p.b_id = b.b_id AND p.g_id = g.g_id;

SELECT b.b_id, b.title, d.price,p.p_su,g.g_name, d.price*p.p_su 판매금액
FROM book b JOIN danga  d ON b.b_id = d.b_id JOIN panmai p ON p.b_id = b.b_id JOIN gogaek g ON p.g_id = g.g_id;

--문제) 출판된 책들이 각각 총 몇권이 판매 되었는지 조회
SELECT b.b_id, title, price, SUM(p_su)
FROM book b JOIN danga  d ON b.b_id = d.b_id JOIN panmai p ON p.b_id = b.b_id
GROUP BY b.b_id,b.title,d.price
ORDER BY b.b_id;

SELECT DISTINCT b.b_id, title, price, SUM(p_su)OVER(PARTITION BY b.b_id)
FROM book b JOIN danga  d ON b.b_id = d.b_id JOIN panmai p ON p.b_id = b.b_id
ORDER BY b.b_id;

--문제 책 판매된 적이 있는 책ID제목 --SEMIJOIN
SELECT b.b_id,title, price
FROM book b JOIN danga d ON b.b_id=d.b_id
WHERE EXISTS (SELECT b_id
                    FROM panmai p
                    WHERE b.b_id = p.b_id);
--문제 책 판매된 적이 없는 책ID제목 --ANTIJOIN
SELECT b.b_id,title, price
FROM book b JOIN danga d ON b.b_id=d.b_id
WHERE b.b_id NOT IN (SELECT b_id
                    FROM panmai p
                    WHERE b.b_id = p.b_id);
                    
WITH E AS (
SELECT b.B_ID as b_id, title, price 
,SUM(p_su) 총판매수
FROM book b  
LEFT JOIN danga d ON b.b_id = d.b_id
LEFT JOIN PANMAI p ON b.b_id = p.b_id
GROUP BY b.B_ID, title, price)
SELECT E.b_id, E.title
FROM E
WHERE E.총판매수 IS NULL;

-- 판매된 적이 없는 책은 0으로 포함해서 출력
SELECT b.b_id, title, price, NVL(SUM(p_su),0)총판매수량
FROM book b JOIN danga  d ON b.b_id = d.b_id LEFT JOIN panmai p ON p.b_id = b.b_id
GROUP BY b.b_id,b.title,d.price
ORDER BY b.b_id;

SELECT DISTINCT b.b_id, title, NVL(SUM(p_su)OVER(PARTITION BY b.b_id),0)총판매수량
FROM book b  LEFT JOIN panmai p ON p.b_id = b.b_id
ORDER BY b.b_id;

-- 문제 가장 판매권수가 많은 책에 대한 정보를 출력 id title 총판매 권수
-- TOP -n 방식
SELECT t.*
FROM (
SELECT b.b_id, title, SUM(p_su)총판매수량
FROM book b  JOIN panmai p ON p.b_id = b.b_id
GROUP BY b.b_id,b.title
ORDER BY NVL(SUM(p_su),0) DESC
)t
WHERE rownum <=3;
-- RANK() 방식
SELECT  b_id, title,총판매수량
FROM (
SELECT b.b_id, title, SUM(p_su)총판매수량,
        RANK()OVER(ORDER BY SUM(p_su) DESC)r
FROM book b  JOIN panmai p ON p.b_id = b.b_id
GROUP BY b.b_id,b.title
)t
WHERE r <=3;

-- 년도별 월별 판매 현황
(판매년도,판매금액);
SELECT TO_CHAR(p.p_date,'YYYY')||'년도',SUM(p.p_su),SUM(d.price*p.p_su)
FROM danga  d  JOIN panmai p ON p.b_id = d.b_id
GROUP BY TO_CHAR(p.p_date,'YYYY');

(판매년도,판매월,판매금액);
SELECT TO_CHAR(p.p_date,'YYYY')||'년도' 년도,TO_CHAR(p.p_date,'MM')||'월' 월,SUM(p.p_su)수량,SUM(d.price*p.p_su)금액
FROM danga  d  JOIN panmai p ON p.b_id = d.b_id
GROUP BY TO_CHAR(p.p_date,'YYYY'),TO_CHAR(p.p_date,'MM')
ORDER BY TO_CHAR(p.p_date,'YYYY'),TO_CHAR(p.p_date,'MM');

-- 문제 서점별 판매현황 조회
-- 년도 서점id 서점명 총판매금액
SELECT b.b_id, b.title, d.price,p.p_su,g.g_name, d.price*p.p_su 판매금액
FROM book b JOIN danga  d ON b.b_id = d.b_id JOIN panmai p ON p.b_id = b.b_id JOIN gogaek g ON p.g_id = g.g_id;

SELECT TO_CHAR(p.p_date,'YYYY')year,g.g_id,g.g_name,SUM(d.price*p.p_su)금액
FROM danga  d  JOIN panmai p ON p.b_id = d.b_id JOIN gogaek g ON p.g_id = g.g_id
GROUP BY TO_CHAR(p.p_date,'YYYY'),g.g_id,g.g_name
ORDER BY TO_CHAR(p.p_date,'YYYY'),g.g_id,g.g_name;

-- 올해 서점별 판매현황
-- 서점코드 서점명 - 판매금액합 비율(0.00)

--모든 년도
WITH t AS(
            SELECT SUM(d.price*p.p_su)r FROM danga  d  JOIN panmai p ON p.b_id = d.b_id
)
SELECT TO_CHAR(p.p_date,'YYYY')year,g.g_id,g.g_name,SUM(d.price*p.p_su)금액
    ,ROUND(SUM(d.price*p.p_su)/t.r,2)*100 AS 비율
FROM danga  d  JOIN panmai p ON p.b_id = d.b_id JOIN gogaek g ON p.g_id = g.g_id,t
GROUP BY TO_CHAR(p.p_date,'YYYY'),g.g_id,g.g_name,r
ORDER BY TO_CHAR(p.p_date,'YYYY'),g.g_id,g.g_name;
--23년도
WITH t AS(
            SELECT SUM(d.price*p.p_su)r FROM danga  d  JOIN panmai p ON p.b_id = d.b_id
            WHERE TO_CHAR(p.p_date,'YYYY') = '2023'
)
SELECT TO_CHAR(p.p_date,'YYYY')year,g.g_id,g.g_name,SUM(d.price*p.p_su)금액
    ,ROUND(SUM(d.price*p.p_su)/t.r,2)*100 AS 비율
FROM danga  d  JOIN panmai p ON p.b_id = d.b_id JOIN gogaek g ON p.g_id = g.g_id,t
WHERE TO_CHAR(p.p_date,'YYYY') = '2023'
GROUP BY TO_CHAR(p.p_date,'YYYY'),g.g_id,g.g_name,r
ORDER BY TO_CHAR(p.p_date,'YYYY'),g.g_id,g.g_name;

-- 문제 책의 총판매 금액이 15000원 이상인 책 : id 제목 단가 총판매권수 총판매 금액
SELECT b.b_id, title, price, SUM(p_su),SUM(p_su*price)
FROM book b JOIN danga  d ON b.b_id = d.b_id JOIN panmai p ON p.b_id = b.b_id
GROUP BY b.b_id,b.title,d.price
HAVING SUM(p_su*price) >=15000
ORDER BY b.b_id;

SELECT b.b_id, title, price, SUM(p_su)
FROM book b JOIN danga  d ON b.b_id = d.b_id JOIN panmai p ON p.b_id = b.b_id
GROUP BY b.b_id,b.title,d.price
HAVING SUM(p_su) >=10
ORDER BY b.b_id;
--
-- JOIN + 연산자, 함수, SQL --

--뷰(view)
-- FROM 테이블 또는 뷰
-- user_tables, user_constraints, user_users = 뷰...
-- 1) 가상테이블 : 뷰란 한개 이상의 기본 테이블이나 다른 뷰를 이용하여 생성되는 가상 테이블(virtual table)이다.
-- 2) 전체 테이터 중에서 일부만 접근할 수 있도록 제한하기 위한 기법
-- 3) 뷰는 데이터 사전 테이블에 뷰에 대한 정의만 저장하고 디스크에 저장 공간이 할당되지 않는다
--사용 이유
-- 1) 보안(security) 목적과, 사용자에게 편의성(flexibility)를 제공하기 위한 목적을 달성하기 위해서이다.
-- 뷰 만들기 위해서는 권한 필요
--권한 확인
SELECT *
FROM user_sys_privs;

-- 형식
CREATE [OR REPLACE] [FORCE | NOFORCE] VIEW 뷰이름
		[(alias[,alias]...]
	AS subquery
	[WITH CHECK OPTION]
	[WITH READ ONLY];
-- 뷰 생성
-- 매번 자주 조회 쿼리 사용
-- 복합뷰 -> DML 제한적
CREATE OR REPLACE VIEW panView
AS
SELECT b.b_id, b.title, d.price,g.g_id,g.g_name,p.p_date, p.p_su
    ,p.p_su*price amt
FROM book b JOIN danga  d ON b.b_id = d.b_id JOIN panmai p ON p.b_id = b.b_id JOIN gogaek g ON p.g_id = g.g_id
ORDER BY p.p_date DESC;

SELECT *
FROM panView;

DESC panView;
-- 뷰를 이용한 총판매 금액
SELECT SUM(amt) 
FROM panView;

-- 뷰 소스 확인: DB 객체, 쿼리저장
SELECT *
FROM user_views;

-- 뷰수정 CREATE OR REPLACE VIEW
-- 뷰ㅠ 삭제
DROP VIEW panview;

-- 문제 년도, 월, 고객코드, 판매극액합(년도별 월)
CREATE OR REPLACE VIEW gogaekView
AS
SELECT TO_CHAR(p_date,'YYYY')판매년도,TO_CHAR(p_date,'MM')판매월,
        g.g_id,g_name,SUM(p_su*price)총판매금액
FROM danga  d  JOIN panmai p ON p.b_id = d.b_id JOIN gogaek g ON p.g_id = g.g_id
GROUP BY TO_CHAR(p_date,'YYYY'),TO_CHAR(p_date,'MM'), g.g_id,g_name
ORDER BY 1,2
;

SELECT *
FROM gogaekView;
--
SELECT *
FROM tab -->user_tables
WHERE tabtype = 'VIEW';
-- 뷰: DML 작업 가능 [실습]
-- ㄴ 심플뷰 -> 실제 기존 테이블 수정
-- ㄴ 복합뷰 X

CREATE TABLE testa (
    aid NUMBER PRIMARY KEY
    ,name VARCHAR2(20) NOT NULL
    ,tel VARCHAR2(20) NOT NULL
    ,memo VARCHAR2(100)
);

CREATE TABLE testb (
    bid NUMBER PRIMARY KEY
    ,aid NUMBER CONSTRAINT fk_testb_aid REFERENCES testa(aid)
                                ON DELETE CASCADE
    ,score NUMBER(3)
);

INSERT INTO testa (aid, NAME, tel) VALUES (1, 'a', '1');
INSERT INTO testa (aid, name, tel) VALUES (2, 'b', '2');
INSERT INTO testa (aid, name, tel) VALUES (3, 'c', '3');
INSERT INTO testa (aid, name, tel) VALUES (4, 'd', '4');

INSERT INTO testb (bid, aid, score) VALUES (1, 1, 80);
INSERT INTO testb (bid, aid, score) VALUES (2, 2, 70);
INSERT INTO testb (bid, aid, score) VALUES (3, 3, 90);
INSERT INTO testb (bid, aid, score) VALUES (4, 4, 100);

COMMIT;

SELECT * FROM testa;
SELECT * FROM testb;

--단순 뷰 생성 + DML 작업
DESC testa;
CREATE OR REPLACE VIEW aView
AS
SELECT aid,name,memo
FROM testa;

-- 단순뷰 사용해서 insert 작업
--INSERT INTO aView (aid,name,memo) VALUES (5,'f','5');
--INSERT INTO testa (aid,name,memo) VALUES (5,'f','5');
--cannot insert NULL into ("SCOTT"."TESTA"."TEL") testa의 not null 제약조건 위배
--뷰 수정 memo = null 허용
CREATE OR REPLACE VIEW aView
AS
SELECT aid,name,tel
FROM testa;

INSERT INTO aView (aid,name,tel) VALUES (5,'f','5'); --1 행 이(가) 삽입되었습니다.
commit;
DELETE FROM aView WHERE aid = 5; --1 행 이(가) 삭제되었습니다.

DROP VIEW aView;  --view 삭제

--복합뷰 생성
CREATE OR REPLACE VIEW abView
AS
    SELECT a.aid,name,tel,bid,score
    FROM testa a JOIN testb b ON a.aid = b.aid
;
INSERT INTO abView (aid,name,tel,bid,score) VALUES (5,'f','5',5,5);
--오류 : 동시에 두 테이블의 내용을 각각 insert할수 없더라

INSERT INTO abView (aid,name,tel) VALUES (5,'f','5');
-- 한테이블의 내용만 수정 가능
UPDATE abView
SET score = 90
WHERE bid = 1;
ROLLBACK;
-- 수정 : 두테이블의 내용을 수정 X

DELETE FROM abView
WHERE aid = 1;

SELECT * FROM testa;
SELECT * FROM testb;
ROLLBACK;
-- 점수가 90점 이상인 뷰 생성
CREATE OR REPLACE VIEW bView
AS
    SELECT bid, aid, score
    FROM testb
    WHERE score >=90;
    -- bid 가 3인 행의 score = 70 점으로 수정
UPDATE bView
SET score = 70
WHERE bid=3;
ROLLBACK;
SELECT *
FROM bView;
-- WITH CHECK OPTION
CREATE OR REPLACE VIEW bView
AS
    SELECT bid, aid, score
    FROM testb
    WHERE score >=90
WITH CHECK OPTION CONSTRAINT CK_bView
    ;
    
UPDATE bView
SET score = 70
WHERE bid=3;
-- ORA-01402: view WITH CHECK OPTION where-clause violation 
SELECT *
FROM bView;

DROP VIEW aView;
DROP VIEW bView;
DROP VIEW abView;
DROP VIEW GOGAEKVIEW;
SELECT *
FROM tab
WHERE tabtype = 'VIEW';

-- MATERIALIZED VIEW (물리적 뷰)
-- 실제 데이터를 가지고 있는 뷰

-- [계층적 질의]--
SELECT LEVEL
FROM dual;
-- LEVEL 컬럼?
--ORA-01788: CONNECT BY clause required in this query block --CONNECT BY절 필요

SELECT LEVEL
FROM dual
CONNECT BY LEVEL <=31; --조건절

SELECT *
FROM emp;

LEVEL -> CONNECT BY -> LEVEL도움말 -> 계층적 질의
LEVEL: 계층적 질의문에서 검색된 결과에 대해 계층별로 레벨 번호를 표시하는 의사칼럼
-- 2차원 평면적인 테이블
-- 실무 -> 조직도, 족보 -> 계층적 구조 표현(저장,조회)
-- 1) 테이블: 부모-자식 컬럼 추가
-- 2) SELECT : START WITH, CONNECT BY 구문을 사용하면 계층적 질의

SELECT *
FROM emp;
-- 계층적 질의문에서 where 절의 실행은 where 절에 JOIN 식을 포함하고 있느냐에 따라 다르게 수행된다. 
-- JOIN식이 없는 경우, 우선 connect by 절을 수행한 후, where 절의 조건을 수행한다.
SELECT empno,ename,mgr,sal,LEVEL
FROM emp
WHERE mgr = 7698        -- 7698의 직속 부하 직원들
START WITH mgr IS NULL
CONNECT BY PRIOR empno = mgr; --자식 = 부모 top-down 출력형식

create table tbl_test(
    deptno number(3) not null primary key,
    dname varchar2(24) not null,
    college number(3),
    loc varchar2(10)
    );
    
INSERT INTO tbl_test VALUES        ( 101,  '컴퓨터공학과', 100,  '1호관');
INSERT INTO tbl_test VALUES        (102,  '멀티미디어학과', 100,  '2호관');
INSERT INTO tbl_test VALUES        (201,  '전자공학과 ',   200,  '3호관');
INSERT INTO tbl_test VALUES        (202,  '기계공학과',    200,  '4호관');
INSERT INTO tbl_test VALUES        (100,  '정보미디어학부', 10 , null );
INSERT INTO tbl_test VALUES        (200,  '메카트로닉스학부',10 , null);
INSERT INTO tbl_test VALUES        (10,  '공과대학',null , null);
COMMIT;

SELECT *
FROM tbl_test;

SELECT t.*,LEVEL
FROM tbl_test t
START WITH deptno = 10
CONNECT BY PRIOR deptno = college;

SELECT LPAD('ㄴ',(LEVEL-1)*3)||dname
FROM tbl_test t
START WITH dname = '공과대학'
CONNECT BY PRIOR deptno = college;
--where절 사용시 그가지만 제거되고 자식 노드는 지워지지 않는다
SELECT LPAD('ㄴ',(LEVEL-1)*3)||dname
FROM tbl_test t
WHERE dname !='정보미디어학부'
START WITH dname = '공과대학'
CONNECT BY PRIOR deptno = college;
--CONNECT BY 절 사용시 가지와 그가지의 하위 노드도 지워짐
SELECT LPAD('ㄴ',(LEVEL-1)*3)||dname
FROM tbl_test t
START WITH dname = '공과대학'
CONNECT BY PRIOR deptno = college
AND dname != '정보미디어학부';
------------------------- HR

SELECT  last_name "employee",
        [CONNECT_BY_ISCYCLE "Cycle"],
        LEVEL, 
        [SYS_CONNECT_BY_PATH(last_name, '/') "Path"]
FROM employees
WHERE LEVEL <=3 and department_id = 80
    START WITH last_name ='King'
    CONNECT BY [NOCYCLE] PRIOR employee_id = manager_id AND LEVEL <= 4
    ORDER BY "employee", "Cycle", LEVEL, "Path";

-------------------------------------
1. START WITH 최상위조건 : 계층형 구조에서 최상위 계층의 행을 식별하는 조건
2. CONNECT BY 조건 : 계층형 구조가 어떤 식으로 연결되는지를 기술하는 구문.
   PRIOR : 계층형 쿼리에서만 사용할 수 있는 연산자, '앞서의, 직전의'
   
   SELECT e.empno
        , LPAD(' ',(LEVEL-1)*4)||ename
        , LEVEL
        , SYS_CONNECT_BY_PATH(ename,'/')
        , CONNECT_BY_ROOT  ename
        , CONNECT_BY_ISLEAF
   FROM emp e, dept d
   WHERE  e.deptno = d.deptno
   START WITH e.mgr IS NULL
   CONNECT BY PRIOR e.empno = e.mgr
   ORDER SIBLINGS BY d.dname;
   
   SELECT e.empno
        , LPAD(' ',(LEVEL-1)*4)||ename
        , LEVEL
        , SYS_CONNECT_BY_PATH(ename,'/')
        , CONNECT_BY_ROOT  ename
        , CONNECT_BY_ISLEAF
   FROM emp e
   START WITH e.mgr IS NULL
   CONNECT BY PRIOR e.empno = e.mgr;
   
3. ORDER [SIBLINGS] BY : 부서명으로 정렬됨과 동시에 계층형 구조까지 보존
4. CONNECT_BY_ROOT : 계층형 쿼리에서 최상위 로우를 반환하는 연산자.
5. CONNECT_BY_ISLEAF : CONNECT BY 조건에 정의된 관계에 따라 
   해당 행이 최하위 자식행이면 1, 그렇지 안으면 0 을 반환하는 의사컬럼
6. SYS_CONNECT_BY_PATH(column, char)  : 루트 노드에서 시작해서 자신의 행까지 
   연결된 경로 정보를 반환하는 함수.
7. CONNECT_BY_ISCYCLE : 오라클의 계층형 쿼리는 루프(반복) 알고리즘을 사용한다. 
  그래서, 부모-자식 관계 잘못 정의하면 무한루프를 타고 오류 발생한다.   
  이때는 루프가 발생하는 원인을 찾아 잘못된 데이터를 수정해야 하는 데, 
  이를 위해서는 
    먼저  CONNECT BY절에 NOCYCLE 추가
    SELECT 절에 CONNECT_BY_ISCYCLE 의사 컬럼을 사용해 찾을 수 있다. 
  즉, 현재 로우가 자식을 갖고 있는 데 동시에 그 자식 로우가 부모로우 이면 1,
     그렇지 않으면 0 반환.

- 1) 7566 JONES의 mgr을 7839에서 7369로  수정;
UPDATE emp
SET mgr = 7369
WHERE empno = 7566;
-- 2)
SELECT  deptno, empno, LPAD(' ', 3*(LEVEL-1)) ||  ename
, LEVEL
, SYS_CONNECT_BY_PATH(ename, '/')
FROM emp   
START WITH  mgr IS NULL
CONNECT BY PRIOR  empno =  mgr   ;
-- 3)
ROLLBACK;
-- 4)
SELECT  deptno, empno, LPAD(' ', 3*(LEVEL-1)) ||  ename
, LEVEL
, SYS_CONNECT_BY_PATH(ename, '/')
, CONNECT_BY_ISCYCLE IsLoop
FROM emp   
START WITH  mgr IS NULL
CONNECT BY NOCYCLE PRIOR  empno =  mgr;
----------------------------------
-- 데이터 베이스 모델링 + 쿼리작성(PL/SQL)
1. 데이터베이스 모델링 정의
    - 현실 세계의 업무적인 프로세스를 물리적으로 데이터베이스화 시키는 과정
    예) 고객 주문/결제/취소 상품
    1) 현실 세계
        업무 프로세스 분석
        (업무 요구 분석서)
    2) 개념적 모델링 (ER-Diagram)
    3) 논리적 모델링 (정규화)
    4) 물리적 모델링(역 정규화) 

2. 데이터베이스 모델링 단계
    1) ***업무 분석***
        ㄱ. 관련 업무에 대한 기본 지식과 상식 필요 + (강사 1~3개월 강의)
          예) 국민은행 사이트 + 앱
                용어, 지식 필요
                회계관련 용어, 지식 (대차대조표,손실,자산 등등) 숙지
        ㄴ. 신입 사원에서 업무 처리 관련 모든 프로세스 분석
        ㄷ. 담당자 인터뷰
        ㄹ. 모든 문서(서류,장표,보고서) 파악해서 데이터로 관리 되어지는 항목 정확하게 파악 필요
        ㅁ. 백그라운드 프로세서 파악, 다양한 업무의 다양한 경우의 수를 파악
        ㅂ. 그 사용자의 [요구 분석서] 작성...
    2)
    3)
    4)