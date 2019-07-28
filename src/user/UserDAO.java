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
	
	
	
	
	// ȸ������ 
	// SQL �κ� ��� ¥�� �Ǵ��� �����.
	public int join(User user) {
		
		// ����� setString ������ �����־�� �Ѵ�. 
		String SQL = "INSERT INTO user VALUES (?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setString(1, user.getUserID());
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserGender());
			pstmt.setString(5, user.getUserEmail());
			
			// ����! execute Update �̴�.
			// �̰͵� Ʋ���� �Է� ��Ų �� ������ ���� ��Ų��. EXECUTE���� �����̽��� ���� �Լ��� ����
			// ���ϰ��� �����ش�. �װɷ� UPDATE�� INT�� ��ȯ�Ѵٴ� ����� �˷��ش�.
			return pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return -1; // ������ ���̽� ������
		           // ������� �۾��� �� �� ���� �÷ο쿡 ���ؼ� �����. joinAction �������� ����ٰ�
		           // ����Ѵٸ� joinAction ������������ ���� �ʿ������� ����� �����Ѵ�.
		           // 
	}
	
	
	
}
