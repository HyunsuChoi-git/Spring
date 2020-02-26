<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/spring/resources/style.css" rel="stylesheet" type="text/css">
</head>

<c:if test="${sessionScope.memId == null}">
	<script>
		alert("로그인이 필요합니다.");
		window.location.href="/spring/member/loginForm.do";
	</script>
</c:if>

<c:if test="${sessionScope.memId != null}">
<body>
<br/>
<h1 align="center">작성하기</h1>
<br/>
<form action="/spring/board/writePro.do" method="post">
	<input type="hidden" name="num" value="${vo.num}"/>
	<input type="hidden" name="ref" value="${vo.ref}"/>
	<input type="hidden" name="re_step" value="${vo.re_step}"/>
	<input type="hidden" name="re_level" value="${vo.re_level}"/>
	<table>
		<tr>
			<td>제목</td>
			<td align="left">
			<c:if test="${vo.num == 0}"> 
				<input type="text" name="subject" />
			</c:if>
			<c:if test="${vo.num != 0}"> 
				<input type="text" name="subject" value="[Re]"/>
			</c:if>
			</td>
		</tr>
		<tr>
			<td>ID</td>
			<td align="left"><input type="text" name="id" value="${sessionScope.memId}" readonly/></td>
		</tr>
		<tr>
			<td colspan="2">내용</td>
		</tr>
		<tr>
			<td colspan="2"><textarea rows="20" cols="80" name="content"></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" value="등록" /> 
				<input type="reset" value="다시쓰기" /> 
				<input type="button" value="뒤로가기" onclick="history.go(-1)"/> 
			</td>
		</tr>
	</table>
</form>
</body>
</c:if>
</html>