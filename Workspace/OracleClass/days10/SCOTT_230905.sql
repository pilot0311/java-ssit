CREATE TABLE tbl_empdeptgrade (deptno, dname,empno,ename,pay,grade)
AS
SELECT e.deptno, d.dname,e.empno,e.ename,sal+NVL(comm,0) pay,s.grade
FROM emp e,dept d,SALGRADE s 
WHERE e.deptno = d.deptno AND sal+NVL(comm,0) BETWEEN s.losal AND s.hisal;

commit;

CREATE TABLE tbl_score (num, name)
AS
SELECT num,name
FROM insa;



ALTER TABLE tbl_score ADD (kor NUMBER(3) DEFAULT 0, 
                            eng NUMBER(3) DEFAULT 0,
                            mat NUMBER(3) DEFAULT 0,
                            tot NUMBER(3) DEFAULT 0,
                            avg NUMBER(5,2) DEFAULT 0,
                            grade CHAR(1 char),
                            rank NUMBER(3));
UPDATE tbl_score SET
                kor = FLOOR(dbms_random.value(0,101)),
                eng = FLOOR(dbms_random.value(0,101)),
                mat = FLOOR(dbms_random.value(0,101));                         
 
 UPDATE tbl_score SET
                tot = kor+eng+mat,
                avg = (kor+eng+mat)/3;    
ALTER TABLE tbl_score MODIFY (grade VARCHAR2(5 CHAR));
DESC tbl_score;
UPDATE tbl_score SET grade = CASE
                WHEN avg >=60 AND kor >= 40 AND eng >= 40 AND mat >= 40 THEN '합격'
                WHEN avg >= 60 AND (kor < 40 OR eng < 40 OR mat < 40) THEN '과락'
                ELSE '불합격'
                END;  
            
UPDATE tbl_score s SET rank = (SELECT t.r FROM
                                  (SELECT num,RANK()OVER(ORDER BY avg DESC) r
                                    FROM tbl_score)t
                                    WHERE s.num = t.num
                                    );  
                
 UPDATE tbl_score s SET rank = 0;  
 
MERGE INTO tbl_score b
    USING (SELECT num,RANK()OVER(ORDER BY tot DESC)r FROM tbl_score)e
    ON (b.num = e.num)
    WHEN MATCHED THEN 
        UPDATE SET b.rank = e.r;
                                   
COMMIT;
SELECT *
FROM tbl_score;

DESC emp;
SELECT *
FROM user_constraints
WHERE table_name = 'EMP';

INSERT INTO emp VALUES (8000,'pilot','CLERK',7788,'23/9/5',4000,1500,40);

CREATE TABLE tbl_emp10 AS (SELECT * FROM emp WHERE 1=0);
CREATE TABLE tbl_emp20 AS (SELECT * FROM emp WHERE 1=0);
CREATE TABLE tbl_emp30 AS (SELECT * FROM emp WHERE 1=0);
CREATE TABLE tbl_emp40 AS (SELECT * FROM emp WHERE 1=0);

INSERT FIRST
        WHEN deptno =10 THEN
            INTO tbl_emp10 VALUES(empno,ename,job,mgr,hiredate,sal,comm,deptno)
        WHEN deptno =20 THEN
            INTO tbl_emp20 VALUES(empno,ename,job,mgr,hiredate,sal,comm,deptno)
        WHEN deptno =30 THEN
            INTO tbl_emp30 VALUES(empno,ename,job,mgr,hiredate,sal,comm,deptno)
        WHEN deptno =40 THEN
            INTO tbl_emp40 VALUES(empno,ename,job,mgr,hiredate,sal,comm,deptno)
SELECT * FROM emp;

commit;
select *
FROM tbl_emp40;


CREATE TABLE tbl_merge1
(
     id number primary key
   , name varchar2(20)
   , pay number
   , sudang number             
);
    
CREATE TABLE tbl_merge2
(
   id number primary key 
   , sudang number             
);

