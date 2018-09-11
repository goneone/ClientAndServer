package kt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class insertMethod {
	//메인메소드 없고 그냥 메소드만 있는 select 테스트...
	public void insert() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 1. JDBC 드라이버 로딩 - DB연결을 위해서.
		Class.forName("com.mysql.cj.jdbc.Driver");
		// 2. 데이터베이스 커넥션 생성 -drivermanger.getconnection메서드는 db와 연결된 connection 객체를 리턴한다.
		try {

			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/kt?characterEncoding=UTF-8&serverTimezone=UTC", "root",
					"root");
			System.out.println("DB연결 성공!!");

			// 3. 틀을 미리 생성해 놓고 값을 넣음.
			pstmt = conn.prepareStatement("insert into ktmember values(?,?,?,?,?)");
			pstmt.setString(1, "1029");
			pstmt.setString(2, "b");
			pstmt.setString(3, "c");
			pstmt.setString(4, "cd");
			pstmt.setString(5, "cd");

			// 4. 쿼리실행
			pstmt.executeUpdate();
			System.out.println("값입력완료");
			/*
			String sql;
			sql = "SELECT * from author";
			Statement stmt = null;
			ResultSet rs = null;

			// 5. Statement 생성 - Statement 객체를 사용하면 쿼리(SELECT,INSERT,UPDATE,DELETE)를 실행 할 수
			// 있다.
			stmt = conn.createStatement();
			// 6. 쿼리 실행
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
			}
			*/
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}

			// 6. 커넥션 종료
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
	}
}
