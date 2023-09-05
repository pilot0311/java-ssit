-- 오라클 자료형
-- 1) CHAR
    - 고정 길이
    - CHAR(size BYTE|CAHR)
      CHAR == CHAR(1)
      CHAR(10)
      CHAR(10 byte)
      CHAR(10 char)    
      기본값 : 1
      size크기의 고정길이 문자 데이터
      1바이트 ~ 2000바이트
      한글(3바이트) 영어 (1바이트)
      
-- 2) NCHAR[(size)] ==N(UNICODE) + CHAR
    - NCHAR[(size)] --> 문자
    - 기본1문자, 최소 1문자
    - 최대 2000bytes
    - 고정 길이
    예) NCHAR(20) -> 20문자 저장가능 2문자 저장하더라도 남은공간 가지고있음
    - NCHAR() -> NCHAR(1) 1문자
    - 단위(byte)X
    create table test (
                aa char(3),    -- char(3 byte)
                bb char(3 char),  --> 3문자
                cc nchar(3));   --> 3문자

    INSERT INTO test(aa,bb,cc) values('홍길동','홍길동','홍길동');
--ORA-12899: value too large for column "SCOTT"."TEST"."AA" (actual: 9, maximum: 3) aa칼럼  최대 3바이트 입력 9바이트 에러
    INSERT INTO test(aa,bb,cc) values('홍','홍길동','홍길동'); -- 에러 없음
    
-- 고정길이: CHAR, NCHAR : 최대크기 2000byte
    -- 문자열 크든작든 고정된 길이 할당

-- 가변길이
-- 3) VARCHAR2(size[BYTE ? CHAR])
-- 최대 크기: 4000byte , 가변길이
-- 사용할 최대값을 선언해야 함
-- 가변길이 데이터입력 컬럼으로 선언되며, 입력되는 데이터가 선언된 용량보다 작으면, 공간이 줄어들고, 
-- 선언된 용량보다 입력되는 데이터량이 더 크면 에러를 반환한다.
예) 고정길이/가변길이
    name CHAR(10 CHAR)      -> 3글자 입력시 남은 공간 공백으로 채움
    name VARCHAR2(10 CHAR)  -> 10개의 공간 잡은후 3글자 입력시 남은공간 반환함
                    ㄴ 최대 문자열의 길이
    VARCHAR2(10) = VARCHAR2(10 byte)
    VARCHAR2  = VARCHAR2(1) = VARCHAR2(1 byte)
    
-- 4) NVARCHAR2(size)
    -- N + VARCHAR2
    -- NVARCHAR2 데이터타입은 오직 unicode 데이터타입에만 사용된다.
    -- NVARCHAR2로 선언된 컬럼은 캐릭터만 정의할 수 있다, 바이트로는 않됨
    
-- 5) LONG - 오라클: 문자 자료형, 최대값: 2GB, 가변길이
-- 긴 문장을 저장하는데 쓰이며, 저장된 문장은 select 문에서 기본적으로 80문자만 보이므로 set long 500처럼 설정을 변경해야 보인다.

-- 6) NUMBER[(p[,s])] 숫자를 나타내는 자료형(정수,실수)
--      NUMPER
--      NUMBER(p) : precision : 정확도 : 전체 자릿수 1~38
--      NUMBER(p,s) : scale : 수수점 자리 이하 자리수 : -83~127
--      NUMBER(4): 정수
--      NUMBER(5,2): 실수
--  예)  NUMBER(3,7): -> 0.0000[][][]
--      KOR NUMBER == NUMBER(38,127)
--      kor NUMBER(3) == kor NUMBER(3,0)
CREATE table tbl_number(
    kor NUMBER(3),      -- -999 ~ 999   제약조건(0~100)
    eng NUMBER(3,0),
    mat NUMBER(3),
    tot NUMBER(3),
    avg NUMBER(5,2)
);

INSERT INTO tbl_number (kor,eng,mat,tot,avg) VALUES(90.89,85,100);
   -- ORA-00947: not enough values 입력된 값 부족
