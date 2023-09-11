--익명 프로시저 선언 RECORD 형 변수
--익명 프로시저 선언 %TYPE 형 변수 선언
DECLARE
  Vdeptno NUMBER(2);
  vdname  dept.DNAME%TYPE;
  vempno  emp.EMPNO%TYPE;
  vename  emp.ENAME%TYPE;
  vpay    NUMBER;
BEGIN
  SELECT d.DEPTNO,D.DNAME,E.EMPNO,E.ENAME,sal+NVL(E.COMM,0)pay
    INTO Vdeptno,vdname,vempno,vename,vpay
  FROM dept d JOIN emp e ON d.deptno = e.deptno
  WHERE empno = 7369;
  DBMS_OUTPUT.PUT_LINE(Vdeptno ||','||vdname||','||vempno||','||vename||','||vpay);
--EXCEPTION
END;

--익명 프로시저 선언 %ROWTYPE 형 변수 사용
DECLARE
  vdrow dept%ROWTYPE;
  verow emp%ROWTYPE;
  vpay NUMBER;
BEGIN
  SELECT d.DEPTNO,D.DNAME,E.EMPNO,E.ENAME,sal+NVL(E.COMM,0)pay
    INTO vdrow.deptno,vdrow.dname,verow.empno,verow.ename,vpay
  FROM dept d JOIN emp e ON d.deptno = e.deptno
  WHERE empno = 7369;
  DBMS_OUTPUT.PUT_LINE(vdrow.deptno||','||vdrow.dname||','||verow.empno||','||verow.ename||','||vpay);
--EXCEPTION
END;

--익명 프로시저 선언 RECORD 형 변수
DECLARE
  --사용자 정의 구조체 타입 선언
  TYPE EmpDeptType IS RECORD
  (
    deptno NUMBER(2),
    dname  dept.DNAME%TYPE,
    empno  emp.EMPNO%TYPE,
    ename  emp.ENAME%TYPE,
    pay    NUMBER
  );
  vderow EmpDeptType;
BEGIN
  SELECT d.DEPTNO,D.DNAME,E.EMPNO,E.ENAME,sal+NVL(E.COMM,0)pay
    INTO vderow.deptno,vderow.dname,vderow.empno,vderow.ename,vderow.pay
  FROM dept d JOIN emp e ON d.deptno = e.deptno
  WHERE empno = 7369;
  DBMS_OUTPUT.PUT_LINE(vderow.deptno||','||vderow.dname||','||vderow.empno||','||vderow.ename||','||vderow.pay);
--EXCEPTION
END;

--CURSOR(커서)
-- 반드시 커서를 사용해서 fetch(가져오기)
--ORA-01422: exact fetch returns more than requested number of rows
DECLARE
  --사용자 정의 구조체 타입 선언
  TYPE EmpDeptType IS RECORD
  (
    deptno NUMBER(2),
    dname  dept.DNAME%TYPE,
    empno  emp.EMPNO%TYPE,
    ename  emp.ENAME%TYPE,
    pay    NUMBER
  );
  vderow EmpDeptType;
BEGIN
-- 1개의 행결과물 (암시적 커서)
  SELECT d.DEPTNO,D.DNAME,E.EMPNO,E.ENAME,sal+NVL(E.COMM,0)pay
    INTO vderow.deptno,vderow.dname,vderow.empno,vderow.ename,vderow.pay
  FROM dept d JOIN emp e ON d.deptno = e.deptno;
  --WHERE empno = 7369;
  DBMS_OUTPUT.PUT_LINE(vderow.deptno||','||vderow.dname||','||vderow.empno||','||vderow.ename||','||vderow.pay);
--EXCEPTION
END;