INSERT INTO tbl_merge1 (id, name, pay, sudang) VALUES (1, 'a', 100, 10);
INSERT INTO tbl_merge1 (id, name, pay, sudang) VALUES (2, 'b', 150, 20);
INSERT INTO tbl_merge1 (id, name, pay, sudang) VALUES (3, 'c', 130, 0);

INSERT INTO tbl_merge2 (id, sudang) VALUES (2,5);
INSERT INTO tbl_merge2 (id, sudang) VALUES (3,10);
INSERT INTO tbl_merge2 (id, sudang) VALUES (4,20);
commit;

3) tbl_merge1을 tbl_merge2에 병합 ( id, sudang )하세요... ;

MERGE INTO tbl_merge2 m2
    USING (SELECT id, sudang FROM tbl_merge1) m1
    ON (m2.id = m1.id)
    WHEN MATCHED THEN
        UPDATE SET m2.sudang = m2.sudang + m1.sudang
        WHEN NOT MATCHED THEN INSERT (m2.id,m2.sudang) VALUES (m1.id,m1.sudang);
    
2	5
3	10
4	20

2	25
3	10
4	20
1	10       
COMMIT;
        SELECT *
        FROM tbl_merge2;

DROP TABLE tbl_merge2 PURGE;  --완전 삭제
DROP TABLE tbl_merge1;
-----------------------------------
-- 제약 조건 CONSTRAINTS: DML에 의한 잘못된 데이터 조작(삽입,수정,삭제) 방지
-- 무결성 : 데이터의 정확성과 일관성을 유지하고, 데이터에 결손과 부정합이 없음을 보증하는 것
-- data integrity(데이터 무결성): 데이터를 보호하고, 항상 정상인 데이터를 유지하는 것
-- 행(row)을 입력, 수정, 삭제할 때 적용되는 규칙으로 사용되며 테이블에 의해 참조되고 있는 경우 테이블의 삭제 방지를 위해서도 사용된다
-- 데이터 무결성 종류
-- 1) 개체 무결성(Entity Integrity): 테이블에 저장되는 튜플의 유일성을 보장하기 위한 제약 조건
--    튜플의 유일성을 보장하기 위하여 하나 이상의 속성으로 구성되는 식별자를 지정하며, 이러한 식별자를 기본키(primary key)라 함
--    기본 키는 유일성(uniqueness)과 최소성(minimality)을 만족해야 한다. 
--    유일성은 기본 키를 구성하는 속성 집합(컬럼 집합)의 값은 릴레이션에서 유일해야 한다는 성질을 말한다. 
--    최소성은 기본 키를 구성하는 속성집합이 유일성을 해치지 않는 최소의 속성으로 구성해야 한다는 성질을 말한다. 
--    기본 키를 구성하는 모든 속성 값은 null이 될 수 없다.                
-- 2) 참조 무결성(Relational Integrity): 테이블 간의 데이터의 일관성을 보장하기 위한 제약조건이다
--    하나의 릴레이션에 있는 속성 값이 다른 릴레이션에 있는 속성 값을 참조하기 위해서는 참조되는 속성 값이 반드시 해당 릴레이션에 존재해야 한다
--    참조 무결성 규칙에서 다른 릴레이션의 컬럼 값을 참조하는 컬럼을 외래 키(foreign key)라 하고 
--    다른 릴레이션에서 참조되는 컬럼을 참조 키(reference key)라 한다. 
--    외래 키는 반드시 참조 키의 값과 일치하거나 null을 가져야 한다
-- 3) 도메인 무결성(domain integrity): 속성에서 허용 가능한 값의 범위를 지정하기 위한 제약조건이다
--    도메인 무결성 규칙에서는 속성의 데이터 타입, 길이, 기본 키, 유일성, null 허용, 허용 값의 범위와 같은 다양한 제약조건을 지정할 수 있다.