INSERT INTO tbl_number (kor,eng,mat) VALUES(90.89,85,100);
-- 91	85	100		 -> 90.89-> 반올림 되어서 91
INSERT INTO tbl_number (kor,eng,mat) VALUES(90,85,300);
INSERT INTO tbl_number (kor,eng,mat) VALUES(90.89,85,-999);
INSERT INTO tbl_number (kor,eng,mat) VALUES(80,75,30);

-- [PL?SQLfor/while 반목문-> 국영수 랜덤한 0~100정수
INSERT INTO tbl_number (kor,eng,mat) VALUES(TRUNC(dbms_random.value(0,101)),
                                            TRUNC(dbms_random.value(0,101)),
                                            TRUNC(dbms_random.value(0,101)));

-- 모든 학생의 총점, 평균 계산(UPDATE)
UPDATE tbl_number
SET tot = kor+eng+mat, avg = (kor+eng+mat)/3;
-- 한 학생의 성적 수정
UPDATE tbl_number
--SET avg = 999.1234567
SET avg = 99999
-- ORA-01438: value larger than specified precision allowed for this column : 지정된 범위보다 큼
WHERE avg = 92;     --고유한 키 (primary key) 학번
-- 999.12
desc emp;
desc dept;

-- 7) FLOAT(p) == NUMBER

-- 8) DATE 날짜 + 시간(초) 7byte
        TIMESTAMP
    예) 학생정보를 저장하고 관리하는 테이블 생성
    학번 : NUMBER(7) 또는 (CHAR) 고정길이 한글x, var X
    이름 : 가변길이 NVARCHAR2(10) 한글 10문자 까지 저장
                    테이블 수정(칼럼 크기)
    국,영,수,총 : NUMBER(3) + 체크 제약조건(0~100 정수)
    평균 : NUMBER(5,2) --100.00
    등수 : NUMBER(3)
    생일 : 닐찌  [DATE], TIMESTAMP X
    주민등록 번호: CHAR(14), NCHAR X
    
-- 9) TIMESTAMP : DATE 확장
        TIMESTAMP(6) == TIMESTAMP
        TIMESTAMP(0)
        TIMESTAMP(9)
        
-- 10) 2진 데이터(0,1) RAW(size), LONG RAW
--      2RAW의 최대값은 2000바이트로 반드시 size를 기술해야 하며 LONG RAW는 2GB까지 지원
    예) 이미지 파일, 실행 파일 -> 2진 데이터 -> DB 저장
    
-- 11) BLOB : Binary Large OBject
--      Binary 데이터를 4GB까지 저장 
--      BFILE : Binary 데이터를 외부에 file형태로 (264 -1바이트)까지 저장

-- 12) CLOB: Character 데이터를 4GB까지 저장    --글내용
--     NCLOB: Unicode 데이터를 4GB까지 저장

-- COUNT OVER() : 질의한 행의 누적된 결과값을 반환
SELECT buseo,name, basicpay
    --, COUNT(*)OVER(ORDER BY basicpay ASC)
    , COUNT(*)OVER(PARTITION BY buseo ORDER BY basicpay ASC)
FROM insa;

SELECT buseo,name, basicpay
  --  , SUM(basicpay)OVER(ORDER BY basicpay ASC)
    , SUM(basicpay)OVER(PARTITION BY buseo ORDER BY basicpay ASC)
FROM insa;

-- 각 지역별 급여 평균과 나의 급여액의 차이

SELECT city, name, basicpay
    , AVG(basicpay)OVER(PARTITION BY city ORDER BY city)
    , basicpay - AVG(basicpay)OVER(PARTITION BY city ORDER BY city)
FROM insa

-- 테이블 생성, 수정, 삭제
-- 테이블 레코드(행,로우)를 추가 수정 삭제

