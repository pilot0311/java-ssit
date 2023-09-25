package days04;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.util.DBConn;

import days04.board.controller.BoardController;
import days04.board.domain.BoardDTO;
import days04.board.persistence.BoardDAO;
import days04.board.persistence.BoardDAOImpl;
import days04.board.service.BoardService;

public class Ex01 {
// 게시판
// 설문조사
// 각자 개별 테스트
// 모델 1방식: 글쓰기,목록,수정,삭제 -> 로직 처리
// 모델 2방식(MVC패턴): 글쓰기 컨트롤러 - DTO -> 글쓰기서비스 - DTO -> DAO -> DB처리
//										<-		<-		<-		<-
//	MVC: Model 로직처리 객체, View 출력 객체, Controller 모든 요청/처리 담당 객체
	public static void main(String[] args) {
		// 1. 테이블/시퀀스 생성
		// 			ㄴtbl_cstvboard, seq_tbl_cstvboard
		// 2. domain.BoardDTO 생성
		// 3. persistance.BoardDAO 인터페이스 생성
		// 	  persistance.BoardDAOImpl 인터페이스 구현 생성
		//		ㄴ selcet(),insert()기능 구현
		// 4. 단위테스트(junit) select(),insert()
		//		days04.test.BoardDAOImplTest
		// 5. 서비스 - 트랜잭션 처리
		//		하나의 게시글 보기
		//			ㄴ 1)로그 기록 dao.로그기록()
		//			ㄴ 2)조회수 1증가 dao.조회수증가(seq)
		//			ㄴ 3)게시글 정보 dao.게시블정보(seq)
		// 6. BoardService 단위테스트
		// 7. BoardController
		//		ㄴ 입력/출력
		// 8. days04.Ex01 테스트
		Connection conn = DBConn.getConnection();
		BoardDAO dao = new BoardDAOImpl(conn);
		BoardService service = new BoardService(dao);
		BoardController controller = new BoardController(service);
		
		controller.boardStart();
		//9. 목록, 새글쓰기, 상세보기
		//10. 삭제
		//11. 수정
		//12. 검색
		//13. 페이징 처리
		//		한페이지에 몇 개의 게시글 출력? int numberPerPage = 10;
		//		현재 페이지 번호? int currentPage = 1;
		//		페이징블럭 수? int numberOfPageBlock = 10; 
		
		
		//	1) 현재 페이지 번호 필드	currentpage
		//	2) 페이지 당 출력 게시글 수 필드	NumberPerPage
		//	3) 페이지 블럭 수 필드
		//	4) 총 레코드 수 BoardDAO.getTotalRecords()
		//	5) 총 페이지 수 BoardDAO.getTotalPages()
		//	6) 쿼리 확인
		//	6-2) WHERE b.no BETWEEN ? AND ?
		//		int begin = (currentPage -1)*numberPerPage+1;
		//		int end = begin + numberPerPage-1;
		//	7) BoardController.목록보기()
		//		service.selectService(currentPage,numberPerPage)
		//		출력
		//	8) service.selectService()
		//		ArrayList<BoardDTO> list = dao.select(currentPage,numberPerPage)
	}//main
}//class


/*
 * CREATE SEQUENCE seq_tbl_cstVSBoard;
 * 테이블 생성
 CREATE TABLE tbl_cstVSBoard (
  seq NUMBER  not null primary key ,
  writer varchar2 (20) not null ,
  pwd varchar2 (20) not null ,
  email varchar2 (100) ,
  title varchar2 (200) not null ,
  writedate date DEFAULT (SYSDATE),
  readed NUMBER DEFAULT (0),
  tag NUMBER(1) DEFAULT (0) ,
  content CLOB null
);

1) sequence 생성
2) tbl_cstVSBoard 테이블 생성
3) BoardDTO
4) BoardDAO, BoardDAOImple -> 단위 테스트
5) BoardService -> 단위 테스트
6) BoardController
7) Ex01.main()
		controller.boardStart();
8)페이징 처리
9) 검색하기() 페이징 처리

 */
