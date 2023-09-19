--  1)  트리거
1) 트리거(TRIGGER): 방아쇠 -> 자동 -> 총구(총알)
    trigger란 어떤 작업전, 또는 작업 후 trigger에 정의한 로직을 실행시키는 PL/SQL 블럭이다
    테이블에 미리 지정한 어떤 이벤트가 발생할 때 활동하도록한 객체를 의미한다.
    트리거 역시 임의의 테이블에 대해 SQL 문장이 실행될 때 임의의 조건을 만족하는 경우 해당되는 명령을 처리하는 방식으로 사용된다
2)  원하지 않는 사용자가 원하지 않는 작업 X
3) 예) 근무시간(9~18)외에는 CRUD 작업 X
       주말        ``                X

4) 예약어
    BEFORE        구문을 실행하기 전에 트리거를 시작  
    AFTER         구문을 실행한 후에 트리거를 시작 
    FOR EACH ROW  행 트리거임을 알림 
    REFERENCING   영향받는 행의 값을 참조 
    :OLD          참조 전 열의 값 
    :NEW          참조 후 열의 값 

예제)
CREATE OR REPLACE TRIGGER test_trigger
BEFORE 
  INSERT OR UPDATE OR DELETE ON tbl_emp

BEGIN
 IF TO_CHAR(SYSDATE,'DY') IN ('SAT','화','TUE') THEN
  DBMS_OUTPUT.PUT_LINE('주말에는 데이터를 변경할 수 없습니다...');
 END IF;
END;

SELECT TO_CHAR(SYSDATE,'DY')
FROM dual;

SELECT *
FROM tbl_emp;

DELETE FROM tbl_emp
WHERE empno = 9999;

INSERT INTO tbl_emp (empno) VALUES(9999);

DROP TRIGGER test_trigger;
commit;

CREATE TABLE EXAM1 (
   id NUMBER PRIMARY KEY
    ,name VARCHAR2(20)
);

CREATE TABLE exam2 (
   memo VARCHAR2(100)
    ,ilja DATE DEFAULT SYSDATE
);

예) exam1 테이블에 IUD 실행시 자동으로 exam2에 로그 기록하는 트리거 생성

SELECT * FROM exam1;
SELECT * FROM exam2;
-- 문장레벨 트리거
CREATE OR REPLACE TRIGGER ut_exam1
AFTER
  INSERT OR UPDATE OR DELETE ON exam1
--FOR EACH ROW 행트리거 WHEN
BEGIN
  IF INSERTING THEN
    INSERT INTO exam2 (memo) VALUES ('추가');
  ELSIF UPDATING THEN
    INSERT INTO exam2 (memo) VALUES ('수정');
  ELSIF DELETING THEN
    INSERT INTO exam2 (memo) VALUES ('삭제');
  END IF;
END;

INSERT INTO exam1 (id,name)VALUES (1,'aaa');
INSERT INTO exam1 (id,name)VALUES (2,'aaa');
INSERT INTO exam1 (id,name)VALUES (3,'aaa');
commit;

UPDATE exam1
SET name = 'xxx'
WHERE id = 3;
-- 문장레벨트리거 : 트리거는 한번만 발생
DELETE FROM exam1;

commit;
SELECT * FROM exam1;
SELECT * FROM exam2;


CREATE OR REPLACE TRIGGER ut_Exam2
   BEFORE INSERT OR DELETE OR UPDATE ON EXAM1
BEGIN
   
   IF TO_CHAR(SYSDATE, 'DAY') IN ('토요일', '일요일') OR
       TO_CHAR(SYSDATE, 'hh24')<12 OR
       TO_CHAR(SYSDATE, 'hh24')>=18 THEN
       raise_application_error(-20000, '지금은 근무 시간이 아니기에 자료 입력(수정, 삭제)이 안되는 시간입니다!');
    END IF;
END;

DROP TRIGGER ut_exam1;
DROP TRIGGER ut_exam2;

DROP TABLE exam1;
DROP TABLE exam2;

--행 트리거 작성을 위한 테이블 작성
CREATE TABLE test1 (
   hak VARCHAR2(10) PRIMARY KEY
    ,name VARCHAR2(20)
    ,kor NUMBER(3)
    ,eng NUMBER(3)
    ,mat NUMBER(3)
);

CREATE TABLE test2 (
   hak VARCHAR2(10) PRIMARY KEY
    ,tot NUMBER(3)
    ,ave NUMBER(4,1)
    ,CONSTRAINT fk_test2_hak FOREIGN KEY(hak) REFERENCES TEST1(hak)
);

