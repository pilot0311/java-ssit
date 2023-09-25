package survey.persistence;

import java.sql.SQLException;
import java.util.ArrayList;

import survey.domain.SurveyDTO;
import survey.domain.SurveyOptionDTO;
import survey.domain.VoteDTO;

public interface SurveyDAO {
	// 설문 목록 조회
	ArrayList<SurveyDTO> select(int currentPage,int numberPerPage,int searchCondition,String searchWord) throws SQLException;
	// 설문 상세보기
	SurveyDTO view(int seq) throws SQLException;
	// 설문 항목 보기
	ArrayList<SurveyOptionDTO> optselect(int seq) throws SQLException;
	//설문 입력하기
	int insert(SurveyDTO dto) throws SQLException;
	//설문 항목 입력하기
	int optinsert(SurveyOptionDTO sodto) throws SQLException;
	//페이징 처리
	int getTotRecords()throws SQLException;
	int getTotPages(int numberPerPage)throws SQLException;
	// 투표하기
	int voteInsert(VoteDTO dto) throws SQLException;
	//투표수정
	int voteUpdate(VoteDTO dto)throws SQLException;
	//투표취소
	int voteDelete(String userid, int seq)throws SQLException;
	// 투표수
	void increase() throws SQLException;
}
