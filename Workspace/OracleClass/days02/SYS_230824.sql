--sys--
select *
from v$instance;
from v$sga;

select tablespace_name, file_name from dba_data_files;
 
show parameter db_block_size; --8192

select name
from v$tablespace; --���� ����Ŭ ������ �����ϴ� tablespace �̸��� ��ȸ�ϴ� ��ɾ�

select owner, segment_name, extent_id, bytes, blocks
from dba_extents; --dba_extents extends�� ���� ������ ��ȸ�ϴ� sql

-- 1extent = 8192(block)*8  = 65536
select 8192*8
from dual;

SELECT * FROM dba_users;
-- dba_xxx = �����ڸ� ��밡��
--������(SYS)�� HR���� ��� ����
ALTER USER HR ACCOUNT UNLOCK;
ALTER USER HR IDENFIED BY lion;

ALTER USER HR IDENTIFIED  BY lion ACCOUNT UNLOCK;

--����
CREATE USER --����
DROP USER --����
ALTER USER --����
-- ���̺�
CREATE TABLE -- ����
DROP TABLE  -- ����
ALTER TABLE -- ����
-- ���̺� �����̽�
CREATE TABLESPACE -- ����
DROP TABLESPACE -- ����
ALTER TABLESPACE -- ����