-- test1 테이블에 한 학생의 학번 이름 국 영 수 INSERT -> 자동으로 test2에 총점 평균 INSERT 트리거
-- NEW or OLD references not allowed in table level triggers : 행레벨에서만 :NEW, :OLD 사용 가능
CREATE OR REPLACE TRIGGER ut_instest1
AFTER
  INSERT ON test1
  FOR EACH ROW  --행레벨 트리거
DECLARE
  vtot NUMBER(3);
  vavg NUMBER(5,2);
BEGIN
  vtot := :NEW.kor+:NEW.eng+:NEW.mat;
  vavg := vtot/3;
  INSERT INTO test2 (hak,tot,ave)VALUES (:NEW.hak,vtot,vavg);
END;


--
INSERT INTO TEST1(hak, NAME, kor, eng, mat) VALUES ('1', 'a', 100, 70, 80);
INSERT INTO TEST1(hak, NAME, kor, eng, mat) VALUES ('2', 'b', 80, 80, 80);
COMMIT;


-- 학번 1 수정 -> 총점도 수정
CREATE OR REPLACE TRIGGER ut_instest1
AFTER
  INSERT OR UPDATE ON test1
  FOR EACH ROW  --행레벨 트리거
DECLARE
  vtot NUMBER(3);
  vavg NUMBER(5,2);
BEGIN
  vtot := :NEW.kor+:NEW.eng+:NEW.mat;
  vavg := vtot/3;
  IF INSERTING THEN
    INSERT INTO test2 (hak,tot,ave)VALUES (:NEW.hak,vtot,vavg);
  ELSIF UPDATING THEN
    UPDATE test2
    SET tot = vtot, ave = vavg
    WHERE hak = :OLD.hak;
  END IF;
END;


UPDATE TEST1 SET kor=20, eng=20, mat=20 
   WHERE hak=1;
COMMIT;

-- test1에서 1번 학생 삭제
-- test1 -> test2(FK)
CREATE OR REPLACE TRIGGER ut_deltest1
BEFORE
  DELETE ON test1
  FOR EACH ROW  --행레벨 트리거
BEGIN
  DELETE FROM test2
  WHERE hak = :OLD.hak;
END;

DELETE FROM test1
WHERE hak =1;
COMMIT;
SELECT * FROM test1;
SELECT * FROM test2;

--------------------------------트리거 실습 예제---------------------------------------
-- 상품 테이블 작성
CREATE TABLE 상품 (
   상품코드    VARCHAR2(6) NOT NULL PRIMARY KEY
  ,상품명      VARCHAR2(30)  NOT NULL
  ,제조사      VARCHAR2(30)  NOT NULL
  ,소비자가격  NUMBER
  ,재고수량    NUMBER DEFAULT 0
);

-- 입고 테이블 작성
CREATE TABLE 입고 (
   입고번호       NUMBER PRIMARY KEY
  ,상품코드       VARCHAR2(6) NOT NULL CONSTRAINT FK_ibgo_no
                 REFERENCES 상품(상품코드)
  ,입고일자       DATE
  ,입고수량       NUMBER
  ,입고단가       NUMBER
);

-- 판매 테이블 작성
CREATE TABLE 판매 (
   판매번호      NUMBER  PRIMARY KEY
  ,상품코드      VARCHAR2(6) NOT NULL CONSTRAINT FK_pan_no
                REFERENCES 상품(상품코드)
  ,판매일자      DATE
  ,판매수량      NUMBER
  ,판매단가      NUMBER
);

-- 상품 테이블에 자료 추가
INSERT INTO 상품(상품코드, 상품명, 제조사, 소비자가격) VALUES
        ('AAAAAA', '디카', '삼싱', 100000);
INSERT INTO 상품(상품코드, 상품명, 제조사, 소비자가격) VALUES
        ('BBBBBB', '컴퓨터', '엘디', 1500000);
INSERT INTO 상품(상품코드, 상품명, 제조사, 소비자가격) VALUES
        ('CCCCCC', '모니터', '삼싱', 600000);
INSERT INTO 상품(상품코드, 상품명, 제조사, 소비자가격) VALUES
        ('DDDDDD', '핸드폰', '다우', 500000);
INSERT INTO 상품(상품코드, 상품명, 제조사, 소비자가격) VALUES
         ('EEEEEE', '프린터', '삼싱', 200000);
COMMIT;
SELECT * FROM 상품;

-- 입고 테이블에 상품이 들어올시 상품테이블의 재고수량이 update되는 트리거 생성
CREATE OR REPLACE TRIGGER ut_insIpgo
AFTER
  INSERT ON 입고
  FOR EACH ROW
BEGIN
  UPDATE 상품
  SET 재고수량 = 재고수량 + :NEW.입고수량
  WHERE 상품코드 = :NEW.상품코드;
END;


