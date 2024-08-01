package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import member.bean.MemberDTO;
import semi.main.Properties;

public class MemberDAO {
	Properties properties = new Properties();
	
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

	public int write(MemberDTO memberDTO) {
		int su = 0;
		getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("insert into member(MEMBER_NO, name, id, pwd, phone, address, admin) values(member_sequence.nextval, ?, ?, ?, ?, ?, 0)");
		try {
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, memberDTO.getName());
			pstmt.setString(2, memberDTO.getId());
			pstmt.setString(3, memberDTO.getPwd());
			pstmt.setString(4, memberDTO.getPhone());
			pstmt.setString(5, memberDTO.getAddress());
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

	public boolean isExist(String id, String value) {
		int su = 0;
		boolean check = false;
		getConnection();
		StringBuilder sb = new StringBuilder();
		if (value.equals("id")) {
			sb.append("select * from member where id = ?");
		} else if(value.equals("phone"))
			sb.append("select * from member where phone = ?");
		try {
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, id);
			su = pstmt.executeUpdate();
			if (su > 0 && value.equals("id")) {
				System.out.println("중복된 아이디입니다");
				check = true;
			} else if (su > 0 && value.equals("phone")) {
				System.out.println("중복된 번호입니다");
				check = true;
			}
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

	public MemberDTO loginInfo(String id, String pwd, MemberDTO memberDTO) {
		StringBuilder sb = new StringBuilder();
		getConnection();
		sb.append("select * from member where id = ? and pwd = ?");
		try {
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberDTO.setMemberNo(rs.getInt("member_no"));
				memberDTO.setId(rs.getString("id"));
				memberDTO.setPwd(rs.getString("pwd"));
				memberDTO.setName(rs.getString("name"));
				memberDTO.setPhone(rs.getString("phone"));
				memberDTO.setAddress(rs.getString("address"));
				memberDTO.setAdmin(rs.getInt("admin"));
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
		return memberDTO;
	}
	
	public boolean isExistPwd(String id, String pwd) {
		boolean ck = false;
		StringBuilder sb = new StringBuilder();
		getConnection();
		sb.append("select * from member where id = ? and pwd = ?");
		try {
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if(rs.next()) ck = true;
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
		return ck;
	}
	
	public boolean deleteMember(String id) {
		boolean ck = false;
		StringBuilder sb = new StringBuilder();
		getConnection();
		sb.append("delete member where id = ?");
		try {
			pstmt = con.prepareStatement(sb.toString());
			
			pstmt.setString(1, id);
			
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

	public boolean updateMember(String type, String value, String id, String pwd) {
		StringBuilder sb = new StringBuilder();
		boolean ck = false;
		getConnection();
		
		if(type.equals("name")) {
			sb.append("UPDATE MEMBER SET NAME = ? WHERE ID = ? and PWD = ?");
		} else if (type.equals("id")) {
			sb.append("UPDATE MEMBER SET ID = ? WHERE ID = ? and PWD = ?");
		} else if (type.equals("pwd")) {
			sb.append("UPDATE MEMBER SET PWD = ? WHERE ID = ? and PWD = ?");
		} else if (type.equals("phone")) {
			sb.append("UPDATE MEMBER SET PHONE = ? WHERE ID = ? and PWD = ?");
		} else if (type.equals("address")) {
			sb.append("UPDATE MEMBER SET ADDRESS = ? WHERE ID = ? and PWD = ?");
		}
		
		try {
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, value);
			pstmt.setString(2, id);
			pstmt.setString(3, pwd);
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

	public ArrayList<MemberDTO> viewList() {
		StringBuilder sb = new StringBuilder();
		ArrayList<MemberDTO> list = new ArrayList<>();
		getConnection();
		sb.append("select * from member WHERE admin = 0");
		
		try {
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDTO newMemberDTO = new MemberDTO();
				newMemberDTO.setMemberNo(rs.getInt("member_no"));
				newMemberDTO.setId(rs.getString("id"));
				newMemberDTO.setPhone(rs.getString("phone"));
				newMemberDTO.setName(rs.getString("name"));
				newMemberDTO.setPwd(rs.getString("pwd"));
				newMemberDTO.setAddress(rs.getString("address"));
				newMemberDTO.setAdmin(rs.getInt("admin"));
				list.add(newMemberDTO);
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

}