-- 1) 테이블? : 데이터 저장소
-- 2) DB 모델링 -> 테이블 생성
예) 게시판의 게시글을 저장할 테이블 생성
    1) 테이블명: tbl_board
    2)            컬럼명       자료형         크기                       NULL 허용            설명
        글번호(PK) seq         숫자(정수)      NUMBER(38)                 NOT NULL          게시글 작성된 순서
        작성자     writer      문자           VARCHAR2(20 BYTE)          NOT NULL              
        비밀번호   passwd       문자           VARCHAR2(15)               NOT NULL
        제목      title        문자           VARCHAR2(100)              NOT NULL
        내용      content      문자           CLOB                      
        작성일    regdate      날짜            DATE                      DEFAULT SYSDATE
        등등
    3) 게시글을 구분할 수 있는 고유한 키 : 글번호
    4) 필수 입력 사항: NOT NULL(NN) 제약조건,
    5) 작성일은 현재 시스템의 날짜,시간 정보로 자동 입력: 
형식
 CREATE [GLOBAL TEMPORARY] TABLE [schema.] table
      ( 
        열이름  데이터타입 [DEFAULT 표현식] [제약조건] 
       [,열이름  데이터타입 [DEFAULT 표현식] [제약조건] ] 
       [,...]  
      ); 

      
CREATE TABLE TBL_BOARD
      ( 
       seq      NUMBER(38)                  NOT NULL PRIMARY KEY ,
       writer   VARCHAR2(20 BYTE)           NOT NULL,
       passwd   VARCHAR2(15)                NOT NULL,
       title    VARCHAR2(100)               NOT NULL,
       content  CLOB,                      
       regdate  DATE        DEFAULT SYSDATE
      ); 
desc tbl_board;

-- 조회수 컬럼x - 테이블 생성 후 새로운 컬럼 추가
-- 테이블 수정
-- ALTER TABLE (DDL)
-- CREATE TABLE(DDL)
-- DROP TABLE (DDL)

? alter table ... add 컬럼  또는 제약조건                   -- 새로운 컬럼을 테이블에 추가
컬럼 추가시 테이블의 행이 존재한다면, 새로 추가되는 컬럼은 이미 존재하는 모든 행의 값은 NULL로 초기화한다.
? alter table ... modify 컬럼                 -- 컬럼을 테이블에서 수정
? alter table ... drop[constraint] 제약조건    --제약 조건을 테이블에서 삭제
? alter table ... drop column 컬럼            -- 컬럼을 테이블에서 삭제
;
INSERT INTO tbl_board (seq,writer,passwd,title,content,regdate)
                VALUES(1,'admin','1234','test -1','test -1',SYSDATE);
INSERT INTO tbl_board (seq,writer,passwd,title,content,regdate)
                VALUES(2,'admin','1234','test -2','test -2',SYSDATE);

--ORA-00001: unique constraint (SCOTT.SYS_C007017) violated : 유일성 제약 조건위배: pk(seq)는 중복될 수 없음
INSERT INTO tbl_board VALUES(4,'pilot','1234','test -4','test -4',SYSDATE);
-- 테이블 컬럼 순서대로 VALUE()코딩
commit;
SELECT *
FROM tbl_board;
--tbl_board의 제약 조건 모두 조회
SELECT *
FROM user_constraints
WHERE table_name LIKE UPPER('%board');

-- 조회수 컬럼x - 테이블 생성 후 새로운 컬럼 추가
-- 컬럼 추가시 테이블의 행이 존재한다면, 새로 추가되는 컬럼은 이미 존재하는 모든 행의 값은 NULL로 초기화한다.
--  DEFAULT값을 줄경우 이미 존재하는 행도 DEFAULT값으로 초기화 됨
-- readed NUMBER
ALTER TABLE tbl_board ADD readed NUMBER DEFAULT 0;
SELECT *
FROM tbl_board;

-- 1) 게시글 작성(INSERT 문) content X readed 0 DATE SYSDATE 
INSERT INTO tbl_board (writer, seq, title, passwd)
             VALUES('pilot',(SELECT NVL(MAX(seq),0)+1 FROM tbl_board), 'test -5', '1234');
COMMIT;
SELECT *
FROM tbl_board;