INSERT INTO 입고 (입고번호, 상품코드, 입고일자, 입고수량, 입고단가)
              VALUES (1, 'AAAAAA', '2004-10-10', 5,   50000);
INSERT INTO 입고 (입고번호, 상품코드, 입고일자, 입고수량, 입고단가)
              VALUES (2, 'BBBBBB', '2004-10-10', 15, 700000);
INSERT INTO 입고 (입고번호, 상품코드, 입고일자, 입고수량, 입고단가)
              VALUES (3, 'AAAAAA', '2004-10-11', 15, 52000);
INSERT INTO 입고 (입고번호, 상품코드, 입고일자, 입고수량, 입고단가)
              VALUES (4, 'CCCCCC', '2004-10-14', 15,  250000);
INSERT INTO 입고 (입고번호, 상품코드, 입고일자, 입고수량, 입고단가)
              VALUES (5, 'BBBBBB', '2004-10-16', 25, 700000);
COMMIT;

-- 문제) 

CREATE OR REPLACE TRIGGER ut_upIpgo
AFTER
  UPDATE ON 입고
  FOR EACH ROW
BEGIN
  UPDATE 상품
  SET 재고수량 = 재고수량 - :OLD.입고수량 + :NEW.입고수량
  WHERE 상품코드 = :NEW.상품코드;
END;

UPDATE 입고
SET 입고수량 = 30
WHERE 입고번호 = 5;

-- 문제) 입고 테이블에서 입고가 취소 되어서 입고 삭제 -> 상품 테이블의 제고수량 수정
CREATE OR REPLACE TRIGGER ut_delpgo
AFTER
  DELETE ON 입고
  FOR EACH ROW
BEGIN
  UPDATE 상품
  SET 재고수량 = 재고수량 - :OLD.입고수량
  WHERE 상품코드 = :OLD.상품코드;
END;

DELETE FROM 입고
WHERE 입고번호 = 5;

COMMIT;
SELECT * FROM 상품;
SELECT * FROM 입고;

-- 1) 판매 테이블에 상품이 판매가 되면 상품 테이블에 판매된 상품의 재고수량도 수정
CREATE OR REPLACE TRIGGER ut_insPan
BEFORE
  INSERT ON 판매
  FOR EACH ROW
DECLARE
  qty NUMBER;
BEGIN
  SELECT 재고수량 INTO qty
  FROM 상품
  WHERE 상품코드 = :NEW.상품코드;

  IF qty >= :NEW.판매수량 THEN
    UPDATE 상품 
    SET 재고수량 = 재고수량 - :NEW.판매수량
    WHERE 상품코드 = :NEW.상품코드;
  ELSE
    raise_application_error(-20000,'재고수량 부족으로 판매 오류');
  END IF;
END;


INSERT INTO 판매 (판매번호, 상품코드, 판매일자, 판매수량, 판매단가) VALUES
               (1, 'AAAAAA', '2004-11-10', 5, 1000000);
COMMIT;
ROLLBACK;
SELECT * FROM 상품;
SELECT * FROM 입고;
SELECT * FROM 판매;

--2) AAAAA 5개 판매 -> 판매 수정
-- 상품 테이블 재고 수량 수정
CREATE OR REPLACE TRIGGER ut_upPan
BEFORE
  UPDATE ON 판매
  FOR EACH ROW
DECLARE
  qty NUMBER;
BEGIN
  SELECT 재고수량 INTO qty
  FROM 상품
  WHERE 상품코드 = :NEW.상품코드;
  qty := qty + :OLD.판매수량;
  IF qty >= :NEW.판매수량 THEN
    UPDATE 상품 
    SET 재고수량 = 재고수량 + :OLD.판매수량 - :NEW.판매수량
    WHERE 상품코드 = :NEW.상품코드;
  ELSE
    raise_application_error(-20000,'재고수량 부족으로 판매 오류');
  END IF;
END;

UPDATE 판매
SET 판매수량 = 16
WHERE 판매번호 = 1;

COMMIT;
ROLLBACK;
SELECT * FROM 상품;
SELECT * FROM 입고;
SELECT * FROM 판매;

-- 판매 취소
-- 상품 테이블 재고수량 + 판매 수량

CREATE OR REPLACE TRIGGER ut_delPan
AFTER
  DELETE ON 판매
  FOR EACH ROW
BEGIN
  UPDATE 상품
  SET 재고수량 = 재고수량 + :OLD.판매수량
  WHERE 상품코드 = :OLD.상품코드;
END;

DELETE FROM 판매
WHERE 판매번호 = 1;

COMMIT;
ROLLBACK;
SELECT * FROM 상품;
SELECT * FROM 입고;
SELECT * FROM 판매;

-- 모든 트리커 확인

SELECT *
FROM USER_TRIGGERS;