-- 5) CURSOR(커서)
1. pl.sql 블럭 내에서 실행되는 select문을 의미한다
2. 여러 레코드로 구성된 작업영역에서 sql문을 실행하고 그 결과를 저장하기 위해서 cursor를 사용한다
3. 커서 2가지 종류
    1) 묵시적(implicit cursor) == 암시적 == 자동
      일반적으로 사용된는 SQL문을 묵시적 커서라 한다. 한 번 실행에 하나의 결과를 반환하는 SQL문을 의미 함
    2) 명시적(explicit cursor)
      SQL문을 실행했을 때 그 결과가 여러 개인 경우에 묵시적 커서를 사용하면 해당 SQL문은 에러가 발생함
      이유는 묵시적 커서에 사용되는 스칼라 변수는 한 번에 하나의 값만 저장할 수 있기 때문임
      이렇게 여러 개의 행이 반환되는 SQL문을 실행하는 경우에는 반드시 명시적 커서를 사용해야 함
      (1)명시적 커서를 사용하는 순서
          ㄱ. 커서 선언   : SELECT문을 작성
          ㄴ. 커서 OPEN   : SELECT문을 실행
          ㄷ. 커서 FETCH  : 결과물을 갖고 있는 커서로 부터 가져오기(FETCH) -> 반복문을 사용해서 처리
                                                                      커서의 속성
                                                                      %NOTFOUND   : 커서의 행이 없는지 유무
                                                                      %FOUND      : 커서의 행이 있는지 유무
                                                                      %ISOPEN     : 현재 커서 상태
                                                                      %ROUWCOUNT  : 커서를 사용해서 읽힌 행의 수
          ㄹ. 커서 CLOSE
--CURSOR(커서) 예제
DECLARE
  TYPE EmpDeptType IS RECORD
  (
    deptno NUMBER(2),
    dname  dept.DNAME%TYPE,
    empno  emp.EMPNO%TYPE,
    ename  emp.ENAME%TYPE,
    pay    NUMBER
  );
  vderow EmpDeptType;
  --1) 커서 선언
  -- CURSOR 커서명 IS SELECT문 ;   == CURSOR 선언 형식
  CURSOR edcursor IS ( SELECT d.DEPTNO,d.DNAME,e.EMPNO,e.ENAME,sal+NVL(e.COMM,0)pay
                       FROM dept d JOIN emp e ON d.deptno = e.deptno );
BEGIN
  --2) 커서 실행 OPEN
  -- 형식) OPEN 커서명;
  OPEN edcursor;
  --3) 커서 FETCH
  LOOP
    FETCH edcursor INTO vderow;
     --                      '문자열'  t/f
    --DBMS_OUTPUT.PUT_LINE(edcursor%ISOPEN);
    IF  edcursor%ISOPEN THEN
      DBMS_OUTPUT.PUT_LINE('TRUE');
    ELSE
      DBMS_OUTPUT.PUT_LINE('FALSE');
    END IF;
    DBMS_OUTPUT.PUT_LINE(vderow.deptno||','||vderow.dname||','||vderow.empno||','||vderow.ename||','||vderow.pay);
    EXIT WHEN edcursor%NOTFOUND;
  END LOOP;
 
  --4) 커서종료 CLOSE
  -- 형식) CLOSE 커서명
  CLOSE edcursor;
--EXCEPTION
END;          


--6) 익명프로시저 선언  FOR 문사용해서 커서
DECLARE
  TYPE EmpDeptType IS RECORD
  (
    deptno NUMBER(2),
    dname  dept.DNAME%TYPE,
    empno  emp.EMPNO%TYPE,
    ename  emp.ENAME%TYPE,
    pay    NUMBER
  );
  vderow EmpDeptType;
  --1) 커서 선언
  -- CURSOR 커서명 IS SELECT문 ;   == CURSOR 선언 형식
  CURSOR edcursor IS ( SELECT d.DEPTNO,d.DNAME,e.EMPNO,e.ENAME,sal+NVL(e.COMM,0)pay
                       FROM dept d JOIN emp e ON d.deptno = e.deptno );
BEGIN
 
  --3) 커서 FETCH  for문 사용하기
  FOR vderow IN edcursor
  LOOP
    DBMS_OUTPUT.PUT_LINE(vderow.deptno||','||vderow.dname||','||vderow.empno||','||vderow.ename||','||vderow.pay);
  END LOOP;
--EXCEPTION
END;

