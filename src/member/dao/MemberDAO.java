package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import semi.main.Properties;

public class MemberDAO {
	Properties properties;
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static MemberDAO instance = new MemberDAO();
	
	public MemberDAO() {
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

	public static MemberDAO getInstance() {
		return instance;
	}

}
