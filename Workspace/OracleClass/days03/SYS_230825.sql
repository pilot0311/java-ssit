--Ű����(�����) ���̺�
SELECT * FROM DICTIONARY where table_name like '%WORDS%';

SELECT * FROM V$RESERVED_WORDS;

-- table or view does not exist  scott.emp�� ����  sys�� �������� ���ٱ��� ����
-- ��Ű��.��ü�� -> ���� (�ó��)
SELECT *
FROM scott.emp;
FROM emp;

SELECT *
FROM dba_tables
WHERE OWNER = 'SCOTT';

-- PUBLIC �ó�� ���� [PUBLIC �ó��]�� ����, ������ DBA�� ����
--1)DBA�� ����
--2)�ó�� ���� 
-- ����
--CREATE [PUBLIC] SYNONYM [schema.]synonym��
--  	FOR [schema.]object��;

CREATE PUBLIC SYNONYM arirnag
  	FOR scott.emp;
--3) ������ �ó�Կ� ���� ��ü �����ڷ� �����Ѵ�. - scott
SELECT *
FROM arirnag;

-- PUBLIC SYNONYM ����
DROP PUBLIC SYNONYM arirnag;


--�ó�� ���� ��ȸ
SELECT *
FROM all_synonyms; -- ��� �ó�� ����
FROM user_synonyms; -- ����ڰ� ���� �ó�� ����
