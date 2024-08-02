package travel.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import member.bean.MemberDTO;
import semi.main.Properties;
import travel.bean.TravelDTO;

public class TravelDAO {
	Properties properties = new Properties();
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static TravelDAO instance = new TravelDAO();
	
	public TravelDAO() {
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

	public static TravelDAO getInstance() {
		return instance;
	}

	public boolean isExist(String type, String continent) {
		boolean check = false;
		int su = 0;
		getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM TRAVEL WHERE "+type+" = ?");
		try {
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, continent);
			su = pstmt.executeUpdate();
			if (su > 0) check = true;
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
		return check;
	}

	public void continentList() {
		StringBuilder sb = new StringBuilder();
		getConnection();
		sb.append("select * from continent");
		try {
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("continent"));
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
	}

	public int write(TravelDTO travelDTO) {
		int su = 0;
		getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO TRAVEL(TRAVEL_NO, NAME, CONTINENT, CONTENT) VALUES (travel_sequence.nextval, ?, ?, ?)");
		try {
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, travelDTO.getName());
			pstmt.setString(2, travelDTO.getContinent());
			pstmt.setString(3, travelDTO.getContent());
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

	public ArrayList<TravelDTO> viewSearchList(String type, String value) {
		StringBuilder sb = new StringBuilder();
		ArrayList<TravelDTO> list = new ArrayList<>();
		getConnection();
		sb.append("SELECT t.name, t.travel_no, t.continent, avg_likes.avg_like, t.content ");
		sb.append("FROM travel t ");
		sb.append("LEFT OUTER JOIN FUNCTION f ON t.travel_no = f.travel_no ");
		sb.append("LEFT OUTER JOIN ( ");
		sb.append("    SELECT travel_no, AVG(func_like) AS avg_like ");
		sb.append("    FROM FUNCTION ");
		sb.append("    GROUP BY travel_no ");
		sb.append(") avg_likes ON t.travel_no = avg_likes.travel_no ");
		sb.append("WHERE t."+type+" like ? ");
		sb.append("GROUP BY t.name, t.travel_no, t.continent, avg_likes.avg_like, t.content ");
		try {
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, "%"+value+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				TravelDTO newTravelDTO = new TravelDTO();
				newTravelDTO.setName(rs.getString("name"));
				newTravelDTO.setContent(rs.getString("content"));
				newTravelDTO.setContinent(rs.getString("continent"));
				newTravelDTO.setLike(rs.getDouble("avg_like"));
				list.add(newTravelDTO);
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

	public boolean updateTravel(String type, String value, String name) {
		StringBuilder sb = new StringBuilder();
		boolean ck = false;
		getConnection();
		
		sb.append("UPDATE TRAVEL SET "+type+" = ? WHERE NAME = "+name);
		
		try {
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, value);
			if(pstmt.executeUpdate() > 0) ck = true;
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
		return ck;
	}

	public boolean deleteTravel(String name) {
		boolean ck = false;
		StringBuilder sb = new StringBuilder();
		getConnection();
		sb.append("delete travel where name = ?");
		try {
			pstmt = con.prepareStatement(sb.toString());
			
			pstmt.setString(1, name);
			
			if(pstmt.executeUpdate() > 0) ck = true;
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
		
		return ck;
	}

}
