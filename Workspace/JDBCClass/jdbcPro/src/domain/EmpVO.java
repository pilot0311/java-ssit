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
	private String dname;
	
	
	
	@Override
	public String toString() {
		return "EmpVO [empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", hiredate=" + hiredate
				+ ", sal=" + sal + ", comm=" + comm + ", deptno=" + deptno + "]";
	}



	public EmpVO(int empno, String ename, String job, int mgr, String hiredate, int sal, int comm, int deptno) {
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}
	
	
	
	
}