-- 2) content가 null인 경우 -> '냉무' 게시글 수정
--ORA-00932: inconsistent datatypes: expected - got CLOB
UPDATE tbl_board 
SET content = '냉무'
WHERE content IS NULL;  --where절 없으면 모든 레코드를 수정

-- 3) pilot 작성자의 모든 게시글을 삭제
DELETE FROM tbl_board
where writer = 'pilot';

-- 4) 컬럼의 자료형의 크기 수정
--ALTER TABLE ... MODIFY
-- 변경 대상 컬럼에 데이터가 없거나 null 값만 존재할 경우에는 size를 줄일 수 있다.
-- 컬럼 크기의 변경은 저장된 데이터의 크기보다 같거나 클 경우에만 가능하다.
-- NOT NULL 컬럼인 경우에는 size의 확대만 가능하다.
-- 컬럼의 기본값 변경은 그 이후에 삽입되는 행부터 영향을 준다.
DESC tbl_board;
--WRITER  NOT NULL VARCHAR2(20) -> 40
형식
ALTER TABLE 테이블명
        MODIFY (컬럼명 datatype [DEFAULT 값]
               [,컬럼명 datatype]...);

SELECT MAX(VSIZE(writer)) --5
FROM tbl_board;

ALTER TABLE tbl_board MODIFY (writer VARCHAR2(40));

-- 5) title 컬럼명 수정 -> subject
ALTER TABLE tbl_board
RENAME COLUMN title TO subject;

-- 6) bigo 컬럼 추가(기타 사항) -> bigo 삭제
ALTER TABLE tbl_board
ADD bigo VARCHAR2(100);

DESC tbl_board;
SELECT *
FROM tbl_board;

-- ALTER TABLE ... DROP COLUMN: 테이블을 삭제하는 것이 아니라, 특정 테이블의 컬럼이나 constraint를 삭제할 때 사용한다
    ? 컬럼을 삭제하면 해당 컬럼에 저장된 데이터도 함께 삭제된다.
    ? 한번에 하나의 컬럼만 삭제할 수 있다.
    ? 삭제 후 테이블에는 적어도 하나의 컬럼은 존재해야 한다.
    ? DDL문으로 삭제된 컬러은 복구할 수 없다.

ALTER TABLE tbl_board
DROP COLUMN bigo;

DROP TABLE tbl_board;

-- 7) 테이블명을 수정
RENAME 테이블명 TO 테이블명
-----------------------------
-- 2) 테이블을 생성하는 방법: 서브쿼리(subquery)를 이용한
    ㄱ. 이미 기존에 테이블 존재 + 레코드(행)존재
    ㄴ. subquery사용 해서 테이불 생성
    ㄷ. (1)테이블 생성 + (2) 데이터 복사 + (3)제약조건 복사X (NN은 복사됨)
    ㄹ. 
    ;
    
CREATE TABLE tbl_emp(empno,ename,job,hiredate,mgr,pay,deptno    )
AS
(
SELECT empno,ename,job,hiredate,mgr,sal+NVL(comm,0)pay,deptno    
FROM emp
);
DESC tbl_emp;
SELECT *
FROM tbl_emp;

-- 제약 조건 복사 X
SELECT *
FROM user_constraints
WHERE table_name = 'TBL_EMP';

-- 서브쿼리를 이용해서 테이블 생성 + 데이터 복사 X(테이블의 구조만 복사)
CREATE TABLE tbl_emp
AS
SELECT *
FROM emp
WHERE 1 = 0;

SELECT *
FROM tbl_emp;

DROP TABLE tbl_empgrade;
COMMIT;

-- 문제 dept, dname,empno,ename,hiredate,pay,grade
-- tbl_empgrade
CREATE TABLE tbl_empgrade (dept, dname,empno,ename,hiredate,pay,grade)
AS
SELECT e.deptno, d.dname,e.empno,e.ename,e.hiredate,sal+NVL(comm,0) pay,s.grade
FROM emp e,dept d,SALGRADE s 
WHERE e.deptno = d.deptno AND sal+NVL(comm,0) BETWEEN s.losal AND s.hisal;

