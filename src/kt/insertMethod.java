package kt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class insertMethod {
	//���θ޼ҵ� ���� �׳� �޼ҵ常 �ִ� select �׽�Ʈ...
	public void insert() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 1. JDBC ����̹� �ε� - DB������ ���ؼ�.
		Class.forName("com.mysql.cj.jdbc.Driver");
		// 2. �����ͺ��̽� Ŀ�ؼ� ���� -drivermanger.getconnection�޼���� db�� ����� connection ��ü�� �����Ѵ�.
		try {

			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/opentutorials?characterEncoding=UTF-8&serverTimezone=UTC", "root",
					"root");
			System.out.println("DB���� ����!!");

			// 3. Ʋ�� �̸� ������ ���� ���� ����.
			pstmt = conn.prepareStatement("insert into author values(?,?,?)");
			pstmt.setString(1, "109");
			pstmt.setString(2, "b");
			pstmt.setString(3, "c");

			// 4. ��������
			pstmt.executeUpdate();
			System.out.println("���Է¿Ϸ�");

			String sql;
			sql = "SELECT * from author";
			Statement stmt = null;
			ResultSet rs = null;

			// 5. Statement ���� - Statement ��ü�� ����ϸ� ����(SELECT,INSERT,UPDATE,DELETE)�� ���� �� ��
			// �ִ�.
			stmt = conn.createStatement();
			// 6. ���� ����
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
			}

		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}

			// 6. Ŀ�ؼ� ����
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
	}
}