-- 6-2) FOR 문 사용시 변수 선언 생략, 커서 선언부 -> for문, open,close생략 가능
DECLARE
BEGIN
  --3) 커서 FETCH  for문 사용하기
  FOR vderow IN ( SELECT d.DEPTNO,d.DNAME,e.EMPNO,e.ENAME,sal+NVL(e.COMM,0)pay
                  FROM dept d JOIN emp e ON d.deptno = e.deptno )
  LOOP
    DBMS_OUTPUT.PUT_LINE(vderow.deptno||','||vderow.dname||','||vderow.empno||','||vderow.ename||','||vderow.pay);
  END LOOP;
--EXCEPTION
END;


-- 저장 프로시저(stored procideur)
-- 1) PL/SQL의 가장 대표적인 구조
-- 2) 데이터베이스 객체 저장
-- 3) 형식

CREATE [OR REPLACE] PROCEDURE [프로시저이름] --up_프로시저명
 (--매개변수,파라미터,인자 p접두사
  argument1 [mode] data_type1,
  argument2 [mode] data_type2,
     ...............
 )
  IS [AS]
    -- 선언 블럭: 변수 선언 v접두사
  BEGIN
    -- 실행 블럭
  EXCEPTION
    --예외처리 블럭
  END;

-- 4) 저장 프로시저를 실행하는 3가지 방법
      (1) EXEC[UTE]
      (2) 익명 프로시저 안에서 실행
      (3) 또 다른 저장 프로시저 안에서 실행

--실습
CREATE TABLE tbl_emp
AS
(
  SELECT * FROM emp
);
-- 1) 개발자가 자주 실행하는 업무 --> 저장프로시저
--    가정) 사원 번호를 입력 받아서 해당 사원을 삭제하는 업무
DELETE FROM tbl_emp
WHERE empno = 7369;
COMMIT;

-- 위의 delete 저장 프로시저로 만들기
CREATE OR REPLACE PROCEDURE up_delEMP
(
  -- 저장 프로시저의 파라미터 선언 시 자료형의 크기 X
  -- 저장 프로시저의 파라미터 여러개 선언 시 콤마 연산자
  --pempno NUMBER(4);
  --pempno NUMBER
  --pempno 파라미터모드 emp.EMPNO%TYPE
  --        ㄴ IN(입력용,기본값),OUT(출력용), IN OUT(입출력용)
  pempno IN emp.EMPNO%TYPE
)
IS
BEGIN
  DELETE FROM tbl_emp
  WHERE empno = pempno;
  COMMIT;
--EXCEPTION
  --예외처리
END;

--실행
(1)execute 문
EXECUTE up_delemp(pempno=>7369);
EXECUTE up_delemp(7934);
(2) 익명 프로시저 안에서 저자 프로시저 실행
BEGIN
  up_delemp(7902);
END;
(3) 또 다른 저장 프로시저 안에서 실행
CREATE OR REPLACE PROCEDURE up_delemp_test
IS
BEGIN 
  up_delemp(7900);
END;

EXEC up_delemp_test;

-- 문제)
--1) dept 테이블 복사해서 tbl_dept 생성
CREATE TABLE tbl_dept
AS(
  SELECT * FROM dept
);
--2) 부서명 지역 명 입력 받아서 새로운 부서를 추가하는 저장 프로시저를 생성 up_insertdept
CREATE OR REPLACE PROCEDURE up_insertdept
(
  --pDEPTNO IN dept.DEPTNO%TYPE,
  pDNAME  IN dept.DNAME%TYPE,
  pLOC    IN DEPT.LOC%TYPE
)
IS
  vdeptno dept.DEPTNO%TYPE;
BEGIN

  SELECT MAX(deptno) INTO vdeptno FROM dept;

  vdeptno := vdeptno+10;

  INSERT INTO TBL_DEPT VALUES (vdeptno,pDNAME,pLOC);
  COMMIT;
END;
--3) 저장 프로세스 실행
EXEC up_insertdept('QC','SEOUL');

DELETE FROM tbl_dept
WHERE deptno = 50;
commit;


