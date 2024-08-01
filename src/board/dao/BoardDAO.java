package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		sb.append("insert into board values(review_seq.nextvql,?,?,?,?,sysdate)");
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
	
	

}
