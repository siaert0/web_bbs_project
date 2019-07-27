<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <!-- JSP 다루는 법과 밑에 보이는 부분들.  -->   
<%@ page import = "user.UserDAO" %>
<%@ page import = "user.User" %>
<%@ page import = "java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="user" class="user.User" scope="page"/>
<jsp:setProperty name = "user" property="userID"/>
<jsp:setProperty name = "user" property="userPassword"/>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">  
<title>게시판</title>
</head>
<body>
	 <%
	 	UserDAO userDAO = new UserDAO();
	     
	 
	    // 윗 jsp: 이부분을 넣어주지 않으면 자동완성이 되지 않는 것을 일깨워 주며, 다시한번 겟터,셋터 설명.
	 	int result = userDAO.login(user.getUserID(), user.getUserPassword());
	 	
	 	if (result == 1) {
	 		PrintWriter script = response.getWriter();
	 		
	 		script.println("<script>");
	 		script.println("location.href = 'main.jsp'");
	 		script.println("</script>");	
	 	}
	 	else if (result == 0) {
	 		PrintWriter script = response.getWriter();
	 		 
	 		script.println("<script>");
	 		script.println("alert('비밀번호가 틀려요.')");
	 		script.println("history.back()");
	 		script.println("</script>");	
	 	}
	 	else if (result == -1) {
	 		PrintWriter script = response.getWriter();
	 		
	 		script.println("<script>");
	 		script.println("alert('존재하지 않는 아이디 입니다.')");
	 		script.println("history.back()");
	 		script.println("</script>");	
	 	}
	 	else if (result == -2) {
	 		PrintWriter script = response.getWriter();
	 		
	 		script.println("<script>");
	 		script.println("alert('DB오류 발생.')");
	 		script.println("history.back()");
	 		script.println("</script>");	
	 	}
	 
	 
	 %>
</body>
</html>