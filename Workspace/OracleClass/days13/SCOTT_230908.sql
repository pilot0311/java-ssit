commit;

SELECT *
FROM tbl_dept;

DROP TABLE tbl_dept;
-- 모델링 질문--
사원테이블
ㄴ 정규직
ㄴ 비정규직

(1) 슈퍼 타입: 전체를 하나의 테이블로 관리
공통속성(컬럼)
[][][][][][][정][정][정][비][비][비]
[][][][][][][정][정][정][NULL][NULL][NULL]  정규직이면
[][][][][][][NULL][NULL][NULL][비][비][비]   비정 규직이면 
null로 낭비되는 컬럼이 나옴
(2) 서브 타입: 정규직, 비정규직 사원...서브 타입의 갯수 만큼 테이블로 관리
정규직사원테이블
[][][][][][][정][정][정]
비정규직사원 테이블
[][][][][][][비][비][비]

(3)
사원테이블
[][][][][][] --공통적인 칼럼
정규직테이블
[정][정][정] --정규직만 가지는 칼럼
비정규직 테이블
[비][비][비] -- 비정규직만 가지는 칼럼


설문조사-필요 쿼리 (정리) -> jdbc-> html,css,js -> jsp/sevlet 처리

-- 시퀀스 (SEQUENCE)
-- 자동 일련번호 생성
-- dept 테이블의 deptno를 시퀀스를 생성해서 사용
;
SELECT MAX(deptno)
FROM dept;

--
【형식】
	CREATE SEQUENCE 시퀀스명
	[ INCREMENT BY 정수]
	[ START WITH 정수]
	[ MAXVALUE n ? NOMAXVALUE]
	[ MINVALUE n ? NOMINVALUE]
	[ CYCLE ? NOCYCLE]
	[ CACHE n ? NOCACHE];
    
    CREATE SEQUENCE seq_deptno;
    모든 옵션 생략시
    [ INCREMENT BY 1]  10
	[ START WITH 1]    50
	[ MAXVALUE 9999999999999999999999999999 ]  90
	[ MINVALUE 1 ]
	[  NOCYCLE  ]
	[ CACHE 20     NOCACHE;
    
    DROP SEQUENCE seq_deptno;
    
    CREATE SEQUENCE seq_deptno
     INCREMENT BY 10
	 START WITH 50
	 MAXVALUE  90
	 NOCACHE;
    
    
    INSERT INTO dept VALUES (seq_deptno.NEXTVAL,'QC',NULL);
    SELECT *
    FROM dept;
    
    SELECT seq_deptno.CURRVAL
    FROM dual;
    ROLLBACK;
    -- 50 
    
    CREATE SEQUENCE seq_test;
    DROP SEQUENCE seq_deptno;
    --EQ_TEST.CURRVAL is not yet defined in this session  -> NEXTVAL먼저 쓰고 사용해야 됨
    SELECT seq_test.CURRVAL
    FROM dual;
    
    
SELECT *
FROM user_sequences;
FROM seq;


---------
--PL/SQL--
--  Procedural Language extensions to SQL
--절차적 언어(변수,제어문) + 확장 SQL
-- 블록 구조로 된 언어
-- 형식)
[DECLARE]
    1)선언 블럭
BEGIN
    2)실행 블럭
    SELECT
    INSERT
    UPDATE
    DELETE
    ...
[EXCEPTION]
    3)예외 처리 블럭
END
-- PL/SQL의 6가지 종류
    1) 익명 프로시저
    2) 저장 프로시저
    3) 저장 함수
    4) 패키지
    5) 트리거
    --6) 객체 X
;
예)
DESC insa;
--1) 익명 프로시저
-- 변수 값을 할당하는 방법
    1) :=
    2)  SELECT 또는 fetch 절 에서 INTO 문

DECLARE
-- 선언 블럭: 변수 선언
-- 일반변수 v, 매개변수 p
    --vname VARCHAR2(20);
    --vpay NUMBER(10);
    vname INSA.name%TYPE; -- 타입형 변수
    vpay NUMBER(10);
    vpi CONSTANT NUMBER := 3.141592;
    vmessage VARCHAR(100);
BEGIN
-- 실행 블럭
    SELECT name,basicpay+sudang
        INTO vname, vpay
    FROM insa
    WHERE num = 1001;
    --DBMS_OUTPUT.PUT_LINE('사원명=' || vname);
    --DBMS_OUTPUT.PUT_LINE('급여=' || vpay);
    vmessage := vname || ',' || vpay;
    DBMS_OUTPUT.PUT_LINE('결과 :' || vmessage);
--EXCEPTION
END;

-- 문제) 30번 부서의 지역명을 얻어 와서 10번 부서의 지역명으로 설정
SELECT *
FROM dept;

DECLARE
    vloc dept.loc%TYPE;
BEGIN
    SELECT loc INTO vloc
    FROM dept
    WHERE deptno = 30;
    
    UPDATE dept
    SET loc = vloc
    WHERE deptno = 10;
