PL/SQL
1. PACKAGE
    PL/SQL�� ��Ű���� ����Ǵ� Ÿ��, ���α׷� ��ü, �������α׷�(procedure, function)�� �������� ���� ���� ��
    
2. ��Ű���� specification�� body �κ����� �Ǿ� ������, ����Ŭ���� �⺻������ �����ϴ� ��Ű���� ������, ������ �̸� �̿��ϸ� ���ϴ�
    specification �κ��� type, constant, variable, exception, cursor, subprogram�� ����ȴ�. 
    body �κ��� cursor, subprogram ������ �����Ѵ�.
    ȣ���� �� '��Ű��_�̸�.���ν���_�̸�' ������ ������ �̿��ؾ� �Ѵ�.

-- ��)
-- 1. ��(specification) �κ�
CREATE OR REPLACE PACKAGE employee_pkg AS 
    PROCEDURE print_ename(p_empno number); 
    PROCEDURE print_sal(p_empno number); 
END employee_pkg;

-- 2. ��ü(BODY)�κ�
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