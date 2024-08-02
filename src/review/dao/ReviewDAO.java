package review.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import review.bean.ReviewDTO;
import semi.main.Properties;
import travel.bean.TravelDTO;

public class ReviewDAO {
	Properties properties = new Properties();
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static ReviewDAO instance = new ReviewDAO();
	
	public ReviewDAO() {
		try {
			Class.forName(properties.getDriver());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void getConnection() {
		try {
			con = DriverManager.getConnection(properties.getUrl(), properties.getUsername(), properties.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ReviewDAO getInstance() {
		return instance;
	}

	public ArrayList<ReviewDTO> viewSearchList(String type, String value) {
		StringBuilder sb = new StringBuilder();
		ArrayList<ReviewDTO> list = new ArrayList<>();
		getConnection();
		sb.append("SELECT ");
		sb.append("    r.REVIEW_NO AS reviewNo, ");
		sb.append("    r.TRAVEL_NAME AS travelName, ");
		sb.append("    r.CONTINENT AS continent, ");
		sb.append("    r.SUBJECT AS subject, ");
		sb.append("    r.CONTENT AS content, ");
		sb.append("    r.REVIEW_COMMENT AS reviewComment, ");
		sb.append("    f.FUNC_LIKE AS funcLike, ");
		sb.append("    m.NAME AS name, ");
		sb.append("    r.LOGTIME AS logtime ");
		sb.append("FROM REVIEW r  ");
		sb.append("JOIN TRAVEL t ON r.TRAVEL_NAME = t.TRAVEL_NAME ");
		sb.append("JOIN MEMBER m ON r.MEMBER_ID = m.ID ");
		sb.append("LEFT JOIN FUNCTION f ON r.TRAVEL_NAME = f.TRAVEL_NAME AND r.MEMBER_ID = f.ID ");
		sb.append("WHERE "+type+" like ? ");
		sb.append("ORDER BY r.LOGTIME DESC");
		try {
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, "%"+value+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReviewDTO newReviewDTO = new ReviewDTO();
				newReviewDTO.setReviewNo(rs.getInt("reviewNo"));
				newReviewDTO.setTravelName(rs.getString("travelName"));
				newReviewDTO.setContinent(rs.getString("continent"));
				newReviewDTO.setSubject(rs.getString("subject"));
				newReviewDTO.setContent(rs.getString("content"));
				newReviewDTO.setReviewComment(rs.getString("reviewComment"));
				newReviewDTO.setLike(rs.getDouble("funcLike"));
				newReviewDTO.setMemberId(rs.getString("name"));
				newReviewDTO.setDate(rs.getString("logtime"));
				list.add(newReviewDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public int write(ReviewDTO reviewDTO) {
		int su = 0;
		getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO REVIEW(REVIEW_NO, TRAVEL_NAME, CONTINENT, MEMBER_ID, SUBJECT, CONTENT) VALUES (REVIEW_SEQUENCE.nextval, ?, ?, ?, ?, ?)");
		try {
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, reviewDTO.getTravelName());
			pstmt.setString(2, reviewDTO.getContinent());
			pstmt.setString(3, reviewDTO.getMemberId());
			
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return su;
	}

}