DROP TABLE dept;
--ORA-02449: unique/primary keys in table referenced by foreign keys
INSERT INTO emp (empno) VALUES (7839); -- 개체 무결성 위반 unique constraint (SCOTT.PK_EMP) violated
INSERT INTO emp (empno,deptno) VALUES (7739,50); -- 참조 무결성 위반 
--ntegrity constraint (SCOTT.FK_DEPTNO) violated - parent key not found
INSERT INTO emp (empno) VALUES ('abc'); -- 도메인 무결성 위반

사원테이블
사원번호        고유한 키 PK
주민등록번호     유일한키 == 중복되지안는 키 UK
국어           NUMBER(3) 범위(-999~999) ->  0~100체크 : CK INSERT UPDATE 101 : 도메인 무결성 위배

-- 제약조건 설정 방법
1) 컬럼   레벨 방식   (in-line 방식)
2) 테이블 레벨  방식  (out-of-line 방식)

CREATE TABLE sample(
    id varchar2(20) PK,NN,CK,UK 등등 -> 컬럼 레벨 방식
    ,pwd varchar2(20) PK,NN,CK,UK 등등
    , CONSTRAINTS id NN제약조건 X (NOT NULL 제약조건은 테이블 레벨방식으로 설정 불가 반드시 컬럼레벨으로만 설정 가능)
    , CONSTRAINTS id + pwd 제약조건 복합키로 설정(테이블 레벨 방식으로만 설정 할 수 있다)
    , CONSTRAINTS 제약조건 -> 테이블 레벨 방식
    );

-- 제약 조건을 설정하는 시점
1) 테이블 생성할 때 - CREATE TABLE 문
2) 테이블 수정할 때 - ALTER TABLE 문

-- 제약 조건의 종류 5 가지
1) PRIMARY KEY(PK): 해당 컬럼 값은 반드시 존재해야 하며, 유일해야 함
                    (NOT NULL과 UNIQUE 제약조건을 결합한 형태) 
2) FOREIGN KEY(FK) 해당 컬럼 값은 참조되는 테이블의 컬럼 값 중의 하나와 일치하거나 NULL을 가짐 
3) UNIQUE KEY(UK) 테이블내에서 해당 컬럼 값은 항상 유일해야 함 
4) NOT NULL(NN) 컬럼은 NULL 값을 포함할 수 없다. 
5) CHECK(CK) 해당 컬럼에 저장 가능한 데이터 값의 범위나 조건 지정 
;
-- 실습)
1) 컬럼 레벨 제약 조건 설정
CREATE TABLE tbl_constraint1(
   -- empno NUMBER(4) NOT NULL PRIMARY KEY
    empno NUMBER(4) NOT NULL CONSTRAINT PK_tblconstraint1_empno PRIMARY KEY     --제약 조건 이름 달기
    , ename VARCHAR2(20)
    , deptno NUMBER(2) CONSTRAINT FK_tblconstraint1_deptno
                        REFERENCES dept(deptno)                  --dept(deptno)를 참조하는 외래키(FK)
    , kor NUMBER(3) CONSTRAINT CK_tblconstraint1_kor CHECK (kor BETWEEN 0 AND 100) -- 0~100사이만 입력가능한 제약조건 CK 
    , email VARCHAR2(250) CONSTRAINT UK_tblconstraint1_email UNIQUE -- 유일한 값, 유일성 제약 조건 (UK)
    , city VARCHAR2(20) CONSTRAINT CK_tblconstraint1_city 
                        CHECK (city IN ('서울','부산','대구','대전'))-- 서울,부산,대구,대전 중 하나만 사용
);
SYS_C007028	C NOT NULL 제약조건
SYS_C007029	P   PK 제약조건   --SYS_C007029 시스템이 알아서 정해준 제약조건 이름
-- 제약 조건 삭제
[형식]
ALTER TABLE 테이블명 
DROP [CONSTRAINT constraint명 | PRIMARY KEY | UNIQUE(컬럼명)]
[CASCADE];
--ㄱ
ALTER TABLE tbl_constraint1
DROP CONSTRAINT PK_tbl_constraint1_empno;
--ㄴ. PK제약조건 이름 몰라도 제거 가능
ALTER TABLE tbl_constraint1
DROP PRIMARY KEY;