--SEQUENCE 사용
CREATE SEQUENCE seq_tbldept
INCREMENT BY 10
START WITH 50
MAXVALUE 90
NOCYCLE
NOCACHE;

CREATE OR REPLACE PROCEDURE up_insertdept
(
  --pDEPTNO IN dept.DEPTNO%TYPE,
  pDNAME  IN dept.DNAME%TYPE  :=NULL,
  pLOC    IN DEPT.LOC%TYPE    DEFAULT NULL
)
IS
  
BEGIN


  INSERT INTO TBL_DEPT VALUES (seq_tbldept.NEXTVAL,pDNAME,pLOC);
  COMMIT;
END;


--부서명 O, 지역명 X
--EXEC up_insertdept('QC');
EXEC up_insertdept('QC',NULL);
EXEC up_insertdept(pDNAME => 'QC3');
----부서명 X, 지역명 O
-- EXEC up_insertdept('SEOUL');
EXEC up_insertdept(pLOC => 'SEOUL3');

-- [문제] tbl_dept 테이블을 수정 : up_updateDept
-- 1) 수정할 부서번호
-- 2) 부서명만 수정
-- 3) 지역명만 수정
-- 4) 부서명 + 지역명 모두를 수정

EXEC up_updateDept(50, 'X', 'Y');
EXEC up_updateDept(50, pdname => 'QC5');
EXEC up_updateDept(80, ploc => 'SEOUL');
EXEC up_updateDept(50, pdname => 'SM', ploc => 'PO');

SELECT *
FROM tbl_dept;

CREATE OR REPLACE PROCEDURE up_updateDept(
    pdeptno tbl_dept.deptno%TYPE 
    , pdname tbl_dept.dname%TYPE DEFAULT NULL
    , ploc tbl_dept.loc%TYPE DEFAULT NULL
)
IS
BEGIN
    UPDATE tbl_dept
    SET dname = NVL(pdname, dname), 
    loc = CASE 
            WHEN ploc IS NULL THEN loc
            ELSE ploc
          END
    WHERE deptno = pdeptno;
    COMMIT;
END;

CREATE OR REPLACE PROCEDURE up_updateDept(
    pdeptno tbl_dept.deptno%TYPE 
    , pdname tbl_dept.dname%TYPE DEFAULT NULL
    , ploc tbl_dept.loc%TYPE DEFAULT NULL
)
IS
    vdname dept.dname%TYPE;
    vloc dept.loc%TYPE;
BEGIN
    SELECT dname, loc 
        INTO vdname, vloc
    FROM tbl_dept
    WHERE deptno = pdeptno;
    
    IF pdname IS NULL AND ploc IS NULL THEN
        UPDATE tbl_dept
        SET dname = vdname, loc = vloc
        WHERE deptno = pdeptno;
    ELSIF pdname IS NULL THEN
        UPDATE tbl_dept
        SET dname = vdname, loc = ploc
        WHERE deptno = pdeptno;
    ELSIF ploc IS NULL THE
        UPDATE tbl_dept
        SET dname = pdname, loc = vloc
        WHERE deptno = pdeptno;
    ELSE
        UPDATE tbl_dept
        SET dname = vdname, loc = vloc
        WHERE deptno = pdeptno;
    END IF;

    UPDATE tbl_dept
    SET dname = NVL(pdname, dname), loc = NVL(ploc, loc)
    WHERE deptno = pdeptno;
    COMMIT;
END;

-- [문제점] 없는 부서도 성공이 됨
EXEC up_updateDept(100);

-- 부서 번호를 입력 받아서 해당 부서원들의 정보를 출력하는 저장 프로시저
-- up_selectEMP
-- 모든 사원 조회
CREATE OR REPLACE PROCEDURE up_selectEMP

IS
  vdeptno tbl_emp.deptno%TYPE;
  venmae tbl_emp.ename%TYPE;
  vhiredate tbl_emp.hiredate%TYPE;
  CURSOR curemp IS (SELECT deptno,ename,hiredate FROM tbl_emp);