SELECT *
FROM tbl_empgrade;
COMMIT;

-- INSERT
INSERT INTO 테이블명 [(칼럼명,...)] VALUES (컬럼값 ...);
DML - COMMIT(완료), ROLLBACK(취소)
--
--Multi + table insert 문
-- 하나의 insert 문으로 하나의 테이블에 하나의 행(row)만을 입력하지 않고 하나의 insert 문으로 여러 개의 테이블에 동시에 하나의 행을 입력하는 것이다.
-- 종류
-- 1) unconditional insert all
-- 2) conditional insert all 
-- 3) conditional first insert
-- 4) pivoting insert 

-- 1) unconditional insert all
Unconditional insert all 문은 조건과 상관없이 기술되어진 여러 개의 테이블에 데이터를 입력한다.

? 서브쿼리로부터 한번에 하나의 행을 반환받아 각각 insert 절을 수행한다.
? into 절과 values 절에 기술한 컬럼의 개수와 데이터 타입은 동일해야 한다.

【형식】
	INSERT ALL | FIRST
	  [INTO 테이블1 VALUES (컬럼1,컬럼2,...)]
	  [INTO 테이블2 VALUES (컬럼1,컬럼2,...)]
	  .......
	Subquery;

여기서 
 ALL : 서브쿼리의 결과 집합을 해당하는 insert 절에 모두 입력
 FIRST : 서브쿼리의 결과 집합을 해당하는 첫 번째 insert 절에 입력
 subquery : 입력 데이터 집합을 정의하기 위한 서브쿼리는 한 번에 하나의 행을 반환하여 각 insert 절 수행
-- 예) 

CREATE TABLE dept_10 AS (SELECT * FROM dept WHERE 1=0);
CREATE TABLE dept_20 AS (SELECT * FROM dept WHERE 1=0);
CREATE TABLE dept_30 AS (SELECT * FROM dept WHERE 1=0);
CREATE TABLE dept_40 AS (SELECT * FROM dept WHERE 1=0);

INSERT ALL
    INTO dept_10 VALUES(deptno,dname,loc)
    INTO dept_20 VALUES(deptno,dname,loc)
    INTO dept_30 VALUES(deptno,dname,loc)
    INTO dept_40 VALUES(deptno,dname,loc)
SELECT deptno,dname,loc FROM dept;

SELECT *
FROM emp;
ROLLBACK;
emp_10, emp_20, emp_30, emp_40 테이블 생성 후
emp을 select 조회하는 서브 쿼리에서 각 부서별로 4개의 각각의 테이블에 insert
CREATE TABLE emp_10 AS (SELECT * FROM emp WHERE 1=0);
CREATE TABLE emp_20 AS (SELECT * FROM emp WHERE 1=0);
CREATE TABLE emp_30 AS (SELECT * FROM emp WHERE 1=0);
CREATE TABLE emp_40 AS (SELECT * FROM emp WHERE 1=0);

-- 조건이 있는 다중 테이블 인서트 문
2) conditional insert all 
--INSERT ALL
3) conditional first insert
INSERT FIRST
   WHEN deptno = 10 THEN
    INTO emp_10 VALUES(empno,ename,job,mgr,hiredate,sal,comm,deptno)
    WHEN deptno = 20 THEN
    INTO emp_20 VALUES(empno,ename,job,mgr,hiredate,sal,comm,deptno)
    WHEN deptno = 30 THEN
    INTO emp_30 VALUES(empno,ename,job,mgr,hiredate,sal,comm,deptno)
    ELSE
    INTO emp_40 VALUES(empno,ename,job,mgr,hiredate,sal,comm,deptno)
SELECT * FROM EMP;

SELECT * 
FROM emp_40;
ROLLBACK;

