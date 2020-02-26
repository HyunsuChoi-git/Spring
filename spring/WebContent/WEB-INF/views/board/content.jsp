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
<body>
	<br/>
	<h1 align="center">게시판</h1>
	<br/>
	<table>
		<tr>
			<td colspan="2">${vo.subject}</td>
		</tr>
		<tr>
			<td>${vo.id }</td>
			<td>${vo.reg }</td>
		</tr>
		<tr>
			<td colspan="2">${vo.content}</td>
		</tr>
		<c:if test="${sessionScope.memId == vo.id}">
			<tr>
				<td colspan="2">
				<button onclick="window.location.href='modify.do?num=${vo.num }&pageNum=${pageNum}&id=${vo.id}'">수정하기</button>
				<button onclick="window.location.href='delete.do?num=${vo.num }&id=${vo.id}'">삭제하기</button>
				</td>
			</tr>
		</c:if>
		<tr>
			<td colspan="2">
			<button onclick="window.location.href='writeForm.do?num=${vo.num }&ref=${vo.ref }&re_step=${vo.re_step }&re_level=${vo.re_level }'">답글</button>
			<button onclick="window.location.href='list.do?pageNum=${pageNum}'">목록</button>
			</td>
		</tr>
	</table>
</body>
</html>