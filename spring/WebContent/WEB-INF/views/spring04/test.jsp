<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> count : ${ count } </h2>
	<h2> count : ${ maxAge } </h2>
	<c:forEach var="user" varStatus="status" items="${userList}">
		<h2> ${status.count} : ${ user.id } : ${ user.pw } : ${ user.age } : ${user.reg} </h2>
	</c:forEach>
	<h2> ${ user.id } / ${ user.pw } / ${ user.age } / ${ user.reg }</h2>
	<h2> test1 의 가입날짜 : ${reg}</h2>
</body>
</html>