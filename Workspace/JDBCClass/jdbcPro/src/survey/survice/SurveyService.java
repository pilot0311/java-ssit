package survey.survice;

import java.sql.SQLException;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import survey.domain.SurveyDTO;
import survey.domain.SurveyOptionDTO;
import survey.domain.VoteDTO;
import survey.persistence.SurveyDAO;

@Data
@AllArgsConstructor
@Builder
public class SurveyService {

	private SurveyDAO dao = null;

	// 투표하기
	public int voteInsertService(VoteDTO dto) {
		int rowCount = 0;

		System.out.println("투표하기 -> 로그 기록 작업...");

		try {
			rowCount = this.dao.voteInsert(dto);
			this.dao.increase();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rowCount;
	}
	// 투표 수정
	public int voteUpdateService(VoteDTO dto) {
		int rowCount = 0;
		System.out.println("투표수정 -> 로그 기록 작업...");
		try {
			rowCount = this.dao.voteUpdate(dto);
			this.dao.increase();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	
	
	// 투표취소
	public int voteDeleteService(String userid,int seq) {
		int rowCount = 0;
		// 1) 로그기록
		System.out.println("게시글 삭제 -> 로그 기록 작업...");
		// 2)
		try {
			rowCount = this.dao.voteDelete(userid, seq);
			this.dao.increase();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rowCount;
	}
	
	
	// 항목 입력
	public int optInsertService(SurveyOptionDTO dto) {
		int rowCount = 0;

		System.out.println("설문 쓰기 -> 로그 기록 작업...");

		try {
			rowCount = this.dao.optinsert(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rowCount;
	}

	// 설문 입력
	public int insertService(SurveyDTO dto) {
		int rowCount = 0;

		System.out.println("설문 쓰기 -> 로그 기록 작업...");

		try {
			rowCount = this.dao.insert(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rowCount;
	}

	// 설문 상세보기 정보 가져오기
	public SurveyDTO viewService(int seq) {
		SurveyDTO dto = null;
		try {

//			ㄴ. 해당 게시글 정보를 조회
			dto = this.dao.view(seq);

//			ㄷ. 로그 기록
			System.out.println("게시글 상세 보기 -> 로그 기록 작업...");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}

	// 설문 항목 불러오기
	public ArrayList<SurveyOptionDTO> optViewService(int seq) {
		ArrayList<SurveyOptionDTO> list = null;

		
		// 2)
		try {
			list = this.dao.optselect(seq);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	// 페이징 처리가 된 목록불러오기
	public ArrayList<SurveyDTO> selectService(int currentPage, int numberPerPage, int searchCondition,String searchWord) {
		ArrayList<SurveyDTO> list = null;

		// 1) 로그기록
		System.out.println("게시글 목록 조회 -> 로그 기록 작업...");
		// 2)
		try {
			list = this.dao.select(currentPage, numberPerPage,searchCondition,searchWord);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public String pageService(int currentPage, int numberPerPage, int numberOfPageBlock) {
		String pagingBlock = "\t\t\t";

		int totalPages;
		try {
			totalPages = this.dao.getTotPages(numberPerPage);
			int start = (currentPage - 1) / numberOfPageBlock * numberOfPageBlock + 1;
			int end = start + numberOfPageBlock - 1;
			end = end > totalPages ? totalPages : end;

			if (start != 1)
				pagingBlock += " < ";
			for (int j = start; j <= end; j++) {
				pagingBlock += String.format(currentPage == j ? "[%d] " : "%d ", j);
			}
			if (end != totalPages)
				pagingBlock += " > ";

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pagingBlock;
	}
}