BEGIN
OPEN curemp;
LOOP
  FETCH curemp INTO vdeptno,venmae,vhiredate;

EXIT WHEN curemp%NOTFOUND;
END LOOP;
DBMS_OUTPUT.PUT_LINE(vdeptno||','||venmae||','||vhiredate);
CLOSE curemp;
END;
-- 지정한 사원만 조회
CREATE OR REPLACE PROCEDURE up_selectEMP
(
    pdeptno tbl_dept.deptno%TYPE 
)
IS
  vdeptno tbl_emp.deptno%TYPE;
  venmae tbl_emp.ename%TYPE;
  vhiredate tbl_emp.hiredate%TYPE;
  CURSOR curemp IS (SELECT deptno,ename,hiredate FROM tbl_emp WHERE deptno = pdeptno);
BEGIN
OPEN curemp;
LOOP
  FETCH curemp INTO vdeptno,venmae,vhiredate;
  DBMS_OUTPUT.PUT_LINE(vdeptno||','||venmae||','||vhiredate);
EXIT WHEN curemp%NOTFOUND;
END LOOP;

CLOSE curemp;
END;

EXEC up_selectEMP (20);
--매개 변수 없는 경우 10번 부서원 출력
CREATE OR REPLACE PROCEDURE up_selectEMP
(
    pdeptno tbl_dept.deptno%TYPE DEFAULT 10
)
IS
  vdeptno tbl_emp.deptno%TYPE;
  venmae tbl_emp.ename%TYPE;
  vhiredate tbl_emp.hiredate%TYPE;
  CURSOR curemp IS (SELECT deptno,ename,hiredate FROM tbl_emp WHERE deptno = pdeptno);
BEGIN
OPEN curemp;
LOOP
  FETCH curemp INTO vdeptno,venmae,vhiredate;
  DBMS_OUTPUT.PUT_LINE(vdeptno||','||venmae||','||vhiredate);
EXIT WHEN curemp%NOTFOUND;
END LOOP;

CLOSE curemp;
END;

EXEC up_selectEMP(20);

-- 커서 파라미터를 이용하는 방법
CREATE OR REPLACE PROCEDURE up_selectEMP
(
    pdeptno tbl_dept.deptno%TYPE DEFAULT 10
)
IS
  vdeptno tbl_emp.deptno%TYPE;
  venmae tbl_emp.ename%TYPE;
  vhiredate tbl_emp.hiredate%TYPE;
  CURSOR curemp(cpdeptno tbl_dept.deptno%TYPE) IS (SELECT deptno,ename,hiredate FROM tbl_emp WHERE deptno = cpdeptno);
BEGIN
OPEN curemp(pdeptno);
LOOP
  FETCH curemp INTO vdeptno,venmae,vhiredate;
  DBMS_OUTPUT.PUT_LINE(vdeptno||','||venmae||','||vhiredate);
EXIT WHEN curemp%NOTFOUND;
END LOOP;

CLOSE curemp;
END;

EXEC up_selectEMP;

--FOR 사용하는 CURSOR
CREATE OR REPLACE PROCEDURE up_selectEMP
(
    pdeptno tbl_dept.deptno%TYPE DEFAULT 10
)
IS
BEGIN
FOR erow IN (SELECT deptno,ename,hiredate FROM tbl_emp WHERE deptno = pdeptno)
LOOP
  DBMS_OUTPUT.PUT_LINE(erow.deptno||','||erow.ename||','||erow.hiredate);
END LOOP;
END;

EXEC up_selectEMP(20);

--  입력용(IN) 매개변수만 저장 프로시저에서 사용
--  출력용(OUT) 매개변수만 저장 프로시저에서 사용
SELECT num,ssn
FROM insa;

--IN num 
--OUT rrn 771212-1******

CREATE OR REPLACE PROCEDURE up_insarrn
(
  pnum IN insa.NUM%TYPE,
  pname OUT insa.name%TYPE,
  prrn OUT VARCHAR2
)
IS
  vrrn insa.SSN%TYPE;
  vname insa.name%TYPE;
