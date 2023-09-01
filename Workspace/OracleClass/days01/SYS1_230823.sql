-- �ּ�ó��
-- ��� ����� ������ ��ȸ�ϴ� DQL��
SELECT * 
FROM dba_users;
FROM all_users;

-- 1) ������ ����
show user;

-- 2) scott ���� tiger ��й�ȣ ���ο� ����� ���� ����

CREATE USER scott IDENTIFIED BY tiger;

-- CREATE SESSION �ý��� ���� �ο�
-- 1) SYS���� ����
SHOW user;

-- 2) ���� �ο�
GRANT CREATE SESSION TO scott;
GRANT CONNECT, RESOURCE TO scott;
-- 3) ���� ȸ��
REVOKE CREATE SESSION From scott;

-- �̸� ���ǵ� �Ѱ� �ü�������� ��
-- 1) ����Ŭ ��ġ �� �̸� ���ǵ� ���� ��ȸ�ϴ� SQL�� �ۼ�
SELECT * 
FROM dba_roles;

--scott ���� ����
-- 1) sys ����
DROP USER scott;
-- ORA-01940: cannot drop a user that is currently connected ���� �������̶� ���� �ȵ�
-- User SCOTT��(��) �����Ǿ����ϴ�.
SELECT *
FROM all_users;