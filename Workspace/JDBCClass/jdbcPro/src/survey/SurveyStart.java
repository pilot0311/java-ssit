package survey;

import java.sql.Connection;

import com.util.DBConn;

import survey.controller.SurveyController;
import survey.persistence.SurveyDAO;
import survey.persistence.SurveyDAOImpl;
import survey.survice.SurveyService;

public class SurveyStart {

	public static void main(String[] args) {
		Connection conn = DBConn.getConnection();
		SurveyDAO dao = new SurveyDAOImpl(conn);
		SurveyService service = new SurveyService(dao);
		SurveyController controller = new SurveyController(service);
		
		controller.surveyStart();
		//시간 남으면 
		// 1. 투표 수정, 삭제 시 입력받은 userid 목록 불러오기
		// 2. 출력 콘솔 깔끔하게 만들기?
	}
}