BEGIN
  SELECT ssn,name INTO vrrn, vname
  FROM insa
  WHERE num = pnum;

  prrn := SUBSTR(vrrn,1,8) || '******';
  pname := vname;
END;
-- 출력용 매개변수 테스트(익명 프로시저)
DECLARE
  vrrn insa.ssn%TYPE;
  vname insa.name%TYPE;
BEGIN
  up_insarrn(1001,vname,vrrn);
  DBMS_OUTPUT.PUT_LINE(vname||','||vrrn);
--EXCEPTION
END;

-- 입출력용(IN OUT) 매개변수 사용
-- 주민등록 번호 14자리를 입력용 매개변수 -> 주민등록 앞자리 6자리만 츨력용 매개변수
CREATE OR REPLACE PROCEDURE up_rrn
(
  prrn  IN OUT VARCHAR2
)
IS
BEGIN
  prrn := SUBSTR(prrn,1,6);
END;

DECLARE
  vrrn VARCHAR2(14) := '771212-1234567';
BEGIN
  up_rrn(vrrn);
  DBMS_OUTPUT.PUT_LINE(vrrn);
END;

--  1)  저장 프로시저 연습 문제
--  2)  저장 함수(STORED FUNCTION)
--  3)  트리거, 예외처리, 패키지
--  4)  동적 쿼리

CREATE TABLE tbl_score(
    num NUMBER(4) PRIMARY KEY
    , name VARCHAR2(20)
    , kor NUMBER(3)
    , eng NUMBER(3)
    , mat NUMBER(3)
    , tot NUMBER(3)
    , avg NUMBER(5, 2)
    , rank NUMBER(3)
    , grade CHAR(1 CHAR)
);

-- 번호, 이름, 국, 영, 수 -> 파라미터
CREATE OR REPLACE PROCEDURE up_insertScore (
    pnum NUMBER
    , pname VARCHAR2
    , pkor NUMBER
    , peng NUMBER
    , pmat NUMBER
)
IS
    vtot NUMBER(3);
    vavg NUMBER(5, 2);
    vrank NUMBER(4);
    vgrade VARCHAR2(4);
BEGIN
    vtot := pkor + peng + pmat;
    vavg := vtot / 3;
    --vrank := (SELECT COUNT(*)+1 FROM tbl_score WHERE tot>vtot);

  IF vavg >= 90 THEN vgrade := 'A';
  ELSIF vavg >= 80 THEN vgrade := 'B';
  ELSIF vavg >=70 THEN vgrade := 'C';
  ELSIF vavg >= 60 THEN vgrade := 'D';
  ELSE
    vgrade := 'F';
  END IF;

    
    INSERT INTO tbl_score(num, name, kor, eng, mat, tot, avg, rank, grade)
    VALUES(pnum, pname, pkor, peng, pmat,vtot,vavg,vrank,vgrade);

  UPDATE tbl_score a
  SET rank = (SELECT COUNT(*)+1 FROM tbl_score WHERE tot>a.tot);

--EXCEPTION
END; 

EXEC up_insertScore(1001,'홍길동',70,90,80);
EXEC up_insertScore(1002,'홍길동',100,90,80);
EXEC up_insertScore(1003,'홍길동',70,100,90);

SELECT *
FROM tbl_score;

--모든 학생의 등수 처리


CREATE OR REPLACE PROCEDURE up_updateScore
(
    pnum  NUMBER  
  , pkor  NUMBER := NULL
  , peng  NUMBER := NULL 
  , pmat  NUMBER  := NULL
)
IS
  vtot NUMBER(3);
  vavg  NUMBER(5,2);
  vrank NUMBER(4);
  vgrade CHAR(1 CHAR);
  
  vkor  NUMBER(3);
  veng  NUMBER(3);
  vmat  NUMBER(3);
