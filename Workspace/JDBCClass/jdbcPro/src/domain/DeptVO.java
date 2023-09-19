package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DeptVO {
//			이름     널?       유형           
//			------ -------- ------------ 
//			DEPTNO NOT NULL NUMBER(2)    
//			DNAME           VARCHAR2(14) 
//			LOC             VARCHAR2(13) 

	private int deptno;
	private String dname;
	private String loc;
	@Override
	public String toString() {
		return "DeptVO [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + "]";
	}
	
	
	
	}//class
