package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// 데이터베이스 접근 객체 Database approch object
// 컨트롤 + 쉬프트 + O
public class UserDAO {
	private Connection conn; 
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// 생성자 - 자료첨부
	public UserDAO() {
		try {
			// 맨 끝엔 데이터베이스 이름이며 모든 것을 최신버젼으로 할 시 서버타임존 에러가 발생한다. 그리고 각종오류 발생.
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
		// userid가 ? 인 테이블 user 에서 password를 가져온다.
		// 특히 테이블명 조심해서 기입해 준다.
		String SQL = "SELECT userPassword FROM user WHERE userID = ?";
		
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if (rs.getString(1).equals(userPassword)) {
					return 1; // 로그인 성공을 뜻하는 값
				}
				
				else {
					return 0; // 비밀번호 불일치 값
				}
			}
			
			return -1; // 아이디 자체가 없다는 거다.
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return -2; // 아예 데이터베이스가  오류다.
	}
	
	
	
	
	// 회원가입 
	// SQL 부분 어떻게 짜야 되는지 물어본다.
	public int join(User user) {
		
		// 참고로 setString 순서도 지켜주어야 한다. 
		String SQL = "INSERT INTO user VALUES (?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setString(1, user.getUserID());
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserGender());
			pstmt.setString(5, user.getUserEmail());
			
			// 조심! execute Update 이다.
			// 이것도 틀리게 입력 시킨 후 에러를 숙지 시킨다. EXECUTE에서 스페이스를 눌러 함수를 보고
			// 리턴값을 보여준다. 그걸로 UPDATE가 INT를 반환한다는 사실을 알려준다.
			return pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return -1; // 데이터 베이스 오류값
		           // 여기까지 작업한 후 그 다음 플로우에 대해서 물어본다. joinAction 페이지를 만든다고
		           // 대답한다면 joinAction 페이지에서는 뭐가 필요한지도 물어보고 생각한다.
		           // 
	}
	
	
	
}