BEGIN
   SELECT kor, eng, mat INTO vkor, veng, vmat
   FROM tbl_score
   WHERE num = pnum;
   
   vtot := NVL(pkor, vkor) + NVL(peng, veng) + NVL(pmat, vmat);
   vavg := vtot / 3 ;
   
   IF vavg >= 90 THEN
     vgrade := 'A';
  ELSIF vavg >= 80 THEN
     vgrade := 'B';
  ELSIF vavg >= 70 THEN
     vgrade := 'C';
  ELSIF vavg >= 60 THEN
    vgrade := 'D';
  ELSE
    vgrade := 'F';
  END IF; 
  
  UPDATE tbl_score
  SET kor = NVL(pkor, vkor), 
      eng = NVL(peng, veng), 
      mat = NVL(pmat, vmat), 
      tot = vtot,
      avg = vavg,
      grade = vgrade
  WHERE num = pnum;
  
  -- 모든 학생들의 등수 매김 다시 
  UPDATE  tbl_score a
  SET rank = ( SELECT COUNT(*)+1 FROM tbl_score WHERE tot > a.tot ); 
  
  COMMIT;
   
   

-- EXCEPTION
END;



EXEC up_updateScore( 1001, 34, 45, 90 );
EXEC up_updateScore( 1001, pkor =>34 );
EXEC up_updateScore( 1001, pkor =>34, pmat => 90 );
EXEC up_updateScore( 1002, peng =>45, pmat => 90 );


SELECT *
FROM tbl_score;

--문제 EXEC up_deletescore(1002) 학번으로 학생 삭제 후 모든 학생 등수 다시
CREATE OR REPLACE PROCEDURE up_deletescore
(
  pnum NUMBER
)
IS
BEGIN
DELETE FROM tbl_score
WHERE
    num = pnum;

UPDATE  tbl_score a
  SET rank = ( SELECT COUNT(*)+1 FROM tbl_score WHERE tot > a.tot ); 
  
  COMMIT;
END;

EXEC up_deletescore(1002);

SELECT *
FROM tbl_score;
--문제 EXEC up_selectscore 모든 학생들 정보 출력

CREATE OR REPLACE PROCEDURE up_selectscore
IS
  CURSOR scursor IS (SELECT num,name,kor,eng,mat,tot,avg,rank,grade FROM tbl_score);
  vrow tbl_score%ROWTYPE;
BEGIN
  OPEN scursor;
  LOOP
    FETCH scursor INTO vrow;
  EXIT WHEN scursor%NOTFOUND;
  DBMS_OUTPUT.PUT_LINE(vrow.num||','||vrow.name||','||vrow.kor||','||vrow.eng||','||vrow.mat||','||
                          vrow.tot||','||vrow.avg||','||vrow.rank||','||vrow.grade);
  END LOOP;
  CLOSE scursor;
END;

EXEC up_selectscore;

CREATE OR REPLACE FUNCTION uf_함수명
(

)
RETURN 리턴 자료형
IS
BEGIN


  RETURN 리턴값;
END;


SELECT num, name, ssn, DECODE(MOD(SUBSTR(ssn,-7,1),2),1,'남자','여자')성별,
      uf_gender(ssn), uf_age(ssm)
FROM insa;

--저장 함수
CREATE OR REPLACE FUNCTION uf_gender
(
  prrn VARCHAR2
)
RETURN VARCHAR2
IS
  vgender VARCHAR2(6);
BEGIN
  IF MOD(SUBSTR(prrn,-7,1),2) = 1 THEN vgender := '남자';
  ELSE
    vgender := '여자';
  END IF;
  RETURN vgender;
--EXCEPTION
END;

CREATE OR REPLACE FUNCTION uf_age
(
  prrn VARCHAR2
)
RETURN NUMBER
IS
  vage NUMBER(3);
  vbirth VARCHAR2(20);
  vcentury NUMBER(2);
BEGIN
      vbirth := SUBSTR(prrn,1,6);
      vcentury := CASE
                WHEN SUBSTR(prrn,-7,1) IN (1,2,5,6) THEN  19
                WHEN SUBSTR(prrn,-7,1) IN (3,4,7,8) THEN  20
                ELSE 18
              END;
  vbirth := vcentury || vbirth;
vage := FLOOR(MONTHS_BETWEEN(SYSDATE,TO_DATE(vbirth,'YYYYMMDD'))/12);
RETURN vage;
END;