--EXCEPTION
END;

--문제) 10번 부서원 중에 최고 sal를 받는 사원의 정보 조회
-- 1) Top -n 방식
SELECT *
FROM(
SELECT *
FROM emp
WHERE deptno = 10
ORDER BY sal desc
)t
WHERE ROWNUM =1;
-- 2) rank
SELECT *
FROM(
SELECT e.*
    , RANK()OVER(ORDER BY sal DESC)sal_rank
FROM emp e
WHERE deptno = 10
)
WHERE sal_rank =1;
--3)서브 쿼리
SELECT *
FROM emp
WHERE deptno = 10 AND sal = (SELECT MAX(sal) FROM emp WHERE deptno = 10);
-- 4) 익명 프로시저 사용해서 처리
DECLARE
    vmax_sal_10 emp.sal%TYPE;
    vempno emp.empno%TYPE;
    vename emp.ename%TYPE;
    vjob emp.job%TYPE;
    vsal emp.sal%TYPE;
    vhiredate emp.hiredate%TYPE;
    vdeptno emp.deptno%TYPE;
BEGIN

SELECT MAX(sal) INTO vmax_sal_10
FROM emp 
WHERE deptno = 10;

SELECT empno,ename,job,sal,hiredate,deptno
       INTO vempno,vename,vjob,vsal,vhiredate,vdeptno
FROM emp
WHERE deptno = 10 AND sal = vmax_sal_10;

DBMS_OUTPUT.PUT_LINE('사원번호: ' || vempno);
DBMS_OUTPUT.PUT_LINE('사원명: ' || vename);
DBMS_OUTPUT.PUT_LINE('입사일자: ' || vhiredate);
--EXCEPTION
END;

-- PL/SQL 에서 여러개의 레코드를 가져와서 처리하기 위해서는 반드시 커서(cursor)를 사용해야 한다
--ORA-01422: exact fetch returns more than requested number of rows
DECLARE
    vname INSA.name%TYPE; -- 타입형 변수
    vpay NUMBER(10);
    vmessage VARCHAR(100);
BEGIN
    SELECT name,basicpay+sudang
        INTO vname, vpay
    FROM insa;
    
    --출력
    vmessage := vname || ',' || vpay;
    DBMS_OUTPUT.PUT_LINE('결과 :' || vmessage);
--EXCEPTION
END;
--
--[4-2]
DECLARE
    vmax_sal_10 emp.sal%TYPE;
   vrow emp%ROWTYPE;  -- 레코드형 변수
BEGIN

SELECT MAX(sal) INTO vmax_sal_10
FROM emp 
WHERE deptno = 10;

SELECT empno,ename,job,sal,hiredate,deptno
       INTO vrow.empno,vrow.ename,vrow.job,vrow.sal,vrow.hiredate,vrow.deptno
FROM emp
WHERE deptno = 10 AND sal = vmax_sal_10;

DBMS_OUTPUT.PUT_LINE('사원번호: ' || vrow.empno);
DBMS_OUTPUT.PUT_LINE('사원명: ' || vrow.ename);
DBMS_OUTPUT.PUT_LINE('입사일자: ' || vrow.hiredate);
--EXCEPTION
END;
------------
--IF...THEN...ELSE 문
--자바
if(조건){
}
--
if(조건){
}else{
}
--
if(조건){
}else if(조건){
}else if(조건){
}else if(조건){
}else{
}

--PL/SQL
IF (조건식) THEN
END IF;
--
IF (조건식) THEN
ELSE
END IF;
--
IF (조건식) THEN
ELSIF (조건식) THEN
ELSIF (조건식) THEN
ELSIF (조건식) THEN
ELSE
END IF;
--
--문제 변수를 하나 선언해서 점수를 입력 받아서 짝수 홀수 출력
DECLARE
  vnum NUMBER(4) := 0;
  vresult nvarchar2(2) := '홀수';
BEGIN
  vnum := :bindnumber;
  
IF (MOD(vnum,2)=0) THEN
    vresult := '짝수';
--ELSE
   -- vresult := '홀수';
END IF;
  DBMS_OUTPUT.PUT_LINE(vnum||':'||vresult);
--EXCEPTION
END;

-- 문제 국어점수입력 받아서 수 ~ 가 출력



DECLARE
  vkor NUMBER(4) := 0;
  vgrade varchar2(3) := '가';
BEGIN
  vkor := :bindnumber;
IF(vkor BETWEEN 0 AND 100) THEN 
    IF (vkor BETWEEN 90 AND 100) THEN
    vgrade := '수';
    ELSIF (vkor BETWEEN 80 AND 89) THEN
    vgrade := '우';
    ELSIF (vkor BETWEEN 70 AND 79) THEN
    vgrade := '미';
    ELSIF (vkor BETWEEN 60 AND 69) THEN
    vgrade := '양';
    ELSIF (vkor < 60 ) THEN
    vgrade := '가';
    END IF;
  DBMS_OUTPUT.PUT_LINE(vkor||':'||vgrade);
