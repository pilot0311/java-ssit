package days04;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.util.DBConn;

import domain.BoardDTO;
import persistence.BoardDAOImpl;

public class Ex01 {
// 게시판
// 설문조사
// 각자 개별 테스트
// 모델 1방식: 글쓰기,목록,수정,삭제 -> 로직 처리
// 모델 2방식(MVC패턴): 글쓰기 컨트롤러 -> 글쓰기서비스 -> DAO -> DB처리
//							<-		<-		<-		<-
//	MVC: Model 로직처리 객체, View 출력 객체, Controller 모든 요청/처리 담당 객체
	public static void main(String[] args) {
		// 1. 테이블/시퀀스 생성
		// 2. domain.BoardDTO 생성
		// 3. persistance.BoardDAO 인터페이스 생성
		// 4. persistance.BoardDAOImpl 인터페이스 구현 생성
		
		
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


 */
