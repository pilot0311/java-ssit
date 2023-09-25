package survey.persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import survey.domain.SurveyDTO;
import survey.domain.SurveyOptionDTO;
import survey.domain.VoteDTO;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SurveyDAOImpl implements SurveyDAO {

	private Connection conn = null;

	@Override
	public ArrayList<SurveyDTO> select(int currentPage, int numberPerPage,int searchCondition,String searchWord) throws SQLException {
		int begin = (currentPage - 1) * numberPerPage + 1;
		int end = begin + numberPerPage - 1;
		String sql = "SELECT * " + "FROM (" + "        SELECT ROWNUM no, t.* " 
				+ "        FROM ( "
				+ "                SELECT SURVEY_ID,  USER_ID, START_DATE, END_DATE, TITLE , OPTION_LIST, SURVEY_ALLCNT, REGDATE  "
				+ "                FROM survey " ;
		switch (searchCondition) {
		case 1: // 제목
			sql += " WHERE REGEXP_LIKE(title,?,'i') ";
			break;
		case 2: // 작성자
			sql += " WHERE REGEXP_LIKE(user_id,?,'i') ";
			break;
		case 3: // 작성자+제목
			sql += " WHERE REGEXP_LIKE(title,?,'i') OR REGEXP_LIKE(user_id,?,'i') ";
			break;
		default:
			break;
		}
		sql = sql + " ORDER BY SURVEY_ID DESC " + "        ) t "+ ")  b     " + "WHERE b.no BETWEEN ? AND ?";

		ResultSet rs = null;
		PreparedStatement pstmt = null;

		ArrayList<SurveyDTO> list = null;
		SurveyDTO vo = null;

		int surveyId;
		String userId;
		Date startDate;
		Date endDate;
		String title;
		int optionList;
		int surveyAllCnt;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, begin);
			pstmt.setInt(2, end);
			
			switch (searchCondition) {
			case 1: // 제목
			case 2: // 작성자
				pstmt.setString(1, searchWord);
				pstmt.setInt(2, begin);
				pstmt.setInt(3, end);
				break;
			case 3: // 작성자+제목
				pstmt.setString(1, searchWord);
				pstmt.setString(2, searchWord);
				pstmt.setInt(3, begin);
				pstmt.setInt(4, end);
				break;
			default:
				pstmt.setInt(1, begin);
				pstmt.setInt(2, end);
				break;
			}
			
			rs = pstmt.executeQuery();

			if (rs.next()) {
				list = new ArrayList<>();
				do {
					surveyId = rs.getInt("survey_id");
					userId = rs.getString("user_id");
					startDate = rs.getDate("start_date");
					endDate = rs.getDate("end_date");
					title = rs.getString("title");
					optionList = rs.getInt("option_list");
					surveyAllCnt = rs.getInt("survey_allcnt");
					vo = SurveyDTO.builder().surveyId(surveyId).userId(userId).startDate(startDate).endDate(endDate)
							.title(title).optionList(optionList).surveyAllCnt(surveyAllCnt).build();
					list.add(vo);
				} while (rs.next());

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public SurveyDTO view(int seq) throws SQLException {
		String sql = " SELECT * " + " FROM survey " + " WHERE SURVEY_ID = ? ";
		SurveyDTO dto = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		pstmt = this.conn.prepareStatement(sql);
		pstmt.setInt(1, seq);
		rs = pstmt.executeQuery();

		if (rs.next()) {
			dto = SurveyDTO.builder().surveyId(rs.getInt("survey_id")).userId(rs.getString("user_id"))
					.startDate(rs.getDate("start_date")).endDate(rs.getDate("end_date")).title(rs.getString("title"))
					.optionList(rs.getInt("option_list")).surveyAllCnt(rs.getInt("survey_allcnt")).build();
		}

		rs.close();
		pstmt.close();
		return dto;
	}

	@Override
	public ArrayList<SurveyOptionDTO> optselect(int seq) throws SQLException {
		String sql = " SELECT * " + " FROM survey_option " + " WHERE survey_id = ? ";

		ResultSet rs = null;
		PreparedStatement pstmt = null;

		ArrayList<SurveyOptionDTO> list = null;
		SurveyOptionDTO vo = null;

		int surveyId;
		int optionId;
		int optionCnt;
		String optionContent;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				list = new ArrayList<>();
				do {
					surveyId = rs.getInt("survey_id");
					optionId = rs.getInt("option_id");
					optionCnt = rs.getInt("option_cnt");
					optionContent = rs.getString("option_content");
					vo = SurveyOptionDTO.builder().surveyId(surveyId).optionId(optionId).optionCnt(optionCnt)
							.optionContent(optionContent).build();
					list.add(vo);
				} while (rs.next());

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public int insert(SurveyDTO dto) throws SQLException {
		int rowCount = 0;

		String sql = "INSERT INTO SURVEY " + " VALUES (survey_seq.NEXTVAL,?,SYSDATE,?,?,?,0,SYSDATE)";

		PreparedStatement pstmt = null;

		pstmt = this.conn.prepareStatement(sql);

		pstmt.setString(1, dto.getUserId());
		pstmt.setDate(2, dto.getEndDate());
		pstmt.setString(3, dto.getTitle());
		pstmt.setInt(4, dto.getOptionList());

		rowCount = pstmt.executeUpdate();

		return rowCount;
	}

	@Override
	public int optinsert(SurveyOptionDTO sodto) throws SQLException {
		int rowCount = 0;

		String sql = "INSERT INTO survey_option " + " VALUES (survey_seq.currval,?,0,?)";

		PreparedStatement pstmt = null;

		pstmt = this.conn.prepareStatement(sql);

		pstmt.setInt(1, sodto.getOptionId());
		pstmt.setString(2, sodto.getOptionContent());

		rowCount = pstmt.executeUpdate();

		return rowCount;
	}

	@Override
	public int getTotRecords() throws SQLException {
		int totalRecords = 0;

		String sql = "SELECT COUNT(*) FROM SURVEY ";

		PreparedStatement pstmt = null;

		pstmt = conn.prepareStatement(sql);
		ResultSet rs = null;
		rs = pstmt.executeQuery();
		if (rs.next())
			totalRecords = rs.getInt(1);

		rs.close();
		pstmt.close();

		return totalRecords;
	}

	@Override
	public int getTotPages(int numberPerPage) throws SQLException {
		int totalPages = 0;

		String sql = "SELECT CEIL(COUNT(*)/?) FROM SURVEY ";

		PreparedStatement pstmt = null;

		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, numberPerPage);
		ResultSet rs = null;
		rs = pstmt.executeQuery();
		if (rs.next())
			totalPages = rs.getInt(1);

		rs.close();
		pstmt.close();

		return totalPages;
	}

	@Override
	public int voteInsert(VoteDTO dto) throws SQLException {
		int rowCount = 0;

		String sql = "INSERT INTO VOTE VALUES (?,?,?)";

		PreparedStatement pstmt = null;

		pstmt = this.conn.prepareStatement(sql);

		pstmt.setString(1, dto.getUser_id());
		pstmt.setInt(2, dto.getSurvey_id());
		pstmt.setInt(3, dto.getOption_id());

		rowCount = pstmt.executeUpdate();

		return rowCount;
	}

	@Override
	public int voteUpdate(VoteDTO dto) throws SQLException {
		int rowCount = 0;
		String sql = "UPDATE vote "
				+ "SET option_id = ? "
				+ "WHERE user_id = ? AND vote.survey_id = ? ";

		PreparedStatement pstmt = this.conn.prepareStatement(sql);
		pstmt.setInt(1, dto.getOption_id());
		pstmt.setString(2, dto.getUser_id());
		pstmt.setInt(3, dto.getSurvey_id());
		rowCount = pstmt.executeUpdate();
		pstmt.close();

		return rowCount;
	}

	@Override
	public int voteDelete(String userid, int seq) throws SQLException {
		int rowCount = 0;

		String sql = "DELETE FROM vote WHERE user_id = ? AND survey_id = ? ";

		PreparedStatement pstmt = null;

		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userid);
		pstmt.setInt(2, seq);
		rowCount = pstmt.executeUpdate();
		pstmt.close();
		return rowCount;
	}

	@Override
	public void increase() throws SQLException {
		String sql ="{call update_cnt }";
		
		CallableStatement cstmt = null;
		cstmt = this.conn.prepareCall(sql);
		cstmt.executeUpdate();
		cstmt.close();
	}

}