SELECT *
FROM user_CONSTRAINTS
WHERE table_name = UPPER('tbl_constraint1');

DROP TABLE tbl_constraint1;

2) 테이블 레벨 제약 조건 설정
CREATE TABLE tbl_constraint2(
    empno NUMBER(4) NOT NULL
    , ename VARCHAR2(20)
    , deptno NUMBER(2)
    , kor NUMBER(3)
    , email VARCHAR2(250)
    , city VARCHAR2(20)
    , CONSTRAINT PK_tbl_constraint2_empno PRIMARY KEY(empno)
    , CONSTRAINT FK_tbl_constraint2_deptno FOREIGN KEY(deptno) REFERENCES dept (deptno)
    , CONSTRAINT CK_tblconstraint2_kor CHECK (kor BETWEEN 0 AND 100)
    , CONSTRAINT UK_tblconstraint2_email UNIQUE (email)
    , CONSTRAINT CK_tblconstraint1_city CHECK (city IN ('서울','부산','대구','대전'))
);
SELECT *
FROM user_CONSTRAINTS
WHERE table_name = UPPER('tbl_constraint2');
DROP TABLE tbl_constraint2;
3) 테이블 생성 후에 pk제약조건 설정
CREATE TABLE tbl_constraint3(
    empno NUMBER(4) 
    , ename VARCHAR2(20)
    , deptno NUMBER(2)
);
-- 테이블 수정
ALTER TABLE tbl_constraint3
ADD CONSTRAINT PK_tbl_constraint3_empno PRIMARY KEY(empno);

ALTER TABLE tbl_constraint3
ADD CONSTRAINT FK_tbl_constraint3_deptno FOREIGN KEY(deptno) REFERENCES dept (deptno);

DROP TABLE tbl_constraint3;
SELECT *
FROM user_CONSTRAINTS
WHERE table_name = UPPER('tbl_constraint3');

-- 제약조건 활성화
ALTER TABLE 테이블명
ENABLE CONSTRAINT 제약조건명
-- 제약조건 비활성화
ALTER TABLE 테이블명
DISABLE CONSTRAINT 제약조건명

--
DROP TABLE 테이블명; --테이블 휴지통으로 삭제 (복구가능)
DROP TABLE 테이블명 PURGE; -- 휴지통에 넣지 않고 완전 삭제
DROP TABLE 테이블명 CASCADE CONSTRAINT; -- 테이블과(dept) 그 테이블을 참조하는 포린키(FK)(emp.deptno)를 동시에 삭제
-- ALTER TABLE 테이블명
-- ADD (컬럼...)
-- ADD (제약조건...)
【컬럼레벨의 형식】
    컬럼명 데이터타입 CONSTRAINT constraint명
	REFERENCES 참조테이블명 (참조컬럼명) 
             [ON DELETE CASCADE | ON DELETE SET NULL]

emp
    , deptno NUMBER(2) CONSTRAINT FK_EMP_DEPTNO REFERENCES dept(deptno)
              ON DELETE CASCADE;  -- emp 테이블의 30번 사원들도 같이 삭제된다
              ON DELETE SET NULL; -- emp 테이블의 30번 사원들의 deptno = null 로 설정
--
DELETE FROM dept
WHERE deptno =30; -- 참조 무결성 위배, 사원 테이블에 30번 사원이 참조하고 있다
ON DELETE CASCADE;  -- emp 테이블의 30번 사원들도 같이 삭제된다
ON DELETE SET NULL; -- emp 테이블의 30번 사원들의 deptno = null 로 설정


-- 실습
-- ON DELETE CASCADE;  -- emp 테이블의 30번 사원들도 같이 삭제된다
CREATE TABLE tbl_emp AS (SELECT * FROM emp);
CREATE TABLE tbl_dept AS (SELECT * FROM dept);

