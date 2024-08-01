package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import board.bean.BoardDTO;
import member.bean.MemberDTO;
import semi.main.Properties;

public class BoardDAO {
	Properties properties = new Properties();
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static BoardDAO instance = new BoardDAO();
	
	public BoardDAO() {
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

	public static BoardDAO getInstance() {
		return instance;
	}

	public boolean write(String travelno, String subject, String content, String memberno) {
		boolean ck = false;
		int su = 0;
		getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("insert into REVIEW values(review_seq.nextval,?,?,?,?,sysdate)");
		try {
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1,travelno);
			pstmt.setString(2,subject);
			pstmt.setString(3,content);
			pstmt.setString(4,memberno);
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(su>0) ck = true;
		return ck;
	}
	
	public BoardDTO getMember(String member_no) {
		BoardDTO boardDTO = null;
		
		getConnection();
		
		String sql = "select * from review where member_no=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member_no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //rs에서 한 줄씩 가져오지만 직접은 어려움 return rs;불가능
				//resultset에 담아옴
				boardDTO = new BoardDTO();
				boardDTO.setContinent(rs.getString("continent"));
				boardDTO.setSubject(rs.getString("subject"));
				boardDTO.setContent(rs.getString("content"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				}
		}
		
		return boardDTO;
	}
	public int update(Map<String, String> map) {
		int su = 0;
		
		getConnection();
		
		String sql = "select * from review where member_no=?";
		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, map.get("continent"));
			pstmt.setString(2, map.get("subject"));
			pstmt.setString(3, map.get("content"));
			
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
		
		return su;
	}
	

}
