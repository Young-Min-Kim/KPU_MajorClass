package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import user.User;

public class projectDAO {
	
	Connection conn; // connection:db에접근하게 해주는 객체
	//private PreparedStatement pstmt;
	
	public void conn() { // 생성자 실행될때마다 자동으로 db연결이 이루어 질 수 있도록함
		conn = null;
		try {
			String url = "jdbc:mysql://elijahlee.iptime.org:3306/test";
			String user = "root";
			String password = "root";

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int AddPro(String id, String proj_name, int number) throws SQLException {
		PreparedStatement pstmt = null;
		int result = -1;
		String SQL = "INSERT INTO projects(userid, proj_name, number) VALUES(?,?,?);";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, id);
			pstmt.setString(2, proj_name);
			pstmt.setInt(3, number);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int ProCount(String id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			String SQL = "SELECT COUNT(userid) FROM projects WHERE userid = ?;";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String ProName(String id, int number) throws SQLException {
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		String result = null;
		try {
			String SQL = "SELECT proj_name FROM projects WHERE userid = ? AND number = ?;";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, id);
			pstmt.setInt(2, number);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