-- 강사님
CREATE OR REPLACE FUNCTION UF_AGE
   ( 
       prrn VARCHAR2
       , ca NUMBER
   )
   RETURN NUMBER
   IS
     ㄱ NUMBER(4); -- 올해 년도 2023
     ㄴ NUMBER(4); -- 생일 년도
     ㄷ NUMBER(1); -- 생일 지남 여부 -1 0 1 
     vcounting_age NUMBER(3);
     vamerican_age NUMBER(3);
   BEGIN     
      ㄱ := TO_CHAR( SYSDATE, 'YYYY' ); 
      ㄴ := SUBSTR( prrn, 0, 2 ) + CASE
                                    WHEN SUBSTR( prrn, -7, 1 ) IN (1,2,5,6) THEN 1900
                                    WHEN SUBSTR( prrn, -7, 1 ) IN (3,4,7,8) THEN 2000
                                    WHEN SUBSTR( prrn, -7, 1 ) IN (9,0) THEN 1800
                                   END;
      ㄷ := SIGN( TO_CHAR( SYSDATE, 'MMDD' ) - SUBSTR( prrn, 3, 4 ) );
      
      vcounting_age :=  ㄱ - ㄴ + 1 ;
      -- 오류(95,36): PLS-00204: function or pseudo-column 'DECODE' may be used inside a SQL statement only
      -- vamerican_age := ㄱ - ㄴ + DECODE( ㄷ, -1, -1, 0 ) ;  -- PL/SQL에서는 사용할 수 없다.
      vamerican_age := ㄱ - ㄴ + CASE  ㄷ
                                     WHEN -1 THEN -1  
                                     ELSE 0
                                 END;  
      
      IF ca = 1 THEN
         RETURN vcounting_age;
      ELSE
         RETURN vamerican_age;
      END IF;   
   -- EXCEPTION
   END;


   -- 주민등록 으로 부터 생년월일 을 반환 하는 저장 함수를 만들고 테스트
  -- uf_birth

CREATE OR REPLACE FUNCTION uf_birth
(
  prrn VARCHAR2
)
RETURN VARCHAR2
IS
  vbirth VARCHAR2(20);
  vcentury NUMBER(2);
BEGIN
  vbirth := SUBSTR(prrn,1,6);
  vcentury := CASE
                WHEN SUBSTR(prrn,-7,1) IN (1,2,5,6) THEN  19
                WHEN SUBSTR(prrn,-7,1) IN (3,4,7,8) THEN  20
                ELSE 18
              END;
  vbirth := vcentury || vbirth;
  vbirth := TO_CHAR(TO_DATE(vbirth,'YYYYMMDD'),'YYYY.MM.DD (DY)');
  RETURN vbirth;
END;

SELECT num, name, ssn,uf_gender(ssn), uf_age(ssn),uf_birth(ssn)
FROM insa;
--
-- 매개변수로 cursor 받기
CREATE OR REPLACE PROCEDURE up_selectInsa
(
  pInsaCursor IN SYS_REFCURSOR
)
IS
  vname insa.name%TYPE;
  vcity insa.city%TYPE;
  vbasicpay insa.BASICPAY%TYPE;
BEGIN
  LOOP
    FETCH pInsaCursor INTO vname,vcity,vbasicpay;
    EXIT WHEN pInsaCursor%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(vname||','||vcity||','||vbasicpay);
  END LOOP;
--EXCEPTION
END;

-- 위의 up_selectInsa 테스트 + 또 다른 저장 프로시저 안에서 커서 생성해서 위의 프로시저의 파라미터로 넣어서 테스트
CREATE OR REPLACE PROCEDURE up_selectInsa_TEST
IS
  vInsaCursor SYS_REFCURSOR;
BEGIN
  --OPEN 커서 for문
  OPEN vInsaCursor FOR SELECT name,city,BASICPAY FROM insa;
  up_selectInsa(vInsaCursor);
  CLOSE vInsaCursor;
END;

EXEC up_selectInsa_TEST;