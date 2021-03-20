package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	// dao : 데이터베이스 접근 객체의 약자로서
	// 실질적으로 db에서 회원정보 불러오거나 db에 회원정보 넣을때

	private Connection conn; // connection:db에접근하게 해주는 객체
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// mysql에 접속해 주는 부분
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

	// 로그인을 시도하는 함수****
	public int login(String id, String passwd){
		rs = null;
		pstmt = null;
		String SQL = "SELECT passwd FROM accounts WHERE id=?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// 패스워드 일치한다면 실행
				if (rs.getString(1).equals(passwd)) {
					return 1; // 로그인 성공
				} else
					return 0; // 비밀번호 불일치
			}
			return -1; // 아이디가 없음 오류
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return -2; // 데이터베이스 오류를 의미
	}
	
	public int SignUp(User user) throws SQLException {
		pstmt= null;
		int result = -1;
		String SQL = "INSERT INTO accounts VALUES (?,?,?,?,?);";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPasswd());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getIntroduce());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return result;
	}
}