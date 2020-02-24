<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/spring/resources/style.css" rel="stylesheet" type="text/css" >
</head>

<c:if test="${sessionScope.memId == null }">
	<script type="text/javascript">
		alert("로그인 후 이용가능한 페이지입니다.");
	</script>
	<c:redirect url="/member/main.do"/>
</c:if>
<c:if test="${sessionScope.memId != null }" >
<body>
	<h2>회원 탈퇴</h2>
	<form action="/spring/member/deleteP.do" method="post">
		<table>
			<tr>
				<td>비밀번호를 입력해주세요. <br/>
				<input type="password" name="pw">
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="탈퇴하기">
					<input type="button" value="뒤로가기" onclick="window.location.href='/spring/member/main.do'"/>
 				</td>
			</tr>
		</table>
	</form>
</body>
</c:if>
</html>