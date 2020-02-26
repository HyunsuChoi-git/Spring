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
 <c:choose>
	<c:when test="${sessionScope.memId != null && sessionScope.memId == vo.id}"> 
	<body>
	<form action="modifyPro.do" method="post">
		<input type="hidden" name="num" value="${vo.num}"/>
		<input type="hidden" name="pageNum" value="${pageNum }"/>
		<table>
			<tr>
				<td>제목</td>
				<td align="left">
				<input type="text" name="subject" value="${vo.subject }"/></td>
			</tr>
			<tr>
				<td>닉네임</td>
				<td align="left">${vo.id }</td>
			</tr>
			<tr>
				<td colspan="2">내용</td>
			</tr>
			<tr>
				<td colspan="2"><textarea rows="20" cols="80" name="content">${vo.content }</textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="수정" /> 
					<input type="button" value="뒤로가기" onclick="history.go(-1)"/> 
				</td>
			</tr>
		</table>
	</form>
	</body>
 	</c:when>
	<c:otherwise> 
		<script type="text/javascript">
			alert("접근오류");
			window.location.href="/spring/member/main.do";
		</script>
	</c:otherwise>
</c:choose> 
</html>