-- INSERT ALL / INSERT FIRST 차이점
-- ALL : 만족하는 모든 insert 실행
-- FIRST : 만족하는 첫번째 insert 실행
INSERT FIRST
  WHEN deptno = 10 THEN
    INTO emp_10 VALUES(empno,ename,job,mgr,hiredate,sal,comm,deptno)
  WHEN job = 'CLERK' THEN
    INTO emp_20 VALUES(empno,ename,job,mgr,hiredate,sal,comm,deptno)
  ELSE
    INTO emp_40 VALUES(empno,ename,job,mgr,hiredate,sal,comm,deptno)
SELECT * FROM emp;

SELECT * FROM emp WHERE job = 'CLERK' AND deptno = 10;
ROLLBACK;
SELECT * FROM emp_40;

-- 4) pivoting insert

create table sales(
    employee_id       number(6),
    week_id            number(2),
    sales_mon          number(8,2),
    sales_tue          number(8,2),
    sales_wed          number(8,2),
    sales_thu          number(8,2),
    sales_fri          number(8,2));
    
insert into sales values(1101,4,100,150,80,60,120);

insert into sales values(1102,5,300,300,230,120,150);
commit;

create table sales_data(
    employee_id        number(6),
    week_id            number(2),
    sales              number(8,2));
    
SELECT * FROM sales;
SELECT * FROM sales_data;

insert all
    into sales_data values(employee_id, week_id, sales_mon)
    into sales_data values(employee_id, week_id, sales_tue)
    into sales_data values(employee_id, week_id, sales_wed)
    into sales_data values(employee_id, week_id, sales_thu)
    into sales_data values(employee_id, week_id, sales_fri)
    select employee_id, week_id, sales_mon, sales_tue, sales_wed,
           sales_thu, sales_fri
    from sales;

SELECT * FROM sales_data;

SELECT *
FROM emp_40;
DELETE FROM emp_10;  --> emp_10의 모든 행 삭제 
TRUNCATE TABLE emp_20;  --> emp_20의 모든 행 삭제 + commit
DROP TABLE emp_30; --> 테이블 자체를 삭제

-- 문제 insa 테이블에서 num, name 컬럼만을 복사 해서 새로운 tbl_score 테이블 생성
(num<=1005);
CREATE TABLE tbl_score (num, name)
AS
SELECT num,name
FROM insa
WHERE num <= 1005;

SELECT *
FROM tbl_score;

-- 문제 tbl_score 테이블에 국영수 총 평 등 등급 컬럼 추가
(조건 총점은 기본값 0), grade - char(1 char);
ALTER TABLE tbl_score ADD (kor NUMBER(3) DEFAULT 0, 
                            eng NUMBER(3) DEFAULT 0,
                            mat NUMBER(3) DEFAULT 0,
                            tot NUMBER(3) DEFAULT 0,
                            avg NUMBER(5,2) DEFAULT 0,
                            grade CHAR(1 char),
                            rank NUMBER(3));
                         

DESC tbl_score;
SELECT *
FROM tbl_score;
-- 문제 1001 -1005명 학생의 kor,eng,mat,점수를 임의의 점수로 업데이트
;
UPDATE tbl_score SET
                kor = FLOOR(dbms_random.value(0,101)),
                eng = FLOOR(dbms_random.value(0,101)),
                mat = FLOOR(dbms_random.value(0,101));
COMMIT; 
SELECT *
FROM tbl_score;


-- 문제 1005 학생의 국영수 -> 1001학생 점수로 수정
--UPDATE tbl_score SET
--                kor = (SELECT kor FROM tbl_score WHERE num = 1005),
--                eng = (SELECT eng FROM tbl_score WHERE num = 1005),
--                mat = (SELECT mat FROM tbl_score WHERE num = 1005)
--WHERE num = 1001;

UPDATE tbl_score
SET(kor,eng,mat) = (SELECT kor,eng,mat FROM tbl_score WHERE num = 1005)
WHERE num = 1001;

-- [문제] 모든 학생의 총점 평균을 수정
--()조건 : 평균은 소수점 2자리
UPDATE tbl_score SET
                tot = kor+eng+mat, 
                avg = (kor+eng+mat)/3;
       
