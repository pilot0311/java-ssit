package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EmpVO {
//	이름       널?       유형           
//			-------- -------- ------------ 
//			EMPNO    NOT NULL NUMBER(4)    
//			ENAME             VARCHAR2(10) 
//			JOB               VARCHAR2(9)  
//			MGR               NUMBER(4)    
//			HIREDATE          DATE         
//			SAL               NUMBER(7,2)  
//			COMM              NUMBER(7,2)  
//			DEPTNO            NUMBER(2)    

	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private String hiredate;
	private int sal;
	private int comm;
	private int deptno;
	
	
	
	
}
