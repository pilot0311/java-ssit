PL/SQL
1. PACKAGE
    PL/SQL의 패키지는 관계되는 타입, 프로그램 객체, 서브프로그램(procedure, function)을 논리적으로 묶어 놓은 것
    
2. 패키지는 specification과 body 부분으로 되어 있으며, 오라클에서 기본적으로 제공하는 패키지가 있으며, 간단히 이를 이용하면 편리하다
    specification 부분은 type, constant, variable, exception, cursor, subprogram이 선언된다. 
    body 부분은 cursor, subprogram 따위가 존재한다.
    호출할 때 '패키지_이름.프로시저_이름' 형식의 참조를 이용해야 한다.

-- 예)
-- 1. 명세(specification) 부분
CREATE OR REPLACE PACKAGE employee_pkg AS 
    PROCEDURE print_ename(p_empno number); 
    PROCEDURE print_sal(p_empno number); 
END employee_pkg;

-- 2. 몸체(BODY)부분
CREATE OR REPLACE PACKAGE BODY employee_pkg as 
   
      procedure print_ename(p_empno number) is 
        l_ename emp.ename%type; 
      begin 
        select ename 
          into l_ename 
          from emp 
          where empno = p_empno; 
       dbms_output.put_line(l_ename); 
     exception 
       when NO_DATA_FOUND then 
         dbms_output.put_line('Invalid employee number'); 
     end print_ename; 
  
   procedure print_sal(p_empno number) is 
     l_sal emp.sal%type; 
   begin 
     select sal 
       into l_sal 
       from emp 
       where empno = p_empno; 
     dbms_output.put_line(l_sal); 
   exception 
     when NO_DATA_FOUND then 
       dbms_output.put_line('Invalid employee number'); 
   end print_sal; 
  
   end employee_pkg; 
execute employee_pkg.print_ename(7782); 



-----------------
create or replace TRIGGER Movie_rsToView_history
AFTER INSERT ON movie_rs 
FOR EACH ROW
DECLARE
    vend_time DATE;
BEGIN 
    SELECT DISTINCT end_time INTO vend_time
    FROM show s JOIN movie_rs m ON s.show_id = m.show_id
    WHERE s.show_id = m.show_id;
    IF (TO_CHAR(SYSDATE, 'HH24MI') - TO_CHAR(vend_time, 'HH24MI') > 0) THEN 
        INSERT INTO view_history(user_id, mv_id, mv_title, view_datetime, cinema_id, theater_id, num_people)
        SELECT user_id, movie_id, mv_title, start_time , theater_id, screen_id, totcnt 
        FROM(
            SELECT user_id, movie_id, mv_title, start_time , theater_id, screen_id, totcnt
            FROM watchview
            ORDER BY ROWNUM DESC
        )
        WHERE ROWNUM = 1;
    END IF;
END;  