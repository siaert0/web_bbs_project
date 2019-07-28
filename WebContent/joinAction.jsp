<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@ page import = "user.UserDAO" %>
<%@ page import = "user.User" %>
<%@ page import = "java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="user" class="user.User" scope="page"/>
<jsp:setProperty name = "user" property="userID"/>
<jsp:setProperty name = "user" property="userPassword"/>
<jsp:setProperty name = "user" property="userName"/>
<jsp:setProperty name = "user" property="userGender"/>
<jsp:setProperty name = "user" property="userEmail"/>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">  
<title>게시판</title>
</head>
<body>
	 <%
	 
	 	// 벨리데이션 작업.
	 	
	 	// null 과 논리연산자 설명.
	 	if (user.getUserID() == null || user.getUserPassword() == null || user.getUserName() == null ||
	 			user.getUserGender() == null || user.getUserEmail() == null ) {
			PrintWriter script = response.getWriter();	 		
	 		script.println("<script>");
	 		script.println("입력이 안된 부분이 존재합니다.");
	 		script.println("history.back()");
	 		script.println("</script>");	
	 	} else {
	 		UserDAO userDAO = new UserDAO();
		     
	 		 
		    // 윗 jsp: 이부분을 넣어주지 않으면 자동완성이 되지 않는 것을 일깨워 주며, 다시한번 겟터,셋터 설명.
		    // join 함수의 매개변수 타입이 user클래스 타입이였다. 그렇다면 당연히 함수에 user 클래스 인스턴스를 넣어주어야 한다.
		    // 클래스와 인스턴스, 변수타입에 대한 숙제.
		    
		 	int result = userDAO.join(user);
		 	
		 	if (result == -1) {
		 		PrintWriter script = response.getWriter();
		 		
		 		// 왜 db오류가 아니라 아이디 오류인가 질문.
		 		// 답은 db에서 기본키로 id를 지정해 놨다. 그렇다는 것은 아이디의 값은 무조건 중복될 수 가 없다.
		 		// 그 말즉슨 아이디가 중복되는 것을 체크한다는 뜻이다.
		 		script.println("<script>");
		 		script.println("alert('해당 아이디가 존재합니다.')");
		 		script.println("history.back()");
		 		script.println("</script>");	
		 	}
		 	else {
		 		PrintWriter script = response.getWriter();
		 		 
		 		script.println("<script>");
		 		script.println("location.href = 'main.jsp'");
		 		script.println("</script>");	
		 	}
		 	
	 	}
	 	
	 
	 
	 %>
</body>
</html>