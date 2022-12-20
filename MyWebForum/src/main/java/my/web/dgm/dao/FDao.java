package my.web.dgm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import my.web.dgm.dto.FDto;
import my.web.dgm.util.Constant;

public class FDao {
	DataSource dataSource;
	JdbcTemplate template = null;

	public FDao() {
		template = Constant.template;
	}

	// 게시판 리스트 열람
	public ArrayList<FDto> list() {
//		String query = "SELECT * FROM DGM_FORUM ORDER BY BID DESC";
//		String query = "SELECT * FROM DGM_FORUM WHERE ROWNUM <= 20 ORDER BY BID DESC";
		String query = "SELECT * FROM DGM_FORUM ORDER BY bId DESC limit 20";
		ArrayList<FDto> dtos = (ArrayList<FDto>) template.query(query, new BeanPropertyRowMapper<FDto>(FDto.class));
		return dtos;
	}

	// 게시판 글쓰기
	public void write(final String bCategory, final String bTitle, final String bName, final String bContent,
			final String bAccount) {
		template.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//				String query = "insert into DGM_FORUM (bId, bCategory, bTitle, bName, bHit, bContent, bAccount)"
//						+ "values (DGM_FORUM_seq.nextval, ?, ?, ?, 0, ?, ?)";
				String query = "insert into DGM_FORUM (bCategory, bTitle, bName, bHit, bContent, bAccount)"
						+ "values (?, ?, ?, 0, ?, ?)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, bCategory);
				pstmt.setString(2, bTitle);
				pstmt.setString(3, bName);
				pstmt.setString(4, bContent);
				pstmt.setString(5, bAccount);

				return pstmt;
			}
		});
	}

	// 게시글 열람
	public FDto contentView(String strID) {
		upHit(strID); // 조회수 코드
		String query = "select * from DGM_FORUM where bId = " + strID;
		return template.queryForObject(query, new BeanPropertyRowMapper<FDto>(FDto.class));
	}

	// 조회수 구현
	private void upHit(final String bId) {
		String query = "update DGM_FORUM set bHit = bHit + 1 where bId = ?";
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, Integer.parseInt(bId));
			}
		});
	}

	// 게시글 수정창 꺼내기
	public FDto modifyView(String strID) {
		String query = "select * from DGM_FORUM where bId = " + strID;
		return template.queryForObject(query, new BeanPropertyRowMapper<FDto>(FDto.class));
	}

	// 게시글 수정
	public void modify(final String bId, final String bCategory, final String bTitle, final String bName,
			final String bContent, final String bAccount) {
		String query = "update DGM_FORUM set bCategory = ?, bTitle = ?, bName = ?,  bContent = ?, bAccount = ? where bId = ?";
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, bCategory);
				ps.setString(2, bTitle);
				ps.setString(3, bName);
				ps.setString(4, bContent);
				ps.setString(5, bAccount);
				ps.setInt(6, Integer.parseInt(bId));
			}
		});
	}

	public void delete(final String strID) {
		String query = "delete from DGM_FORUM where bId = ?";
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, strID);
			}
		});

	}

}
