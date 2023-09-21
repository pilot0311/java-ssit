package days02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.util.DBConn;

import domain.EmpVO;
import persistence.EmpDAO;
import persistence.EmpDAOImpl;

public class Ex04 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//
		// INSERT
		// SELECT
		// UPDATE
		// DELETE
		// persistence.EmpDAO
		
	
		ArrayList<EmpVO>list = new ArrayList<EmpVO>();
		Connection conn = DBConn.getConnection();
		
		EmpDAO dao = new EmpDAOImpl(conn);
		//모든 사원 조회
		//list = dao.getSelect();
		//사원 검색 조회
		/*
		Scanner sc = new Scanner(System.in);
		System.out.println("검색 조건을 입력: ");
		int searchCondition = sc.nextInt();
		System.out.println("검색 조건을 입력: ");
		String searchWord = sc.next();
		list = dao.getSelect(searchCondition,searchWord);
		printList(list);
		*/
		// 사원 추가
		/*
		  int empno;
	      String ename;
	      String job;
	      int mgr;
	      String hiredate; 
	      int sal;
	      int comm;
	      int deptno;

	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	      System.out.print("1. empno 입력 ? ");      
	      empno = Integer.parseInt( br.readLine() );      
	      System.out.print("2. ename 입력 ? ");
	      ename = br.readLine() ;      
	      System.out.print("3. job 입력 ? ");
	      job = br.readLine() ;
	      System.out.print("4. mgr 입력 ? ");
	      mgr = Integer.parseInt( br.readLine() );
	      System.out.print("5. hiredate 입력 ? ");
	      hiredate = br.readLine() ;
	      System.out.print("6. sal 입력 ? ");
	      sal = Integer.parseInt(br.readLine()) ;
	      System.out.print("7. comm 입력 ? ");
	      comm = Integer.parseInt(br.readLine()) ;
	      System.out.print("8. deptno 입력 ? ");
	      deptno = Integer.parseInt( br.readLine() );
	      EmpVO vo = new EmpVO(empno, ename, job, mgr, hiredate, sal, comm, deptno);
	 
		dao.add(vo);
		*/
		//사원 수정
		/*
		int empno;
	    String ename;
	    String job;
	    int mgr;
	    String hiredate; 
	    int sal;
	    int comm;
	    int deptno;

	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    System.out.print("1. 수정할 empno 입력 ? ");      
	    empno = Integer.parseInt( br.readLine() );      
	    EmpVO vo = dao.get(empno);
	    //System.out.println(vo);
	    System.out.print("2. ename 입력 ? ");
	    ename = br.readLine() ;     
	    if(ename.equals(""))ename = vo.getEname();
	    System.out.print("3. job 입력 ? ");
	    job = br.readLine() ;
	    if(job.equals(""))job = vo.getJob();
	    System.out.print("4. mgr 입력 ? ");
	    try {
	    	mgr = Integer.parseInt( br.readLine());
		} catch (Exception e) {
			mgr = vo.getMgr();
		}
	    
	    System.out.print("6. sal 입력 ? ");
	    try {
	    	sal = Integer.parseInt(br.readLine()) ;
		} catch (Exception e) {
			sal = vo.getSal();
		}
	    System.out.print("7. comm 입력 ? ");
	    try {
	    	 comm = Integer.parseInt(br.readLine());
		} catch (Exception e) {
			comm = vo.getComm();
		}
	    System.out.print("8. deptno 입력 ? ");
	    try {
	    	deptno = Integer.parseInt( br.readLine());
		} catch (Exception e) {
			deptno = vo.getDeptno();
		}
	    
	    // 입력 안받으면 예전의 값으로 설정
	    vo = new EmpVO(empno, ename, job, mgr, vo.getHiredate(), sal, comm, deptno);
	    
	    int rowCount = dao.update(vo);
	    if (rowCount == 1)System.out.println("UPDATE 수행됨");
	    */
		// 사원 삭제
		
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 사원 번호입력: ");
		int empno = sc.nextInt();
		int flag = dao.delete(empno);
		if(flag>0)System.out.println("삭제 되었습니다");
		DBConn.close();
		System.out.println("end");
		
		
	}//main
	
	private static void printList(ArrayList<EmpVO> list) {
		if (list == null) {
			System.out.println("사원 없음");
			return;
		}
		int count = list.size();
		System.out.printf("사원수: %d명\n",count);
		Iterator<EmpVO> ir = list.iterator();
		while (ir.hasNext()) {
			EmpVO vo = ir.next();
			System.out.println(vo);
			
		}
	}
	
}//class
