package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import domain.EmpVO;

public interface EmpDAO {




	// 검색
	 ArrayList<EmpVO> getSelect(int searchCondition, String searchWord);
	
	// 조회
	 ArrayList<EmpVO> getSelect();
	
	// 추가
	 int add(EmpVO vo);
//사원번호 로 조회
	 EmpVO get(int empno);
// 업데이트// 수정
	 int update(EmpVO vo);
	// 삭제
	 int delete(int empno);
	
	
	
	

}