ALTER TABLE tbl_dept
ADD CONSTRAINT PK_tbl_dept_deptno PRIMARY KEY(deptno);

ALTER TABLE tbl_emp
ADD (CONSTRAINT PK_tbl_emp_empno PRIMARY KEY(empno)
    , CONSTRAINT FK_tbl_emp_deptno FOREIGN KEY(deptno) REFERENCES tbl_dept(deptno) ON DELETE CASCADE);

SELECT *
FROM tbl_emp;
DELETE FROM tbl_dept
WHERE deptno =30;

select*
FROM tbl_emp;

SELECT *
FROM user_constraints
WHERE table_name = UPPER('tbl_emp');

-- join
--책 테이블
 CREATE TABLE book(
       b_id     VARCHAR2(10)    NOT NULL PRIMARY KEY   -- 책ID
      ,title      VARCHAR2(100) NOT NULL  -- 책 제목
      ,c_name  VARCHAR2(100)    NOT NULL     -- c 이름
     -- ,  price  NUMBER(7) NOT NULL
 );
-- Table BOOK이(가) 생성되었습니다.
INSERT INTO book (b_id, title, c_name) VALUES ('a-1', '데이터베이스', '서울');
INSERT INTO book (b_id, title, c_name) VALUES ('a-2', '데이터베이스', '경기');
INSERT INTO book (b_id, title, c_name) VALUES ('b-1', '운영체제', '부산');
INSERT INTO book (b_id, title, c_name) VALUES ('b-2', '운영체제', '인천');
INSERT INTO book (b_id, title, c_name) VALUES ('c-1', '워드', '경기');
INSERT INTO book (b_id, title, c_name) VALUES ('d-1', '엑셀', '대구');
INSERT INTO book (b_id, title, c_name) VALUES ('e-1', '파워포인트', '부산');
INSERT INTO book (b_id, title, c_name) VALUES ('f-1', '엑세스', '인천');
INSERT INTO book (b_id, title, c_name) VALUES ('f-2', '엑세스', '서울');

COMMIT;

SELECT *
FROM book;
--단가 테이블(책의 가격)
 CREATE TABLE danga(
      b_id  VARCHAR2(10)  NOT NULL  -- PK , FK  (식별관계)
      ,price  NUMBER(7) NOT NULL    -- 책 가격
      
      ,CONSTRAINT PK_dangga_id PRIMARY KEY(b_id)
      ,CONSTRAINT FK_dangga_id FOREIGN KEY (b_id)
              REFERENCES book(b_id)
              ON DELETE CASCADE
);

book -b_id(pk), title, c_name
danga - b_id(pk,fk), price

INSERT INTO danga (b_id, price) VALUES ('a-1', 300);
INSERT INTO danga (b_id, price) VALUES ('a-2', 500);
INSERT INTO danga (b_id, price) VALUES ('b-1', 450);
INSERT INTO danga (b_id, price) VALUES ('b-2', 440);
INSERT INTO danga (b_id, price) VALUES ('c-1', 320);
INSERT INTO danga (b_id, price) VALUES ('d-1', 321);
INSERT INTO danga (b_id, price) VALUES ('e-1', 250);
INSERT INTO danga (b_id, price) VALUES ('f-1', 510);
INSERT INTO danga (b_id, price) VALUES ('f-2', 400);

COMMIT;

SELECT*
FROM danga;
--
-- 저자 테이블
 CREATE TABLE au_book(
       id   number(5)  NOT NULL PRIMARY KEY
      ,b_id VARCHAR2(10)  NOT NULL  CONSTRAINT FK_AUBOOK_BID
            REFERENCES book(b_id) ON DELETE CASCADE
      ,name VARCHAR2(20)  NOT NULL
);

