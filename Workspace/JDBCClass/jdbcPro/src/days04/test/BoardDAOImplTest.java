package days04.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

import com.util.DBConn;

import days04.board.domain.BoardDTO;
import days04.board.persistence.BoardDAOImpl;

class BoardDAOImplTest {
	
	@Test
	   void totalPagesTest() {
	      Connection conn = DBConn.getConnection();
	      
	      BoardDAOImpl dao = new BoardDAOImpl(conn);
	      
	      try {
	         
	         
	         int totalPages = dao.getTotPages(10);
	         
	         System.out.printf("총 페이지 수: %d",totalPages);
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {         
		         DBConn.close();
		      }
	}
	//@Test
	   void totalRecordsTest() {
	      Connection conn = DBConn.getConnection();
	      
	      BoardDAOImpl dao = new BoardDAOImpl(conn);
	      
	      try {
	         
	         
	         int totalRecords = dao.getTotRecords();
	         
	         System.out.printf("총 레코드 수: %d",totalRecords);
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {         
		         DBConn.close();
		      }
	}

//	   @Test
	   void selectTest() {
	      Connection conn = DBConn.getConnection();
	      
	      BoardDAOImpl dao = new BoardDAOImpl(conn);
	      
	      try {
	         ArrayList<BoardDTO> list = dao.select();
	         
	         if(list == null) {
	            System.out.println("> 게시글은 존재 X");
	            return;
	         }
	         
	         Iterator<BoardDTO> ir = list.iterator();
	         
	         while (ir.hasNext()) {
	            BoardDTO dto = ir.next();
	            System.out.println(dto);
	         }
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {         
	         DBConn.close();
	      }
	      
	   }

//	   @Test
	   void insertTest() {
	      Connection conn = DBConn.getConnection();
	      
	      BoardDAOImpl dao = new BoardDAOImpl(conn);
	      
	      try {
	         BoardDTO dto = BoardDTO.builder()
	                              .writer("dwsa")
	                              .pwd("1234")
	                              .email("dwsa@naver.com")
	                              .title("네 번째 게시글")
	                              .tag(0)
	                              .content("네 번째 게시글 내용")
	                              .build();
	         
	         int rowCount = dao.insert(dto);
	         
	         if(rowCount == 1) {
	            System.out.println("> 게시글 작성 완료!!!");
	            return;
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {         
	         DBConn.close();
	      }
	      
	   }
	}