-- HR ������ �����ϰ� �ִ� ���� ���̺� ��ȸ
SELECT *
FROM user_tables;
-- ��� ������ �����ϰ� �ִ� ���̺� 
SELECT * FROM EMPLOYEES;
-- ��� ������ �����ϰ� �ִ� ���̺� ���� first last name + ��ü �̸� ���
SELECT first_name, last_name FROM EMPLOYEES;
SELECT first_name, last_name, concat(first_name, last_name) as name FROM EMPLOYEES;
SELECT first_name, last_name, first_name || ' ' || last_name as name FROM EMPLOYEES;
-- ����Ŭ =  '���ڿ�'  '��¥����'
--REGIONS
--COUNTRIES
--LOCATIONS
--DEPARTMENTS
--JOBS
--EMPLOYEES
--JOB_HISTORY

--table or view does not exist
-- emp���̺�(��ü)�� ������ �����ڵ� �ƴϰ� SELECT���ѵ� X
SELECT *
FROM emp;
--HR�� ���̺� ���� ����
SELECT * FROM tabs 