INSERT INTO au_book (id, b_id, name) VALUES (1, 'a-1', '저팔개');
INSERT INTO au_book (id, b_id, name) VALUES (2, 'b-1', '손오공');
INSERT INTO au_book (id, b_id, name) VALUES (3, 'a-1', '사오정');
INSERT INTO au_book (id, b_id, name) VALUES (4, 'b-1', '김유신');
INSERT INTO au_book (id, b_id, name) VALUES (5, 'c-1', '유관순');
INSERT INTO au_book (id, b_id, name) VALUES (6, 'd-1', '김하늘');
INSERT INTO au_book (id, b_id, name) VALUES (7, 'a-1', '심심해');
INSERT INTO au_book (id, b_id, name) VALUES (8, 'd-1', '허첨');
INSERT INTO au_book (id, b_id, name) VALUES (9, 'e-1', '이한나');
INSERT INTO au_book (id, b_id, name) VALUES (10, 'f-1', '정말자');
INSERT INTO au_book (id, b_id, name) VALUES (11, 'f-2', '이영애');

COMMIT;

SELECT * 
FROM au_book;
       
-- 판매 출판사 -> 책 -> 서점          
-- 고객 테이블(서점)
CREATE TABLE gogaek(
      g_id       NUMBER(5) NOT NULL PRIMARY KEY 
      ,g_name   VARCHAR2(20) NOT NULL
      ,g_tel      VARCHAR2(20)
);

INSERT INTO gogaek (g_id, g_name, g_tel) VALUES (1, '우리서점', '111-1111');
INSERT INTO gogaek (g_id, g_name, g_tel) VALUES (2, '도시서점', '111-1111');
INSERT INTO gogaek (g_id, g_name, g_tel) VALUES (3, '지구서점', '333-3333');
INSERT INTO gogaek (g_id, g_name, g_tel) VALUES (4, '서울서점', '444-4444');
INSERT INTO gogaek (g_id, g_name, g_tel) VALUES (5, '수도서점', '555-5555');
INSERT INTO gogaek (g_id, g_name, g_tel) VALUES (6, '강남서점', '666-6666');
INSERT INTO gogaek (g_id, g_name, g_tel) VALUES (7, '강북서점', '777-7777');

COMMIT;

SELECT *
FROM gogaek;

-- 판매 테이블
CREATE TABLE panmai(
       id         NUMBER(5) NOT NULL PRIMARY KEY
      ,g_id       NUMBER(5) NOT NULL CONSTRAINT FK_PANMAI_GID
                     REFERENCES gogaek(g_id) ON DELETE CASCADE
      ,b_id       VARCHAR2(10)  NOT NULL CONSTRAINT FK_PANMAI_BID
                     REFERENCES book(b_id) ON DELETE CASCADE
      ,p_date     DATE DEFAULT SYSDATE
      ,p_su       NUMBER(5)  NOT NULL
);

INSERT INTO panmai (id, g_id, b_id, p_date, p_su) VALUES (1, 1, 'a-1', '2000-10-10', 10);
INSERT INTO panmai (id, g_id, b_id, p_date, p_su) VALUES (2, 2, 'a-1', '2000-03-04', 20);
INSERT INTO panmai (id, g_id, b_id, p_date, p_su) VALUES (3, 1, 'b-1', DEFAULT, 13);
INSERT INTO panmai (id, g_id, b_id, p_date, p_su) VALUES (4, 4, 'c-1', '2000-07-07', 5);
INSERT INTO panmai (id, g_id, b_id, p_date, p_su) VALUES (5, 4, 'd-1', DEFAULT, 31);
INSERT INTO panmai (id, g_id, b_id, p_date, p_su) VALUES (6, 6, 'f-1', DEFAULT, 21);
INSERT INTO panmai (id, g_id, b_id, p_date, p_su) VALUES (7, 7, 'a-1', DEFAULT, 26);
INSERT INTO panmai (id, g_id, b_id, p_date, p_su) VALUES (8, 6, 'a-1', DEFAULT, 17);
INSERT INTO panmai (id, g_id, b_id, p_date, p_su) VALUES (9, 6, 'b-1', DEFAULT, 5);
INSERT INTO panmai (id, g_id, b_id, p_date, p_su) VALUES (10, 7, 'a-2', '2000-10-10', 15);

