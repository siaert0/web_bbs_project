<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content = "width=device-width" initial-scale = 1">
<meta charset="UTF-8"> <!-- 가장 대중적이고 안정적인 인코딩 방법 중 하나이다. 이걸 쓰지 않는다면 
						한글이 깨지고 오류가 발생할 가능성이 있으니, 한글이 깨진다면 이 인코딩 방식을 찾아 수정할 수 있어야 한다.  -->
<link rel="stylesheet" href ="css/bootstrap.min.css"> <!-- 주의 -->
<title>게시판</title>
</head>
<body>
	<!-- JSP가 뭔지에 대해서 설명해 준다. 자료 따로 첨부 -->
	<nav class="navbar navbar-default">
		<div class="navbar-header"> <!-- 이부분에서 간단한 html 레이아웃에 대해서 설명. 헤더, 바디, 풋 등등 -->
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expended="false"> <!-- 깊게 설명하지 않기. class와 id에 대한 설명 하기, 각종 속성은 적어 놨다가 구글에 쳐보라고 시킨다. -->
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="main.jsp">게시판 사이트</a> <!-- a태그에 대한 설명.  -->
		</div>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="dropdown"><a href="main.jsp">메인</a></li>
				<li class="dropdown"><a href="bbs.jsp">게시판</a></li>	
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
					aria-haspopup="true" aria-expended="false" >접속하기<span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li class="active"><a href="login.jsp">로그인</a></li>
					<li><a href="join.jsp">회원가입</a></li>
				</ul>
				</li>
			</ul>
		</div>
	</nav>
	
	<div class="container">
		<div class="col-lg-4"></div>
		<div class="col-lg-4">
			<div class="jumbotron" style="padding-top:20px;">
				<form method="post" action="loginAction.jsp">
					<h3 style="text-aline:center;">로그인 해 주세요.</h3>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="아이디" name="userID" maxlength="20"/>
					</div> 
					<div class="form-group">
						<input type="password" class="form-control" placeholder="비밀번호" name="userPassword" maxlength="20"/>
					</div>
					<input type="submit" class="btn btn-primary form-control" value="로그인"> 
				</form>
			</div>
		</div>
		<div class="col-lg-4"></div>
	</div>
	<script src = "https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src = "js/bootstrap.js"></script>
</body>
</html>