-- 문제) 등급 에 'A','B','C','D','E'
--              90,80,  70, 60

UPDATE tbl_score SET grade = CASE
                WHEN avg >=90 THEN 'A'
                WHEN avg BETWEEN 80 AND 89 THEN 'B'
                WHEN avg BETWEEN 70 AND 79 THEN 'C'
                WHEN avg BETWEEN 60 AND 69 THEN 'D'
                ELSE 'F'
                END;
                
 --  [1]              
UPDATE tbl_score p SET rank = ( 
                                SELECT ranks
                                FROM (
                                        SELECT RANK()OVER(ORDER BY tot DESC)ranks
                                            ,ROWID rid
                                        FROM tbl_score
                                )c
                                WHERE p.ROWID = c.rid
                                );
       --[2]                         
  UPDATE tbl_score s SET rank = (SELECT COUNT(*)+1 FROM tbl_score t where (t.avg > s.avg) );         
           --[3]
UPDATE tbl_score p SET rank = ( 
                            SELECT t.r
                            FROM(
                                SELECT num,tot, RANK()OVER(ORDER BY tot DESC)r
                                FROM tbl_score
                                )t
                            WHERE t.num = p.num
                                );
                         
    
    -- 모든 학생들의 영어 점수를 20점 증가... 100점 넘어도 100으로...
    
    UPDATE tbl_score
    SET eng = CASE
                WHEN eng >= 80 THEN 100
                ELSE eng+20
                END;
    
    -- 국영수 점수가 수정이 되면 수정된 학생들의 총점, 평균 전체 학생의 등수도 달라지네...
    -- PL/SQL 5가지의 한 종류: 패키지(package),트리거 (Trigger)
    
SELECT empno,ename,sal, 
        ROW_NUMBER()OVER(ORDER BY sal DESC)rn,
        RANK()OVER(ORDER BY sal DESC)r,
        DENSE_RANK()OVER(ORDER BY sal DESC)dr
FROM emp;

-- 문제 여학생들만 국어 점수를 5점 씩 증가 시키는 쿼리작성
--tbl_score 테이블에 성별 칼럼 X insa테이블 ssn
-- (insa join)
UPDATE tbl_score s SET kor = 
                    (   SELECT c.k
                        FROM(
                            SELECT t.num,DECODE(MOD(SUBSTR(ssn,8,1),2),1,kor+5,kor)k
                            FROM tbl_score t join insa i ON t.num = i.num
                                )c
                        WHERE c.num = s.num);
--[2]
UPDATE tbl_score s SET kor = CASE
                WHEN kor >= 95 THEN 100
                ELSE kor+5
                END
WHERE num = ANY(SELECT num FROM insa
                    WHERE num <= 1005 AND MOD(SUBSTR(ssn,8,1),2)=1
                    );


ROLLBACK;
commit;
SELECT *
FROM tbl_score;

SELECT DECODE(SUBSTR(ssn,8,1),1,kor,kor+5)
FROM tbl_score t join insa i ON t.num = i.num;


-- 테스팅
UPDATE tbl_score s SET kor = 
                    (   SELECT c.k
                        FROM(
                            SELECT t.num,DECODE(MOD(SUBSTR(ssn,8,1),2),1,
                            CASE 
                                WHEN kor >=95 THEN 100
                                ELSE kor+5
                            END
                            ,kor)k
                            FROM tbl_score t join insa i ON t.num = i.num
                                )c
                        WHERE c.num = s.num);
        
-- merge(병합): 구조가 같은 두 개의 테이블을 비교하여 하나의 테이블로 합치기 위한 데이터 조작이다        
        【형식】
    MERGE [hint] INTO [schema.] {table ? view} [t_alias]
      USING {{[schema.] {table ? view}} ?
            subquery} [t_alias]
      ON (condition) [merge_update_clause] [merge_insert_clause] [error_logging_clause];

【merge_update_clause 형식】
   WHEN MATCHED THEN UPDATE SET {column = {expr ? DEFAULT},...}
     [where_clause] [DELETE where_clause]