COMMIT;

SELECT *
FROM panmai;   

-- join 종류
-- 1) EQUI JOIN 
-- 두 개 이상의 테이블에 관계되는 컬럼들의 값들이 일치하는 경우에 사용하는 가장 일반적인 join 형태
-- WHERE 절에 '='(등호)를 사용한다.
-- 부.pk = 자.fk
-- 오라클에서는 natural join과 동일
-- USING절을 사용해도 동일...

--[문제] 책 ID와 책제목 출판사(c_name),단가 정보 출력
-- 1)객체명.컬럼명
SELECT book.b_id,book.title,book.c_name,danga.price
FROM book, danga
WHERE book.b_id = danga.b_id;  -- EQUI JOIN 
-- 2) 별칭.컬럼명
SELECT b.b_id,title,c_name,price
FROM book b, danga d
WHERE b.b_id = d.b_id;  -- EQUI JOIN 
-- 3) join-on 구문
SELECT b.b_id,title,c_name,price
FROM book b JOIN danga d ON b.b_id = d.b_id;
-- 4) USING 절 사용 - 객체명.컬럼명 또는 별칭명.컬럼명 X
SELECT b_id,title,c_name,price
FROM book JOIN danga USING(b_id);
-- 5) 오라클 : NATURAL JOIN 사용
SELECT b_id,title,c_name,price
FROM book NATURAL JOIN danga;

--[문제] 책id 책제목 판매수량 단가 서점명 판매금액 출력
1),
SELECT b.b_id,b.title,p.p_su,d.price,g.g_name,(p.p_su*d.price)판매금액
FROM book b,panmai p, danga d, gogaek g 
WHERE b.b_id = p.b_id AND d.b_id = b.b_id AND p.g_id=g.g_id;
2)join-on
SELECT b.b_id,b.title,p.p_su,d.price,g.g_name,(p.p_su*d.price)판매금액
FROM book b JOIN panmai p ON b.b_id = p.b_id JOIN danga d ON  d.b_id = b.b_id JOIN gogaek g ON p.g_id=g.g_id;
3) USING
SELECT b_id,title,p_su,price,g_name,(p_su*price)판매금액
FROM book JOIN panmai USING(b_id)  JOIN danga USING(b_id) JOIN gogaek USING(g_id);

-- 2) NON-EQUI JOIN 
-- 관계되는 컬럼이 정확히 일치하지 않는 경우에 사용되는 JOIN의 형태이다.
-- WHERE 절에 BETWEEN ... AND ... 연산자를 사용한다.
-- 오라클에서는 ON 절을 이용하여 NON-EQUI JOIN과 동일한 역할을 수행한다
-- emp + salgrade
--
SELECT deptno,ename,sal,losal ||'~'|| hisal,grade
FROM emp e, salgrade s
WHERE sal BETWEEN losal AND hisal;
--
SELECT deptno,ename,sal,losal ||'~'|| hisal,grade
FROM emp e JOIN salgrade s ON sal BETWEEN losal AND hisal;

-- 3) INNER JOIN == EQUI JOIN 
-- simple join이라고도 하며, 둘 이상의 테이블에서 join 조건을 만족하는 행만 반환한다.
--emp /dept join
SELECT d.deptno,dname,ename,sal
FROM emp e, dept d
WHERE e.deptno = d.deptno;
-- deptno = null 인 KING 과 emp에 없는 deptno=40 인 행 나오지 않음 == 양쪽에 다 있는 부서만 나옴

