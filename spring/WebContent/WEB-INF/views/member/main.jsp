<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Main</title>
	<link href="/spring/resources/style.css" rel="stylesheet" type="text/css">
</head>

<c:if test="${sessionScope.memId == null}">
<body>
	<br />
	<h1 align="center"> 메인페이지 </h1>
	<table>
		<tr>
			<td> 로그인 원하시면 버튼을 누르세요 <br />
				<button onclick="window.location.href='/spring/member/loginForm.do'" >로그인</button>
			</td>
		</tr>
		<tr>
			<td>
				<a href="/spring/member/signupForm.do" > 회원가입 </a>
			</td>
		</tr>
	</table>
	<br /><br /><br /><br />
	<div align="center">
		<img src="/spring/resources/img/beach.png" width="700" />
	</div>
</body>
</c:if>	

<c:if test="${sessionScope.memId != null}">
<body>
	<br />
	<h1 align="center"> 메인페이지 </h1>
	<table>
		<tr>
			<td><%=session.getAttribute("memId") %>님 환영합니다.<br />
				<button onclick="window.location.href='/spring/member/logout.do'" >로그아웃</button>
				<button onclick="window.location.href='/spring/member/modify.do'" >회원정보 변경</button>
			</td>
		</tr>
	</table>
	<br /><br /><br /><br />
	<div align="center">
		<img src="/spring/resources/img/beach.png" width="700" />
	</div>
</body>
</c:if>

</html>