【merge_insert_clause 형식】
   WHEN MATCHED THEN INSERT [(column,...)]
    VALUES ({expr,... ? DEFAULT}) [where_clause]
   
【where_clause 형식】
   WHERE condition

【error_logging_clause 형식】
   LOG ERROR [INTO [schema.] table] [(simple_expression)]
     [REJECT LIMIT {integer ? UNLIMITED}]


-- 예제
create table tbl_emp(
    id number primary key,      --> primary key = NOT NULL + UNIQE 제약조건 
    name varchar2(10) not null,
    salary  number,
    bonus number default 100);

DESC tbl_emp;
        
insert into tbl_emp(id,name,salary) values(1001,'jijoe',150);
insert into tbl_emp(id,name,salary) values(1002,'cho',130);
insert into tbl_emp(id,name,salary) values(1003,'kim',140);
commit;
select * from tbl_emp;

create table tbl_bonus(id number, bonus number default 100);
insert into tbl_bonus(id) (select e.id from tbl_emp e);
COMMIT;
select * from tbl_bonus;


insert into tbl_bonus VALUES (1004,50);
commit;
-- tbl_emp테이블에는 1004ID 가진 사원 없음

--병합(merge) tbl_emp과 tbl_bonus 두 테이블

MERGE INTO tbl_bonus b
  USING (SELECT id,salary FROM tbl_emp) e
  ON (b.id = e.id)
  WHEN MATCHED THEN 
            UPDATE SET b.bonus = b.bonus + e.salary*0.01
   WHEN NOT MATCHED THEN INSERT (b.id,b.bonus) VALUES (e.id,e.salary*0.01);
                    --where

SELECT *
FROM tbl_emp;
SELECT *
FROM tbl_bonus;
SELECT *
FROM tbl_score;
commit;

MERGE INTO tbl_score b
    USING (SELECT num,RANK()OVER(ORDER BY tot DESC)r FROM tbl_score)e
    ON (b.num = e.num)
    WHEN MATCHED THEN 
        UPDATE SET b.rank = e.r;
        
------------------
SELECT 
      NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 1, TO_CHAR( dates, 'DD')) ), ' ')  일
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 2, TO_CHAR( dates, 'DD')) ), ' ')  월
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 3, TO_CHAR( dates, 'DD')) ), ' ')  화
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 4, TO_CHAR( dates, 'DD')) ), ' ')  수
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 5, TO_CHAR( dates, 'DD')) ), ' ')  목
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 6, TO_CHAR( dates, 'DD')) ), ' ')  금
     , NVL( MIN( DECODE( TO_CHAR( dates, 'D'), 7, TO_CHAR( dates, 'DD')) ), ' ')  토
FROM (
        SELECT TO_DATE(:yyyymm , 'YYYYMM') + LEVEL - 1  dates
        FROM dual
        CONNECT BY LEVEL <= EXTRACT ( DAY FROM LAST_DAY(TO_DATE(:yyyymm , 'YYYYMM') ) )
)  t 
GROUP BY CASE
                -- 1/2/3/4/5/6/7               2022/04/1의 요일
            WHEN TO_CHAR( dates, 'D' ) < TO_CHAR( TO_DATE( :yyyymm,'YYYYMM' ), 'D' ) 
                 THEN TO_CHAR( dates, 'W' ) + 1
            ELSE TO_NUMBER( TO_CHAR( dates, 'W' ) )
        END
ORDER BY CASE
            WHEN TO_CHAR( dates, 'D' ) < TO_CHAR( TO_DATE( :yyyymm,'YYYYMM' ), 'D' ) THEN TO_CHAR( dates, 'W' ) + 1
            ELSE TO_NUMBER( TO_CHAR( dates, 'W' ) )
        END;
        
        
        
        -------------------


        
        
        
        
                        
                        
수 DB모델링 팀
목 팀 발표
토 프젝시작 
토/일/월/화/수/목/금/토/일 : 1~2시간 수업 프젝
월 발표