-- 4) OUTER JOIN
-- JOIN 조건을 만족하지 않는 행을 보기 위한 추가적인 join의 형태이다.
-- 일반적인 join으로 얻을 수 없는 데이터를 구하고 싶을 때 사용하며, '(+)' 연산자를 사용한다.
-- 오라클에서는 LEFT(RIGHT) [OUTER] JOIN도 가능
-- 사원은 다나오게 (+)사용
SELECT d.deptno,dname,ename,sal
FROM emp e, dept d
WHERE e.deptno = d.deptno(+);
-- LEFT [OUTER] JOIN
SELECT d.deptno,dname,ename,sal
FROM emp e LEFT OUTER JOIN dept d ON e.deptno = d.deptno;
-- 부서는 나오게(+)사용
SELECT d.deptno,dname,ename,sal
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno;
-- RIGHT JOIN ----OUTER생략가능
SELECT d.deptno,dname,ename,sal
FROM emp e RIGHT JOIN dept d ON e.deptno = d.deptno;
-- 부서 사원 다 나오게 
SELECT d.deptno,dname,ename,sal
FROM emp e FULL JOIN dept d ON e.deptno = d.deptno;

-- 5) SELF JOIN
-- 자신의 테이블을 alias를 사용하여 마치 두 개의 테이블인처럼 JOIN하는 형태이다.
-- 오라클에서는 JOIN ∼ ON 문을 이용하여 SELF JOIN과 동일한 역할을 수행한다.

-- deptno, empno, 직속 상사의 부서번호/ 사원 번호/사원명
SELECT e.deptno,e.empno,e.ename,e.mgr,j.deptno,j.empno,j.ename 
FROM emp e, emp j  --self join
WHERE e.mgr = j.empno;

SELECT e.deptno,e.empno,e.ename,e.mgr,j.deptno,j.empno,j.ename 
FROM emp e JOIN emp j ON e.mgr = j.empno; --self join

-- 6) CROSS JOIN : Cartesian Product(곱집합)을 수행하는 join
SELECT *
FROM emp CROSS JOIN dept;  -- 결과 emp의 행갯수 14 * dept의 행 갯수4 = 56행이 나옴
FROM emp,dept;

-- 7) ANTIJOIN :  NOT IN  서브쿼리한 결과 속에 해당 컬럼이 존재하지 않는 경우로 NOT IN을 사용함
-- 서브쿼리에 NOT IN한 컬럼만 반환함
SELECT employee_id, first_name, last_name,
     manager_id, department_id
FROM employees
WHERE department_id NOT IN (  -- ANTIJOIN
                            SELECT department_id 
                            FROM departments
                            WHERE location_id = 1700
                            );
SELECT *
FROM employees;

SELECT *
FROM LOCATIONS
WHERE location_id = 1700;

-- 8) SEMIJOIN : EXISTS  서브쿼리한 결과 속에 있는 컬럼 
-- 서브쿼리에 EXISTS하는 컬럼만 반환함
SELECT * 
FROM departments d
WHERE EXISTS (
                SELECT * FROM employees e
                 WHERE d.department_id = e.department_id
                     AND e.salary > 2500
                );
-- 프로그래머스 1 답 이상한데?
SELECT  F.FLAVOR,SUM(F.TOTAL_ORDER + J.TOTAL_ORDER) FROM FIRST_HALF F, JULY J
WHERE F.FLAVOR = J.FLAVOR AND rownum <=3
GROUP BY F.FLAVOR
ORDER BY SUM(F.TOTAL_ORDER + J.TOTAL_ORDER) DESC;

SELECT b.book_id,a.AUTHOR_NAME,b.PUBLISHED_DATE
FROM book b,AUTHOR a
WHERE b.AUTHOR_ID = a.AUTHOR_ID AND b.book_id IN(2,3)
ORDER BY b.PUBLISHED_DATE;

SELECT ANIMAL_ID,NAME
FROM ANIMAL_OUTS o
WHERE ANIMAL_ID NOT IN(
                        SELECT ANIMAL_ID
                        FROM ANIMAL_INS i
                        WHERE o.ANIMAL_ID = i.ANIMAL_ID
                        )



주제 :  
수   : DB모델링
목   : DB모델링 발표
금~일: DB설계
월   : 발표