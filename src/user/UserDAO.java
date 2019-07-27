package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// �����ͺ��̽� ���� ��ü Database approch object
// ��Ʈ�� + ����Ʈ + O
public class UserDAO {
	private Connection conn; 
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// ������ - �ڷ�÷��
	public UserDAO() {
		try {
			// �� ���� �����ͺ��̽� �̸��̸� ��� ���� �ֽŹ������� �� �� ����Ÿ���� ������ �߻��Ѵ�. �׸��� �������� �߻�.
			String dbURL = "jdbc:mysql://localhost:3306/bbs?serverTimezone=UTC&useSSL=false";
			String dbID = "root";
			String dbPassword = "root";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// TODO Auto-generated constructor stub
	}
	
	
	public int login(String userID, String userPassword) {
		// userid�� ? �� ���̺� user ���� password�� �����´�.
		// Ư�� ���̺�� �����ؼ� ������ �ش�.
		String SQL = "SELECT userPassword FROM user WHERE userID = ?";
		
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if (rs.getString(1).equals(userPassword)) {
					return 1; // �α��� ������ ���ϴ� ��
				}
				
				else {
					return 0; // ��й�ȣ ����ġ ��
				}
			}
			
			return -1; // ���̵� ��ü�� ���ٴ� �Ŵ�.
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return -2; // �ƿ� �����ͺ��̽���  ������.
	}
	
	
	
	
}
