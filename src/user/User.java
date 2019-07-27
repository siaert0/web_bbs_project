package user;

// 이 클래스는 자바빈즈라고 한다. user 객체를 이용해서 사용하기 때문이며, 
// 원래는 해당 객체의 특성에 맞게 date와 interger 등을 이용하여 객체의 타입을 정의해 줘야 한다.
// 하지만 수업 특성상 간단히 하기 위함이다.

// getter setter 는  말그대로 데이터의 입구와 출구 역할을 한다. 많이쓰는 기법이다.
public class User {
	private String userID;
	private String userPassword;
	private String userName;
	private String userGender;
	private String userEmail;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	
	
}