ELSE
  DBMS_OUTPUT.PUT_LINE(vkor||': 0~100 사이만 가능');
END IF;
--EXCEPTION
END;
--------

DECLARE
  vkor NUMBER(4) := 0;
  vgrade varchar2(3) := '가';
BEGIN
  vkor := :bindnumber;
IF(vkor BETWEEN 0 AND 100) THEN
   vgrade := CASE TRUNC(vkor/10)
    WHEN 10 THEN  '수'
    WHEN 9 THEN '수'
    WHEN 8 THEN '우'
    WHEN 7 THEN '미'
    WHEN 6 THEN '양'
    ELSE'가'
    END;
  DBMS_OUTPUT.PUT_LINE(vkor||':'||vgrade);
ELSE
  DBMS_OUTPUT.PUT_LINE(vkor||': 0~100 사이만 가능');
END IF;
--EXCEPTION
END;

--


-- oracle
LOOP
--
--
EXIT WHEN 조건
END LOOP;

예) 1~10 = 55
DECLARE
    vi NUMBER := 1;
    vsum NUMBER := 0;
BEGIN
    LOOP
      IF vi = 10 THEN
        DBMS_OUTPUT.PUT(vi);
      ELSE
        DBMS_OUTPUT.PUT(vi || '+');
      END IF;
      --vsum += vi;
      vsum := vsum + vi;
    EXIT WHEN vi = 10;
      vi := vi + 1;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('=' || vsum);
--EXCEPTION
END;


-- WHILE ... LOOP(제한적 반복)문
WHILE(조건식)
LOOP
--
--
END LOOP;
--예) 1~10 = 55
DECLARE
    vi NUMBER := 1;
    vsum NUMBER := 0;
BEGIN
    WHILE(vi <= 10)
    LOOP
      IF vi = 10 THEN
        DBMS_OUTPUT.PUT(vi);
      ELSE
        DBMS_OUTPUT.PUT(vi || '+');
      END IF;
      vsum := vsum + vi;
      vi := vi + 1;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('=' || vsum);
--EXCEPTION
END;

-- FOR...LOOP(제한적 반복)문
FOR 반복변수 IN [REVERSE] 시작값.. 끝값
LOOP
-- 반복처리 구문
--
END LOOP;
-- 예) 1~ 10 =55
DECLARE 
  vi NUMBER := 1;
  vsum NUMBER := 0;
BEGIN
  FOR vi IN 1.. 10
  LOOP
    DBMS_OUTPUT.PUT(vi || '+');
    vsum := vsum + vi;
  END LOOP;
  DBMS_OUTPUT.PUT_LINE('=' || vsum);
--EXCEPTION
END;
-----------------------------
DECLARE 
  --vi NUMBER := 1;
  vsum NUMBER := 0;
BEGIN
  FOR vi IN REVERSE 1.. 10
  LOOP
    DBMS_OUTPUT.PUT(vi || '+');
    vsum := vsum + vi;
  END LOOP;
  DBMS_OUTPUT.PUT_LINE('=' || vsum);
--EXCEPTION
END;
---
--DECLARE
BEGIN
  
  GOTO first_proc;
  
  <<second_proc>>
  DBMS_OUTPUT.PUT_LINE('> 2 처리');
  GOTO third_proc;
  
  <<first_proc>>
  DBMS_OUTPUT.PUT_LINE('> 1 처리');
  GOTO second_proc;
  
   <<third_proc>>
  DBMS_OUTPUT.PUT_LINE('> 3 처리');
  

--EXCEPTION
END;

-- 구구단(2~9) 출력
1) WHILE LOOP ~ END LOOP 사용
2) FOR LOOP ~ END LOOP

DECLARE
vi1 number := 2;
vi2 number := 1;
vresult number := 0;
BEGIN
FOR vi1 IN 2..9
LOOP
  FOR vi2 IN 1..9
  LOOP
  DBMS_OUTPUT.PUT_LINE(vi1 || '*' || vi2 || '=' || vi1*vi2);
  END LOOP;
END LOOP;

END;


DECLARE
vi1 number := 2;
vi2 number := 1;
vresult number := 0;
BEGIN
WHILE(vi1 <= 9)
LOOP
DBMS_OUTPUT.PUT_LINE(vi1 ||'단');
  WHILE(vi2 <= 9)
  LOOP
  DBMS_OUTPUT.PUT(vi1 || '*' || vi2 || '=' || vi1*vi2||'   ');
  vi2 := vi2 + 1;
  END LOOP;
DBMS_OUTPUT.PUT_LINE(' ');
vi1 := vi1 + 1;
vi2 := 1;
END LOOP;

END;




SELECT
  *
FROM
  EMP;

  --비쥬얼 코드 테스팅?