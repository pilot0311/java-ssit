package persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.BoardDTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class BoardDAOImpl implements BoardDAO {

	private Connection conn = null;
	//private PreparedStatement pstmt = null;
	@Override
	public ArrayList<BoardDTO> select() throws SQLException {
		String sql = "SELECT seq, title, writer, email, writedate, readed " 
				+ "FROM tbl_cstVSBoard "
				+ "ORDER BY seq DESC ";

		ResultSet rs = null;
		PreparedStatement pstmt = null;

		ArrayList<BoardDTO> list = null;
		BoardDTO vo = null;
		
		int seq;
		String writer;
		String email;
		String title;
		Date writedate;
		int readed;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				list = new ArrayList<>();
				do {
					seq = rs.getInt("seq");
					title = rs.getString("title");
					writer = rs.getString("writer");
					email = rs.getString("email");
					writedate = rs.getDate("writedate");
					readed = rs.getInt("readed");
					vo = BoardDTO.builder()
							.seq(seq)
							.title(title)
							.writer(writer)
							.email(email)
							.writedate(writedate)
							.readed(readed)
							.build();
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
	public int insert(BoardDTO dto) throws SQLException {
		int rowCount = 0;

		String sql = 
				"INSERT INTO tbl_cstVSBoard ( seq, writer, pwd, email, title, tag, content) "
						+ " VALUES ( seq_tbl_cstVSBoard.NEXTVAL,?,?,?,?,?,?)";

		PreparedStatement pstmt = null;
		
		

			pstmt = this.conn.prepareStatement(sql);

			 pstmt.setString(1,  dto.getWriter() );
		     pstmt.setString(2,  dto.getPwd() );
		     pstmt.setString(3,  dto.getEmail() );
		     pstmt.setString(4,  dto.getTitle() );
		     pstmt.setInt(5, dto.getTag());
		     pstmt.setString(6,  dto.getContent() );
			
			
			rowCount = pstmt.executeUpdate();
			
		

		return rowCount;
	}

}
